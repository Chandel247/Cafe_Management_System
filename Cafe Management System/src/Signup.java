import java.util.Scanner;

public class Signup {
    String username;
    String password;

    Scanner scanner = new Scanner(System.in);

    public void enter_details() {
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();
    }

}
