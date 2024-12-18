package org.example;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {

    private int adminID;
    private List<Integer> managedCourses; // List of courses managed by the admin
    private List<Integer> managedUsers; // List of users (students/instructors) managed by the admin

    // Constructor
    public Admin(int userID, String name, String email, String password, int adminID) {
        super(userID, name, email, password, Role.ADMIN); // Call the constructor of the abstract User class
        this.adminID = adminID;
        this.managedCourses = new ArrayList<>(); // Initialize the list
        this.managedUsers = new ArrayList<>();   // Initialize the list
    }


    // Method to create a new user (student or instructor)
    public void createUser(int userID, String name, String email, String password, Role role) {
        if (role == Role.STUDENT || role == Role.INSTRUCTOR) {
            managedUsers.add(userID);
            System.out.println("User created successfully: " + name + " (" + role + ")");
        } else {
            System.out.println("Invalid role for user creation. Only STUDENT or INSTRUCTOR roles are allowed.");
        }
    }

    // Method to manage a course (e.g., assign instructors, view course performance)
    public void manageCourse(int courseID) {
        if (!managedCourses.contains(courseID)) {
            managedCourses.add(courseID);
            System.out.println("Course added to managed list: " + courseID);
        } else {
            System.out.println("Course already managed: " + courseID);
        }
    }

    // Method to delete a user (e.g., deactivate a student or instructor account)
    public boolean deleteUser(int userID) {
        for (int user : managedUsers ){
            if (user == userID){
                managedUsers.remove(userID);
                System.out.println("User deleted successfully:");
                return true;
            }
        }
        return false;
    }

    // Method to generate system reports (e.g., user activity, course statistics)
    public void generateReport() {
        System.out.println("Generating system report...");
        System.out.println("Managed Courses: " + managedCourses);
        System.out.println("Managed Users: " + managedUsers);
        // Additional reporting logic can be added here
    }

    // Method to login as an admin
    public String login(String email, String password) {
        if (getEmail().equals(email) && getPassword().equals(password)) {
            setActive(true);
            return ("Login successful.");
        } else {
            return ("Invalid email or password.");
        }
    }


    // Method to logout as a student
    public String logout() {
        setActive(false);
        return ("Logged out successfully.");
    }

    // Method to update admin profile
    public void updateProfile(String newName, String newEmail) {
        setName(newName);
        setEmail(newEmail);
        System.out.println("Profile updated successfully: " + newName + " | " + newEmail);
    }
    public List<String> listAllUsers() {
        return null;
    }


}
