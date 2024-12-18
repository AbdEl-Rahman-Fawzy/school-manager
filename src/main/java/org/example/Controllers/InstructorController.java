package org.example.Controllers;

import org.example.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private ArrayList<Instructor> instructors = new ArrayList<>();  // In-memory store for instructors
    public InstructorController() {
        instructors.add(new Instructor(1, "John Doe", "john.doe@example.com","123123", "Expert "));
        instructors.add(new Instructor(2, "Jane Smith", "jane.smith@example.com","123321", "Data Science "));
    }


    // Method to create a course
    @PostMapping("/createCourse")
    public String createCourse(@RequestParam int instructorID, @RequestParam int courseID, @RequestParam String title , @RequestParam String description) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            //create course and add it
            Course course = new Course(courseID, title, description,instructorID);
            instructor.createCourse(course);
            return "Course created successfully!";
        }
        return "Instructor not found!";
    }

    // Method to assign a lesson
    @PostMapping("/addLesson")
    public String assignLesson(@RequestParam int instructorID, @RequestParam int lessonID, @RequestParam int courseID, @RequestParam int duration,@RequestParam String date, @RequestParam String title) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            Lesson lesson = new Lesson(lessonID, title, courseID, instructor.getUserID(),duration,date );
            instructor.addLesson(lesson);
            return "Lesson assigned successfully!";
        }
        return "Instructor not found!";
    }

    // Method to grade a student assignment
    @PostMapping("/gradeAssignment")
    public String gradeAssignment(@RequestParam int instructorID, @RequestParam String studentID, @RequestParam int assignmentID, @RequestParam double grade) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.gradeAssignment(studentID, assignmentID, grade);
            return "Assignment graded successfully!";
        }
        return "Instructor not found!";
    }

    // Method to add a quiz to a course
    @PostMapping("/addQuiz")
    public String addQuiz(
            @RequestParam int instructorID,
            @RequestParam int courseID,
            @RequestParam int quizID,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam List<String> questions, // Accept list directly
            @RequestParam Quiztype quiztype,
            @RequestParam String title,
            @RequestParam int duration
    ) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            Quiz quiz = new Quiz(quizID, title, quiztype, questions, duration, startDate, endDate, instructorID, courseID);
            instructor.addQuiz(quiz);
            return "Quiz added to course successfully!";
        }
        return "Instructor not found!";
    }

    // Method to view a list of students in a course
    @GetMapping("/viewStudents")
    public List<String> viewStudents(@RequestParam int instructorID, @RequestParam int courseID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            return instructor.viewStudentsInCourse(courseID);
        }
        return null; // Or return an appropriate response
    }


    // Method to view student progress in a course
    @GetMapping("/viewProgress")
    public String viewProgress(@RequestParam int instructorID, @RequestParam int studentID, @RequestParam int courseID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            return instructor.viewStudentProgress(studentID, courseID);  // Assuming this method is implemented
        }
        return "Instructor not found!";
    }

    // Method to upload course materials
    @PostMapping("/uploadMaterial")
    public String uploadMaterial(@RequestParam int instructorID, @RequestParam int courseID, @RequestParam String data ) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.uploadCourseMaterial(courseID, data);  // Assuming method is implemented in Instructor class
            return "Course material uploaded successfully!";
        }
        return "Instructor not found!";
    }

    // Method to update the instructor's profile (e.g., bio)
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam int instructorID, @RequestParam String newname, @RequestParam String newEmail, @RequestParam String newBio) {
        Instructor instructor = findInstructorById(instructorID);
        System.out.println("Instructor ID: " + instructorID);
        System.out.println("New Name: " + newname);
        System.out.println("New Email: " + newEmail);
        System.out.println("New Bio: " + newBio);
        if (instructor != null) {
            instructor.updateProfile(newname, newEmail, newBio);
            return "Instructor profile updated successfully!";
        }
        return "Instructor not found!";
    }


    // Method to get the list of courses created by the instructor
    @GetMapping("/viewCoursesCreated")
    public String viewCoursesCreated(@RequestParam int instructorID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            return instructor.getCoursesCreated();
        }
        return null;
    }

    // Method to grade a student
    @PostMapping("/gradeStudent")
    public String gradeStudent(@RequestParam int instructorID, @RequestParam int studentID, @RequestParam int courseID, @RequestParam double grade) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.gradeStudent(studentID,courseID, grade);  // Calling the gradeStudent method in Instructor class
            return "Student graded successfully!";
        }
        return "Instructor not found!";
    }


    // Helper method to find instructor by ID (for demo purposes)
    private Instructor findInstructorById(int instructorID) {
        for (Instructor instructor : instructors) {
            if (instructor.getUserID() == instructorID) {
                return instructor;
            }
        }
        return null;
    }
}
