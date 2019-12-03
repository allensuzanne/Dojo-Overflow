package com.codingdojo.dojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoOverflow.models.Tagging;

@Repository
public interface TaggingRepository extends CrudRepository <Tagging, Long>{

	Optional<Tagging> findBySubject(String st);
	

}
