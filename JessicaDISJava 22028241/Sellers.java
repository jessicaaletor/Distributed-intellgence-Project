/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import models.Seller;

/**
 *
 * @author jessicae
 */
public class Sellers {

    public ArrayList<Seller> sellers;
    
    public Sellers(){
        sellers = new ArrayList<>();
        SeedSellers();
    }
    
    public ArrayList<Seller> GetSellers(){
        return sellers;
    }
    
    
    
    private void SeedSellers(){
        Seller seller1 = new Seller();
        seller1.setName("Seller1");
        sellers.add(seller1);
        Seller seller2 = new Seller();
        seller2.setName("Seller2");
        sellers.add(seller2);
        Seller seller3 = new Seller();
        seller3.setName("Seller3");
        sellers.add(seller3);
        
    }
    

    
}
