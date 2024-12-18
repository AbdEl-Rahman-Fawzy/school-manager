package org.example;

public class Notification {

    private String notificationID;
    private String userID;
    private String content;
    private String otp;
    private String receiver;
    private boolean isRead;

    // Constructor
    public Notification(String notificationID, String userID, String content, String otp, String receiver) {
        this.notificationID = notificationID;
        this.userID = userID;
        this.content = content;
        this.otp = otp;
        this.receiver = receiver;
        this.isRead = false; // Default to unread
    }

    // Method to send the notification
    public void send() {
        // Method logic
    }

    // Method to view unread notifications
    public void viewUnread() {
        // Method logic
    }

    // Method to mark the notification as read
    public void markAsRead() {
        // Method logic
    }

    // Getter and Setter methods
    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
