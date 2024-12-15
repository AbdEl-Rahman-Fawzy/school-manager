import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> students;  // In-memory store for students

    // Method to enroll in a course
    @PostMapping("/enroll")
    public String enrollCourse(@RequestParam String studentID, @RequestParam String courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.enrollInCourse(courseID);
            return "Student enrolled in course successfully!";
        }
        return "Student not found!";
    }

    // Method to submit an assignment
    @PostMapping("/submitAssignment")
    public String submitAssignment(@RequestParam String studentID, @RequestParam String assignmentID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.submitAssignment(assignmentID);
            return "Assignment submitted successfully!";
        }
        return "Student not found!";
    }

    // Method to update the student's profile
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam String studentID, @RequestParam String newName, @RequestParam String newEmail) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.updateProfile(newName, newEmail);
            return "Profile updated successfully!";
        }
        return "Student not found!";
    }

    // Method to view enrolled courses
    @GetMapping("/viewCourses")
    public List<String> viewCourses(@RequestParam String studentID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.getEnrolledCourses();
        }
        return null;  // Or return an appropriate response
    }

    // Method to drop a course
    @PostMapping("/dropCourse")
    public String dropCourse(@RequestParam String studentID, @RequestParam String courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.dropCourse(courseID);
            return "Course dropped successfully!";
        }
        return "Student not found!";
    }

    // Method to view grades for assignments
    @GetMapping("/viewGrades")
    public String viewGrades(@RequestParam String studentID, @RequestParam String courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.viewGrades(courseID);  // Assuming this method is in the Student class
        }
        return "Student not found!";
    }

    // Method to view assignments in a course
    @GetMapping("/viewAssignments")
    public List<String> viewAssignments(@RequestParam String studentID, @RequestParam String courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.viewAssignments(courseID);  // Assuming this method is in the Student class
        }
        return null;  // Or return an appropriate response
    }

    // Method to attempt a quiz
    @PostMapping("/attemptQuiz")
    public String attemptQuiz(@RequestParam String studentID, @RequestParam String quizID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            student.attemptQuiz(quizID);
            return "Quiz attempted successfully!";
        }
        return "Student not found!";
    }

    // Method to view the student's progress (overall score, completed assignments, quizzes)
    @GetMapping("/viewProgress")
    public String viewProgress(@RequestParam String studentID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.viewProgress();
        }
        return "Student not found!";
    }

    // Method to view course materials
    @GetMapping("/viewCourseMaterials")
    public List<String> viewCourseMaterials(@RequestParam String studentID, @RequestParam String courseID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            return student.viewCourseMaterials(courseID);  // Assuming this method is in the Student class
        }
        return null;  // Or return an appropriate response
    }

    // Method to request certification if the student meets the requirements
    @PostMapping("/requestCertification")
    public String requestCertification(@RequestParam String studentID) {
        Student student = findStudentById(studentID);
        if (student != null) {
            if (student.isEligibleForCertification()) {
                return "Certification requested successfully!";
            } else {
                return "Student is not eligible for certification.";
            }
        }
        return "Student not found!";
    }

    // Helper method to find student by ID (for demo purposes)
    private Student findStudentById(String studentID) {
        for (Student student : students) {
            if (student.getUserID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }
}
