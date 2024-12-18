package org.example.Controllers;

import org.example.Course;
import org.example.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> students = new ArrayList<>();  // In-memory store for students

    // Method to enroll in a course
    @PostMapping("/enroll")
    public String enrollCourse(@RequestParam int studentID, @RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.enrollInCourse(courseID);
            return "Student enrolled in course successfully!";
        }
        return "Student not found!";
    }

    // Method to submit an assignment
    @PostMapping("/submitAssignment")
    public String submitAssignment(@RequestParam int studentID, @RequestParam int assignmentID, @RequestParam int courseID, @RequestParam String data) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.submitAssignment(assignmentID, courseID, data);
            return "Assignment submitted successfully!";
        }
        return "Student not found!";
    }

    // Method to update the student's profile
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam int studentID, @RequestParam String newName, @RequestParam String newEmail) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.updateProfile(newName, newEmail);
            return "Profile updated successfully!";
        }
        return "Student not found!";
    }

    // Method to view enrolled courses
    @GetMapping("/viewCourses")
    public List<Course> viewCourses(@RequestParam int studentID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.getEnrolledCourses();
        }
        return new ArrayList<>();  // Return an empty list if student not found
    }

    // Method to drop a course
    @PostMapping("/dropCourse")
    public String dropCourse(@RequestParam int studentID, @RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.dropCourse(courseID);
            return "Course dropped successfully!";
        }
        return "Student not found!";
    }

    // Method to view grades for assignments
    @GetMapping("/viewGrades")
    public String viewGrades(@RequestParam int studentID, @RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.viewGrades(courseID);
        }
        return "Student not found!";
    }

    // Method to view assignments in a course
    @GetMapping("/viewAssignments")
    public List<String> viewAssignments(@RequestParam int studentID, @RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.viewAssignments(courseID);
        }
        return new ArrayList<>();  // Return an empty list if student not found
    }

    // Method to attempt a quiz
    @PostMapping("/attemptQuiz")
    public String attemptQuiz(@RequestParam int studentID, @RequestParam int quizID, @RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.attemptQuiz(courseID, quizID);
            return "Quiz attempted successfully!";
        }
        return "Student not found!";
    }

    // Method to view the student's progress (overall score, completed assignments, quizzes)
    @GetMapping("/viewProgress/{courseID}")
    public String viewProgress(@RequestParam int studentID,@RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.getProgress(courseID);
        }
        return "Student not found!";
    }

    // Method to view course materials
    @GetMapping("/viewCourseMaterials")
    public List<String> viewCourseMaterials(@RequestParam int studentID, @RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.viewCourseMaterials(courseID);
        }
        return new ArrayList<>();  // Return an empty list if student not found
    }

    // Method to request certification if the student meets the requirements
    @PostMapping("/requestCertification")
    public String requestCertification(@RequestParam int studentID, @RequestParam int courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            if (student.isEligibleForCertification(courseID)) {
                return "Certification requested successfully!";
            } else {
                return "Student is not eligible for certification.";
            }
        }
        return "Student not found!";
    }

    // Helper method to find student by ID (for demo purposes)
    private Student findStudentById(int studentID) {
        for (Student student : students) {
            if (student.getUserID() == studentID) {
                return student;
            }
        }
        return null;
    }
}
