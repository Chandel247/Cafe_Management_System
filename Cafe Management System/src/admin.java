import java.util.Scanner;
import java.io.*;

public class admin {
    String name;
    String password;
    boolean is_admin;

    //to check whether the login is of admin
        public boolean check_admin(String name, String password) {
           if (this.name.equals(name) && this.password.equals(password) && this.is_admin) {
                return true;
            }
            return false;
        }

    //to change the menu
    public void change_menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the item to be added: ");
        String item = sc.nextLine();
        System.out.println("Enter the price of the item to be added: ");
        int price = sc.nextInt();
        System.out.println("Enter the quantity of the item to be added: ");
        int quantity = sc.nextInt();
        try {
            FileWriter fw = new FileWriter("menu.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(item + " " + price + " " + quantity);
            bw.newLine();
            bw.close();
            fw.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    


}
