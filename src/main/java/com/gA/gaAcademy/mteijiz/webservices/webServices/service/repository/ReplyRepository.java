package com.gA.gaAcademy.mteijiz.webservices.webServices.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gA.gaAcademy.mteijiz.webservices.webServices.entity.Reply;
import com.gA.gaAcademy.mteijiz.webservices.webServices.entity.Topic;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	Optional<List<Reply>>findByTopic(Topic topic);
}
