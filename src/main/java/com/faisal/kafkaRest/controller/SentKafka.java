package com.faisal.kafkaRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;

@Service
public class SentKafka {
	private String topicName = "faisal";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String Haloo) {
		ListenableFuture<SendResult<String, String>> future =
				kafkaTemplate.send(topicName, Haloo);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
		@Override
		public void onSuccess(SendResult<String, String>result) {
			System.out.println("Sent message= ["+ Haloo +
					result.getRecordMetadata().offset()+"]");
		}
		@Override
		public void onFailure(Throwable ex) {
			System.out.println(
					"Unable to Send Message=[ "+Haloo+"] due to : "
					+ ex.getMessage());
		}
		});
	}

}
