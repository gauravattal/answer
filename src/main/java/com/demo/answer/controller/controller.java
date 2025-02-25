package com.demo.answer.controller;

import com.demo.answer.model.answer;
import com.demo.answer.service.answerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class controller
{
    @Autowired
    private  answerService answerService;

    @PostMapping("/create")
    public answer Save(@RequestBody answer answer)
    {
        return answerService.Save(answer);
    }

    @GetMapping("/{id}")
    public answer findAnswer(@PathVariable int id)
    {
      return answerService.findById(id);
    }


    @GetMapping("/question/{id}")
    public List<answer> getAnswerByQuestionId(@PathVariable int id)
    {
        return answerService.getAnswerByQuestionId(id);
    }


}
