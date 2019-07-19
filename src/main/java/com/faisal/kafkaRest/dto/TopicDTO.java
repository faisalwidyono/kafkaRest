package com.faisal.kafkaRest.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TopicDTO {
	
	private String topic;
	private String data;

}
