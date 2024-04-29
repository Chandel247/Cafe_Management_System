import java.util.Scanner;
import java.io.*;

public class admin extends Employee {
    String name;
    String password;
    boolean is_admin;

    //to check whether the login is of admin
    public void check_identity(String name, String password){
        try{
            File file =new File("Files\\Employee.txt");
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
            FileWriter fw = new FileWriter("Files\\menu.txt", true);
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
        File file = new File("Files\\Employee.txt");
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
    
    //to update quantity of an item
    public void update_quantity(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the serial number of the item you want to update: ");
        String serial_num=sc.nextLine();
        System.out.println("Enter the new quantity of the item: ");
        int quantity=sc.nextInt();
        try{
            File file=new File("Files\\menu.txt");
            Scanner reader=new Scanner(file);
            String file_content="";
            while(reader.hasNextLine()){
                String item=reader.nextLine();
                String[] arr=item.split("   ");
                if(arr[3].equals(serial_num)){
                    arr[2]=Integer.toString(quantity);
                }
                file_content+=arr[0]+"   "+arr[1]+"   "+arr[2]+"   "+arr[3]+"\n";
            }
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(file_content);
            bw.close();
            fw.close();
            reader.close();
            sc.close();
        }
        catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    //to remove an employee
    public void remove_employee(String name){
        try{
            File file=new File("Files\\Employee.txt");
            Scanner reader=new Scanner(file);
            String file_content="";
            while(reader.hasNextLine()){
                String line=reader.nextLine();
                String[] arr=line.split("   ");
                if(arr[0].equals(name)){
                    continue;
                }
                file_content+=line+"\n";
            }
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(file_content);
            bw.close();
            fw.close();
            reader.close();
        }
        catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    //to print the bill for the latest order made
    public void check_for_discount(String price){
        
        if (Float.parseFloat(price)>1000){
            System.out.println("Congratulations! You have earned a discount of 10%");
            float discount=(Float.parseFloat(price)*10)/100;
            System.out.println("Total price after discount: "+(Float.parseFloat(price)-discount));
        }
        else{
            System.out.println("Total price: "+price);
        }
    }
}
