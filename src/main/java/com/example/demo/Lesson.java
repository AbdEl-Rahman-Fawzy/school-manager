package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Lesson {

    private int lessonID;
    private String title;
    private int courseID;
    private int instructorID;
    private List<String> materials; // List of resources like documents, videos, etc.
    private int duration; // Duration of the lesson in minutes
    private boolean isCompleted; // Indicates whether the lesson is completed or not
    private String dateScheduled;

    // Constructor
    public Lesson(int lessonID, String title, int courseID, int instructorID, int duration) {
        this.lessonID = lessonID;
        this.title = title;
        this.courseID = courseID;
        this.instructorID = instructorID;
        this.duration = duration;
        this.isCompleted = false; // Default to not completed
        this.materials = new ArrayList<>(); // Initialize with an empty list
    }

    // Overloaded constructor
    public Lesson(int lessonID, String title, int courseID, int instructorID, int duration, String dateScheduled) {
        this(lessonID, title, courseID, instructorID, duration);
        this.dateScheduled = dateScheduled;
    }

    // Method to start the lesson
    public String startLesson() {
        if (isCompleted) {
            return "Lesson is already completed.";
        }
        return "Starting lesson: " + title;
    }

    // Method to end the lesson
    public String endLesson() {
        if (isCompleted) {
            return "Lesson is already completed.";
        }
        isCompleted = true;
        return "Lesson ended: " + title;
    }

    // Method to update lesson materials
    public String updateMaterials(List<String> newMaterials) {
        if (newMaterials == null || newMaterials.isEmpty()) {
            return "No materials provided to update.";
        }
        this.materials.clear();
        this.materials.addAll(newMaterials);
        return "Materials updated for lesson: " + title;
    }

    // Method to check if the lesson is completed
    public boolean checkCompletion() {
        return isCompleted;
    }

    // Method to get lesson details
    public String getLessonDetails() {
        return "Lesson ID: " + lessonID + "\n" +
                "Title: " + title + "\n" +
                "Course ID: " + courseID + "\n" +
                "Instructor ID: " + instructorID + "\n" +
                "Duration: " + duration + " minutes\n" +
                "Scheduled Date: " + dateScheduled + "\n" +
                "Completion Status: " + (isCompleted ? "Completed" : "Not Completed") + "\n" +
                "Materials: " + (materials.isEmpty() ? "No materials available" : materials);
    }

    // Getter and Setter methods
    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public String getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(String dateScheduled) {
        this.dateScheduled = dateScheduled;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
