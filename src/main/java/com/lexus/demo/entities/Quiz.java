package com.lexus.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizId;
    private String contact;

    @ManyToOne
    private User adviser;

    private String timeWaiting;
    private String timeToSolve;
    private String knowledge;
    private String satisfaction;


    public int getId_quiz() {
        return quizId;
    }

    public void setId_quiz(int quizId) {
        this.quizId = quizId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public User getAdviser() {
        return adviser;
    }

    public void setAdviser(User adviser) {
        this.adviser = adviser;
    }

    public String getTimeWaiting() {
        return timeWaiting;
    }

    public void setTimeWaiting(String timeWaiting) {
        this.timeWaiting = timeWaiting;
    }

    public String getTimeToSolve() {
        return timeToSolve;
    }

    public void setTimeToSolve(String timeToSolve) {
        this.timeToSolve = timeToSolve;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }
}
