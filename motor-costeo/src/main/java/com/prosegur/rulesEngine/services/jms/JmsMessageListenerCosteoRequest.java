package com.prosegur.rulesEngine.services.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
public class JmsMessageListenerCosteoRequest implements MessageListener {
	@Autowired private JmsTemplateEngine jmsTemplateEngine;
	@Autowired private JmsQueueNames jmsQueueNames;
	
	public void onMessage(Message message) {
        try {
            final String textMessage = ((TextMessage) message).getText(); 
        	
            System.out.println(textMessage);
            
            jmsTemplateEngine.send(jmsQueueNames.getQueueNameResponseCosteo(), textMessage);
        } catch (JMSException ex) {
            throw new RuntimeException(ex);
        }
	}

}

