package com.prosegur.rulesEngine.engine.audit;

import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.drools.event.rule.WorkingMemoryEvent;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogWorkingMemory implements WorkingMemoryEventListener {
	private static final Logger log = LoggerFactory.getLogger(LogWorkingMemory.class);
	
    public void objectInserted(ObjectInsertedEvent event) {
    	if (log.isTraceEnabled()) {
    		printLog(event, "Object inserted new: ", event.getObject());
    	}
    }

	public void objectUpdated(final ObjectUpdatedEvent event) {
		if (log.isTraceEnabled()) {
			printLog(event, "Object updated new: ", event.getObject());
		}
	}
    
    public void objectRetracted(ObjectRetractedEvent event) {
    	if (log.isTraceEnabled()) {
    		printLog(event, "Object retracted old: ", event.getOldObject());
    	}
    }
    
	private void printLog(WorkingMemoryEvent event, String tipo, Object objeto) {
		log.trace("KnowledgeRuntime@" + Integer.toHexString(event.getKnowledgeRuntime().hashCode()) + ". " + tipo + objeto.toString());
	}    

}