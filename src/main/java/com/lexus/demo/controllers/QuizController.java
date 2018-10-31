package com.lexus.demo.controllers;

import com.lexus.demo.entities.Quiz;
import com.lexus.demo.entities.User;
import com.lexus.demo.services.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {


    @Autowired
    QuizDao quizDao;

    @PostMapping("/adviser/{id_adviser}/quiz")
    @CrossOrigin("*")
    public boolean saveQuiz(@RequestBody Quiz quiz, @PathVariable long id_adviser){
        quiz.setAdviser(new User(id_adviser));
        if(quizDao.saveQuiz(quiz)){
            return true;
        }

        return false;
    }


    @GetMapping("/adviser/{id_adviser}/quiz")
    @CrossOrigin("*")
    public List<Quiz> findQuizByADviserId(@PathVariable long id_adviser){
        return quizDao.findQuizByAdviserId(id_adviser);
    }

    @GetMapping("/quiz")
    @CrossOrigin("*")
    public List<Quiz> findAllQuiz(){
        return quizDao.findAll();
    }

}

/*
{
	"contact":"algo",
	"timeWaiting":"1 hora",
    "timeToSolve": "30 min",
    "knowledge": "bueno",
    "satisfaction": "alta"
}
*/