/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import models.Order;
import models.Customer;
import models.Product;
import models.Seller;
import java.util.ArrayList;
/**
 *
 * @author jessicae
 */
public class Broker {
    private Sellers sellers;
    private Products products;


    private Customers customers;
    private Orders orders;


    public Broker(){
        sellers = new Sellers();
        products = new Products();
        customers = new Customers();
        orders = new Orders();   
    }
    
    public ArrayList<Product> GetProduct(){
        return products.GetProducts();
    }
    
    public ArrayList<Customer> GetCustomer(){
        return customers.GetCustomers();
    }
    
    public ArrayList<Seller> GetSeller(){
        return sellers.GetSellers();
    }
    
    public ArrayList<Order> GetOrder(){
        return orders.GetOrders();
    }
    
    
    public Order SubmitOrder(String customer, String product, String seller, Integer quantity, Double price, Double bidprice){
        Order order;
        order = new Order();
        order.setCustomer(customer);
        order.setPrice(price);
        order.setBidPrice(bidprice);
        order.setQuantity(quantity);
        order.setSeller(seller);
        order.setProduct(product);
        return orders.AddOrder(order);
    }
    
    private Order SetOrderStatus(String product, String seller, String status){
        ArrayList<Order> ordrs = orders.GetOrders();
        Order order = null;
        for(int count = 0; count < ordrs.size(); count++){
            if(ordrs.get(count).getSeller().equalsIgnoreCase(seller) && ordrs.get(count).getProduct().equalsIgnoreCase(product)){
                order = ordrs.get(count);
                order.setStatus(status);
                break;
            }
        }
        return order;
    }
    
    private void UpdateStockQuantity(String seller, String product, int quantity){
        ArrayList<Product> prods = products.GetProducts();
        for (Product p : prods){
            if(p.getName().equalsIgnoreCase(product) && p.getSeller().equalsIgnoreCase(seller)){
                p.setStock(p.getStock()- quantity);
                break;
            }
        }
    }
    
    public Order ApproveOrder( String seller, int quantity, String product){
        Order order = this.SetOrderStatus(product, seller, "sold");
        this.UpdateStockQuantity(seller, product, quantity);
        return order;
    }
    
    public Order DenyOrder( String seller, int quantity, String product){
        Order order = this.SetOrderStatus(product, seller, "denied");
        return order;
    }
    
    
    
}
