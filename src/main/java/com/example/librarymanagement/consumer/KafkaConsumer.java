package com.example.librarymanagement.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

/**
 * @author mangvientrieu
 */
@Component
public class KafkaConsumer {
	@KafkaListener(topics = "TOPIC_DEMO_KAFKA", groupId = "group_1")
	public void listenTopicDemo(String message) {
		System.out.println("Received Message: " + message);
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("DONE! " + message);
	}
}
