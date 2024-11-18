/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import model.CustomerManagement.CustomerProfile;

import model.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class Product {
    private String name;
    private int targetPrice;
    private int floorPrice;
    private int ceilingPrice;
    private int salesVolume;
    private double salesRevenue;
    private int previousPrice;
    ArrayList<OrderItem> orderitems;
        public Product( int fp, int cp, int tp) {

        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        orderitems = new ArrayList();
    }
        public Product(String name, int floor, int ceiling, int target) {
       this.name = name;
    this.floorPrice = floor;
    this.ceilingPrice = ceiling;
    this.targetPrice = target;
    this.previousPrice = target; // Initialize previous price to the same value as target price
    this.salesVolume = 100; // Default sample value
    this.salesRevenue = targetPrice * salesVolume;
        }

    public ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }
        public Product updateProduct(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; //returns itself
    }
    public int getTargetPrice() {return targetPrice;}
    public void addOrderItem(OrderItem oi){     
        orderitems.add(oi);
    }
    //Number of item sales above target 
    public int getNumberOfProductSalesAboveTarget(){
        int sum = 0;
        for (OrderItem oi: orderitems){
            if(oi.isActualAboveTarget()==true) sum = sum +1;
        }
        return sum;
    }
    public int getNumberOfProductSalesBelowTarget(){
        int sum = 0;
        for (OrderItem oi: orderitems){
            if(oi.isActualBelowTarget()==true) sum = sum +1;
        }
        return sum;
    }    
    
        public boolean isProductAlwaysAboveTarget(){
        
        for (OrderItem oi: orderitems){
            if(oi.isActualAboveTarget()==false) return false; //
        }
        return true;
    }
    //calculates the revenues gained or lost (in relation to the target)
    //For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will be $200
    // Add all these difference to get the total including wins and loses
    
        public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }
        public int getSalesVolume() {
        return salesVolume;
    }
    public void setTargetPrice(int price) {
        if (price >= floorPrice && price <= ceilingPrice) {
            this.previousPrice = this.targetPrice; // Store old price before changing
            this.targetPrice = price;
            this.salesRevenue = this.targetPrice * this.salesVolume;
        }
    }
    public void setFloorPrice(int floorPrice) {
        this.floorPrice = floorPrice;
        // Update revenue when price changes
        this.salesRevenue = this.targetPrice * this.salesVolume;
    }
    public void setCeilingPrice(int ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }
    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
        // Update revenue when volume changes
        this.salesRevenue = this.targetPrice * this.salesVolume;
    }
    public void setSalesRevenue(double salesRevenue) {
        this.salesRevenue = salesRevenue;
    }
    
    public double getSalesRevenue() {
        return salesRevenue;
    }

   
    public void setName(String n){
        name = n;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return name;
    }
    public int getFloorPrice(){
        return floorPrice;
    }
    public int getCeilingPrice(){
        return ceilingPrice;
    }
    public int getPreviousPrice() {
        return previousPrice;
    }

    public void addOrder(CustomerProfile randomCustomer, int targetPrice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
