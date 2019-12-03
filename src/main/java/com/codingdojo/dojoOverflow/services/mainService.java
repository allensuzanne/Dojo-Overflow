package com.codingdojo.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoOverflow.models.Answer;
import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.models.QuestionTagging;
import com.codingdojo.dojoOverflow.models.Tagging;
import com.codingdojo.dojoOverflow.repositories.AnswerRepository;
import com.codingdojo.dojoOverflow.repositories.QuestionRepository;
import com.codingdojo.dojoOverflow.repositories.QuestionTaggingRepository;
import com.codingdojo.dojoOverflow.repositories.TaggingRepository;

@Service
public class mainService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private TaggingRepository taggingRepository;
	
	@Autowired
	private QuestionTaggingRepository questionTaggingRepository;

	
	
//  ----------------------------------------------------------------
//  find 
//  ----------------------------------------------------------------
	
	public List<Question> allQuestions(){
		return questionRepository.findAll();
	}



	public Question findQuestionById(Long question_id) {
		return questionRepository.findQuestionById(question_id);
	}

	public List<Answer> findByQuestion_Id(Long question_id) {
		return answerRepository.findByQuestion_Id(question_id);
	}

//  ----------------------------------------------------------------
//  create and delete
//  ----------------------------------------------------------------
	
	
	public Tagging createTags(String st) {
		Optional<Tagging> optionalTagging = taggingRepository.findBySubject(st);
		if(optionalTagging.isPresent()) {
			return optionalTagging.get();
		}
		else {
			Tagging newTag = new Tagging(st);
			return taggingRepository.save(newTag);
		}
		
	}
	
	public void createQuestionTagging(QuestionTagging newQuestionTagging){
		questionTaggingRepository.save(newQuestionTagging);
	}



	public Question createQuestion(String question) {
		Question newQuest = new Question(question);
		return questionRepository.save(newQuest);
		
	}



	public Answer createAnswer(Answer answer) {
		return answerRepository.save(answer);
		
	}

}
