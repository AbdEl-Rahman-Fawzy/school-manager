import java.util.List;

public class Student extends User {

    private String studentID;
    private List<String> enrolledCourses; // List of course IDs the student is enrolled in
    private List<String> submittedAssignments; // List of assignment IDs the student has submitted
    private List<String> attemptedQuizzes; // List of quiz IDs the student has attempted
    private double totalScore; // Overall score for the student (could be weighted)
    private boolean isCertified; // Whether the student has earned certification for the course

    // Constructor
    public Student(String userID, String name, String email, String password, String studentID) {
        super(userID, name, email, password, Role.STUDENT);  // Call the constructor of the abstract User class
        this.studentID = studentID;
    }

    // Method to enroll in a course
    public void enrollCourse(String courseID) {
        // Method logic
    }

    // Method to submit an assignment
    public void submitAssignment(String assignmentID) {
        // Method logic
    }

    // Method to attempt a quiz
    public void attemptQuiz(String quizID) {
        // Method logic
    }

    // Method to view the student's progress (overall score, completed assignments, quizzes)
    public void viewProgress() {
        // Method logic
    }

    // Method to view course materials
    public void viewCourseMaterials(String courseID) {
        // Method logic
    }

    // Method to request certification (if the student meets the requirements)
    public void requestCertification() {
        // Method logic
    }

    // Method to update the student's profile (e.g., name, email, password)
    @Override
    public void updateProfile() {
        // Method logic
    }

    // Method to login as a student
    @Override
    public void login() {
        // Method logic
    }

    // Method to logout as a student
    @Override
    public void logout() {
        // Method logic
    }

    // Getter and Setter methods
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public List<String> getSubmittedAssignments() {
        return submittedAssignments;
    }

    public void setSubmittedAssignments(List<String> submittedAssignments) {
        this.submittedAssignments = submittedAssignments;
    }

    public List<String> getAttemptedQuizzes() {
        return attemptedQuizzes;
    }

    public void setAttemptedQuizzes(List<String> attemptedQuizzes) {
        this.attemptedQuizzes = attemptedQuizzes;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public void setCertified(boolean certified) {
        isCertified = certified;
    }
}
