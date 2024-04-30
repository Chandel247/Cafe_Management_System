import java.io.*;
import java.util.Scanner;

public class Employee {
    String name;
    String password;

    //to check the identity of the employee
    public boolean check_identity(String name, String password){
        try(Scanner sc=new Scanner(new File("/Users/shivpratapsinghchandel/git/Cafe_Management_System/Cafe Management System/src/Files/Employees.txt"))){
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String[] arr=line.split("    ");
                if(arr[0].equals(name) && arr[1].equals(password)){
                    return true;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return false;
    }

    //to print the menu
    public void menu_reader(){
        try{
            File file = new File("/Users/shivpratapsinghchandel/git/Cafe_Management_System/Cafe Management System/src/Files/menu.txt");
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

    public void ordering(String name, String phone_num){
        menu_reader();
        boolean countine_order=true;
        while(countine_order){
            Scanner input=new Scanner(System.in);
            System.out.println("Enter the serial number of the item you want to order: ");
            String serial_num=input.nextLine();
            System.out.println("Enter the quantity of the item you want to order: ");
            int quantity=input.nextInt();
            try{
                File file=new File("/Users/shivpratapsinghchandel/git/Cafe_Management_System/Cafe Management System/src/Files/menu.txt");
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
                        FileWriter fw=new FileWriter("/Users/shivpratapsinghchandel/git/Cafe_Management_System/Cafe Management System/src/Files/Orders.txt", true);
                        BufferedWriter bw=new BufferedWriter(fw);
                        bw.write(name + "    " + phone_num + "    " + arr[0] + "    " + quantity + "    " + total_price);
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

    public void print_bill(){
        admin ad=new admin();
        try{
            File file=new File("/Users/shivpratapsinghchandel/git/Cafe_Management_System/Cafe Management System/src/Files/Orders.txt");
            Scanner reader=new Scanner(file);
            String last_order="";
            while(reader.hasNextLine()){
                last_order=reader.nextLine();
            }
            String[] arr=last_order.split("    ");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("-----------------------Thank you for ordering!-----------------------------");
            System.out.println("Name: "+arr[0]);
            System.out.println("Phone number: "+arr[1]);
            System.out.println("Item: "+arr[2]);
            System.out.println("Quantity: "+arr[3]);
            ad.check_for_discount(arr[4]);
            System.out.println("-----------------------Please visit again!---------------------------------");
            System.out.println("---------------------------------------------------------------------------");
            reader.close();
        }
        catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}