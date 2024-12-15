import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private List<Instructor> instructors;  // In-memory store for instructors

    // Method to create a course
    @PostMapping("/createCourse")
    public String createCourse(@RequestParam String instructorID, @RequestParam String courseID, @RequestParam String courseName) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.createCourse(courseID, courseName);
            return "Course created successfully!";
        }
        return "Instructor not found!";
    }

    // Method to assign a lesson
    @PostMapping("/assignLesson")
    public String assignLesson(@RequestParam String instructorID, @RequestParam String lessonID, @RequestParam String courseID, @RequestParam String lessonName) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.assignLesson(lessonID, courseID, lessonName);
            return "Lesson assigned successfully!";
        }
        return "Instructor not found!";
    }

    // Method to grade a student assignment
    @PostMapping("/gradeAssignment")
    public String gradeAssignment(@RequestParam String instructorID, @RequestParam String studentID, @RequestParam String assignmentID, @RequestParam String grade) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.gradeAssignment(studentID, assignmentID, grade);
            return "Assignment graded successfully!";
        }
        return "Instructor not found!";
    }

    // Method to add a quiz to a course
    @PostMapping("/addQuiz")
    public String addQuiz(@RequestParam String instructorID, @RequestParam String courseID, @RequestParam String quizID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.addQuiz(courseID, quizID);
            return "Quiz added to course successfully!";
        }
        return "Instructor not found!";
    }

    // Method to view a list of students in a course
    @GetMapping("/viewStudents")
    public List<String> viewStudents(@RequestParam String instructorID, @RequestParam String courseID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            return instructor.viewStudentsInCourse(courseID);
        }
        return null;  // Or return an appropriate response
    }

    // Method to view student progress in a course
    @GetMapping("/viewProgress")
    public String viewProgress(@RequestParam String instructorID, @RequestParam String studentID, @RequestParam String courseID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            return instructor.viewStudentProgress(studentID, courseID);  // Assuming this method is implemented
        }
        return "Instructor not found!";
    }

    // Method to upload course materials
    @PostMapping("/uploadMaterial")
    public String uploadMaterial(@RequestParam String instructorID, @RequestParam String courseID, @RequestParam String materialID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.uploadCourseMaterial(courseID, materialID);  // Assuming method is implemented in Instructor class
            return "Course material uploaded successfully!";
        }
        return "Instructor not found!";
    }

    // Method to update the instructor's profile (e.g., bio)
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam String instructorID, @RequestParam String newBio) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.updateProfile(newBio);  // Assuming method is implemented in Instructor class
            return "Instructor profile updated successfully!";
        }
        return "Instructor not found!";
    }

    // Method to deactivate an instructor
    @PostMapping("/deactivateInstructor")
    public String deactivateInstructor(@RequestParam String instructorID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.deactivateInstructor();  // Assuming method is implemented in Instructor class
            return "Instructor deactivated successfully!";
        }
        return "Instructor not found!";
    }

    // Method to reactivate an instructor
    @PostMapping("/reactivateInstructor")
    public String reactivateInstructor(@RequestParam String instructorID) {
        Instructor instructor = findInstructorById(instructorID);
        if (instructor != null) {
            instructor.reactivateInstructor();  // Assuming method is implemented in Instructor class
            return "Instructor reactivated successfully!";
        }
        return "Instructor not found!";
    }

    // Helper method to find instructor by ID (for demo purposes)
    private Instructor findInstructorById(String instructorID) {
        for (Instructor instructor : instructors) {
            if (instructor.getUserID().equals(instructorID)) {
                return instructor;
            }
        }
        return null;
    }
}
