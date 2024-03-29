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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="taggings")
public class Tagging {
	

//----------------------------------------------------------------
//							Attributes
//----------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=2)
    private String subject;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "questions_taggings", 
        joinColumns = @JoinColumn(name = "tagging_id"), 
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )     
    private List<Question> questions;
    
    
//----------------------------------------------------------------
//    	Constructors
//----------------------------------------------------------------
    
    
	public Tagging() {

	}

	public Tagging(String st) {
		this.subject = st;
	}
	
	public Tagging(Long id, String subject, Date createdAt, Date updatedAt, List<Question> questions) {
		this.id = id;
		this.subject = subject;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.questions = questions;
	}

    
//----------------------------------------------------------------
//		  		Getters and Setters
//----------------------------------------------------------------
		  
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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

