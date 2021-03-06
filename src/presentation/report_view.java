/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author ren
 */
public class report_view extends javax.swing.JFrame {

    /**
     * Creates new form report_view
     */
    public report_view() throws IOException {
        initComponents();
        load_account_names();
        load_combined_aggregated_table();
        
    }
    
    public void load_combined_aggregated_table() throws IOException{
        
        String homedirec = System.getProperty("user.home");
        String combined_aggregated_reports = homedirec + "/carbide/Combined_Data_Entry/all_aggregated_accounts";
           
        BufferedReader br = null;
        
        String[] columnNames = new String[0];
        Object[][] data = new Object[0][0];
        String line = "";
        String splitSign = ",";
        
        File folder = new File(combined_aggregated_reports);
        File[] listOfFiles = folder.listFiles();
        String file = null;
        String filename = null;
        
        for (int i = 0; i < listOfFiles.length; i++){
            
            if (listOfFiles[i].getName().contains(".csv")) {
                file = listOfFiles[i].getPath();
                filename = listOfFiles[i].getName();
                break;
            }
        }
                  
        int i = 0;
        br = new BufferedReader(new FileReader(file));
                    
        while (br.readLine() != null) {
            i++;
        }
        br.close();
        data = new Object[i - 1][];
        i = 0;
        br = new BufferedReader(new FileReader(file));
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
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jTable1.setRowSorter(sorter);
        
    };
    
    public void load_norm_hedg_aggregated_table(String dir) throws IOException{
                  
        BufferedReader br = null;
        
        String[] columnNames = new String[0];
        Object[][] data = new Object[0][0];
        String line = "";
        String splitSign = ",";
        
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        String file = null;
        String filename = null;
        
        for (int i = 0; i < listOfFiles.length; i++){
            
            if (listOfFiles[i].getName().contains(".csv")) {
                file = listOfFiles[i].getPath();
                filename = listOfFiles[i].getName();
                break;
            }
        }
                  
        int i = 0;
        br = new BufferedReader(new FileReader(file));
                    
        while (br.readLine() != null) {
            i++;
        }
        br.close();
        data = new Object[i - 1][];
        i = 0;
        br = new BufferedReader(new FileReader(file));
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
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jTable1.setRowSorter(sorter);
        
    };

