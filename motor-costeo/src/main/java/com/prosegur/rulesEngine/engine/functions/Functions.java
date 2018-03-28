package com.prosegur.rulesEngine.engine.functions;

import org.drools.spi.KnowledgeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Functions for use in DRL files.
 */
public class Functions {
	private static final Logger log = LoggerFactory.getLogger(Functions.class);
	
	/**
	 * Log a debug message from a rule, using the rule’s package and name as the Log4J
	 * category.
	 */
	public static void log(final KnowledgeHelper drools, final String message, final Object... parameters) {
		final String formattedMessage = String.format(message, parameters);

		log.debug("KnowledgeRuntime@" + Integer.toHexString(drools.getKnowledgeRuntime().hashCode()) + ". " + formattedMessage);

	}
}