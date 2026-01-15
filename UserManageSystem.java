import java.util.*;

public class UserManageSystem {

    // Responsibility 1: User data
    static class User {
        String name;
        String email;
        String password;

        User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }

    // Responsibility 2: Validation logic
    static class UserValidator {

        public boolean validateEmail(String email) {
            return email != null && email.contains("@");
        }

        public boolean validateName(String name) {
            return name != null && !name.trim().isEmpty();
        }
    }

    public static void main(String[] args) {
        User user = new User("Harish", "harish@gmail.com", "12345");

        UserValidator validator = new UserValidator();

        System.out.println("Email valid: " + validator.validateEmail(user.email));
        System.out.println("Name valid: " + validator.validateName(user.name));
    }
}
