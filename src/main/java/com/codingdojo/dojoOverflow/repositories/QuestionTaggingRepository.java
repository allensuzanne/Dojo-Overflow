package com.codingdojo.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoOverflow.models.QuestionTagging;

@Repository
public interface QuestionTaggingRepository extends CrudRepository<QuestionTagging, Long> {

}
