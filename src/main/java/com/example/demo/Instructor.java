package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private final List<Course> coursesCreated; // List of course IDs created by the instructor
    private final String department; // Department the instructor belongs to
    private String bio; // Short biography of the instructor
    private boolean isActive; // Whether the instructor is currently active
    public static List<Instructor> instructors = new ArrayList<>();  // Static list of all instructors


    // Constructor
    public Instructor(int userID, String name, String email, String password, String department) {
        super(userID, name, email, password, Role.INSTRUCTOR);  // Call the constructor of the abstract User class
        this.department = department;
        this.isActive = true; // Default active status
        this.coursesCreated = new ArrayList<>();
        instructors.add(this);  // Add this instructor to the static list
    }

    // Method to create a course
    public String createCourse(Course newCourse) {
        coursesCreated.add(newCourse);
        return "Course created successfully: " + newCourse.getCourseID();
    }

    public String addLesson(Lesson lesson) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == lesson.getCourseID()) {
                course.addLesson(lesson);
                return "Lesson assigned successfully: " + lesson.getLessonID();
            }
        }
        return "Error: Course not found or unauthorized access.";
    }

    // Method to grade a student
    public String gradeStudent(int studentID, int courseID, double grade) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                for (Student student : course.getStudentList()) {
                    if (student.getUserID() == studentID) {
                        student.updateGrade(courseID, grade); // Assuming Student has a method to update grade for a course
                        return "Graded student " + studentID + " for course " + courseID + " with grade: " + grade;
                    }
                }
            }
        }
        return "Error: Student not found in course.";
    }

    // Method to add a quiz to a course
    public String addQuiz(Quiz quiz) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == quiz.getCourseID()) {
                course.addQuiz(quiz);
                return "Quiz " + quiz.getID() + " added to course: " + quiz.getCourseID();
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
            return "Login successful.";
        } else {
            return "Invalid email or password.";
        }
    }

    // Method to logout
    public String logout() {
        setActive(false);
        return "Logged out successfully.";
    }

    public String updateProfile(String newName, String newEmail, String newBio) {
        setName(newName);
        setEmail(newEmail);
        this.bio = newBio;
        return "Profile updated successfully: " + newName + " | " + newEmail + " | Bio: " + newBio;
    }

    public String gradeAssignment(int studentID, int assignmentID, double grade) {
        for (Course course : coursesCreated) {
            for (Assignment assignment : course.getAssignments()) { // Assuming Course has a getAssignments method
                if (assignment.getAssignmentID() == assignmentID) {
                    assignment.gradeStudent(studentID, grade); // Assuming Assignment has a gradeStudent method
                    return "Graded assignment " + assignmentID + " for student " + studentID + ".";
                }
            }
        }
        return "Error: Assignment or student not found.";
    }

    public String viewStudentsInCourse(int courseID) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                List<String> studentData = new ArrayList<>();
                for (Student student : course.getStudentList()) {
                    studentData.add("ID: " + student.getUserID() + ", Name: " + student.getName());
                }
                if (studentData.size() == 0){
                    return "NO student enrolled yet in course";
                }
                return String.valueOf(studentData);
            }
        }
        return "Not an available course ";
    }

    public String viewStudentProgress(int studentID, int courseID) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                for (Student student : course.getStudentList()) {
                    System.out.println("Wtf");
                    if (student.getUserID() == studentID) {
                        return student.getProgress(courseID);
                    }
                }
                return "Error Student not found.";
            }
            return "Error course not found.";
        }
        return "Error: Student or course not found.";
    }

    public String uploadCourseMaterial(int courseID, String materialID) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                course.addMaterial(materialID);
                return "Material " + materialID + " uploaded for course: " + courseID;
            }
        }
        return "Error: Course not found or unauthorized access.";
    }

    public String sendFeedback(int courseID, int studentID, String feedback) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                for (Student student : course.getStudentList()) {
                    if (student.getUserID() == studentID) {
                        student.addFeedback(this.getName(), feedback);
                        return "Feedback sent successfully.";
                    }
                }
            }
        }
        return "Student or course not found.";
    }

    public String addQuestion(int courseID, String data) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {
                course.addQuistion(data);
                return "Question added successfully.";
            }
        }
        return "Course not found.";
    }

    public String gradeQuiz(int studentID, int courseID, int quizID, double grade) {
        for (Course course : coursesCreated) {
            if (course.getCourseID() == courseID) {

                for (Student student : course.getStudentList()) {
                    if (student.getStudentID() == studentID) {System.out.println("wtf");
                        for (Quiz quiz : student.getAttemptedQuizzes()) {
                            if (quiz.getID() == quizID) {
                                quiz.setGrade(grade);
                                return "Graded successfully.";
                            }
                        }
                        return "Student didn't attempt quiz.";
                    }
                }
                return "Invalid student ID.";
            }
        }
        return "Invalid course ID.";
    }
}