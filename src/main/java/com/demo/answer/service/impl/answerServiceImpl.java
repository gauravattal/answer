package com.demo.answer.service.impl;

import com.demo.answer.model.answer;
import com.demo.answer.repository.answerRepository;
import com.demo.answer.service.answerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class answerServiceImpl implements answerService {

    @Autowired
    private final  answerRepository answerRepository;

    public answerServiceImpl(answerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public answer Save(answer answer)
    {
        return answerRepository.save(answer);
    }

    public answer findById(int id) {
        answer answer = answerRepository.findById(id).get();
        return answer;
    }

    @Override
    public List<answer> getAnswerByQuestionId(int id) {
        List<answer> answerByQuestionId = answerRepository.getAnswerByquestionid(id);
        return answerByQuestionId;
    }


}
