/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonDirectory;
import model.MarketingManagement.MarketingPersonProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.EmployeeDirectory;
import model.Personnel.EmployeeProfile;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  public static Business initialize() {
    Business business = new Business("Xerox");

    return business;
  }
  static int upperPriceLimit = 50;
    static int lowerPriceLimit = 10;
    static int range = 5;
    static int productMaxQuantity = 5;

    public static Business createABusinessAndLoadALotOfData(String name, int supplierCount, int productCount,
            int customerCount, int orderCount, int itemCount) {
        Business business = new Business(name);

        // Add Suppliers +
        loadSuppliers(business, supplierCount);

        // Add Products +
        loadProducts(business, productCount);

        // Add Customers
        loadCustomers(business, customerCount);

        // Add Order
        loadOrders(business, orderCount, itemCount);

        // Pick any 10 Suppliers and add 20 Products to each
        addProducts(business, 10, 20);

        // Pick any 25 Customers and add 1-3 Orders with 1-10 Items to each
        addOrders(business, 25, 3, 10);

        // Pick three random Customers and print out their Sales orders
        getCustomerSalesOrders(business, 3);

        // Find a Supplier with most sales
        getBestSupplier(business);

        // Find a Supplier with least sales (do not include Supplier with zero sales)
        getWorstSupplier(business);

        return business;
    }

    public static void loadSuppliers(Business b, int supplierCount) {
        SupplierDirectory supplierDirectory = b.getSupplierDirectory();
        for (int index = 1; index <= supplierCount; index++) {
            supplierDirectory.newSupplier("Supplier #" + index);
        }
    }

    static void loadProducts(Business b, int productCount) {
        SupplierDirectory supplierDirectory = b.getSupplierDirectory();

        for (Supplier supplier : supplierDirectory.getSuplierList()) {

            int randomProductNumber = getRandom(1, productCount);
            ProductCatalog productCatalog = supplier.getProductCatalog();

            for (int index = 1; index <= randomProductNumber; index++) {

                String productName = "Product #" + index + " from " + supplier.getName();
                int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
                int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
                int randomTarget = getRandom(randomFloor, randomCeiling);

                productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
            }
        }
    }

    static void addProducts(Business b, int supplierCount, int productCount) {
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    Set<Supplier> uniqueSuppliers = new HashSet<>(); 

    while (uniqueSuppliers.size() < supplierCount) {
        Supplier randomSupplier = supplierDirectory.pickRandomSupplier();
        uniqueSuppliers.add(randomSupplier);
    }

    for (Supplier supplier : uniqueSuppliers) {
        ProductCatalog currentSupplierProductCatalog = supplier.getProductCatalog();

        // Changed getProductList() to getProducts()
        System.out.println("Previous number of products for supplier " + supplier.getName() + " is: "
                + currentSupplierProductCatalog.getProducts().size());

        for (int i = 1; i <= productCount; i++) {
            String productName = "New Product #" + i + " from " + supplier.getName();
            int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
            int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
            int randomTarget = getRandom(randomFloor, randomCeiling);
            currentSupplierProductCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
        }

        // Changed getProductList() to getProducts()
        System.out.println("Current number of products for supplier " + supplier.getName() + " is: "
                + currentSupplierProductCatalog.getProducts().size());
    }
}

    // get a random number from range [lower, upper), i.e. include lower bound,
    // exclude upper bound
    static int getRandom(int lower, int upper) {
        Random r = new Random();

        // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
        // numbers from 10 to 15
        // I will have result = 10 + nextInt(5)
        int randomInt = lower + r.nextInt(upper - lower);
        return randomInt;
    }

    static void loadCustomers(Business b, int customerCount) {
        CustomerDirectory customerDirectory = b.getCustomerDirectory();
        PersonDirectory personDirectory = b.getPersonDirectory();

        for (int index = 1; index <= customerCount; index++) {
            Person newPerson = personDirectory.newPerson("" + index);
            customerDirectory.newCustomerProfile(newPerson);
        }
    }

   
    static void addOrders(Business b, int customerCount, int maxOrderCount, int maxItemCount) {
        // choose a number of customers
        CustomerDirectory customerDirectory = b.getCustomerDirectory();
        SupplierDirectory sd = b.getSupplierDirectory();
        Set<CustomerProfile> uniqueCustomerProfiles = new HashSet<>();

        while (uniqueCustomerProfiles.size() < customerCount) {
            CustomerProfile customerProfile = customerDirectory.pickRandomCustomer();
            uniqueCustomerProfiles.add(customerProfile);
        }

        // add orders (with maximum number) for each selected customers
        MasterOrderList orderList = b.getMasterOrderList();

        for (CustomerProfile customerProfile : uniqueCustomerProfiles) {
            // choose order count from 1-3
            int randomNumberOfOrders = getRandom(1, maxOrderCount + 1);
            // add orders to this customer
            for (int i = 0; i < randomNumberOfOrders; i++) {
                Order newOrder = orderList.newOrder(customerProfile);
                // choose item count from 1-10
                int randomNumberOfItems = getRandom(1, maxItemCount + 1);
                for (int j = 0; j < randomNumberOfItems; j++) {
                    // initialize an order item
                    Supplier randomSupplier = sd.pickRandomSupplier();
                    if (randomSupplier == null) {
                        System.out.println("Cannot generate orders. No supplier in the supplier directory.");
                        return;
                    }
                    ProductCatalog pc = randomSupplier.getProductCatalog();
                    Product randomProduct = pc.pickRandomProduct();
                    if (randomProduct == null) {
                        System.out.println("Cannot generate orders. No products in the product catalog.");
                        return;
                    }
                    int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
                    int randomQuantity = getRandom(1, productMaxQuantity);

                    OrderItem oi = newOrder.newOrderItem(randomProduct, randomPrice, randomQuantity);
                }
                System.out.println("Add one order to masterOrderList for customer "
                        + customerProfile.getCustomerId() + " with " + randomNumberOfItems + " items.");
            }
        }

    }

    static void loadOrders(Business b, int orderCount, int itemCount) {

        // reach out to masterOrderList
        MasterOrderList mol = b.getMasterOrderList();

        // pick a random customer (reach to customer directory)
        CustomerDirectory cd = b.getCustomerDirectory();
        SupplierDirectory sd = b.getSupplierDirectory();

        for (int index = 0; index < orderCount; index++) {

            CustomerProfile randomCustomer = cd.pickRandomCustomer();
            if (randomCustomer == null) {
                System.out.println("Cannot generate orders. No customers in the customer directory.");
                return;
            }

            // create an order for that customer
            Order randomOrder = mol.newOrder(randomCustomer);

            // add order items
            // -- pick a supplier first (randomly)
            // -- pick a product (randomly)
            // -- actual price, quantity

            int randomItemCount = getRandom(1, itemCount);
            for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {

                Supplier randomSupplier = sd.pickRandomSupplier();
                if (randomSupplier == null) {
                    System.out.println("Cannot generate orders. No supplier in the supplier directory.");
                    return;
                }
                ProductCatalog pc = randomSupplier.getProductCatalog();
                Product randomProduct = pc.pickRandomProduct();
                if (randomProduct == null) {
                    System.out.println("Cannot generate orders. No products in the product catalog.");
                    return;
                }

                int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
                int randomQuantity = getRandom(1, productMaxQuantity);

                OrderItem oi = randomOrder.newOrderItem(randomProduct, randomPrice, randomQuantity);
            }
        }
        // Make sure order items are connected to the order

    }

    static void getCustomerSalesOrders(Business b, int customerCount) {
        // choose a number of customers
        CustomerDirectory customerDirectory = b.getCustomerDirectory();
        Set<CustomerProfile> uniqueCustomerProfiles = new HashSet<>();

        while (uniqueCustomerProfiles.size() < customerCount) {
            CustomerProfile customerProfile = customerDirectory.pickRandomCustomer();
            uniqueCustomerProfiles.add(customerProfile);
        }

//        for (CustomerProfile customerProfile : uniqueCustomerProfiles) {
//            ArrayList<Order> orders = customerProfile.getOrders();
//            for (Order order : orders) {
//                order.printInfo();
//            }
//        }
    }

    

    static void getBestSupplier(Business b) {
        SupplierDirectory supplierDirectory = b.getSupplierDirectory();
        ArrayList<Supplier> suppliers = supplierDirectory.getSuplierList();

        int maximumSales = Integer.MIN_VALUE;
        Supplier bestSupplier = new Supplier("default");

        for (Supplier supplier : suppliers) {
            ProductsReport productsReport = supplier.prepareProductsReport();
            ArrayList<ProductSummary> productSummaries = productsReport.getProductSummaries();

            int salesSum = 0;

            for (ProductSummary productSummary : productSummaries) {
                salesSum += productSummary.getSalesRevenues();
            }

            if (salesSum > maximumSales) {
                maximumSales = salesSum;
                bestSupplier = supplier;
            }
        }

        System.out.println("The supplier with most sales is " + bestSupplier.getName() + " with total sales volume "
                + maximumSales);
    }

    static void getWorstSupplier(Business b) {
        SupplierDirectory supplierDirectory = b.getSupplierDirectory();
        ArrayList<Supplier> suppliers = supplierDirectory.getSuplierList();

        int minimumSales = Integer.MAX_VALUE;
        Supplier worstSupplier = new Supplier("default");

        for (Supplier supplier : suppliers) {
            ProductsReport productsReport = supplier.prepareProductsReport();
            ArrayList<ProductSummary> productSummaries = productsReport.getProductSummaries();

            int salesSum = 0;

            for (ProductSummary productSummary : productSummaries) {
                salesSum += productSummary.getSalesRevenues();
            }

            if (salesSum != 0 && salesSum < minimumSales) {
                minimumSales = salesSum;
                worstSupplier = supplier;
            }
        }

        System.out.println("The supplier with least sales is " + worstSupplier.getName() + " with total sales volume "
                + minimumSales);
    }


}
