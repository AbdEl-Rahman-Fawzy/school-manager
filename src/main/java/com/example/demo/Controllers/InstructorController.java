package com.example.demo.Controllers;

import com.example.demo.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    // Method to create a course
    @PostMapping("/createCourse")
    public String createCourse(@RequestParam int instructorID, @RequestParam int courseID,
                               @RequestParam String title, @RequestParam String description) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                Course course = new Course(courseID, title, description, instructorID);
                instructor.createCourse(course);
                return "Course created successfully!";
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to assign a lesson
    @PostMapping("/addLesson")
    public String assignLesson(@RequestParam int instructorID, @RequestParam int lessonID,
                               @RequestParam int courseID, @RequestParam int duration,
                               @RequestParam String date, @RequestParam String title) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                Lesson lesson = new Lesson(lessonID, title, courseID, instructor.getUserID(), duration, date);
                instructor.addLesson(lesson);
                return "Lesson assigned successfully!";
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to grade a student assignment
    @PostMapping("/gradeAssignment")
    public String gradeAssignment(@RequestParam int instructorID, @RequestParam int studentID,
                                  @RequestParam int assignmentID, @RequestParam double grade) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                instructor.gradeAssignment(studentID, assignmentID, grade);
                return "Assignment graded successfully!";
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }


    // Method to add a quiz to a course
    @PostMapping("/addQuiz")
    public String addQuiz(@RequestParam int instructorID, @RequestParam int courseID,
                          @RequestParam int quizID, @RequestParam String startDate,
                          @RequestParam String endDate, @RequestParam List<String> questions,
                          @RequestParam Quiztype quiztype, @RequestParam String title,
                          @RequestParam int duration) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                Quiz quiz = new Quiz(quizID, title, quiztype, questions, duration, startDate, endDate, instructorID, courseID);
                instructor.addQuiz(quiz);
                return "Quiz added to course successfully!";
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to view a list of students in a course
    @GetMapping("/viewStudents")
    public String viewStudents(@RequestParam int instructorID, @RequestParam int courseID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                return String.valueOf(instructor.viewStudentsInCourse(courseID));
            }
            return "User not active!";
        }
        return "Invalid Instructor ID";
    }

    // Method to view student progress in a course
    @GetMapping("/viewProgress")
    public String viewProgress(@RequestParam int instructorID, @RequestParam int studentID, @RequestParam int courseID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                return instructor.viewStudentProgress(studentID, courseID);  // Assuming this method is implemented
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to upload course materials
    @PostMapping("/uploadMaterial")
    public String uploadMaterial(@RequestParam int instructorID, @RequestParam int courseID, @RequestParam String data) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                instructor.uploadCourseMaterial(courseID, data);  // Assuming method is implemented in Instructor class
                return "Course material uploaded successfully!";
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to update the instructor's profile (e.g., bio)
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam int instructorID, @RequestParam String newname,
                                @RequestParam String newEmail, @RequestParam String newBio) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                instructor.updateProfile(newname, newEmail, newBio);
                return "Instructor profile updated successfully!";
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to get the list of courses created by the instructor
    @GetMapping("/viewCoursesCreated")
    public String viewCoursesCreated(@RequestParam int instructorID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                return instructor.getCoursesCreated();
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to add feedback to a student
    @PostMapping("/addFeedback")
    public String addFeedback(@RequestParam int instructorID, @RequestParam int courseID,
                              @RequestParam int studentID, @RequestParam String feedback) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                return instructor.sendFeedback(courseID, studentID, feedback);
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to send a notification
    public String sendNotification(@RequestParam int senderID, @RequestParam int notificationID,
                                   @RequestParam int receiverID, @RequestParam String data) {
        Instructor instructor = findInstructorById(senderID);
        if (instructor != null) {
            if (instructor.isActive()) {
                Notification notification = new Notification(notificationID, senderID, data, receiverID);
                return notification.send();
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to add a question to a course
    @PostMapping("/addQuestion")
    public String addQuestion(@RequestParam int instructorID, @RequestParam String data, @RequestParam int courseID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                return instructor.addQuestion(courseID, data);
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to grade a quiz
    @PostMapping("/gradeQuiz")
    public String gradeQuiz(@RequestParam int instructorID, @RequestParam int studentID,
                            @RequestParam int courseID, @RequestParam int quizID,
                            @RequestParam double grade) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            if (instructor.isActive()) {
                instructor.gradeQuiz(studentID, courseID, quizID, grade);
                return "Student graded successfully!";
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to read notifications
    @PostMapping("/readNotification")
    public String readNotification(@RequestParam int senderID) {
        Instructor instructor = findInstructorById(senderID);
        if (instructor != null) {
            if (instructor.isActive()) {
                return instructor.readNotifications();
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }

    // Method to read unread notifications
    @PostMapping("/readUnreadNotification")
    public String readUnreadNotification(@RequestParam int senderID) {
        Instructor instructor = findInstructorById(senderID);
        if (instructor != null) {
            if (instructor.isActive()) {
                return instructor.readUnreadNotifications();
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }
    @PostMapping("/login")
    public String login(@RequestParam String mail,@RequestParam String password ,@RequestParam int id) {
        Instructor instructor = findInstructorById(id);
        return instructor.login(mail,password);
    }
    @PostMapping("/logout")
    public String signUp(@RequestParam int id) {
        Instructor instructor = findInstructorById(id);
        if (instructor != null) {
            if (instructor.isActive()) {
                return instructor.logout();
            }
            return "User not active!";
        }
        return "Instructor not found!";
    }
    private Instructor findInstructorById(int instructorID) {
        for (Instructor instructor : Instructor.instructors) {
            if (instructor.getUserID() == instructorID) {
                return instructor;
            }
        }
        return null;
    }

}

