package com.test.kafka.learning.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.test.kafka.learning.controller.TestDTO;

@Component
public class TestConsumer {

	private static final Logger logger = LoggerFactory.getLogger(TestConsumer.class);

	@Value(value = "${topic.name}")
    private String topic;
    
    @Value(value = "${spring.kafka.group-id}")
    private String groupId;
	
	
    @KafkaListener(topics = "${topic.name}", groupId="${spring.kafka.group-id}", containerFactory="testKafkaListenerContainerFactory")
	public void listenTopicTest(ConsumerRecord<String, TestDTO> record) {
    	logger.info("Received Message" + record.partition());
    	logger.info("Received Message" + record.value());
	}
	
}
