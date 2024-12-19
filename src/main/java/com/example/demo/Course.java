package com.example.demo;

import java.util.ArrayList;
import java.util.List;

// Course class
public class Course {
    private int courseID;
    private String title;
    private int instructorID;
    private String description;
    private List<Lesson> lessons;
    private List<String> materials;
    private List<Quiz> quizzes;
    private List<Assignment> assignments;
    public static List<Course> allCourses = new ArrayList<>();

    // Constructor
    public Course(int courseID, String courseTitle, String description, int instructorID) {
        this.courseID = courseID;
        this.title = courseTitle;
        this.description = description;
        this.instructorID = instructorID;
        this.lessons = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.quizzes = new ArrayList<>();
        this.assignments = new ArrayList<>();
        allCourses.add(this);
    }
    public static List<Course> getAllCourses() {
        return allCourses;
    }
    public static Course getCourse(int courseID){
        for (Course course : allCourses){
            if (course.getCourseID() == courseID){
                return course;
            }
        }
        return null;
    }

    // Method to generate an OTP (placeholder logic)
    public String generateOTP() {
        String otp = String.valueOf((int) (Math.random() * 9000) + 1000);
        return "Generated OTP: " + otp;
    }


    // Method to get the list of students
    public List<Student> getStudentList() {
        List <Student> students = new ArrayList<>();
        for (Student student : Student.students){
            for(Course id : student.getEnrolledCourses()){
                if (id.courseID == this.courseID){
                    students.add(student);
                }
            }
        }
        return students;
    }

    // Method to add a quiz
    public String addQuiz(Quiz quiz) {
        quizzes.add(quiz);
        return "Quiz added: " + quiz.getTitle();
    }

    // Method to set grade (placeholder logic)
    public String setGrade(double grade) {
        return "Grade set: " + grade;
    }

    // Method to add material
    public String addMaterial(String materialID) {
        materials.add(materialID);
        return "Material added: " + materialID;
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
    public String addLesson(Lesson lesson) {
        lessons.add(lesson);
        return "Lesson added: " + lesson.getTitle();
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

    public String addQuistion(String data) {
        return "Question added: " + data;
    }
}
