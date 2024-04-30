import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Employee emp=new Employee();
        admin ad=new admin();
        Scanner input=new Scanner(System.in);
        boolean logged_in=false;
        String logged_in_as="";

        String choice;

        //Loop to check whether the login is successful
        while(logged_in==false){
            System.out.println("Are you an admin or a employee?");
            choice=input.nextLine();
            if (choice.equals("admin")){
                System.out.println("Enter your name: ");
                String name=input.nextLine();
                System.out.println("Enter your password: ");
                String password=input.nextLine();
                if(ad.check_identity(name, password)){
                    logged_in=true;
                    logged_in_as="admin";
                }
            }
            else if (choice.equals("employee")){
                System.out.println("Enter your name: ");
                String name=input.nextLine();
                System.out.println("Enter your password: ");
                String password=input.nextLine();
                if(emp.check_identity(name, password)){
                    logged_in=true;
                    logged_in_as="employee";
                }
            }
        }

        if (logged_in_as.equals("admin")){        
            System.out.println("Do you want to change the menu, add a new employee or order for the customer?");
            String choice1=input.nextLine();
            if (choice1.equals("change the menu")){
                ad.change_menu();
            }
            else if (choice1.equals("add a new employee")){
                System.out.println("Enter the name of the employee: ");
                String name1=input.nextLine();
                System.out.println("Enter the password of the employee: ");
                String password1=input.nextLine();
                ad.add_emplyee(name1, password1);
            }
            else if (choice1.equals("order something fot the customer")){
                
            }
        }
        else if(logged_in_as.equals("employee")){
            emp.checking_for_new_customers();
            emp.print_bill();
        }
            
        input.close();
    }
            
}

//Admin account class with permission to change the menu and the quantity of the items
//User account with only permission to order something from the menu
//Different files for different users
//Different file for the menu
//Placed orders will be stored in the file of the user which ordered the items
//Check whether the item is available in the menu with the same quantity as the user ordered
//If the item is not available, then the user will be notified
//If the item is available, then the user will be notified with the total amount to be paid
//The quantity of the item will be reduced in the menu file
//Admin can see the placed orders of the users
//Admin can see the amount of money earned
//Admin can add discounts to the items