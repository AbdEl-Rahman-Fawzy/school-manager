package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    public static List<User> users = new ArrayList<>(); // Public static list of users

    private boolean isActive;
    private int userID;
    private String name;
    private String email;
    private String password;
    private Role role;

    // Constructor
    public User(int userID, String name, String email, String password, Role role) {
        this.isActive = false;
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        users.add(this); // Add user to the static list upon creation
    }

    // Getters and Setters for attributes
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public String readNotifications() {
        StringBuilder data = new StringBuilder();

        for (Notification notification : Notification.notifications) {
            if (notification != null && notification.getUserID() == this.userID) {
                String status = notification.isRead() ? "Read" : "Unread";
                data.append("Notification ID: ").append(notification.getNotificationID()).append("\n");
                data.append("From User ID: ").append(notification.getUserID()).append("\n");
                data.append("Content: ").append(notification.getContent()).append("\n");
                data.append("Status: ").append(status).append("\n");
                notification.setRead(true);
            }
        }
        return data.toString();
    }

    public String readUnreadNotifications() {
        StringBuilder data = new StringBuilder();

        for (Notification notification : Notification.notifications) {
            if (notification != null && !notification.isRead() && notification.getUserID() == userID) {
                String status = notification.isRead() ? "Read" : "Unread";
                data.append("Notification ID: ").append(notification.getNotificationID()).append("\n");
                data.append("From User ID: ").append(notification.getUserID()).append("\n");
                data.append("Content: ").append(notification.getContent()).append("\n");
                data.append("Status: ").append(status).append("\n");
                notification.setRead(true);
            }
        }
        return data.toString();
    }
    public String displayData() {
        StringBuilder data = new StringBuilder();
        data.append("User ID: ").append(this.userID).append("\n");
        data.append("Name: ").append(this.name).append("\n");
        data.append("Email: ").append(this.email).append("\n");
        data.append("Role: ").append(this.role).append("\n");
        data.append("Active: ").append(this.isActive ? "Yes" : "No").append("\n");
        return data.toString();
    }

}
