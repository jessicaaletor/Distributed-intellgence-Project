/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */


import models.Customer;
import models.Order;
import models.Product;
import models.Seller;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jessicae
 */
public class Agents {
    private static final Broker broker = new Broker();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Select an Action");
        System.out.println("1. Customer");
        System.out.println("2. Retailer");
        String s = in.nextLine();
        if(s.equals("customer") || s.equals("1")){
            //implement customer interface
           System.out.println("Customer Interface");
            AskCustomerLogon(in);
        }
       else if(s.equals("retailer") ||  s.equals("2")){
            //implements retailer interface
            System.out.println("Retailer Interface");
            AskRetailerLogon(in);
        }
    }

    
    private static void AskCustomerLogon(Scanner in){
            System.out.println("Enter Customer ID to continue");
            String s = in.nextLine();
            Boolean loggedin = false;
            ArrayList<Customer> customers = broker.GetCustomer();
            for(Customer c : customers){
                if(c.getName().equalsIgnoreCase(s)){
                    DisplayCustomerInterface(broker, in, c.getName());
                    loggedin = true;
                    break;
                }
            }
            if(!loggedin){
            System.out.println("Invalid Customer Id Entered. Please Try Again");
                AskCustomerLogon(in);
            }
    }
    
    private static void DisplayCustomerInterface(Broker broker, Scanner in, String customer) {
        System.out.println("Select a Product Id to Bid");
        ArrayList<Product> products = broker.GetProduct();
        System.out.println("Id Product Price Retailer");
        for(int count = 1; count <= products.size(); count++){
            Product p = products.get(count-1);
            System.out.println(count+". "+ p.getName()+ " "+p.getPrice()+ " "+p.getSeller());
        }
        int productId = in.nextInt();
        Product prod = products.get(productId-1);
        System.out.println("Enter quantity you intend to purchase");
        int quantity = in.nextInt();
        System.out.println("Enter enter intended price");
        double price = in.nextDouble();
        System.out.println("You are about to bid on :");
        System.out.println(prod.getName()+ " "+prod.getPrice()+ " "+prod.getSeller());
        System.out.println("Enter yes or no to continue");
        String choice = in.nextLine();
        String choic = in.nextLine();
        if(choic.equalsIgnoreCase("no")){
            DisplayCustomerInterface(broker,in, customer);
        }
        broker.SubmitOrder(customer, prod.getName(),prod.getSeller(),quantity ,prod.getPrice(),price);
        
        System.out.println("Your order has been submitted succesfully");
        String[] c = {};
        main(c);
    }
    
    private static void AskRetailerLogon(Scanner in){
            System.out.println("Enter Seller ID to continue");
            String s = in.nextLine();
            Boolean loggedin = false;
            ArrayList<Seller> sellers = broker.GetSeller();
            for(Seller c : sellers){
                if(c.getName().equalsIgnoreCase(s)){
                    DisplaySellerInterface(broker, in, c.getName());
                    loggedin = true;
                    break;
                }
            }
            
            if(!loggedin){
                System.out.println("Invalid Seller Id Entered. Please Try Again");
                AskRetailerLogon(in);
            }
    }

    private static void DisplaySellerInterface(Broker broker, Scanner in, String name) {
        System.out.println("Select an Action");
        System.out.println("1. View Bids");
        System.out.println("2. View Products");
        String s = in.nextLine();
        if(s.equalsIgnoreCase("1") || s.equalsIgnoreCase("View Bids")) {
            SellerBidsInterface(broker, in, name);
        }else if(s.equalsIgnoreCase("2") || s.equalsIgnoreCase("View Products")) {
            SellerProductInterface(broker, in, name);
        }
    }

    private static void SellerBidsInterface(Broker broker, Scanner in, String name) {
       ArrayList<Order> orders = broker.GetOrder();
       System.out.println("Avialable Bids : ");
       System.out.println("Id Product Price BidPrice");
       int count = 1;
       for(Order p : orders){
           if(p.getSeller().equalsIgnoreCase(name) && p.getStatus() == null){
               System.out.println(count+". "+ p.getProduct()+ "  "+p.getPrice()+ "  "+p.getBidPrice());
               count++;
           }
       }
       System.out.println("Select a bid id to continue ");
       int id = in.nextInt();
       System.out.println("Enter yes/no to accept or deny bid ");
       String choic = in.nextLine();
       String choice = in.nextLine();
       if(choice.equalsIgnoreCase("yes")){
           Order order = orders.get(id-1);
           broker.ApproveOrder(order.getSeller(), order.getQuantity(), order.getProduct());
       }else if(choice.equalsIgnoreCase("no")){
           Order order = orders.get(id-1);
           broker.DenyOrder(order.getSeller(), order.getQuantity(), order.getProduct()); 
       }
       System.out.println("Response Saved Succesfully");
       String[] c = {};
       main(c);
    }

    private static void SellerProductInterface(Broker broker, Scanner in, String name) {
       ArrayList<Product> products = broker.GetProduct();
       int count = 1;
       System.out.println("Id Product Price Retailer");
       for(Product p : products){
           if(p.getSeller().equalsIgnoreCase(name)){
               System.out.println(count+". "+ p.getName()+ " "+p.getPrice()+ " "+p.getSeller());
               count++;
           }
       }
       System.out.println("Enter BACK to go back");
       String s = in.nextLine();
       if(s.equalsIgnoreCase("back")){
           DisplaySellerInterface(broker, in, name);
       }
    }
    
    
}
