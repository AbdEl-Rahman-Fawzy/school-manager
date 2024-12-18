package org.example.Controllers;

import org.example.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private List<Admin> admins;

    public AdminController() {
        admins = new ArrayList<>(); // Initialize the list
        admins.add(new Admin(1, "AdminName", "admin@example.com", "password", 1));
    }

    @PostMapping("/createUser")
    public String createUser(@RequestParam int adminID, @RequestParam int userID, @RequestParam String name, @RequestParam String email,
                             @RequestParam String password, @RequestParam String role) {
        System.out.println("createUser endpoint hit");
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.createUser(userID, name, email, password, Role.valueOf(role));
            return "User created successfully!";
        }
        return "Admin not found!";
    }


    @PostMapping("/manageCourse")
    public String manageCourse(@RequestParam int adminID, @RequestParam int courseID) {
        System.out.println("manageCourse endpoint hit with adminID: " + adminID + " and courseID: " + courseID);
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.manageCourse(courseID);
            return "Course managed successfully!";
        }
        return "Admin not found!";
    }

    @DeleteMapping("/deleteUser/{userID}")
    public String deleteUser(@PathVariable int userID) {
        Admin admin = findAdminById(userID);
        if (admin != null) {
            if (admin.deleteUser(userID)) {
                return "User deleted successfully!";
            } else {
                return "User ID invalid!";
            }
        }
        return "Admin not found or userID is false!";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam int adminID, @RequestParam String newName,
                                @RequestParam String newEmail) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.updateProfile(newName, newEmail);
            return "Admin profile updated successfully!";
        }
        return "Admin not found!";
    }

    @GetMapping("/generateReport")
    public String generateReport(@RequestParam int adminID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.generateReport();
            return "Report generated successfully!";
        }
        return "Admin not found!";
    }

    @GetMapping("/listUsers")
    public List<String> listUsers(@RequestParam int adminID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            return admin.listAllUsers();
        }
        return null;
    }

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestParam int adminID, @RequestParam String message) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.sendNotification(message);
            return "Notification sent successfully!";
        }
        return "Admin not found!";
    }

    private Admin findAdminById(int adminID) {
        for (Admin admin : admins) {
            if (admin.getUserID() == adminID) {
                return admin;
            }
        }
        return null;
    }
}
