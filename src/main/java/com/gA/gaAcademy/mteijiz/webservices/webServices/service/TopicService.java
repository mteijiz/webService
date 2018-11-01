package com.gA.gaAcademy.mteijiz.webservices.webServices.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.mteijiz.webservices.webServices.entity.Reply;
import com.gA.gaAcademy.mteijiz.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.mteijiz.webservices.webServices.service.repository.ReplyRepository;
import com.gA.gaAcademy.mteijiz.webservices.webServices.service.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	@Autowired
	ReplyRepository replyRepository;

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

	public int deleteTopicFisico(int id) {
		topicRepository.deleteById(id);
		return id;
	}

	public int deleteLogicoTopic(int id) {
		int toReturn = 0;
		Topic t = topicRepository.findById(id).get();
		if(!t.getDeleted()) {
			t.deleted();
			toReturn = t.getId();
			topicRepository.save(t);
		}
		return toReturn;
		
		
	}

	public void createReply(Reply reply) {
		reply.setDate(new Date());
		replyRepository.save(reply);
	}
	
	public List<Reply> getReplies(int id){
		return topicRepository.findById(id).get().getListOfReplies();
	}
	
	public List<Reply> getReply(int id){
		return replyRepository.findByTopic(topicRepository.findById(id).get()).get();
	}
	
	public void deleteAllReplies(int id) {
		Topic t = topicRepository.findById(id).get();
		t.deleteListOfReplies();
		topicRepository.save(t);
	}
	
	public Reply updateReplyByID(int id, Reply reply) throws NoSuchElementException{
		Reply toUpdate = replyRepository.findById(id).get();
		if(reply.getDescription() != null) {
			toUpdate.setDescription(reply.getDescription());
		}
		replyRepository.save(toUpdate);
		return toUpdate;
	}
	
	
}
