package com.demo.answer.repository;

import com.demo.answer.model.answer;
import com.demo.answer.model.answerresponse;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface answerRepository extends JpaRepository<answer, Integer> {

    public List<answer> getAnswerByquestionid(int questionId);

}
