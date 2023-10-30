package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.SendMessageToKafkaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author mangvientrieu
 */
@RequestMapping("/kafka")
@RestController
public class KafkaController {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping
	public boolean sendMessageToKafka(@RequestBody SendMessageToKafkaInput input) {
		CompletableFuture.runAsync(() -> kafkaTemplate.send(input.getTopic(), input.getMessage()));
		return true;
	}
}
