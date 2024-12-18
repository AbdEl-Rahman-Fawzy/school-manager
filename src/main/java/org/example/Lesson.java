package org.example;

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
    public void startLesson() {
        if (isCompleted) {
            System.out.println("Lesson is already completed.");
            return;
        }
        System.out.println("Starting lesson: " + title);
    }

    // Method to end the lesson
    public void endLesson() {
        if (isCompleted) {
            System.out.println("Lesson is already completed.");
            return;
        }
        isCompleted = true;
        System.out.println("Lesson ended: " + title);
    }

    // Method to update lesson materials
    public void updateMaterials(List<String> newMaterials) {
        if (newMaterials == null || newMaterials.isEmpty()) {
            System.out.println("No materials provided to update.");
            return;
        }
        this.materials.clear();
        this.materials.addAll(newMaterials);
        System.out.println("Materials updated for lesson: " + title);
    }

    // Method to check if the lesson is completed
    public boolean checkCompletion() {
        return isCompleted;
    }

    // Method to get lesson details
    public void getLessonDetails() {
        System.out.println("Lesson ID: " + lessonID);
        System.out.println("Title: " + title);
        System.out.println("Course ID: " + courseID);
        System.out.println("Instructor ID: " + instructorID);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Scheduled Date: " + dateScheduled);
        System.out.println("Completion Status: " + (isCompleted ? "Completed" : "Not Completed"));
        System.out.println("Materials: " + (materials.isEmpty() ? "No materials available" : materials));
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
