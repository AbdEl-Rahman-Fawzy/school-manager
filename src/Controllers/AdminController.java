import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private List<Admin> admins;  // In-memory store for admins

    // Method to create a new user (student or instructor)
    @PostMapping("/createUser")
    public String createUser(@RequestParam String userID, @RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String role) {
        Admin admin = findAdminById(userID);
        if (admin != null) {
            admin.createUser(userID, name, email, password, Role.valueOf(role));
            return "User created successfully!";
        }
        return "Admin not found!";
    }

    // Method to manage a course
    @PostMapping("/manageCourse")
    public String manageCourse(@RequestParam String adminID, @RequestParam String courseID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.manageCourse(courseID);
            return "Course managed successfully!";
        }
        return "Admin not found!";
    }

    // Method to delete a user
    @DeleteMapping("/deleteUser/{userID}")
    public String deleteUser(@PathVariable String userID) {
        Admin admin = findAdminById(userID);
        if (admin != null) {
            admin.deleteUser(userID);
            return "User deleted successfully!";
        }
        return "Admin not found!";
    }

    // Method to update admin profile
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam String adminID, @RequestParam String newName, @RequestParam String newEmail) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.updateProfile(newName, newEmail);
            return "Admin profile updated successfully!";
        }
        return "Admin not found!";
    }

    // Method to generate a report
    @GetMapping("/generateReport")
    public String generateReport(@RequestParam String adminID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.generateReport();
            return "Report generated successfully!";
        }
        return "Admin not found!";
    }

    // Method to list all users
    @GetMapping("/listUsers")
    public List<String> listUsers(@RequestParam String adminID) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            return admin.listAllUsers();  // Assuming this method is implemented in Admin class
        }
        return null;  // Or return an appropriate response
    }

    // Method to send notifications
    @PostMapping("/sendNotification")
    public String sendNotification(@RequestParam String adminID, @RequestParam String message) {
        Admin admin = findAdminById(adminID);
        if (admin != null) {
            admin.sendNotification(message);  // Assuming this method is implemented in Admin class
            return "Notification sent successfully!";
        }
        return "Admin not found!";
    }

    // Helper method to find admin by ID (for demo purposes)
    private Admin findAdminById(String adminID) {
        for (Admin admin : admins) {
            if (admin.getUserID().equals(adminID)) {
                return admin;
            }
        }
        return null;
    }
}
