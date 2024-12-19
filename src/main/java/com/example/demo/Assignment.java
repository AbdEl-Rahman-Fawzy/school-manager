package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Assignment {

    private int assignmentID;
    private String courseID;
    private String title;
    private String description;
    private String dueDate;
    private List<String> submittedAssignments; // List of student IDs who submitted
    private double gradingCriteria; // Grading criteria (could be a percentage or points)
    private String instructorID; // ID of the instructor who created the assignment
    private boolean isGraded; // Whether the assignment has been graded or not

    // Constructor
    public Assignment(int assignmentID, String courseID, String title, String description, String dueDate, double gradingCriteria, String instructorID) {
        this.assignmentID = assignmentID;
        this.courseID = courseID;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.gradingCriteria = gradingCriteria;
        this.instructorID = instructorID;
        this.isGraded = false; // Default to not graded
        this.submittedAssignments = new ArrayList<>(); // Initialize the list
    }

    // Method to create an assignment
    public String createAssignment() {
        return "Assignment created: " + title;
    }

    // Method to submit an assignment
    public String submitAssignment(String studentID) {
        if (submittedAssignments.contains(studentID)) {
            return "Assignment already submitted by student: " + studentID;
        }
        submittedAssignments.add(studentID);
        return "Assignment submitted by student: " + studentID;
    }

    // Method to grade an assignment
    public String gradeAssignment(String studentID, double grade) {
        if (!submittedAssignments.contains(studentID)) {
            return "Student " + studentID + " has not submitted the assignment.";
        }
        if (isGraded) {
            return "Assignment is already graded.";
        }
        isGraded = true;
        return "Assignment graded for student: " + studentID + " with grade: " + grade;
    }

    // Method to check if the assignment is graded
    public boolean checkGradingStatus() {
        return isGraded;
    }

    // Method to get the details of the assignment
    public String getAssignmentDetails() {
        return "Assignment ID: " + assignmentID + "\n" +
                "Course ID: " + courseID + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Due Date: " + dueDate + "\n" +
                "Grading Criteria: " + gradingCriteria + "\n" +
                "Instructor ID: " + instructorID + "\n" +
                "Submitted Assignments: " + (submittedAssignments.isEmpty() ? "None" : submittedAssignments) + "\n" +
                "Graded: " + (isGraded ? "Yes" : "No");
    }

    // Getter and Setter methods
    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<String> getSubmittedAssignments() {
        return new ArrayList<>(submittedAssignments);
    }

    public void setSubmittedAssignments(List<String> submittedAssignments) {
        this.submittedAssignments = new ArrayList<>(submittedAssignments);
    }

    public double getGradingCriteria() {
        return gradingCriteria;
    }

    public void setGradingCriteria(double gradingCriteria) {
        this.gradingCriteria = gradingCriteria;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }

    public String gradeStudent(int studentID, double grade) {
        // Check if the student has submitted the assignment
        if (!submittedAssignments.contains(String.valueOf(studentID))) {
            return "Student " + studentID + " has not submitted the assignment.";
        }

        // Check if the assignment has already been graded
        if (isGraded) {
            return "Assignment is already graded.";
        }

        // Assign grade to the student
        // You can store the grade in a map or list if needed (not done here for simplicity)
        isGraded = true;  // Mark assignment as graded
        return "Assignment graded for student: " + studentID + " with grade: " + grade;
    }

    public double getScore() {
        // Return grade if graded, otherwise return a message indicating it's not graded yet
        if (isGraded) {
            return gradingCriteria;
        }
        return -1;
    }

}
