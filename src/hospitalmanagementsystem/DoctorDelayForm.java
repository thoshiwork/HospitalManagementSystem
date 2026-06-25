/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagementsystem;

import java.sql.*;
import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.cj.protocol.Resultset;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author USER
 */
public class DoctorDelayForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DoctorDelayForm.class.getName());

    private Dashboard mdashboard;
    Dashboard tbl_load = new Dashboard();

    public DoctorDelayForm() {
        initComponents();
        loadSpecializations();
    }

    public DoctorDelayForm(DashboardUser parent) {
        initComponents();
        loadSpecializations();
    }

    public DoctorDelayForm(Dashboard dashboard) {
        initComponents();
        this.mdashboard = dashboard;
        loadSpecializations();
        this.setLocationRelativeTo(null);
    }
    PreparedStatement pst;
    Connect con = new Connect();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoVariable = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtD_ID = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cmbDate = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDelayTime = new javax.swing.JTextField();
        btnAddDelay = new javax.swing.JButton();
        cmbDoctorName = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        cmbSpecialization = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 680));
        setResizable(false);

        LogoVariable.setBackground(new java.awt.Color(15, 118, 110));

        jLabel1.setBackground(new java.awt.Color(15, 118, 110));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospitalmanagementsystem/NirogaHospitals Img.png"))); // NOI18N

        javax.swing.GroupLayout LogoVariableLayout = new javax.swing.GroupLayout(LogoVariable);
        LogoVariable.setLayout(LogoVariableLayout);
        LogoVariableLayout.setHorizontalGroup(
            LogoVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoVariableLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        LogoVariableLayout.setVerticalGroup(
            LogoVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoVariableLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(LogoVariable, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(241, 245, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtD_ID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtD_ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtD_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtD_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 190, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, 560, 10));

        cmbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDate.addActionListener(this::cmbDateActionPerformed);
        jPanel1.add(cmbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 550, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 53, 71));
        jLabel2.setText("Doctor Delay Form");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 34));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(42, 53, 71));
        jLabel6.setText("D_ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 40, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(90, 106, 133));
        jLabel8.setText("Specialization");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 540, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(90, 106, 133));
        jLabel10.setText("Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 550, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(90, 106, 133));
        jLabel12.setText("Date");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 550, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(90, 106, 133));
        jLabel7.setText("Delay Time");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 100, 40));

        txtDelayTime.setBackground(new java.awt.Color(241, 245, 249));
        txtDelayTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtDelayTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 270, 40));

        btnAddDelay.setBackground(new java.awt.Color(16, 185, 129));
        btnAddDelay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddDelay.setForeground(new java.awt.Color(255, 255, 255));
        btnAddDelay.setText("Delay");
        btnAddDelay.addActionListener(this::btnAddDelayActionPerformed);
        jPanel1.add(btnAddDelay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 550, 40));

        cmbDoctorName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDoctorName.addActionListener(this::cmbDoctorNameActionPerformed);
        jPanel1.add(cmbDoctorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 550, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(90, 106, 133));
        jLabel9.setText("Time");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 40));

        txtTime.setBackground(new java.awt.Color(241, 245, 249));
        txtTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 270, 40));

        cmbSpecialization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSpecialization.addActionListener(this::cmbSpecializationActionPerformed);
        jPanel1.add(cmbSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 550, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDelayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDelayActionPerformed
        try {
            String id = txtD_ID.getText().trim();
            String spec = cmbSpecialization.getSelectedItem().toString();
            String name = cmbDoctorName.getSelectedItem().toString();
            String date = cmbDate.getSelectedItem().toString();
            String time = txtTime.getText().trim();
            String delayTime = txtDelayTime.getText().trim(); //take as a string

            if (spec.equals("Select Specialization") || name.equals("Select Doctor") || date.equals("Select Date") || delayTime.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Please fill all the fields!");
                return;
            }

            String sql = "INSERT INTO doctor_delay (D_Id, Specialization, D_Name, Date, Time, Delay) VALUES (?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement pst = con.getConnection().prepareStatement(sql);

            pst.setString(1, id);
            pst.setString(2, spec);
            pst.setString(3, name);
            pst.setString(4, date);
            pst.setString(5, time);
            pst.setString(6, delayTime);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Doctor Delay Added Successfully!");
                tbl_load.loadDelayTable();
                txtDelayTime.setText("");
                cmbSpecialization.setSelectedIndex(0);
            }

        } catch (Exception e) {
            System.out.println("Insert Error: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_btnAddDelayActionPerformed

    private void cmbDoctorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDoctorNameActionPerformed
        try {
            if (cmbDoctorName.getSelectedItem() == null || cmbDoctorName.getSelectedItem().equals("Select Doctor")) {
                return;
            }

            String dName = cmbDoctorName.getSelectedItem().toString();
            String docId = "";

            String sqlId = "SELECT D_Id FROM doctor WHERE D_Name = ?";
            pst = con.getConnection().prepareStatement(sqlId);
            pst.setString(1, dName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                docId = rs.getString("D_Id");
                txtD_ID.setText(docId);
            }

            cmbDate.removeAllItems();
            cmbDate.addItem("Select Date");

            String sqlDate = "SELECT Arrival_Date FROM doctor_availability WHERE Doc_ID = ?";
            java.sql.PreparedStatement pstDate = con.getConnection().prepareStatement(sqlDate);
            pstDate.setString(1, docId);
            java.sql.ResultSet rsDate = pstDate.executeQuery();

            while (rsDate.next()) {
                cmbDate.addItem(rsDate.getString("Arrival_Date"));
            }
        } catch (Exception e) {
            System.out.println("Error loading dates: " + e.getMessage());
        }
    }//GEN-LAST:event_cmbDoctorNameActionPerformed

    private void cmbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDateActionPerformed
        try {
            if (cmbDate.getSelectedItem() == null || cmbDate.getSelectedItem().equals("Select Date")) {
                return;
            }

            String selectedDate = cmbDate.getSelectedItem().toString();
            String docId = txtD_ID.getText().trim();

            String sql = "SELECT Arrival_Time FROM doctor_availability WHERE Doc_ID = ? AND Arrival_Date = ?";
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, docId);
            pst.setString(2, selectedDate);

            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtTime.setText(rs.getString("Arrival_Time"));
            }
        } catch (Exception e) {
            System.out.println("Error loading time: " + e.getMessage());
        }
    }//GEN-LAST:event_cmbDateActionPerformed

    private void cmbSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSpecializationActionPerformed
        try {
            if (cmbSpecialization.getSelectedItem() == null || cmbSpecialization.getSelectedItem().equals("Select Specialization")) {
                return;
            }

            String spec = cmbSpecialization.getSelectedItem().toString();
            cmbDoctorName.removeAllItems();
            cmbDoctorName.addItem("Select Doctor");

            String sql = "SELECT D_Name FROM doctor WHERE Specialization = ?";
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, spec);
            java.sql.ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmbDoctorName.addItem(rs.getString("D_Name"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_cmbSpecializationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("flatlaf.useWindowDecorations", "false");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.getLogger(DoctorDelayForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new DoctorDelayForm((Dashboard) null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogoVariable;
    private javax.swing.JButton btnAddDelay;
    private javax.swing.JComboBox<String> cmbDate;
    private javax.swing.JComboBox<String> cmbDoctorName;
    private javax.swing.JComboBox<String> cmbSpecialization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtD_ID;
    private javax.swing.JTextField txtDelayTime;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables

    private void loadSpecializations() {
        try {
            cmbSpecialization.removeAllItems();
            cmbDoctorName.removeAllItems();
            cmbDate.removeAllItems();
            cmbSpecialization.addItem("Select Specialization");
            cmbDate.addItem("Select Date");
            cmbDoctorName.addItem("Select Doctor Name");

            String sql = "SELECT DISTINCT Specialization FROM doctor";
            pst = con.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmbSpecialization.addItem(rs.getString("Specialization"));
            }
        } catch (Exception e) {
            System.out.println("Error loading specs: " + e.getMessage());
        }
    }

}
