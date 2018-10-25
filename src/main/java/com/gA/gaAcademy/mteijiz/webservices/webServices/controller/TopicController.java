package com.gA.gaAcademy.mteijiz.webservices.webServices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 2caa8b2d29332a1f4f836ab60553fe501e3a80a0
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.mteijiz.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.mteijiz.webservices.webServices.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	public TopicService topicService;

	@PostMapping("/topic")
	// de parametro va a recibir algo del body (en nuestro caso de json)
	public Topic createTopic(@RequestBody Topic inputTopic) {
		Topic returnTopic = topicService.createTopic(inputTopic);
		return returnTopic;
	}
<<<<<<< HEAD

	@GetMapping("/topic")
	public List<Topic> getTopics() {
=======
	
	@GetMapping("/topic")
	public List<Topic> getTopics(){
>>>>>>> 2caa8b2d29332a1f4f836ab60553fe501e3a80a0
		List<Topic> topics = new ArrayList<>();
		topics = topicService.getAllTopics();
		return topics;
	}
<<<<<<< HEAD

	@GetMapping("/topic/{id}")
	public Topic getByID(@PathVariable int id) {
		Topic t = topicService.getId(id);
		return t;
	}

	@PutMapping("/topic/{id}") public Topic updateTopic(@PathVariable int id, @RequestBody Topic updateTopic) {//actualizar uno o mas campos de un topic
		Topic t = topicService.updateTopic(id, updateTopic);
		return t;
	}
=======
	
>>>>>>> 2caa8b2d29332a1f4f836ab60553fe501e3a80a0
}
