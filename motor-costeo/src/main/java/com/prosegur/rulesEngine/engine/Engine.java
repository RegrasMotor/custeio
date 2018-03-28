
package com.prosegur.rulesEngine.engine;

import java.util.HashMap;
import java.util.Map;

import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentConfiguration;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.agent.conf.NewInstanceOption;
import org.drools.agent.conf.ScanDirectoriesOption;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.rule.Rule;
import org.drools.io.Resource;
import org.drools.io.ResourceChangeScannerConfiguration;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prosegur.rulesEngine.engine.audit.LogAgenda;
import com.prosegur.rulesEngine.engine.audit.LogWorkingMemory;

@Service
public class Engine {
	private static final Logger log = LoggerFactory.getLogger(Engine.class);

	@Value("${engine.auditSessions}") private boolean auditSessions;
	
	private static Map<String, KnowledgeAgent> knowledgeAgents = new HashMap<String, KnowledgeAgent>();
	
	@Autowired
	public Engine(@Value("${engine.name}") String engineName, @Value("#{'${engine.countries}'.split(',')}") String[] countries, @Value("${engine.resourceScannerInterval}") String resourceScannerInterval) {
		log.info("Iniciando Engine...");

		// Configuramos el intervalo de escaneo. Si no lo seteamos, por defecto son 60 segundos
		log.info("Configurando escaner...");
		ResourceChangeScannerConfiguration scannerConfiguration = ResourceFactory.getResourceChangeScannerService().newResourceChangeScannerConfiguration();
		scannerConfiguration.setProperty("drools.resource.scanner.interval", resourceScannerInterval);
		ResourceFactory.getResourceChangeScannerService().configure(scannerConfiguration);
		
		ResourceFactory.getResourceChangeNotifierService().start();
		ResourceFactory.getResourceChangeScannerService().start();	
		
		// Configuramos el generador de agentes para que se instancien nuevos KnowledgeBase
		log.info("Configurando agentes de conocimiento...");
		KnowledgeAgentConfiguration kAgentConfiguration = KnowledgeAgentFactory.newKnowledgeAgentConfiguration();
		kAgentConfiguration.setProperty(ScanDirectoriesOption.PROPERTY_NAME, "true");
		kAgentConfiguration.setProperty(NewInstanceOption.PROPERTY_NAME, "true");

		for (String countryAndSimulator : countries) {
    		String country = countryAndSimulator.split("@")[0];
    		String simulator = (countryAndSimulator.split("@").length>1)?countryAndSimulator.split("@")[1]:null;
	    	
    		String knowledgeAgentName = country + "." + engineName;
    		if (simulator!=null && !simulator.isEmpty()) {
    			knowledgeAgentName += ("." + simulator);
    		}
					
			log.info("Configurando agente " + knowledgeAgentName + "...");
			KnowledgeAgent knowledgeAgent = KnowledgeAgentFactory.newKnowledgeAgent(knowledgeAgentName, kAgentConfiguration);
			
			log.info("Importando base de conocimiento...");
			String changeSetName = "change-set/change-set-"+knowledgeAgentName+".xml";
			Resource changeSetResource = ResourceFactory.newClassPathResource(changeSetName);
			knowledgeAgent.applyChangeSet(changeSetResource);
			
			putKnowledgeAgent(knowledgeAgentName, knowledgeAgent);
			
			log.info( knowledgeAgent.getKnowledgeBase().getKnowledgePackages().size() + " Paquetes importados...");
			for (KnowledgePackage knowledgePackage : knowledgeAgent.getKnowledgeBase().getKnowledgePackages()) {
				log.info("Paquete: " + knowledgePackage.getName());
			}

			int totalReglas = 0;
			for (KnowledgePackage knowledgePackage : knowledgeAgent.getKnowledgeBase().getKnowledgePackages()) {
				int numReglasPaquete = knowledgeAgent.getKnowledgeBase().getKnowledgePackage(knowledgePackage.getName()).getRules().size();
				totalReglas += numReglasPaquete;
				log.info(numReglasPaquete + " Recursos importados desde el paquete " + knowledgePackage.getName());
				if (log.isDebugEnabled()) {
					for (Rule rule : knowledgeAgent.getKnowledgeBase().getKnowledgePackage(knowledgePackage.getName()).getRules()) {
						log.debug("Regla: " + rule.getName());
					}
				}
			}
			log.info(totalReglas + " Recursos importados en total");		
			
			log.info("Configurando monitor de eventos en el agente '" + knowledgeAgentName + "'...");
			knowledgeAgent.monitorResourceChangeEvents(true); 
			knowledgeAgent.addEventListener(new ReloadKnowledgeAgent(knowledgeAgentName));
		}
		
		log.info("Engine iniciado");
	}
	
	public StatelessKnowledgeSession createKnowledgeSession (KnowledgeAgent kAgent) {
		log.debug("Creando nueva sesion de conocimiento...");
		StatelessKnowledgeSession knowledgeSession = kAgent.getKnowledgeBase().newStatelessKnowledgeSession();
		
		if (auditSessions) {
			log.debug("Configurando monitor de eventos en sesion...");
			knowledgeSession.addEventListener(new LogAgenda());
			knowledgeSession.addEventListener(new LogWorkingMemory());
		}
		return knowledgeSession;
	}
	
	public KnowledgeAgent getKnowledgeAgent (String key) {
		return knowledgeAgents.get(key);
	}

	private KnowledgeAgent putKnowledgeAgent (String key, KnowledgeAgent knowledgeAgent) {
		return knowledgeAgents.put(key, knowledgeAgent);
	}	
}
