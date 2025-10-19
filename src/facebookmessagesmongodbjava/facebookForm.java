
package facebookmessagesmongodbjava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;

public class facebookForm extends javax.swing.JFrame {

    //public static final java.util.logging.Logger = java.util.logging.Logger.getLogger(facebookForm);
     
    public  void faceBook() {
        initComponents();
        Connect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCollectionName = new javax.swing.JButton();
        btnGetArrayDocuments = new javax.swing.JButton();
        btnCount = new javax.swing.JButton();
        btnCountSpring = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtStName = new javax.swing.JTextField();
        txtStudNo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCollectionName.setText("Collection name");
        btnCollectionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectionNameActionPerformed(evt);
            }
        });

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        txtStudNo.setText(" ");
        txtStudNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGetArrayDocuments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCountSpring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCollectionName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStName)
                    .addComponent(txtStudNo, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnCollectionName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGetArrayDocuments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCountSpring))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(txtStName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtStudNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    MongoClient mongo;
    MongoDatabase dbconnection;
    MongoCollection<org.bson.Document> collection;

    public final void Connect()
    {    
        
        mongo = MongoClients.create();
        dbconnection = mongo.getDatabase("db_name");
        collection = dbconnection.getCollection("col_name");
        System.out.println("connected to database");
  
    }
    private void btnCollectionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectionNameActionPerformed
//       //button action code
    }//GEN-LAST:event_btnCollectionNameActionPerformed

    private void btnGetArrayDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetArrayDocumentsActionPerformed
       //button action code
	Document d =new Document("name",txtStName.getText());
    d.append("studentno",txtStudNo.getText());  
    collection.insertOne(d);
    JOptionPane.showMessageDialog(this, "Class attendance captured sucessfully");
   
    txtStName.setText("");
    txtStudNo.setText("");
    }//GEN-LAST:event_btnGetArrayDocumentsActionPerformed

    private void btnCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountActionPerformed
//       var c = db.prac8db.find()
//               while { c.hasNext() printJson(c.next())) 
//               
//               }
//               
//               prac8db.messages.aggregate(
//                       {$match: _id(),
//                       $group: $id},
//                            $count
//                       })
    }//GEN-LAST:event_btnCountActionPerformed

    private void btnCountSpringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountSpringActionPerformed
       
    }//GEN-LAST:event_btnCountSpringActionPerformed

    private void txtStudNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudNoActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
          initComponents();
        Connect();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCollectionName;
    private javax.swing.JButton btnCount;
    private javax.swing.JButton btnCountSpring;
    private javax.swing.JButton btnGetArrayDocuments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtStName;
    private javax.swing.JTextField txtStudNo;
    // End of variables declaration//GEN-END:variables
}
