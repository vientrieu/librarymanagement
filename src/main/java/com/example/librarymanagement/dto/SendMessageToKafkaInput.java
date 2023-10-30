package com.example.librarymanagement.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class SendMessageToKafkaInput {
	private String topic;
	private String message;
}
