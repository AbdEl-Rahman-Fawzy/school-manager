package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends User {

    private String studentID;
    private List<Course> enrolledCourses = new ArrayList<>();
    private List<String> submittedAssignments = new ArrayList<>();
    private List<Quiz> attemptedQuizzes = new ArrayList<>();

    // Constructor
    public Student(int userID, String name, String email, String password, String studentID) {
        super(userID, name, email, password, Role.STUDENT);
        this.studentID = studentID;
    }

    // Method to attempt a quiz
    public void attemptQuiz(int courseID, int quizID) {
        Course course = getCourse(courseID);
        if (course != null) {
            for (Quiz quiz : course.getQuizzes()) {
                if (quiz.getID() == quizID && !attemptedQuizzes.contains(quiz)) {
                    attemptedQuizzes.add(quiz);
                    System.out.println("Quiz attempted successfully.");
                    return;
                }
            }
            System.out.println("Quiz not found or already attempted.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to view course materials
    public List<String> viewCourseMaterials(int courseID) {
        Course course = getCourse(courseID);
        return course != null ? course.getMaterial() : Collections.singletonList("Course not found.");
    }

    // Method to update the student's profile
    public void updateProfile(String newName, String newEmail) {
        setName(newName);
        setEmail(newEmail);
        System.out.println("Profile updated successfully.");
    }

    // Method to log in
    public void login(String email, String password) {
        if (getEmail().equals(email) && getPassword().equals(password)) {
            setActive(true);
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    // Method to log out
    public void logout() {
        setActive(false);
        System.out.println("Logged out successfully.");
    }

    // Getter and Setter methods
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public List<String> getSubmittedAssignments() {
        return submittedAssignments;
    }

    public void setSubmittedAssignments(List<String> submittedAssignments) {
        this.submittedAssignments = submittedAssignments;
    }

    public List<Quiz> getAttemptedQuizzes() {
        return attemptedQuizzes;
    }

    public void setAttemptedQuizzes(List<Quiz> attemptedQuizzes) {
        this.attemptedQuizzes = attemptedQuizzes;
    }

    // Enroll in a course


    // View grades for a course
    public String viewGrades(int courseID) {
        Course course = getCourse(courseID);
        if (course != null) {
            StringBuilder grades = new StringBuilder("Grades:\n");
            for (Quiz quiz : course.getQuizzes()) {
                grades.append("Quiz ID: ").append(quiz.getID()).append(", Score: ").append(quiz.getScore()).append("\n");
            }
            for (Assignment assignment : course.getAssignments()) {
                grades.append("Assignment ID: ").append(assignment.getAssignmentID()).append(", Score: ").append(assignment.getScore()).append("\n");
            }
            return grades.toString();
        } else {
            return "Course not found.";
        }
    }

    // View assignments for a course
    public List<String> viewAssignments(int courseID) {
        Course course = getCourse(courseID);
        if (course != null) {
            List<String> assignments = new ArrayList<>();
            for (Assignment assignment : course.getAssignments()) {
                assignments.add("ID: " + assignment.getAssignmentID() + ", Title: " + assignment.getTitle());
            }
            return assignments;
        } else {
            return Collections.singletonList("Course not found.");
        }
    }

    // Check eligibility for certification
    public boolean isEligibleForCertification(int courseID) {
        Course course = getCourse(courseID);
        if (course != null) {
            int totalScore = 0;
            for (Quiz quiz : course.getQuizzes()) {
                totalScore += quiz.getScore();
            }
            for (Assignment assignment : course.getAssignments()) {
                totalScore += assignment.getScore();
            }
            return totalScore >= 50;
        }
        return false;
    }

    // Get course by ID
    private Course getCourse(int courseID) {
        for (Course course : enrolledCourses) {
            if (course.getCourseID() == courseID) {
                return course;
            }
        }
        return null;
    }

    // Update progress
    public String getProgress(int courseID) {
        Course course = getCourse(courseID);
        if (course != null) {
            StringBuilder progress = new StringBuilder("Progress:\n");
            for (Quiz quiz : course.getQuizzes()) {
                progress.append("Quiz ID: ").append(quiz.getID()).append(", Score: ").append(quiz.getScore()).append("\n");
            }
            for (Assignment assignment : course.getAssignments()) {
                progress.append("Assignment ID: ").append(assignment.getAssignmentID()).append(", Score: ").append(assignment.getScore()).append("\n");
            }
            return progress.toString();
        } else {
            return "Course not found.";
        }
    }

    // Update grade for a course
    public void updateGrade(int courseID, double grade) {
        Course course = getCourse(courseID);
        if (course != null) {
            course.setGrade(grade);
            System.out.println("Grade updated successfully for course " + courseID + ".");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Submit an assignment
    public void submitAssignment(int assignmentID, int courseID, String data) {
        Course course = getCourse(courseID);
        if (course != null) {
            for (Assignment assignment : course.getAssignments()) {
                if (assignment.getAssignmentID() == assignmentID) {
                    submittedAssignments.add(data);
                    System.out.println("Assignment submitted successfully.");
                    return;
                }
            }
            System.out.println("Assignment not found.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Drop a course
    public void dropCourse(int courseID) {
        Course course = getCourse(courseID);
        if (course != null) {
            enrolledCourses.remove(course);
            System.out.println("Dropped course successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }



    public void enrollInCourse(int courseID) {
    }
}
