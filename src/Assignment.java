import java.util.List;

public class Assignment {

    private String assignmentID;
    private String courseID;
    private String title;
    private String description;
    private String dueDate;
    private List<String> submittedAssignments; // List of student IDs who submitted
    private double gradingCriteria; // Grading criteria (could be a percentage or points)
    private String instructorID; // ID of the instructor who created the assignment
    private boolean isGraded; // Whether the assignment has been graded or not

    // Constructor
    public Assignment(String assignmentID, String courseID, String title, String description, String dueDate, double gradingCriteria, String instructorID) {
        this.assignmentID = assignmentID;
        this.courseID = courseID;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.gradingCriteria = gradingCriteria;
        this.instructorID = instructorID;
        this.isGraded = false; // Default to not graded
    }

    // Method to create an assignment
    public void createAssignment() {
        // Method logic
    }

    // Method to submit an assignment
    public void submitAssignment(String studentID) {
        // Method logic
    }

    // Method to grade an assignment
    public void gradeAssignment(String studentID, double grade) {
        // Method logic
    }

    // Method to check if the assignment is graded
    public boolean checkGradingStatus() {
        // Method logic
        return isGraded;
    }

    // Method to get the details of the assignment
    public void getAssignmentDetails() {
        // Method logic
    }

    // Getter and Setter methods
    public String getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(String assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<String> getSubmittedAssignments() {
        return submittedAssignments;
    }

    public void setSubmittedAssignments(List<String> submittedAssignments) {
        this.submittedAssignments = submittedAssignments;
    }

    public double getGradingCriteria() {
        return gradingCriteria;
    }

    public void setGradingCriteria(double gradingCriteria) {
        this.gradingCriteria = gradingCriteria;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }
}
