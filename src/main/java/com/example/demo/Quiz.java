package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Quiz class
public class Quiz {
    public static List<Quiz> quizzes = new ArrayList<>(); // Public static list of quizzes

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
        this.score = 0;
        this.isStarted = false;
        this.isEnded = false;
        quizzes.add(this); // Add quiz to the static list upon creation
    }

    // Methods
    public String startQuiz() {
        if (isStarted) {
            return "Quiz has already started.";
        }
        isStarted = true;
        return "Quiz started: " + title;
    }

    public String endQuiz() {
        if (!isStarted || isEnded) {
            return "Quiz is not active or has already ended.";
        }
        isEnded = true;
        return "Quiz ended: " + title;
    }

    public String attemptQuiz() {
        if (!isStarted) {
            return "Quiz has not started yet.";
        }
        if (isEnded) {
            return "Quiz has already ended.";
        }
        return "Attempting quiz: " + title;
    }

    public String submitAnswers(List<String> studentAnswers) {
        if (!isStarted || isEnded) {
            return "Quiz is not active.";
        }
        return checkAnswers(studentAnswers);
    }

    public String checkAnswers(List<String> studentAnswers) {
        if (studentAnswers == null || studentAnswers.size() != questions.size()) {
            return "Invalid answers submitted.";
        }
        score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).equalsIgnoreCase(studentAnswers.get(i))) {
                score += 1;
            }
        }
        return "Quiz graded. Score: " + score;
    }

    public String shuffleQuestions() {
        Collections.shuffle(questions);
        return "Questions shuffled.";
    }

    public String getQuizDetails() {
        return "Quiz ID: " + quizID + "\n" +
                "Title: " + title + "\n" +
                "Type: " + quiztype + "\n" +
                "Duration: " + duration + " minutes\n" +
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n" +
                "Created by instructorID: " + instructorID;
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

    public void setGrade(double grade) {
        this.score = grade;
    }
}
