package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Notification {

    public static Notification[] notifications = new Notification[1000000];
    private static int notificationCount = 0;
    private int notificationID;
    private int userID;
    private String content;

    private int receiver;
    private boolean isRead;

    // Constructor
    public Notification(int notificationID, int userID, String content, int receiver) {
        this.notificationID = notificationID;
        this.userID = userID;
        this.content = content;
        this.receiver = receiver;
        this.isRead = false;
    }

    // Method to send the notification
    public String send() {
        if (notificationCount < notifications.length) {
            notifications[notificationCount++] = this; // Add notification and increment count
            return "Notification sent to user " + receiver + ": " + content;
        } else {
            return "Notification list is full. Unable to send notification.";
        }
    }

    // Method to view unread notifications for a specific user
    public static List<Notification> viewUnread(int receiverID) {
        List<Notification> unreadNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification != null && notification.receiver == receiverID && !notification.isRead) {
                unreadNotifications.add(notification);
            }
        }
        return unreadNotifications;
    }

    // Method to mark the notification as read
    public String markAsRead() {
        this.isRead = true;
        return "Notification " + notificationID + " marked as read.";
    }

    // Getter and Setter methods
    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
