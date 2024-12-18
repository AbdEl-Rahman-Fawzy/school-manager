package org.example;

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
    public void createAssignment() {
        System.out.println("Assignment created: " + title);
    }

    // Method to submit an assignment
    public void submitAssignment(String studentID) {
        if (submittedAssignments.contains(studentID)) {
            System.out.println("Assignment already submitted by student: " + studentID);
            return;
        }
        submittedAssignments.add(studentID);
        System.out.println("Assignment submitted by student: " + studentID);
    }

    // Method to grade an assignment
    public void gradeAssignment(String studentID, double grade) {
        if (!submittedAssignments.contains(studentID)) {
            System.out.println("Student " + studentID + " has not submitted the assignment.");
            return;
        }
        if (isGraded) {
            System.out.println("Assignment is already graded.");
            return;
        }
        System.out.println("Assignment graded for student: " + studentID + " with grade: " + grade);
        isGraded = true;
    }

    // Method to check if the assignment is graded
    public boolean checkGradingStatus() {
        return isGraded;
    }

    // Method to get the details of the assignment
    public void getAssignmentDetails() {
        System.out.println("Assignment ID: " + assignmentID);
        System.out.println("Course ID: " + courseID);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Grading Criteria: " + gradingCriteria);
        System.out.println("Instructor ID: " + instructorID);
        System.out.println("Submitted Assignments: " + (submittedAssignments.isEmpty() ? "None" : submittedAssignments));
        System.out.println("Graded: " + (isGraded ? "Yes" : "No"));
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

    public void gradeStudent(String studentID, double grade) {
    }

    public double getScore() {
        return getScore();
    }
}
