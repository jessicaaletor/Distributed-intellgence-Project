/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import models.Customer;

/**
 *
 * @author jessicae
 */
public class Customers {

    private ArrayList<Customer> customers;
    
    public Customers(){
        customers = new ArrayList<>();
        SeedCustomers();
    }
    
    public ArrayList<Customer> GetCustomers(){
        return customers;
    }
    
    private void SeedCustomers(){
        Customer customer1 = new Customer();
        customer1.setName("Customer1");
        customers.add(customer1);
        Customer customer2 = new Customer();
        customer2.setName("Customer2");
        customers.add(customer2);
        Customer customer3 = new Customer();
        customer3.setName("Customer3");
        customers.add(customer3);
    }
    
}
