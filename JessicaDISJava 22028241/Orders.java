/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import models.Order;

/**
 *
 * @author jessicae
 */
public class Orders {
     private ArrayList<Order> orders;
    
    public Orders(){
        orders = new ArrayList<>();
    }
    
    public ArrayList<Order> GetOrders(){
        return orders;
    }
    
    public Order AddOrder(Order order){
        orders.add(order);
        return order;
    }
}


