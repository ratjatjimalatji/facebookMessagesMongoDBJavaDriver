
package facebookmessagesmongodbjava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;


public class facebookTestForm extends javax.swing.JFrame {

    public facebookTestForm() {
        initComponents();
        Connect();
    }
MongoClient mongo;
    MongoDatabase dbconnection;
    MongoCollection<org.bson.Document> collection;

    public final void Connect()
    {            
        mongo = MongoClients.create();
        dbconnection = mongo.getDatabase("prac8db");
        collection = dbconnection.getCollection("messages");  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCollectionName = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextArea();
        btnGetArrayDocuments = new javax.swing.JButton();
        btnCount = new javax.swing.JButton();
        btnCountSpring = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCollectionName.setText("Collection name");
        btnCollectionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectionNameActionPerformed(evt);
            }
        });

        txtDisplay.setColumns(20);
        txtDisplay.setRows(5);
        jScrollPane1.setViewportView(txtDisplay);

        btnGetArrayDocuments.setText("Get array documents");
        btnGetArrayDocuments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetArrayDocumentsActionPerformed(evt);
            }
        });

        btnCount.setText("Count");
        btnCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountActionPerformed(evt);
            }
        });

        btnCountSpring.setText("Count spring");
        btnCountSpring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountSpringActionPerformed(evt);
            }
        });

        jLabel1.setText("facebook Messages Practical 8 u25267869");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGetArrayDocuments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCollectionName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCountSpring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCollectionName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGetArrayDocuments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCountSpring)
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public  List<String> getAllCollections() {
        List<String> collectionNames = new ArrayList<>();

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("prac8Db"); // replace with your database name

            for (String name : db.listCollectionNames()) {
                collectionNames.add(name);
            }

        } catch (Exception e) {
           txtDisplay.setText("Error retrieving collections: " + e.getMessage());
        }

        return collectionNames;
    }

    public  void printAllCollections() {
        List<String> collections = getAllCollections();
        if (collections.isEmpty()) {
            txtDisplay.setText("No collections found.");
        } else {
            txtDisplay.setText("Collections in database:");
            for (String name : collections) {
                txtDisplay.setText(" - " + name);
            }
        }
    }
    
//    public  List<String> getAllDocuments() {
//        List<String> documentNames = new ArrayList<>();
//
//        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
//            MongoDatabase db = client.getDatabase("prac8Db"); // replace with your database name
//
//            for (String name : db.()) {
//                documentNames.add(name);
//            }
//
//        } catch (Exception e) {
//           txtDisplay.setText("Error retrieving collections: " + e.getMessage());
//        }
//
//        return documentNames;
//    }
//
//    public  void printAllDocuments() {
//        List<String> collections = getAllCollections();
//        if (collections.isEmpty()) {
//            txtDisplay.setText("No collections found.");
//        } else {
//            txtDisplay.setText("Collections in database:");
//            for (String name : collections) {
//                txtDisplay.setText(" - " + name);
//            }
//        }
//    }
public void clearDisplay(){
    txtDisplay.setText("");
}
    private void btnCollectionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectionNameActionPerformed
        // TODO add your handling code here:                                            
   clearDisplay();
   printAllCollections();
    }//GEN-LAST:event_btnCollectionNameActionPerformed

    private void btnGetArrayDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetArrayDocumentsActionPerformed
        // TODO add your handling code here:
        clearDisplay();
    }//GEN-LAST:event_btnGetArrayDocumentsActionPerformed

    private void btnCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountActionPerformed
        // TODO add your handling code here:
        clearDisplay();
    }//GEN-LAST:event_btnCountActionPerformed

    private void btnCountSpringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountSpringActionPerformed
        // TODO add your handling code here:
        clearDisplay();
    }//GEN-LAST:event_btnCountSpringActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(facebookTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facebookTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facebookTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facebookTestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facebookTestForm().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCollectionName;
    private javax.swing.JButton btnCount;
    private javax.swing.JButton btnCountSpring;
    private javax.swing.JButton btnGetArrayDocuments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDisplay;
    // End of variables declaration//GEN-END:variables
}
