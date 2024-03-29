package com.faisal.kafkaRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.kafkaRest.dto.TopicDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Api(tags = "Producer")
@RestController
@RequestMapping(value = "api/v1")
public class MainController {

	@Autowired
	SentKafka sentKafka;
	


	
	@ApiOperation(
			value = "API to publish data",
		    notes = "Publish data to Apache Kafka",
		    tags = "Publish Data"
			)
	@PostMapping(value = "/publish")
	public TopicDTO publish(@RequestBody TopicDTO topicDTO) {

		try {
			sentKafka.sendMessage(topicDTO.getData(), topicDTO.getTopic());
			return topicDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


}
