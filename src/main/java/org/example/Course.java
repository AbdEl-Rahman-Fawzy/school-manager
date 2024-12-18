package org.example;
import java.util.ArrayList;
import java.util.List;

// Course class
public class Course {
    private int courseID;
    private String title;
    private int instructorID;
    private String description;
    private List<Lesson> lessons;
    private List<Student> students;
    private List<String> materials;
    private List<Quiz> quizzes;
    private List<Assignment> assignments;

    // Constructor
    public Course(int courseID, String courseTitle, String description, int instructorID) {
        this.courseID = courseID;
        this.title = courseTitle;
        this.description = description;
        this.instructorID = instructorID;
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.quizzes = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // Method to enroll a student
    public void enrollStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("Student is already enrolled in the course.");
            return;
        }
        students.add(student);
        System.out.println("Student enrolled successfully: " + student.getName());
    }

    // Method to generate an OTP (placeholder logic)
    public String generateOTP() {
        String otp = String.valueOf((int) (Math.random() * 9000) + 1000);
        System.out.println("Generated OTP: " + otp);
        return otp;
    }

    // Method to view the list of students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in the course.");
            return;
        }
        System.out.println("Students enrolled in course " + title + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }

    // Method to get the list of students
    public List<Student> getStudentList() {
        return new ArrayList<>(students);
    }

    // Method to add a quiz
    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
        System.out.println("Quiz added: " + quiz.getTitle());
    }

    // Method to set grade (placeholder logic)
    public double setGrade(double grade) {
        // Implement grade setting logic if necessary
        System.out.println("Grade set: " + grade);
        return grade;
    }

    // Method to add material
    public void addMaterial(String materialID) {
        materials.add(materialID);
        System.out.println("Material added: " + materialID);
    }

    // Method to get assignments
    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments);
    }

    // Method to get materials
    public List<String> getMaterial() {
        return new ArrayList<>(materials);
    }

    // Method to get quizzes
    public List<Quiz> getQuizzes() {
        return new ArrayList<>(quizzes);
    }

    // Method to add a lesson
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
        System.out.println("Lesson added: " + lesson.getTitle());
    }

    // Getter for course title
    public String getTitle() {
        return title;
    }

    // Getter for course ID
    public int getCourseID() {
        return courseID;
    }

    public List<Quiz> getQuizes() {
        return quizzes;
    }

}
