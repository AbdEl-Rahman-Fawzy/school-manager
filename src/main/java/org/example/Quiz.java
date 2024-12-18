package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Quiz class
public class Quiz {
    private int quizID;
    private String title;
    private Quiztype quiztype;
    private List<String> questions;
    private int duration;
    private String startDate;
    private String endDate;
    private double score;
    private int instructorID;
    private boolean isStarted;
    private boolean isEnded;
    private int courseID;

    public Quiz(int quizID, String title, Quiztype quiztype, List<String> questions, int duration,
                String startDate, String endDate, int quizCreator, int courseID) {
        this.quizID = quizID;
        this.title = title;
        this.quiztype = quiztype;
        this.questions = new ArrayList<>(questions);
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.instructorID = quizCreator;
        this.courseID = courseID;
        this.isStarted = false;
        this.isEnded = false;
    }

    //methods
    public void startQuiz() {
        if (isStarted) {
            System.out.println("Quiz has already started.");
            return;
        }
        isStarted = true;
        System.out.println("Quiz started: " + title);
    }

    public void endQuiz() {
        if (!isStarted || isEnded) {
            System.out.println("Quiz is not active or has already ended.");
            return;
        }
        isEnded = true;
        System.out.println("Quiz ended: " + title);
    }

    public void attemptQuiz() {
        if (!isStarted) {
            System.out.println("Quiz has not started yet.");
            return;
        }
        if (isEnded) {
            System.out.println("Quiz has already ended.");
            return;
        }
        System.out.println("Attempting quiz: " + title);
    }

    public void submitAnswers(List<String> studentAnswers) {
        if (!isStarted || isEnded) {
            System.out.println("Quiz is not active.");
            return;
        }
        checkAnswers(studentAnswers);
        System.out.println("Answers submitted for quiz: " + title);
    }

    public void checkAnswers(List<String> studentAnswers) {
        if (studentAnswers == null || studentAnswers.size() != questions.size()) {
            System.out.println("Invalid answers submitted.");
            return;
        }
        score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).equalsIgnoreCase(studentAnswers.get(i))) {
                score += 1;
            }
        }
        System.out.println("Quiz graded. Score: " + score);
    }

    public void shuffleQuestions() {
        Collections.shuffle(questions);
        System.out.println("Questions shuffled.");
    }

    public void getQuizDetails() {
        System.out.println("Quiz ID: " + quizID);
        System.out.println("Title: " + title);
        System.out.println("Type: " + quiztype);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Created by instructorID: " + instructorID);
    }

    public int getID() {
        return quizID;
    }

    public double getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
