package SpringMVC.Model;

public class User {
    private String email;
    private String userName;
    private String password;

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: toString()
    @Override
    public String toString() {
        return "User [email=" + email + ", userName=" + userName + ", password=" + password + "]";
    }
}
