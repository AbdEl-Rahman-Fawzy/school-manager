package com.example.demo.Controllers;

import com.example.demo.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private Student findStudentById(int studentID) {
        return Student.students.stream().filter(student -> student.getStudentID() == studentID || student.getUserID() == studentID).findFirst().orElse(null);
    }

    // Helper method to handle operation
    private String handleStudentOperation(int studentID, StudentOperation operation) {
        Student student = findStudentById(studentID);
        if (student == null) {
            return "Student not found!";
        }
        if (!student.isActive()) {
            return "User not active!";
        }
        return operation.apply(student);
    }

    @PostMapping("/enroll")
    public String enrollCourse(@RequestParam int studentID, @RequestParam int courseID) {
        return handleStudentOperation(studentID, student -> {
            student.enrollCourse(courseID);
            return "Student enrolled in course successfully!";
        });
    }

    @PostMapping("/submitAssignment")
    public String submitAssignment(@RequestParam int studentID, @RequestParam int assignmentID,
                                   @RequestParam int courseID, @RequestParam String data) {
        return handleStudentOperation(studentID, student -> {
            student.submitAssignment(assignmentID, courseID, data);
            return "Assignment submitted successfully!";
        });
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam int studentID, @RequestParam String newName,
                                @RequestParam String newEmail) {
        return handleStudentOperation(studentID, student -> {
            student.updateProfile(newName, newEmail);
            return "Profile updated successfully!";
        });
    }

    @GetMapping("/viewCourses")
    public List<Course> viewCourses(@RequestParam int studentID) {
        Student student = findStudentById(studentID);
        return student != null && student.isActive() ? student.getEnrolledCourses() : new ArrayList<>();
    }

    @PostMapping("/dropCourse")
    public String dropCourse(@RequestParam int studentID, @RequestParam int courseID) {
        return handleStudentOperation(studentID, student -> {
            student.dropCourse(courseID);
            return "Course dropped successfully!";
        });
    }

    @GetMapping("/viewGrades")
    public String viewGrades(@RequestParam int studentID, @RequestParam int courseID) {
        return handleStudentOperation(studentID, student -> student.viewGrades(courseID));
    }

    @PostMapping("/attemptQuiz")
    public String attemptQuiz(@RequestParam int studentID, @RequestParam int quizID, @RequestParam int courseID) {
        return handleStudentOperation(studentID, student -> {
            student.attemptQuiz(courseID, quizID);
            return "Quiz attempted successfully!";
        });
    }

    @GetMapping("/viewProgress/{courseID}")
    public String viewProgress(@RequestParam int studentID, @RequestParam int courseID) {
        return handleStudentOperation(studentID, student -> student.getProgress(courseID));
    }

    @PostMapping("/requestCertification")
    public String requestCertification(@RequestParam int studentID, @RequestParam int courseID) {
        return handleStudentOperation(studentID, student -> student.isEligibleForCertification(courseID)
                ? "Certification requested successfully!"
                : "Student is not eligible for certification.");
    }

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestParam int senderID, @RequestParam int notificationID,
                                   @RequestParam int receiverID, @RequestParam String data) {
        return handleStudentOperation(senderID, student -> {
            Notification notification = new Notification(notificationID, senderID, data, receiverID);
            return notification.send();
        });
    }

    @PostMapping("/readNotification")
    public String readNotification(@RequestParam int senderID) {
        return handleStudentOperation(senderID, Student::readNotifications);
    }

    @PostMapping("/readUnreadNotification")
    public String readUnreadNotification(@RequestParam int senderID) {
        return handleStudentOperation(senderID, Student::readUnreadNotifications);
    }

    @PostMapping("/login")
    public String login(@RequestParam String mail, @RequestParam String password, @RequestParam int id) {
        Student student = findStudentById(id);
        if (student != null) {
            return student.login(mail, password);
        }
        return "Admin not found!";
    }

    @PostMapping("/logout")
    public String signUp(@RequestParam int id) {
        Student student = findStudentById(id);
        return student != null && student.isActive() ? student.logout() : "User not active!";
    }

    // Functional interface to represent operations on a student
    @FunctionalInterface
    interface StudentOperation {
        String apply(Student student);
    }
}
