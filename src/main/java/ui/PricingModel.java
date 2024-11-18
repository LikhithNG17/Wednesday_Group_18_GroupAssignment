/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.ProductManagement.ProductCatalog;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author likhithng
 */
public class PricingModel {

  /**
   * @param args the command line arguments
   */
    public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Create main work area with CardLayout
                    JPanel mainWorkArea = new JPanel();
                    mainWorkArea.setLayout(new CardLayout());
                    
                    // Initialize Business
                    System.out.println("Initializing business...");
                    Business business = new Business("Pricing Analytics System");
                    SupplierDirectory supplierDirectory = business.getSupplierDirectory();
                    
                    // Generate sample data
                    System.out.println("Generating sample data...");
                    generateSampleData(supplierDirectory);
                    
                    // Create and show login frame
                    LoginMainJFrame loginFrame = new LoginMainJFrame(mainWorkArea, supplierDirectory);
                    loginFrame.setLocationRelativeTo(null);
                    loginFrame.pack();
                    loginFrame.setVisible(true);
                    
                } catch (Exception e) {
                    System.err.println("Error initializing application:");
                    e.printStackTrace();
                }
            
            
            }
            

            private void generateSampleData(SupplierDirectory supplierDirectory) {
                // Create 5 suppliers
                String[] supplierNames = {"Apple", "Samsung", "Microsoft", "Google", "Amazon"};
                String[] productTypes = {"Phone", "Laptop", "Tablet", "Watch", "Speaker", 
                                       "Headphones", "Camera", "TV", "Console", "Router"};
                
                // For each supplier
                for (String supplierName : supplierNames) {
                    System.out.println("Creating supplier: " + supplierName);
                    
                    // Create supplier
                    Supplier supplier = supplierDirectory.newSupplier(supplierName);
                    ProductCatalog catalog = supplier.getProductCatalog();
                    
                    // Create 10 products for each supplier
                    for (int i = 0; i < 10; i++) {
                        String productName = productTypes[i];
                        
                        int targetPrice = 1000 + (i * 100);  // Prices from 1000 to 1900
                        int floorPrice = targetPrice - 200;   // 200 below target
                        int ceilingPrice = targetPrice + 200; // 200 above target
                        
                        System.out.println("Creating product: " + productName + " for " + supplierName);
                        
                        catalog.newProduct(productName, floorPrice, targetPrice, ceilingPrice);
                    }
                }
                
                // Print summary
                System.out.println("\nData Generation Summary:");
                System.out.println("Number of Suppliers: " + supplierDirectory.getSuplierList().size());
                for (Supplier supplier : supplierDirectory.getSuplierList()) {
                    System.out.println("\nSupplier: " + supplier.getName());
                    // Just print that products were created without trying to access the size
                    System.out.println("Products created for supplier: " + supplier.getName());
                }
            }
        });
    }
}