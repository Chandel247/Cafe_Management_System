import java.io.*;
import java.util.Scanner;

public class Employee {
    String name;
    String password;

    //to check the identity of the employee
    public void check_identity(String name, String password){
        try{
            File file =new File("Employee.txt");
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String[] arr=line.split("   ");
                if(arr[0].equals(name) && arr[1].equals(password)){
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

    //to print the menu
    public void menu_reader(){
        try{
            File file = new File("menu.txt");
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String item=sc.nextLine();
                System.out.println(item);
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void ordering(){
        menu_reader();
        
    }

    

}