    public void load_account_names(){
        
        try {
            String homedirec = System.getProperty("user.home");
            String account_name_direc = homedirec + "/carbide/accounts/accounts_hedge.csv";
            String account_name_direc2 = homedirec + "/carbide/accounts/accounts.csv";
            String account_name_direc3 = homedirec + "/carbide/accounts/accounts_macro.csv";

            BufferedReader br_acc = null;

            Object[][] data_acc = new Object[0][0];
            Object[][] data_acc2 = new Object[0][0];
            Object[][] data_acc3 = new Object[0][0];
            String line = "";
            String splitSign = ",";

            int p = 0;
            br_acc = new BufferedReader(new FileReader(account_name_direc));

            while (br_acc.readLine() != null) {
                p++;
            }
            br_acc.close();
            data_acc = new Object[p - 1][];
            
            p = 0;
            br_acc = new BufferedReader(new FileReader(account_name_direc2));

            while (br_acc.readLine() != null) {
                p++;
            }
            br_acc.close();
            data_acc2 = new Object[p - 1][];
            
            p = 0;
            br_acc = new BufferedReader(new FileReader(account_name_direc3));

            while (br_acc.readLine() != null) {
                p++;
            }
            br_acc.close();
            data_acc3 = new Object[p - 1][];
            
            p = 0;
            br_acc = new BufferedReader(new FileReader(account_name_direc));
            line = br_acc.readLine();

            line = br_acc.readLine();
            while (line != null) {
                data_acc[p] = new Object[line.split(splitSign).length];
                 for (int j = 0; j < data_acc[p].length; j++) {
                    data_acc[p][j] = line.split(splitSign)[j];
                }
                p++;
                line = br_acc.readLine();
            }
            
            
            p = 0;
            br_acc = new BufferedReader(new FileReader(account_name_direc2));
            line = br_acc.readLine();

            line = br_acc.readLine();
            while (line != null) {
                data_acc2[p] = new Object[line.split(splitSign).length];
                 for (int j = 0; j < data_acc2[p].length; j++) {
                    data_acc2[p][j] = line.split(splitSign)[j];
                }
                p++;
                line = br_acc.readLine();
            }
            
            p = 0;
            br_acc = new BufferedReader(new FileReader(account_name_direc3));
            line = br_acc.readLine();

            line = br_acc.readLine();
            while (line != null) {
                data_acc3[p] = new Object[line.split(splitSign).length];
                 for (int j = 0; j < data_acc3[p].length; j++) {
                    data_acc3[p][j] = line.split(splitSign)[j];
                }
                p++;
                line = br_acc.readLine();
            }
            
            
            ArrayList<String> account_names = new ArrayList<String>();
            
            for (int m = 0; m < data_acc3.length; m++){
                String account_info = (String) data_acc3[m][0];
                account_info = account_info + "-" + (String) data_acc3[m][1];
                account_names.add(account_info);
            }

            for (int m = 0; m < data_acc2.length; m++){
                String account_info = (String) data_acc2[m][0];
                account_info = account_info + "-" + (String) data_acc2[m][1];
                account_names.add(account_info);
            }
            
            for (int m = 0; m < data_acc.length; m++){
                String account_info = (String) data_acc[m][0];
                account_info = account_info + "-" + (String) data_acc[m][1];
                account_names.add(account_info);
            }
            
            Set<String> set = new HashSet<>(account_names);
            account_names.clear();
            account_names.addAll(set);
            Collections.sort(account_names);
            
            account_names.add(0, "ALL_macro");   
            account_names.add(0, "ALL_hedged");             
            account_names.add(0, "ALL_normal");             
            account_names.add(0, "ALL");             

            String[] accountarr = new String[account_names.size()];
            accountarr = account_names.toArray(accountarr);
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(accountarr));
            
        } catch (IOException ex) {
            Logger.getLogger(data_entry.class.getName()).log(Level.SEVERE, null, ex);
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
        jComboBox1 = new javax.swing.JComboBox<>();
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
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jComboBox1.setSelectedIndex(0);        
            load_combined_aggregated_table();
        } catch (IOException ex) {
            Logger.getLogger(report_view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String account_to_view = String.valueOf(jComboBox1.getSelectedItem());
        String homedirec = System.getProperty("user.home");
        String hedged_aggregated_reports = homedirec + "/carbide/Combined_Data_Entry/all_aggregated_accounts/hedged_aggregated_accounts";
        String normal_aggregated_reports = homedirec + "/carbide/Combined_Data_Entry/all_aggregated_accounts/normal_aggregated_accounts";
        String macro_aggregated_reports = homedirec + "/carbide/Combined_Data_Entry/all_aggregated_accounts/macro_aggregated_accounts";

        if (account_to_view.equals("ALL")) {
            try {
                load_combined_aggregated_table();
            } catch (IOException ex) {
                Logger.getLogger(report_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(account_to_view.equals("ALL_hedged")) {
            try {
                load_norm_hedg_aggregated_table(hedged_aggregated_reports);
            } catch (IOException ex) {
                Logger.getLogger(report_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(account_to_view.equals("ALL_normal")) {
            try {
                load_norm_hedg_aggregated_table(normal_aggregated_reports);
            } catch (IOException ex) {
                Logger.getLogger(report_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(account_to_view.equals("ALL_macro")) {
            try {
                load_norm_hedg_aggregated_table(macro_aggregated_reports);
            } catch (IOException ex) {
                Logger.getLogger(report_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                load_separate_aggregation(account_to_view);
            } catch (IOException ex) {
                Logger.getLogger(report_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public void load_separate_aggregation(String account_name) throws IOException{
        String homedirec = System.getProperty("user.home");
        String combined_aggregated_reports = homedirec + "/carbide/Combined_Data_Entry/separate_aggregated_accounts";
        
        File files = new File(combined_aggregated_reports); 
        String[] fileList = files.list(); 
        
        boolean existed = false;
        String file_to_open = null;
        
        for(String name:fileList){
            if (name.contains(account_name)){
                file_to_open = combined_aggregated_reports + "/" + name;
                existed = true;
            }
        }
        
        if (existed) {
            BufferedReader br = null;
        
            String[] columnNames = new String[0];
            Object[][] data = new Object[0][0];
            String line = "";
            String splitSign = ",";

            int i = 0;
            br = new BufferedReader(new FileReader(file_to_open));

            while (br.readLine() != null) {
                i++;
            }
            br.close();
            data = new Object[i - 1][];
            i = 0;
            br = new BufferedReader(new FileReader(file_to_open));
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

            jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
            jTable1.setRowSorter(sorter);
        } else {
            JFrame error_frame = new JFrame();
            JOptionPane.showMessageDialog(error_frame, "Account entries don't exist.", "Error in Account!",JOptionPane.ERROR_MESSAGE);
        }

        
    };
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
