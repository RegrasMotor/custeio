package com.prosegur.rulesEngine.engine.audit;

import org.drools.rule.Rule;
import org.drools.common.AgendaItem;
import org.drools.event.rule.ActivationCancelledEvent;
import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.ActivationEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.BeforeActivationFiredEvent;
import org.drools.event.rule.DefaultAgendaEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAgenda extends DefaultAgendaEventListener {
	
	private static final Logger log = LoggerFactory.getLogger(LogAgenda.class);
	
	@Override
    public void activationCreated(ActivationCreatedEvent event) {
		if (log.isTraceEnabled()) {
			printLog(event, "Created");
		}
    }
    
	@Override
    public void activationCancelled(ActivationCancelledEvent event) {
		if (log.isTraceEnabled()) {
			printLog(event, "Cancelled");
		}
    }
	
	@Override
	public void beforeActivationFired(final BeforeActivationFiredEvent event) {
		if (log.isTraceEnabled()) {
			printLog(event, "BeforeFired");
		}
	}
	
	@Override
    public void afterActivationFired(AfterActivationFiredEvent event) {
		/*if (log.isTraceEnabled()) {
			printLog(event, "AfterFired");
		}*/
    }
	
	private void printLog(ActivationEvent event, String tipo) {
		AgendaItem activation = (AgendaItem)event.getActivation();
		Rule regla = activation.getRule();
		String causa = (event instanceof ActivationCancelledEvent)?" | cause:" + ((ActivationCancelledEvent)event).getCause().toString():"";
		log.trace("KnowledgeRuntime@" + Integer.toHexString(event.getKnowledgeRuntime().hashCode()) + ". Rule " + tipo + ": " + regla.getSalience() + "." + regla.getLoadOrder() + " " +regla.getPackageName() + " - " + regla.getName() + causa);
	}
}