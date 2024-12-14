import java.util.List;

public class Lesson {

    private String lessonID;
    private String title;
    private String courseID;
    private String instructorID;
    private List<String> materials; // List of resources like documents, videos, etc.
    private String dateScheduled; // Date when the lesson is scheduled
    private int duration; // Duration of the lesson in minutes
    private boolean isCompleted; // Indicates whether the lesson is completed or not

    // Constructor
    public Lesson(String lessonID, String title, String description, String courseID, String instructorID, String dateScheduled, int duration) {
        this.lessonID = lessonID;
        this.title = title;
        this.courseID = courseID;
        this.instructorID = instructorID;
        this.dateScheduled = dateScheduled;
        this.duration = duration;
        this.isCompleted = false; // Default to not completed
    }

    // Method to start the lesson
    public void startLesson() {
        // Method logic
    }

    // Method to end the lesson
    public void endLesson() {
        // Method logic
    }

    // Method to update lesson materials
    public void updateMaterials(List<String> newMaterials) {
        // Method logic
    }

    // Method to check if the lesson is completed
    public boolean checkCompletion() {
        // Method logic
        return isCompleted;
    }

    // Method to get lesson details
    public void getLessonDetails() {
        // Method logic
    }

    // Getter and Setter methods
    public String getLessonID() {
        return lessonID;
    }

    public void setLessonID(String lessonID) {
        this.lessonID = lessonID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public String getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(String dateScheduled) {
        this.dateScheduled = dateScheduled;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
