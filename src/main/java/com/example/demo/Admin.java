package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {

    // Static lists for managed courses and users
    private static List<Integer> managedCourses = new ArrayList<>(); // List of courses managed by all Admin instances
    private static List<Integer> managedUsers = new ArrayList<>();   // List of users (students/instructors) managed by all Admin instances
    public static List<Admin> admins = new ArrayList<>();
    private int adminID;

    public List<Integer> getManagedCourses() {
        return managedCourses;
    }

    public List<Integer> getManagedUsers() {
        return managedUsers;
    }

    // Constructor
    public Admin(int userID, String name, String email, String password, int adminID) {
        super(userID, name, email, password, Role.ADMIN); // Call the constructor of the abstract User class
        this.adminID = adminID;
        admins.add(this);
    }

    // Method to create a new user (student or instructor)
    public String createUser(int userID, String name, String email, String password, Role role) {
        if (role == Role.STUDENT || role == Role.INSTRUCTOR) {
            managedUsers.add(userID);
            return "User created successfully: " + name + " (" + role + ")";
        } else {
            return "Invalid role for user creation. Only STUDENT or INSTRUCTOR roles are allowed.";
        }
    }

    // Method to manage a course (e.g., assign instructors, view course performance)
    public String manageCourse(int courseID) {
        if (!managedCourses.contains(courseID)) {
            managedCourses.add(courseID);
            return "Course added to managed list: " + courseID;
        } else {
            return "Course already managed: " + courseID;
        }
    }

    // Method to delete a user (e.g., deactivate a student or instructor account)
    public String deleteUser(int userID) {
        for (User user : User.users) {
            if (user.getUserID() == userID) {
                User.users.remove(user);
                return "User deleted successfully: " + userID;
            }
        }
        return "User not found .";
    }

    // Method to generate system reports (e.g., user activity, course statistics)
    public String generateReport() {
        return super.displayData() ;
    }

    // Method to login as an admin
    public String login(String email, String password) {
        if (getEmail().equals(email) && getPassword().equals(password)) {
            setActive(true);
            return "Login successful.";
        } else {
            return "Invalid email or password.";
        }
    }

    // Method to logout as an admin
    public String logout() {
        setActive(false);
        return "Logged out successfully.";
    }

    // Method to update admin profile
    public String updateProfile(String newName, String newEmail) {
        setName(newName);
        setEmail(newEmail);
        return "Profile updated successfully: " + newName + " | " + newEmail;
    }

    // Static method to list all users
    public static List<String> listAllUsers() {
        List<String> userList = new ArrayList<>();
        for (Integer userID : managedUsers) {
            userList.add("User ID: " + userID);
        }
        return userList;
    }
}
