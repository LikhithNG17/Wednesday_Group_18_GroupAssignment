/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import ui.SupplierWorkAreaJPanel;

/**
 *
 * @author likhithng
 */
public class LoginMainJFrame extends javax.swing.JFrame {
    
   private JPanel mainWorkArea;
    private SupplierDirectory supplierDirectory;
    private Supplier selectedSupplier;
    
    
    /**
     * Creates new form LoginMainJFrame
     */
    public LoginMainJFrame(JPanel mainWorkArea, SupplierDirectory supplierDirectory) {
    initComponents();
        
     this.mainWorkArea = mainWorkArea;
        this.supplierDirectory = supplierDirectory;
        
        System.out.println("Initializing Login Frame");
   
    
    
    populateSupplierCombo();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSupplier = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        cmbSuppliers = new javax.swing.JComboBox<>();
        lbltitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        lblSupplier.setBackground(new java.awt.Color(204, 204, 204));
        lblSupplier.setFont(new java.awt.Font("Mali", 0, 24)); // NOI18N
        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplier.setText("Select Supplier:");

        btnLogin.setBackground(new java.awt.Color(204, 204, 255));
        btnLogin.setFont(new java.awt.Font("Mali", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        cmbSuppliers.setBackground(new java.awt.Color(204, 204, 204));
        cmbSuppliers.setFont(new java.awt.Font("Mali", 0, 24)); // NOI18N
        cmbSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSuppliersActionPerformed(evt);
            }
        });

        lbltitle.setBackground(new java.awt.Color(204, 204, 204));
        lbltitle.setFont(new java.awt.Font("Mali", 1, 48)); // NOI18N
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("Group Assignment Pricing Model");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(cmbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbSuppliers, lblSupplier});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:

      if (selectedSupplier == null) {
        JOptionPane.showMessageDialog(this, "Please select a supplier to login.");
        return;
    }
    
    JFrame frame = new JFrame(selectedSupplier.getName() + " Work Area");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Create supplier work area panel
    SupplierWorkAreaJPanel supplierPanel = new SupplierWorkAreaJPanel(mainWorkArea, selectedSupplier);
    
    // Add panel to frame
    frame.add(supplierPanel);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    // Close login window
    this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void cmbSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSuppliersActionPerformed
        // TODO add your handling code here:
                                            
    if (cmbSuppliers.getSelectedItem() != null) {
            selectedSupplier = (Supplier) cmbSuppliers.getSelectedItem();
            System.out.println("Selected supplier: " + selectedSupplier.getName());
        }
    
    


    }//GEN-LAST:event_cmbSuppliersActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(LoginMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(LoginMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(LoginMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(LoginMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            JPanel mainWorkArea = new JPanel();
            mainWorkArea.setLayout(new CardLayout());
            SupplierDirectory supplierDirectory = new SupplierDirectory();
            LoginMainJFrame frame = new LoginMainJFrame(mainWorkArea, supplierDirectory);
            frame.setVisible(true);
        }
    });
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<Supplier> cmbSuppliers;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lbltitle;
    // End of variables declaration//GEN-END:variables


    private void populateSupplierCombo() {
       cmbSuppliers.removeAllItems();
    System.out.println("Populating suppliers combo box");
    
    ArrayList<Supplier> suppliers = supplierDirectory.getSuplierList();
    if (suppliers != null && !suppliers.isEmpty()) {
        for (Supplier supplier : suppliers) {
            System.out.println("Adding supplier: " + supplier.getName());
            cmbSuppliers.addItem(supplier);
        }
    } else {
        System.out.println("No suppliers found in directory");
    }
    }

    void resetSupplierSelection() {
         selectedSupplier = null;
    if (cmbSuppliers != null) {
        cmbSuppliers.setSelectedIndex(-1);
        populateSupplierCombo();
    }
    }
}