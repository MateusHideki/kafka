package com.test.kafka.learning.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.SuccessCallback;

import com.test.kafka.learning.controller.TestDTO;

@Service
public class TestProducer {

	private static final Logger logger = LoggerFactory.getLogger(TestProducer.class);
	private final String topic;
	private final KafkaTemplate<String, TestDTO> kafkaTemplate;
	
	
	public TestProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, TestDTO> kafkaTemplate) {
		this.topic= topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(TestDTO testDTO) {
		kafkaTemplate.send(topic, testDTO).addCallback(
				success -> logger.info("Mensagem enviada com sucesso" + success.getProducerRecord().value()), 
				failure -> logger.info("Mensagem falha" + failure.getMessage())
				);
		
	}
}
