public abstract class User {

    private String userID;
    private String name;
    private String email;
    private String password;
    private Role role;  // Enum to represent the role (Admin, Student, Instructor)

    // Constructor
    public User(String userID, String name, String email, String password, Role role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void login();
    public abstract void logout();
    public abstract void updateProfile();

    // Getters and Setters for attributes
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    public void sendNotification(String message) {
    }
}
enum Role {
    ADMIN,
    STUDENT,
    INSTRUCTOR
}