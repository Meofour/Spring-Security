package vn.iostar.SpringSer.Models;

public class LoginDto {
    private String usernameOrEmail;
    private String password;

    // Getter and Setter for usernameOrEmail
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
