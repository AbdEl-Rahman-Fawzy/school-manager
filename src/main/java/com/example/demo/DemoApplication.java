package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// Mock Data Initialization

			// Admins
			List<Admin> admins = new ArrayList<>(Arrays.asList(
					new Admin(1, "Admin1", "admin1@example.com", "password1", 1001),
					new Admin(2, "Admin2", "admin2@example.com", "password2", 1002),
					new Admin(3, "Admin3", "admin3@example.com", "password3", 1003),
					new Admin(4, "Admin4", "admin4@example.com", "password4", 1004),
					new Admin(5, "Admin5", "admin5@example.com", "password5", 1005)
			));

			// Instructors
			Instructor instructor1 = new Instructor(101, "Instructor1", "instr1@example.com", "pass1", "Computer Science");
			Instructor instructor2 = new Instructor(102, "Instructor2", "instr2@example.com", "pass2", "Mathematics");
			Instructor instructor3 = new Instructor(103, "Instructor3", "instr3@example.com", "pass3", "Physics");
			Instructor instructor4 = new Instructor(104, "Instructor4", "instr4@example.com", "pass4", "Biology");
			Instructor instructor5 = new Instructor(105, "Instructor5", "instr5@example.com", "pass5", "Chemistry");

			// Create courses for each instructor
			Course course1 = new Course(301, "Java Basics", "Introduction to Java", 101);
			Course course2 = new Course(302, "Data Structures", "Learn data structures", 102);
			Course course3 = new Course(303, "Algorithms", "Learn algorithms", 103);
			Course course4 = new Course(304, "Database Systems", "Introduction to databases", 104);
			Course course5 = new Course(305, "Operating Systems", "Understand OS concepts", 105);

			instructor1.createCourse(course1);
			instructor2.createCourse(course2);
			instructor3.createCourse(course3);
			instructor4.createCourse(course4);
			instructor5.createCourse(course5);

			// Add lessons and quizzes to courses
			instructor1.addLesson(new Lesson(401, "Lesson1", 301, 101, 60, "2024-01-01"));
			instructor2.addLesson(new Lesson(402, "Lesson2", 302, 102, 45, "2024-01-02"));
			instructor3.addLesson(new Lesson(403, "Lesson3", 303, 103, 90, "2024-01-03"));
			instructor4.addLesson(new Lesson(404, "Lesson4", 304, 104, 30, "2024-01-04"));
			instructor5.addLesson(new Lesson(405, "Lesson5", 305, 105, 75, "2024-01-05"));

			// Add quizzes
			instructor1.addQuiz(new Quiz(501, "Quiz1", Quiztype.Midterm, Arrays.asList("Q1", "Q2", "Q3"), 30, "2024-01-01", "2024-01-02", 101, 301));
			instructor2.addQuiz(new Quiz(502, "Quiz2", Quiztype.Final, Arrays.asList("Q1", "Q2", "Q3"), 45, "2024-01-03", "2024-01-04", 102, 302));

			// Create Students
			Student student1 = new Student(201, "Student1", "student1@example.com", "password1", 1001);
			Student student2 = new Student(202, "Student2", "student2@example.com", "password2", 1002);

			// Enroll students in courses
			student1.enrollCourse(301);  // Java Basics
			student1.enrollCourse(302);  // Data Structures
			student2.enrollCourse(303);  // Algorithms

			// Students attempt quizzes
			student1.attemptQuiz(301, 501); // Attempting Quiz1 for Java Basics
			student2.attemptQuiz(303, 503); // Attempting a quiz in Algorithms (though Quiz ID is hypothetical)

			// Students submit assignments
			student1.submitAssignment(1, 301, "Assignment data for Java Basics"); // Submit assignment for Java Basics


			// Update profile
			student1.updateProfile("Updated Student1", "updated_student1@example.com");

			// Student logs in and out
			student1.login("student1@example.com", "password1");
			student1.logout();

			// Adding feedback
			student1.addFeedback("Instructor1", "Excellent course material.");
			student2.addFeedback("Instructor3", "Great explanation on algorithms.");

			// Test if student is eligible for certification
			System.out.println("Student 1 eligible for certification in Java Basics: " + student1.isEligibleForCertification(301));

			// Drop a course
			student1.dropCourse(302); // Drop Data Structures
			instructor1.gradeQuiz(1001,301,501,52.1);

		};
	}
}
