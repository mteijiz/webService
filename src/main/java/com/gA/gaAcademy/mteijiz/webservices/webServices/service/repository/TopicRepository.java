package com.gA.gaAcademy.mteijiz.webservices.webServices.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gA.gaAcademy.mteijiz.webservices.webServices.entity.Topic;

//en el repositorio guardamos topicos
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
}
