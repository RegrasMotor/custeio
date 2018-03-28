package com.prosegur.rulesEngine.services.jms;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JmsQueueNames {
	@Getter
	private @Value("${jms.queue.request.costeo}") String queueNameRequestCosteo;
	@Getter
	private @Value("${jms.queue.response.costeo}") String queueNameResponseCosteo;
}


