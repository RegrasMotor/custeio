package com.prosegur.rulesEngine.services.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


@Component
public class JmsTemplateEngine {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(String queueName, final String textMessage) {
        this.jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
              return session.createTextMessage(textMessage);
            }
        });
	}
}

