package com.prosegur.rulesEngine.engine;

import org.drools.KnowledgeBase;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.rule.Rule;
import org.drools.event.knowledgeagent.KnowledgeBaseUpdatedEvent;
import org.drools.event.rule.DefaultKnowledgeAgentEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ReloadKnowledgeAgent extends DefaultKnowledgeAgentEventListener {
	private static final Logger log = LoggerFactory.getLogger(ReloadKnowledgeAgent.class);
	
	@Autowired
	Engine engine;
	
	private String kAgentName;
	
	public ReloadKnowledgeAgent (String kAgentName) {
		this.kAgentName = kAgentName;
	}
	
	@Override
	public void knowledgeBaseUpdated(KnowledgeBaseUpdatedEvent event) 
	{
		log.info("El agente de conocimiento " + kAgentName + " ha detectado algún cambio en su base de conocimientos.");
		
		KnowledgeBase kBase = event.getKnowledgeBase();
		
		log.info("Actualizando paquetes...");
		int totalReglas = 0;
		for (KnowledgePackage knowledgePackage : kBase.getKnowledgePackages()) {
			log.info(knowledgePackage.getName());
			int numReglasPaquete = kBase.getKnowledgePackage(knowledgePackage.getName()).getRules().size();
			log.info(numReglasPaquete + " Recursos actualizados desde el paquete " + knowledgePackage.getName());
			totalReglas += numReglasPaquete;
			if (log.isDebugEnabled()) {
				for (Rule rule : kBase.getKnowledgePackage(knowledgePackage.getName()).getRules()) {
					log.debug(rule.getName());
				}
			}
		}
		log.info(totalReglas + " Recursos actualizados en total");				
	}
}
