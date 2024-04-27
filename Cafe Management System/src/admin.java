import java.util.Scanner;
import java.io.*;

public class admin extends Employee {
    String name;
    String password;
    boolean is_admin;

    //to check whether the login is of admin
    public void check_identity(String name, String password){
        try{
            File file =new File("Employee.txt");
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String[] arr=line.split("   ");
                if(arr[0].equals(name) && arr[1].equals(password) && arr[2]=="true"){
                    System.out.println("Login successful");
                    return;
                }
                sc.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    //to change the menu
    public void change_menu() {
        Serial_Num serial_Num=new Serial_Num();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the item to be added: ");
        String item = sc.nextLine();
        System.out.println("Enter the price of the item to be added: ");
        int price = sc.nextInt();
        System.out.println("Enter the quantity of the item to be added: ");
        int quantity = sc.nextInt();
        String serial_code=serial_Num.serial_genrator();
        System.out.println("The serial number for the product is: "+serial_code);
        try {
            FileWriter fw = new FileWriter("menu.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(item + "   " + price + "   " + quantity + "    "+ serial_code);
            bw.newLine();
            bw.close();
            fw.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        sc.close();
    }

    //to add a new employee
    public void add_emplyee(String name, String password){
        File file = new File("Employee.txt");
        try{
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name + "   " + password+ "    " + false);
            bw.newLine();
            bw.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    


}
