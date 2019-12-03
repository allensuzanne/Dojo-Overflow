package com.codingdojo.dojoOverflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions_taggings")
public class QuestionTagging {


//----------------------------------------------------------------
//						Attributes
//----------------------------------------------------------------

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tagging_id")
    private Tagging tagging;

    
//----------------------------------------------------------------
//  	Constructors
//----------------------------------------------------------------
  
	public QuestionTagging() {
	}
	
	public QuestionTagging(Question quest, Tagging tag) {
		this.question = quest;
		this.tagging = tag;
	}

	public QuestionTagging(Long id, Date createdAt, Date updatedAt, Question question, Tagging tagging) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.question = question;
		this.tagging = tagging;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Tagging getTagging() {
		return tagging;
	}

	public void setTagging(Tagging tagging) {
		this.tagging = tagging;
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

