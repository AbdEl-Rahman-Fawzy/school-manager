import java.util.List;

public class Admin extends User {

    private String adminID;
    private List<String> managedCourses; // List of courses managed by the admin
    private List<String> managedUsers; // List of users (students/instructors) managed by the admin

    // Constructor
    public Admin(String userID, String name, String email, String password, String adminID) {
        super(userID, name, email, password, Role.ADMIN);  // Call the constructor of the abstract User class
        this.adminID = adminID;
    }

    // Method to create a new user (student or instructor)
    public void createUser(String userID, String name, String email, String password, Role role) {
        // Method logic
    }

    // Method to manage a course (e.g., assign instructors, view course performance)
    public void manageCourse(String courseID) {
        // Method logic
    }

    // Method to delete a user (e.g., deactivate a student or instructor account)
    public void deleteUser(String userID) {
        // Method logic
    }

    // Method to generate system reports (e.g., user activity, course statistics)
    public void generateReport() {
        // Method logic
    }

    // Method to login as an admin
    @Override
    public void login() {
        // Method logic
    }

    // Method to logout as an admin
    @Override
    public void logout() {
        // Method logic
    }

    // Method to update admin profile
    @Override
    public void updateProfile(String newName, String newEmail) {
        // Method logic
    }
    public List<String> listAllUsers() {
        return null;
    }

    // Getter and Setter methods
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public List<String> getManagedCourses() {
        return managedCourses;
    }

    public void setManagedCourses(List<String> managedCourses) {
        this.managedCourses = managedCourses;
    }

    public List<String> getManagedUsers() {
        return managedUsers;
    }

    public void setManagedUsers(List<String> managedUsers) {
        this.managedUsers = managedUsers;
    }


}
