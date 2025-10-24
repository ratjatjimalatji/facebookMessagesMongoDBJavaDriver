
package facebookmessagesmongodbjava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
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
    MongoCollection<org.bson.Document> facebookCollection;

    public final void Connect()
    {            
        mongo = MongoClients.create();
        dbconnection = mongo.getDatabase("prac8db");
        collection = dbconnection.getCollection("messages");  
        facebookCollection = dbconnection.getCollection("facebook");  
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
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();

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

    jLabel1.setText("MongoDB database querying with Java drive");
    jLabel2.setText("Returns the number of collections in the database");
    jLabel3.setText("Counts the number of documents in the facebook collection");
    jLabel4.setText("Counts the number of messages in the messages collection");
    jLabel5.setText("Counts the occurances of 'Spring' in the messages collection");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnCollectionName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGetArrayDocuments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCountSpring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(30, 30, 30)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(23, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addGap(200, 200, 200))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jLabel1)
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(btnCollectionName)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(btnGetArrayDocuments)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addComponent(btnCount)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(btnCountSpring)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel5)))
            .addContainerGap(30, Short.MAX_VALUE))
    );
    pack();
}// </editor-fold>//GEN-END:initComponents
    public  List<String> getAllCollections() {
        List<String> collectionNames = new ArrayList<>();

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = client.getDatabase("prac8db"); // replace with your database name

            for (String name : db.listCollectionNames()) {
                collectionNames.add(name);
            }

        } catch (Exception e) {
           txtDisplay.setText("Error retrieving collections: " + e.getMessage());
        }

        return collectionNames;
    }

 public void printAllCollections() {
        List<String> collections = getAllCollections();
        if (collections.isEmpty()) {
            txtDisplay.setText("No collections found in database.");
        } else {
            StringBuilder output = new StringBuilder();
            output.append("Collections in database 'prac8db':\n");
            output.append("=====================================\n\n");
            
            for (String name : collections) {
                output.append("  - ").append(name).append("\n");
            }
            
            output.append("\nTotal collections: ").append(collections.size());
            txtDisplay.setText(output.toString());
        }
    }
    
public void clearDisplay(){
    txtDisplay.setText("");
}
    private void btnCollectionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectionNameActionPerformed
        // TODO add your handling code here:                                            
   clearDisplay();
   printAllCollections();
    }//GEN-LAST:event_btnCollectionNameActionPerformed

    // Replace the button action methods in facebookTestForm.java with these implementations:

private void btnGetArrayDocumentsActionPerformed(java.awt.event.ActionEvent evt) {
    clearDisplay();
    StringBuilder output = new StringBuilder();
    
    try {
        // Query for documents that have a "data" array field
        Document query = new Document("data", new Document("$exists", true));
        
        for (Document doc : facebookCollection.find(query)) {
            // Get the data array
            List<Document> dataArray = (List<Document>) doc.get("data");
            
            if (dataArray != null && !dataArray.isEmpty()) {
                output.append("Found ").append(dataArray.size()).append(" documents in array:\n\n");
                
                for (Document item : dataArray) {
                    output.append("ID: ").append(item.getString("id")).append("\n");
                    
                    // Display from information
                    Document from = (Document) item.get("from");
                    if (from != null) {
                        output.append("From: ").append(from.getString("name"))
                              .append(" (ID: ").append(from.getString("id")).append(")\n");
                    }
                    
                    // Display message
                    output.append("Message: ").append(item.getString("message")).append("\n");
                    output.append("------------------------\n");
                }
            }
        }
        
        if (output.length() == 0) {
            txtDisplay.setText("No documents with data array found.");
        } else {
            txtDisplay.setText(output.toString());
        }
        
    } catch (Exception e) {
        txtDisplay.setText("Error retrieving array documents: " + e.getMessage());
    }
}

private void btnCountActionPerformed(java.awt.event.ActionEvent evt) {
    clearDisplay();
    
    try {
        long count = collection.countDocuments();
        txtDisplay.setText("Total number of documents in collection: " + count);
        
    } catch (Exception e) {
        txtDisplay.setText("Error counting documents: " + e.getMessage());
    }
}

private void btnCountSpringActionPerformed(java.awt.event.ActionEvent evt) {
    clearDisplay();
    
    try {
        // Query for documents where message contains "spring" (case-insensitive)
        Document query = new Document("message", new Document("$regex", "spring").append("$options", "i"));
        
        long count = collection.countDocuments(query);
        txtDisplay.setText("Number of documents containing 'spring': " + count);
        
    } catch (Exception e) {
        txtDisplay.setText("Error counting spring documents: " + e.getMessage());
    }
}
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDisplay;
    // End of variables declaration//GEN-END:variables
}
