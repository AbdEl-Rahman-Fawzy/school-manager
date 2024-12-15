import java.util.List;

public class Instructor extends User {

    private String instructorID;
    private List<String> coursesCreated; // List of course IDs created by the instructor
    private String department; // Department the instructor belongs to
    private String bio; // Short biography of the instructor
    private List<String> assignedLessons; // List of lesson IDs assigned to the instructor
    private boolean isActive; // Whether the instructor is currently active

    // Constructor
    public Instructor(String userID, String name, String email, String password, String instructorID, String department) {
        super(userID, name, email, password, Role.INSTRUCTOR);  // Call the constructor of the abstract User class
        this.instructorID = instructorID;
        this.department = department;
        this.isActive = true; // Default active status
    }

    // Method to create a course
    public void createCourse(String courseID, String courseTitle, String courseDescription) {
        // Method logic
    }

    // Method to assign a lesson to the instructor
    public void assignLesson(String lessonID) {
        // Method logic
    }

    // Method to grade a student
    public void gradeStudent(String studentID, double grade) {
        // Method logic
    }

    // Method to add quiz to a course
    public void addQuiz(String quizID) {
        // Method logic
    }

    // Method to view reports (e.g., course or student performance)
    public void viewReports() {
        // Method logic
    }

    // Method to update instructor profile
    public void updateProfile(String newBio) {
        // Method logic
    }

    // Method to deactivate the instructor (e.g., when they leave or retire)
    public void deactivateInstructor() {
        // Method logic
    }

    // Method to reactivate the instructor
    public void reactivateInstructor() {
        // Method logic
    }

    // Getter and Setter methods
    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public List<String> getCoursesCreated() {
        return coursesCreated;
    }

    public void setCoursesCreated(List<String> coursesCreated) {
        this.coursesCreated = coursesCreated;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getAssignedLessons() {
        return assignedLessons;
    }

    public void setAssignedLessons(List<String> assignedLessons) {
        this.assignedLessons = assignedLessons;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void login() {
        // Method logic
    }

    @Override
    public void logout() {
        // Method logic
    }

    @Override
    public void updateProfile(String newName, String newEmail) {
        // Method logic
    }

    public void gradeAssignment(String studentID, String assignmentID, String grade) {
    }

    public List<String> viewStudentsInCourse(String courseID) {
        return null;
    }

    public String viewStudentProgress(String studentID, String courseID) {
        return null;
    }

    public void uploadCourseMaterial(String courseID, String materialID) {
    }
}
