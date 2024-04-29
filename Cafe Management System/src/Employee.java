import java.io.*;
import java.util.Scanner;

public class Employee {
    String name;
    String password;

    //to check the identity of the employee
    public void check_identity(String name, String password){
        try{
            File file =new File("Files\\Employee.txt");
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
            File file = new File("Files\\menu.txt");
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

    //for the customer to order through employee
    public void checking_for_new_customers(){
        Scanner input= new Scanner(System.in);
        System.out.println("What is your mobile number: ");
        long p_num = Long.parseLong(input.nextLine());
        try {
            File file = new File("Files\\Customers.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String item = reader.nextLine();
                String[] arr = item.split("   ");
                if (Long.parseLong(arr[1]) == p_num) {
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Welcome back!"+ arr[0]);
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("---------------------------------------------------------------------------");
                    ordering(arr[0], p_num);
                }
                else{
                    FileWriter fw=new FileWriter(file, true);
                    BufferedWriter bw=new BufferedWriter(fw);
                    System.out.print("Please enter your name: ");
                    String name=input.nextLine();
                    bw.write(name + "   " + p_num);
                    bw.close();
                    fw.close();
                    ordering(name, p_num);
                }
            }
            reader.close();
        } catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        input.close();
    }

    public void ordering(String name, long phone_num){
        menu_reader();
        boolean countine_order=true;
        while(countine_order){
            Scanner input=new Scanner(System.in);
            System.out.println("Enter the serial number of the item you want to order: ");
            String serial_num=input.nextLine();
            System.out.println("Enter the quantity of the item you want to order: ");
            int quantity=input.nextInt();
            try{
                File file=new File("Files\\menu.txt");
                Scanner reader=new Scanner(file);
                while(reader.hasNextLine()){
                    String item=reader.nextLine();
                    String[] arr=item.split("   ");
                    if(arr[3].equals(serial_num)){
                        int price=Integer.parseInt(arr[1]);
                        if (quantity>Integer.parseInt(arr[2])){
                            System.out.println("The quantity you entered is not available");
                            return;
                        }
                        int total_price=price*quantity;
                        System.out.println("The total price is: "+total_price);
                        FileWriter fw=new FileWriter("Files\\Orders.txt", true);
                        BufferedWriter bw=new BufferedWriter(fw);
                        bw.write(name + "   " + phone_num + "   " + arr[0] + "   " + quantity + "   " + total_price);
                        bw.newLine();
                        bw.close();
                        fw.close();
                    }
                }
                reader.close();
                input.close();
            }
            catch(IOException e){
                System.out.println("An error occurred");
                e.printStackTrace();
            }
            System.out.println("Do you want to order more items? (yes/no)");
            String choice=input.nextLine();
            if(choice.equals("no")){
                countine_order=false;
            }
        }
    }
}