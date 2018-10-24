package com.gA.gaAcademy.mteijiz.webservices.webServices.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}