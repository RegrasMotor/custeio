package com.prosegur.rulesEngine.services;

import java.util.ArrayList;
import java.util.List;

import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.prosegur.rulesEngine.engine.Engine;
import com.prosegur.rulesEngine.factsmodel.costeo.Costeo;
import com.prosegur.rulesEngine.factsmodel.costeo.DetalleCosteo;
import com.prosegur.rulesEngine.factsmodel.costeo.FactRequest;
import com.prosegur.rulesEngine.services.exception.ServiceException;

@Component
public class EngineServicesImpl implements EngineServices {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(EngineServicesImpl.class);

	@Autowired 	private Engine engine;
	@Value("${engine.name}") String engineName;
	
	protected static final String identifierGlobalCosteo = "costeo";

	public List<DetalleCosteo> executeCosteo (FactRequest factRequest, String pais, String simulador) throws ServiceException {
		List<Object> facts = new ArrayList<Object>();		
		facts.add(factRequest.getParams());
		facts.add(factRequest.getOt());
		facts.add(factRequest.getCliente());
		facts.add(factRequest.getSubcliente());
		facts.addAll(factRequest.getEscalas());
		facts.addAll(factRequest.getTiposPuestos());
		facts.addAll(factRequest.getCategoriasSalariales());
		facts.addAll(factRequest.getEsquemasOperativos());
		facts.addAll(factRequest.getEscalasXcategorias());
		facts.addAll(factRequest.getMediosAuxiliares());
		facts.addAll(factRequest.getBeneficios());
		facts.addAll(factRequest.getItemsDeCosto());
		facts.addAll(factRequest.getGruposTarifarios());
		facts.addAll(factRequest.getConceptosFacturacion());
		facts.addAll(factRequest.getDatosFacturacion());

		String knowledgeAgentName = pais + "." + engineName;
		if (simulador!=null && !simulador.isEmpty()) {
			knowledgeAgentName += ("." + simulador);
		}
		
		StatelessKnowledgeSession ksession;
		try {
			ksession = engine.createKnowledgeSession(engine.getKnowledgeAgent(knowledgeAgentName));
		} catch (Exception ex) {
			throw new ServiceException("The request cannot be handled by some knowledge agent configured");
		}
		
		ksession.setGlobal(identifierGlobalCosteo, new Costeo());
		ksession.execute(facts);

		Costeo globalCosteo = (Costeo)ksession.getGlobals().get(identifierGlobalCosteo);
		
		return globalCosteo.getDetalles();
	}
}
