package com.codingdojo.dojoOverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {
  

//----------------------------------------------------------------
//					Attributes
//----------------------------------------------------------------

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=2)
    private String question;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_taggings", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tagging_id")
    )
    private List<Tagging> taggings;
    
	
    
//----------------------------------------------------------------
//  	Constructors
//----------------------------------------------------------------
   
	public Question() {
	}
	
	public Question(String question) {
		this.question = question;
	}

	
	public Question(Long id, String question, Date createdAt, Date updatedAt, List<Answer> answers,
			List<Tagging> taggings) {
		this.id = id;
		this.question = question;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.answers = answers;
		this.taggings = taggings;
	}

//----------------------------------------------------------------
//	  		Getters and Setters
//----------------------------------------------------------------

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	public List<Tagging> getTaggings() {
		return taggings;
	}


	public void setTaggings(List<Tagging> taggings) {
		this.taggings = taggings;
	}
    

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
  
}
