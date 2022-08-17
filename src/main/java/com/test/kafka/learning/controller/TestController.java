package com.test.kafka.learning.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.kafka.learning.producer.TestProducer;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestProducer testProducer;
	
	@PostMapping
	public ResponseEntity<TestDTO> create(@RequestBody TestDTO testDTO){
		TestDTO test = new TestDTO(Uuid.randomUuid().toString(), testDTO.getName(), testDTO.getDocument());
		testProducer.send(testDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(test);
	}
	
}
