package com.lexus.demo.services;

import com.lexus.demo.entities.Quiz;
import com.lexus.demo.repositories.IRepositoryQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizDao {

   @Autowired
   IRepositoryQuiz iRepositoryQuiz;

    public boolean saveQuiz(Quiz quiz){
        if(iRepositoryQuiz.save(quiz) != null){
            return true;
        }

        return false;
    }

    public List<Quiz> findQuizByAdviserId(long idAdviser){
        return iRepositoryQuiz.findAllByAdviser_UserId(idAdviser);
    }

    public List<Quiz> findAll(){
        return iRepositoryQuiz.findAll();
    }
}
