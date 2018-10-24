package com.gA.gaAcademy.mteijiz.webservices.webServices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.mteijiz.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.mteijiz.webservices.webServices.service.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public Topic createTopic(Topic inputTopic) {

		Topic t = topicRepository.save(inputTopic);// guarda en la base de datos
		return t; //save tambien devuelve lo que crea, asi que lo guardamos y lo tenemos
	}

}