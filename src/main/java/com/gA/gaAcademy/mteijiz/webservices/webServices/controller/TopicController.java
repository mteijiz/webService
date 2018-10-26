package com.gA.gaAcademy.mteijiz.webservices.webServices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
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
	}//Esto hecho de esta manera tiene un incoveniente y es que yo devuelvo el topid, pero cuando falla deberia volver una excepcion
	

	@GetMapping("/topic")
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<>();
		topics = topicService.getAllTopics();
		return topics;
	}

	@GetMapping("/topic/{id}")
	public Topic getByID(@PathVariable int id) {
		Topic t = topicService.getId(id);
		return t;
	}

	@PutMapping("/topic/{id}")
	public Topic updateTopic(@PathVariable int id, @RequestBody Topic updateTopic) {// actualizar uno o mas campos de un
																					// topic
		Topic t = topicService.updateTopic(id, updateTopic);
		return t;
	}
	
	@DeleteMapping("/topic/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable int id){
		int idTopic = topicService.deleteTopicFisico(id);
		String message = "El topic: " + idTopic + " fue borrado exitosamente";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	//el http response ahora lo vamos a ver como responseEntity
	//En este caso no vamos a parametrizas el ResponseEntity
	
	@DeleteMapping("/topic/logic/{id}")//Le ponemos otra ruta para no tener problemas con el de arriba que estaria repetido sino
	public ResponseEntity<?> deleteLogicTopic(@PathVariable int id){
		int fueBorrado = topicService.deleteLogicoTopic(id);
		if(fueBorrado > 0){
			String msg = "El topic: " + fueBorrado + " fue borrado exitosamente";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("No se pudo encontrar " + fueBorrado, HttpStatus.NOT_FOUND);
	}
}
