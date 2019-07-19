package com.faisal.kafkaRest.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faisal.kafkaRest.dto.TopicDTO;
import com.faisal.kafkaRest.model.Topic;


public interface TopicDAO extends CrudRepository<Topic, String> {
	

}
