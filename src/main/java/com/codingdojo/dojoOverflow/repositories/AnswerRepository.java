package com.codingdojo.dojoOverflow.repositories;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoOverflow.models.Answer;
import com.codingdojo.dojoOverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository <Answer, Long> {

	List<Answer> findAll();

	List<Answer> findByQuestion_Id(Long question_id);


}
