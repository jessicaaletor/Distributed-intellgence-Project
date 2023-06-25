/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import models.Product;

/**
 *
 * @author jessicae
 */
public class Products {
    private ArrayList<Product> products;
    
    public Products(){
        products = new ArrayList<>();
        SeedProducts();
    }
    
    public ArrayList<Product> GetProducts(){
        return products;
    }
    
    
    
    private void SeedProducts(){
        Product product1 = new Product();
        product1.setName("Product1");
        product1.setPrice(10.00);
        product1.setSeller("seller1");
        product1.setStock(10);
        products.add(product1);
        Product product2 = new Product();
        product2.setName("Product2");
        product2.setPrice(12.00);
        product2.setSeller("seller2");
        product2.setStock(10);
        products.add(product2);
        Product product3 = new Product();
        product3.setName("Product3");
        product3.setPrice(15.00);
        product3.setSeller("seller3");
        product3.setStock(10);
        products.add(product3);
        
    }

}
