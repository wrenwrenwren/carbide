/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ren
 */
public class allocation_view extends javax.swing.JFrame {

    /**
     * Creates new form allocation_view
     */
    public allocation_view() {
        initComponents();
        load_account_weights();
    }
    
    public void load_account_weights(){
        try {
            String homedirec = System.getProperty("user.home");
            String account_weights_direc = homedirec + "/carbide/accounts/account_weights.csv";
            
            String account_name_direc = homedirec + "/carbide/accounts";
            ArrayList<String> account_names = new ArrayList<String>();
            
            for (String line : Files.readAllLines(Paths.get(account_name_direc + "/accounts.txt"))) {
                account_names.add(line);
            }
            
            String[] accountarr = new String[account_names.size()];
            accountarr = account_names.toArray(accountarr);
            
            File account_weights_file = new File(account_weights_direc);
            long file_length = account_weights_file.length();
            if (!account_weights_file.exists() || file_length < 1) {
                
                Object[][] account_weights_data = new Object[accountarr.length][3];
                
                for (int n = 0 ; n < accountarr.length; n++){
                    account_weights_data[n][0] = accountarr[n];
                    account_weights_data[n][1] = "";
                    account_weights_data[n][2] = "";
                }
                String[] column_names = new String[3];
                column_names[0] = "Accounts";
                column_names[1] = "Nominal Value";
                column_names[2] = "Weights";
                
                jTable1.setModel(new javax.swing.table.DefaultTableModel(account_weights_data, column_names));
            } else {
                BufferedReader br = null;

                String[] columnNames = new String[0];
                Object[][] data = new Object[0][0];
                String line = "";
                String splitSign = ",";

                int i = 0;
                br = new BufferedReader(new FileReader(account_weights_direc));

                while (br.readLine() != null) {
                    i++;
                }
                br.close();
                data = new Object[i - 1][];
                i = 0;
                br = new BufferedReader(new FileReader(account_weights_direc));
                line = br.readLine();
                columnNames = line.split(splitSign);

                line = br.readLine();
                while (line != null) {

                    data[i] = new Object[line.split(splitSign).length];
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][j] = line.split(splitSign)[j];
                    }
                    i++;
                     line = br.readLine();
                }
                
                if (accountarr.length > data.length){
                
                    Object[][] new_account_weights_data = new Object[accountarr.length][3];
                
                    for (int n = 0 ; n < accountarr.length; n++){
                        new_account_weights_data[n][0] = accountarr[n];
                        inner: for (int m = 0 ; m < data.length; m++){
                            if (data[m][0].equals(new_account_weights_data[n][0])) {
                                new_account_weights_data[n][1] = data[m][1];
                                new_account_weights_data[n][2] = data[m][2];
                                break inner;
                            } else {
                                new_account_weights_data[n][1] = "";
                                new_account_weights_data[n][2] = "";
                            }   
                        }
                    }
                                
                    jTable1.setModel(new javax.swing.table.DefaultTableModel(new_account_weights_data, columnNames));

                } else if (accountarr.length < data.length){
                    Object[][] new_account_weights_data2 = new Object[accountarr.length][3];
                
                    for (int n = 0 ; n < accountarr.length; n++){
                        new_account_weights_data2[n][0] = accountarr[n];
                        inner: for (int m = 0 ; m < data.length; m++){
                            if (data[m][0].equals(new_account_weights_data2[n][0])) {
                                new_account_weights_data2[n][1] = data[m][1];
                                new_account_weights_data2[n][2] = data[m][2];
                                break inner;
                            }  
                        }
                    }
                    
                    jTable1.setModel(new javax.swing.table.DefaultTableModel(new_account_weights_data2, columnNames));
                    jButton2.doClick();
                    jButton1.doClick();
                } else {
                    jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                    jButton2.doClick();
                }

            }
            
        } catch (IOException ex) {
            Logger.getLogger(account_manager_frame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Save To File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Value:");

        jButton2.setText("Calculate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Object[][] table_data = getTableData(jTable1);
        JFrame error_frame = new JFrame();
        Object[][] table_weights = new Object[table_data.length][3];
        float sum = 0;
        boolean close = false;
        outerloop:
        for(int row =0 ; row < table_data.length; ++row){
            for(int column =0; column<table_data[row].length - 1;++column){
                if (table_data[row][1] == "") {
                    JOptionPane.showMessageDialog(error_frame, "Please nominal values for calculation. It can't be NULL.", "Error in Calculation!",JOptionPane.ERROR_MESSAGE);
                    close = true;
                    break outerloop;
                } else {
                    table_weights[row][column] = table_data[row][column];
                }
            }
        }
        
        if (close) {
           super.dispose();
        }
        
        for(int row =0 ; row < table_weights.length; ++row){
            if (table_data[row][1] != ""){
                sum = sum + Float.valueOf((String) table_data[row][1]);
            } else {
                sum = 0;
            }
        }
        
        if (sum != 0) {
            for(int row =0 ; row < table_weights.length; ++row){
                float weights = Float.valueOf((String) table_weights[row][1]) / sum;
                table_weights[row][2] = String.valueOf(weights);
            }
        }
        
        String[] columnNames = new String[3];
        columnNames[0] = "Accounts";
        columnNames[1] = "Nominal Value";
        columnNames[2] = "Weights";
        

        jTable1.setModel(new javax.swing.table.DefaultTableModel(table_weights, columnNames));
        jTextField1.setText(String.valueOf(sum));
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        try {
            writeCSVfile(jTable1);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(allocation_view.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public Object[][] getTableData (JTable table) {
        
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        return tableData;
    
    }
    
    public void writeCSVfile(JTable table) throws IOException, ClassNotFoundException, SQLException{
        Writer writer = null;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount();
        int nCol = dtm.getColumnCount();
        
        String homedirec = System.getProperty("user.home");
        String account_weights_direc = homedirec + "/carbide/accounts/account_weights.csv";
        new File(account_weights_direc).delete();

            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(account_weights_direc), "utf-8"));

            //write the header information
            StringBuffer bufferHeader = new StringBuffer();
            for (int j = 0; j < nCol; j++) {
                bufferHeader.append(dtm.getColumnName(j));
                if (j!=nCol-1) bufferHeader.append(",");
            }
            writer.write(bufferHeader.toString() + "\r\n");

           //write row information
            for (int i = 0 ; i < nRow ; i++){
                 StringBuffer buffer = new StringBuffer();
                for (int j = 0 ; j < nCol ; j++){
                    buffer.append(dtm.getValueAt(i,j));
                    if (j!=nCol-1) buffer.append(",");
                }
                writer.write(buffer.toString() + "\r\n");
            }
            writer.close();

    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
