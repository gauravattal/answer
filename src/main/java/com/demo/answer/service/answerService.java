package com.demo.answer.service;

import com.demo.answer.model.answer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface answerService {

    public answer Save(answer answer);
    public answer findById(int id);
    public List<answer> getAnswerByQuestionId(int id);
}
