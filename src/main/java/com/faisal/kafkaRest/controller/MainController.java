package com.faisal.kafkaRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.kafkaRest.dao.TopicDAO;
import com.faisal.kafkaRest.dto.TopicDTO;
import com.faisal.kafkaRest.model.Topic;




@RestController
@RequestMapping(value = "api/v1")
public class MainController {
	@Autowired
	TopicDAO topicDAO;
	@Autowired
	SentKafka sentKafka;
	

	
	@GetMapping(value= "/get")
	public List<Topic> get(){
		List<Topic> result = new ArrayList<>();
		
		topicDAO.findAll().forEach(result::add);
		return result;
	}

	@PostMapping(value = "/publish")
	public TopicDTO publish(@RequestBody TopicDTO topicDTO) {
		
		try {
			sentKafka.sendMessage(topicDTO.getData());
			return topicDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
//	@PutMapping(value="/update")
//	public Topic update(@RequestBody Topic topic, @PathVariable Long id) {
//		
//	}

}
