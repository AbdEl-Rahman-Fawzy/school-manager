package com.example.demo.Controllers;

import com.example.demo.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(AdminController.class)
@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/createUser")
    public String createUser(@RequestParam int adminID, @RequestParam int userID, @RequestParam String name, @RequestParam String email,
                             @RequestParam String password, @RequestParam Role role) {
        System.out.println("createUser endpoint hit");
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            if (admin.isActive()) {
                admin.createUser(userID, name, email, password, role);
                return "User created successfully!";
            }
            return "User not active!";
        }
        return "Admin not found!";
    }


    @PostMapping("/manageCourse")
    public String manageCourse(@RequestParam int adminID, @RequestParam int courseID) {
        System.out.println("manageCourse endpoint hit with adminID: " + adminID + " and courseID: " + courseID);
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            if (admin.isActive()) {
                admin.manageCourse(courseID);
                return "Course managed successfully!";
            }
            return "User not active!";
        }
        return "Admin not found!";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam int adminID, @RequestParam int userID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            if (admin.isActive()) {
                return admin.deleteUser(userID);
            }
            return "User not active!";
        }
        return "Admin not found!";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam int adminID, @RequestParam String newName,
                                @RequestParam String newEmail) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            if (admin.isActive()) {
                admin.updateProfile(newName, newEmail);
                return "Admin profile updated successfully!";
            }
            return "User not active!";
        }
        return "Admin not found!";
    }

    @GetMapping("/generateReport")
    public String generateReport(@RequestParam int adminID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            if (admin.isActive()) {
                return admin.generateReport();
            }
            return "User not active!";
        }
        return "Admin not found!";
    }

    @GetMapping("/listUsers")
    public List<User> listUsers(@RequestParam int adminID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            if (admin.isActive()) {
                return User.users;
            }
            return null; // Or "User not active!" if you want to handle inactive admins here.
        }
        return null;
    }

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestParam int senderID, @RequestParam int notificationID, @RequestParam int receiverID, @RequestParam String data) {
        Admin admin = findAdminById(senderID);
        if (admin != null) {
            if (admin.isActive()) {
                Notification notification = new Notification(notificationID, senderID, data, receiverID);
                notification.send();
                return "Notification sent successfully!";
            }
            return "User not active!";
        }
        return "Admin not found!";
    }

    @PostMapping("/readNotification")
    public String readNotification(@RequestParam int senderID) {
        Admin admin = findAdminById(senderID);
        if (admin != null) {
            if (admin.isActive()) {
                return admin.readNotifications();
            }
            return "User not active!";
        }
        return null;
    }

    @PostMapping("/readUnreadNotification")
    public String readUnreadNotification(@RequestParam int senderID) {
        Admin admin = findAdminById(senderID);
        if (admin != null) {
            if (admin.isActive()) {
                return admin.readUnreadNotifications();
            }
            return "User not active!";
        }
        return null;
    }

    @PostMapping("/login")
    public String login(@RequestParam String mail, @RequestParam String password, @RequestParam int id) {
        Admin admin = findAdminById(id);
        if (admin != null) {
            return admin.login(mail, password);
        }
        return "Admin not found!";
    }

    @PostMapping("/logout")
    public String signUp(@RequestParam int id) {
        Admin admin = findAdminById(id);
        if (admin != null) {
            if (admin.isActive()) {
                return admin.logout();
            }
            return "User not active!";
        }
        return "Admin not found!";
    }

    public Admin findAdminById(int adminID) {
        for (Admin admin : Admin.admins) {
            if (admin.getUserID() == adminID) {
                return admin;
            }
        }
        return null;
    }
}
