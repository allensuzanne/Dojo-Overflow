package com.codingdojo.dojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojoOverflow.models.Answer;
import com.codingdojo.dojoOverflow.models.Question;
import com.codingdojo.dojoOverflow.models.QuestionTagging;
import com.codingdojo.dojoOverflow.models.Tagging;
import com.codingdojo.dojoOverflow.services.mainService;

@Controller

public class OverflowController {

	@Autowired
	private mainService mainService;
	
	
	//----------------------------------------------------------------
		// Show all Questions - Get Route
	//----------------------------------------------------------------
	
	@GetMapping("/questions")
	public String allquestions(Model model) {
		List<Question> questions = mainService.allQuestions();
		model.addAttribute("questions", questions);
		return "/questions.jsp";
	}
	
	
	//----------------------------------------------------------------
		// New Question - Get Route
	//----------------------------------------------------------------
	
	@GetMapping("/questions/new")
	public String newQuestions() {
		return "questionsNew.jsp";
	}
	
	//----------------------------------------------------------------
		// Create Question - Post Route
	//----------------------------------------------------------------
	@PostMapping("/questions/create")
	public String createQuestions(@RequestParam("question") String question, @RequestParam("subject") String subject) {
		System.out.println(subject);
		System.out.println(question);
		String[] tagging = subject.split("\\s*,\\s*");
		Question quest = mainService.createQuestion(question);
		for (String st : tagging) {
			Tagging returnedTag = mainService.createTags(st);
			mainService.createQuestionTagging(new QuestionTagging(quest, returnedTag));
		}
		return "redirect:/questions/";
	}
	
	
	//----------------------------------------------------------------
		// Question ID - Get Route
	//----------------------------------------------------------------
	
	@GetMapping("/questions/{id}")
	public String questionsId(Model model, @PathVariable("id") Long question_id) {
		Question question = mainService.findQuestionById(question_id);
		model.addAttribute("question", question);
		List<Answer> answers = mainService.findByQuestion_Id(question_id);
		model.addAttribute("answers", answers);
		return "answer.jsp";
	}

	
	//----------------------------------------------------------------
		// Answers - Post Route
	//----------------------------------------------------------------
	
	@PostMapping("/questions/{id}/answer")
	public String createAnswer(@RequestParam("answer") String answer, @PathVariable("id") Long question_id) {
			Answer newAnswer = new Answer();
			newAnswer.setAnswer(answer);
			Question question = mainService.findQuestionById(question_id);
			newAnswer.setQuestion(question);
			mainService.createAnswer(newAnswer);
			return "redirect:/questions/"+question_id;
		}
}
