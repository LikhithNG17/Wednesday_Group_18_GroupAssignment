/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    String type;
    ArrayList<Product> products;
    
    public ProductCatalog(String n){
        type = n;
        products = new ArrayList<Product>();
    }
    
    // This should be the ONLY getProducts method in your class
    public ArrayList<Product> getProducts(){
        if(products == null) {
            products = new ArrayList<Product>();
        }
        return products;
    }
    public Product newProduct(String name, int fp, int tp, int cp) {
        Product p = new Product(name, fp, tp, cp);
        products.add(p);
        return p;
    }

    public ProductsReport generatProductPerformanceReport() {
        ProductsReport productsreport = new ProductsReport();
        for (Product p : products) {
            ProductSummary ps = new ProductSummary(p);
            productsreport.addProductSummary(ps);
        }
        return productsreport;
    }

    public Product pickRandomProduct() {
        if (products.size() == 0)
            return null;
        Random r = new Random();
        int randomIndex = r.nextInt(products.size());
        return products.get(randomIndex);
    }
    

}
