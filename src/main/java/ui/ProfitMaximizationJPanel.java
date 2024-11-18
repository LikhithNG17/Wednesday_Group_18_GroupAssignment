/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.ProductManagement.Product;
import model.Supplier.Supplier;





/**
 *
 * @author gagan
 */
public class ProfitMaximizationJPanel extends javax.swing.JPanel {
    JPanel workArea;
    Supplier supplier;
    Product product; 

    /**
     * Creates new form ProfitMaximizationJPanel
     */
    public ProfitMaximizationJPanel(JPanel workArea, Supplier supplier) {
        initComponents();
        this.workArea = workArea;
        this.supplier = supplier;
        populateTable();
    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) ProfitMaxTable.getModel();
        model.setRowCount(0);

        if (supplier != null && supplier.getProductCatalog() != null) {
            ArrayList<Product> products = supplier.getProductCatalog().getProducts();
            for (Product p : products) {
                Object[] row = {
                    p.getName(),
                    p.getTargetPrice(),
                    p.getSalesVolume(),
                    p.getTargetPrice() - p.getFloorPrice(),  // Margin
                    p.getSalesRevenue()  // Profitability
                };
                model.addRow(row);
            }
        }
    }
    
    class ProfitMaximizationResult {
    private String productName;
    private double currentPrice;
    private double sales;
    private double margins;
    private double profitability;

    // 构造器
    public ProfitMaximizationResult(String productName, double currentPrice, double sales, double margins, double profitability) {
        this.productName = productName;
        this.currentPrice = currentPrice;
        this.sales = sales;
        this.margins = margins;
        this.profitability = profitability;
    }

    // Getters
    public String getProductName() { return productName; }
    public double getCurrentPrice() { return currentPrice; }
    public double getSales() { return sales; }
    public double getMargins() { return margins; }
    public double getProfitability() { return profitability; }

    // Setters
    public void setProductName(String productName) { this.productName = productName; }
    public void setCurrentPrice(double currentPrice) { this.currentPrice = currentPrice; }
    public void setSales(double sales) { this.sales = sales; }
    public void setMargins(double margins) { this.margins = margins; }
    public void setProfitability(double profitability) { this.profitability = profitability; }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProfitLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProfitMaxTable = new javax.swing.JTable();
        btmMax = new javax.swing.JToggleButton();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MaxTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));

        ProfitLabel.setFont(new java.awt.Font("Mali", 1, 36)); // NOI18N
        ProfitLabel.setText("Profit maximization");

        ProfitMaxTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product", "Current Price", "Sales", "Margins ", "Profitability "
            }
        ));
        jScrollPane1.setViewportView(ProfitMaxTable);

        btmMax.setBackground(new java.awt.Color(204, 204, 255));
        btmMax.setFont(new java.awt.Font("Mali", 0, 14)); // NOI18N
        btmMax.setText("Calculate Max Profit");
        btmMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmMaxActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(204, 204, 255));
        btnBack.setFont(new java.awt.Font("Mali", 0, 14)); // NOI18N
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        MaxTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product", "Current Price", "Sales", "Margins ", "Profitability "
            }
        ));
        jScrollPane2.setViewportView(MaxTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(btmMax))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(ProfitLabel)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(ProfitLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btmMax)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btmMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmMaxActionPerformed
        // TODO add your handling code here:
    ArrayList<ProfitMaximizationResult> results = calculateProfitMaximization();
        
        // Populate MaxTable with optimized results
        DefaultTableModel model = (DefaultTableModel) MaxTable.getModel();
        model.setRowCount(0);

        // Find the most profitable product
        ProfitMaximizationResult maxProfit = null;
        for (ProfitMaximizationResult result : results) {
            if (maxProfit == null || result.getProfitability() > maxProfit.getProfitability()) {
                maxProfit = result;
            }
        }

        // Show the most profitable product
        if (maxProfit != null) {
            model.addRow(new Object[]{
                maxProfit.getProductName(),
                maxProfit.getCurrentPrice(),
                maxProfit.getSales(),
                maxProfit.getMargins(),
                maxProfit.getProfitability()
            });
        }
    
    }//GEN-LAST:event_btmMaxActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout)workArea.getLayout();
        layout.previous(workArea);
       
    }//GEN-LAST:event_btnBackActionPerformed


    private ArrayList<ProfitMaximizationResult> calculateProfitMaximization() {
    ArrayList<ProfitMaximizationResult> results = new ArrayList<>();
    
    if (supplier != null && supplier.getProductCatalog() != null) {
        ArrayList<Product> products = supplier.getProductCatalog().getProducts();
        
        for (Product p : products) {
            double currentPrice = p.getTargetPrice();
            double sales = p.getSalesVolume();
            double margins = p.getTargetPrice() - p.getFloorPrice();
            double profitability = margins * sales;
            
            // Create result object with actual product data
            results.add(new ProfitMaximizationResult(
                p.getName(),          // Product name
                currentPrice,         // Current price
                sales,               // Sales volume
                margins,             // Margin
                profitability        // Profitability
            ));
        }
    }
    
    return results;
}





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MaxTable;
    private javax.swing.JLabel ProfitLabel;
    private javax.swing.JTable ProfitMaxTable;
    private javax.swing.JToggleButton btmMax;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
