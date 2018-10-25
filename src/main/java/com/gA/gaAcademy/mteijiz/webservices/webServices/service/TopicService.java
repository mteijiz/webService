package com.gA.gaAcademy.mteijiz.webservices.webServices.service;

import java.util.ArrayList;
import java.util.List;

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
		return t; // save tambien devuelve lo que crea, asi que lo guardamos y lo tenemos
	}

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topics = topicRepository.findAll();
		return topics;
	}

	public Topic getId(int id) {
		Topic t = topicRepository.findById(id).get();// si solo retornara con el metodo, cuando se hace eso se tiene que
														// se crea una variable anonima, es decir que da lo mismo
														// crearla como no
		return t;
	}

	public Topic updateTopic(int id, Topic updateTopic) {
		Topic toUpdateTopic = topicRepository.findById(id).get();
		if (updateTopic.getAuthor() > 0)
			toUpdateTopic.setAuthor(updateTopic.getAuthor());
		if (updateTopic.getDescription() != null)
			toUpdateTopic.setDescription(updateTopic.getDescription());
		if (updateTopic.getTitle() != null)
			toUpdateTopic.setTitle(updateTopic.getTitle());
		toUpdateTopic = topicRepository.save(toUpdateTopic);
		return toUpdateTopic;
	}// modificamos los valores que no estan en null, si tiene valor lo tenemos que
		// modificar

}
