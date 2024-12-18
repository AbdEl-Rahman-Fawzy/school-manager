package org.example;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private final List<Course> coursesCreated; // List of course IDs created by the instructor
    private final String department; // Department the instructor belongs to
    private String bio; // Short biography of the instructor
    private boolean isActive; // Whether the instructor is currently active

    // Constructor
    public Instructor(int userID, String name, String email, String password, String department) {
        super( userID, name, email, password, Role.INSTRUCTOR);  // Call the constructor of the abstract User class
        this.department = department;
        this.isActive = true; // Default active status
        this.coursesCreated = new ArrayList<>();
    }

    // Method to create a course
    public String createCourse(Course newCourse) {
        coursesCreated.add(newCourse);
        return "Course created successfully: " + newCourse.getCourseID();
    }
    public String addLesson( Lesson lesson) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == lesson.getCourseID()) {
                course.addLesson(lesson);
                return "Lesson assigned successfully: " + lesson.getLessonID();
            }
        }
        return "Error: Course not found or unauthorized access.";
    }

    // Method to grade a student
    public boolean gradeStudent(int studentID, int courseID, double grade) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                for (Student student : course.getStudentList()) {
                    if (student.getUserID() == studentID) {
                        student.updateGrade(courseID, grade); // Assuming Student has a method to update grade for a course
                        System.out.println("Graded student " + studentID + " for course " + courseID + " with grade: " + grade);
                        return true;
                    }
                }
            }
        }
        System.out.println("Error: Student not found in course.");
        return false;
    }

    // Method to add a quiz to a course
    public String addQuiz(Quiz quiz) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == quiz.getCourseID()) {
                course.addQuiz(quiz);
                System.out.println("Quiz " + quiz.getID() + " added to course: " + quiz.getCourseID());
                return "Quiz added successfully.";
            }
        }
        return "Error: Course not found or unauthorized access.";
    }

    public String getCoursesCreated() {
        StringBuilder courses = new StringBuilder();
        for (Course course : coursesCreated) {
            courses.append(course.getCourseID()).append(" - ").append(course.getTitle()).append("\n");
        }
        return courses.toString();
    }

    public String login(String email, String password) {
        if (getEmail().equals(email) && getPassword().equals(password)) {
            setActive(true);
            return ("Login successful.");
        } else {
            return ("Invalid email or password.");
        }
    }


    // Method to logout as a student
    public String logout() {
        setActive(false);
        return ("Logged out successfully.");
    }
    public String updateProfile(String newName, String newEmail, String newBio) {
        setName(newName);
        setEmail(newEmail);
        this.bio = newBio;
        return ("Profile updated successfully: " + newName + " | " + newEmail + " | Bio: " + newBio);
    }

    public String gradeAssignment(String studentID, int assignmentID, double grade) {
        for (Course course : coursesCreated) {
            for (Assignment assignment : course.getAssignments()) { // Assuming Course has a getAssignments method
                if (assignment.getAssignmentID() == assignmentID) {
                    assignment.gradeStudent(studentID, grade); // Assuming Assignment has a gradeStudent method
                    return ("Graded assignment " + assignmentID + " for student " + studentID + ".");
                }
            }
        }
        return ("Error: Assignment or student not found.");
    }

    public List<String> viewStudentsInCourse(int courseID) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                List<String> studentData = new ArrayList<>();
                for (Student student : course.getStudentList()) {
                    studentData.add("ID: " + student.getUserID() + ", Name: " + student.getName());
                }
                return studentData;
            }
        }
        return new ArrayList<>();
    }

    public String viewStudentProgress(int studentID, int courseID) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                for (Student student : course.getStudentList()) {
                    if (student.getUserID() == studentID) {
                        return student.getProgress(courseID); // Assuming Student has a getProgress method
                    }
                }
            }
        }
        System.out.println("Error: Student or course not found.");
        return "";
    }

    public String uploadCourseMaterial(int courseID, String materialID) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                course.addMaterial(materialID);
                return ("Material " + materialID + " uploaded for course: " + courseID);
            }
        }
        return ("Error: Course not found or unauthorized access.");
    }


}