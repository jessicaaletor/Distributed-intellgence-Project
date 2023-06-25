/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author jessicae
 */

public class Order{
        private Double price;
        private String seller;
        private String product;
        private Integer quantity; 
        private String customer;
        private String status = null;
        private Double bidprice;
        public Double getPrice() { return price; }
        public void setPrice(Double price) { this.price = price; }
        public Double getBidPrice() { return bidprice; }
        public void setBidPrice(Double bidprice) { this.bidprice = bidprice; }
        public String getSeller() { return seller; }
        public void setSeller(String seller) { this.seller = seller; }
        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
        public String getCustomer() { return customer; }
        public void setCustomer(String customer) { this.customer = customer; }
        public String getStatus() { return status;}
        public void setStatus(String status ) { this.status = status ;}
        public String getProduct() { return product;}
        public void setProduct(String product ) { this.product = product ;}
}