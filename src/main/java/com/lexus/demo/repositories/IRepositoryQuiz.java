package com.lexus.demo.repositories;

import com.lexus.demo.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface IRepositoryQuiz extends JpaRepository<Quiz, Long> {

    List<Quiz> findAllByAdviser_UserId(Long adviserId);
}
