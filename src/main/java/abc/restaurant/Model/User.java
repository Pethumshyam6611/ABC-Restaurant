package abc.restaurant.Model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String role;
    private String email;
    private int phone;



    public User(int userId, String username, String password, String role, String email, int phone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }
    
    public User(int userId, String username, String password, String role, int phone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    public User(int userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public User(int userId, String username, String password ) {
        this.userId = userId;
        this.username = username;
        this.password = password;
 
    }
    public User(int userId, String username, String email, int phone) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public User() {
    }
  
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
