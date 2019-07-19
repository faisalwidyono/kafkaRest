package com.faisal.kafkaRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.faisal.kafkaRest.dto.TopicDTO;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;

@Service
public class SentKafka {
	

	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String dataSend, String topicName) {  
		ListenableFuture<SendResult<String, String>> future =
				kafkaTemplate.send(topicName, dataSend);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
		@Override
		public void onSuccess(SendResult<String, String>result) {
			System.out.println("Sent message= ["+ dataSend +
					result.getRecordMetadata().offset()+"]");
		}
		@Override
		public void onFailure(Throwable ex) {
			System.out.println(
					"Unable to Send Message=[ "+dataSend+"] due to : "
					+ ex.getMessage());
		}
		});
	}

}
