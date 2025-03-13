package LSE.HealthPower.user;

public class UserCreateForm {

    private String username;

    private String password;

    private String password_chk;

    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_chk() {
        return password_chk;
    }

    public void setPassword_chk(String password_chk) {
        this.password_chk = password_chk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
