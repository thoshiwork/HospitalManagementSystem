/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagementsystem;

import com.formdev.flatlaf.FlatLightLaf;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author USER
 */
public class AddDoctor extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddDoctor.class.getName());

    Dashboard tbl_load = new Dashboard();

    public AddDoctor() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Loading Specializations
        cmbSpecialization.removeAllItems();
        cmbSpecialization.addItem("Select Specialization");
        cmbSpecialization.addItem("Cardiologist");
        cmbSpecialization.addItem("Dermatologist");
        cmbSpecialization.addItem("ENT Specialist");
        cmbSpecialization.addItem("Eye Surgeon");
        cmbSpecialization.addItem("Gynecologist");
        cmbSpecialization.addItem("Neurologist");
        cmbSpecialization.addItem("OPD Doctor");
        cmbSpecialization.addItem("Pediatrician");
        cmbSpecialization.addItem("Psychiatrist");
        cmbSpecialization.addItem("Surgeon");
        generateD_ID();

    }
    PreparedStatement pst;
    ResultSet rs;
    Connect con = new Connect();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoVariable = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtD_ID = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAddPatient = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbSpecialization = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtDate4 = new com.toedter.calendar.JDateChooser();
        txtDate1 = new com.toedter.calendar.JDateChooser();
        txtDate2 = new com.toedter.calendar.JDateChooser();
        txtDate3 = new com.toedter.calendar.JDateChooser();
        txtTime4 = new lu.tudor.santec.jtimechooser.JTimeChooser();
        txtTime1 = new lu.tudor.santec.jtimechooser.JTimeChooser();
        txtTime2 = new lu.tudor.santec.jtimechooser.JTimeChooser();
        txtTime3 = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFee = new javax.swing.JTextField();
        txtRoomNo = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNIC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jPanel1.add(txtD_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 190, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, 560, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 53, 71));
        jLabel2.setText("Doctor Add Form");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 34));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(42, 53, 71));
        jLabel6.setText("D_ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 40, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(90, 106, 133));
        jLabel8.setText("Specialization");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 550, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(90, 106, 133));
        jLabel12.setText("Arrival Dates");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 120, 40));

        btnAddPatient.setBackground(new java.awt.Color(16, 185, 129));
        btnAddPatient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddPatient.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPatient.setText("Add Doctor");
        btnAddPatient.addActionListener(this::btnAddPatientActionPerformed);
        jPanel1.add(btnAddPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 550, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(90, 106, 133));
        jLabel11.setText("Room No");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 230, 40));

        cmbSpecialization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSpecialization.addActionListener(this::cmbSpecializationActionPerformed);
        jPanel1.add(cmbSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 550, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(90, 106, 133));
        jLabel9.setText("Fee");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 100, 40));
        jPanel1.add(txtDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 110, 40));
        jPanel1.add(txtDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, 40));
        jPanel1.add(txtDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 110, 40));
        jPanel1.add(txtDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 110, 40));
        jPanel1.add(txtTime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 110, 40));
        jPanel1.add(txtTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 110, 40));
        jPanel1.add(txtTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 110, 40));
        jPanel1.add(txtTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 110, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(90, 106, 133));
        jLabel13.setText("Time");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(90, 106, 133));
        jLabel14.setText("Contact");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 130, 40));
        jPanel1.add(txtFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 160, 40));
        jPanel1.add(txtRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 230, 40));
        jPanel1.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 160, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(90, 106, 133));
        jLabel15.setText("Name");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 40));
        jPanel1.add(txtDName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 300, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(90, 106, 133));
        jLabel10.setText("NIC");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 160, 40));
        jPanel1.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 160, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed

        java.sql.Connection myCon = null;

        try {

            myCon = con.getConnection();

            String docIdStr = txtD_ID.getText().trim();
            if (docIdStr.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Please generate the Doctor ID!");
                return;
            }
            int docId = Integer.parseInt(docIdStr);

            String insertDoc = "INSERT INTO doctor (D_Id, D_Name, Specialization, D_Nic, Contact, Room_No, Doc_Fee) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = myCon.prepareStatement(insertDoc);

            pst.setInt(1, docId);
            pst.setString(2, txtDName.getText().trim());
            pst.setString(3, cmbSpecialization.getSelectedItem().toString());
            pst.setString(4, txtNIC.getText().trim());
            pst.setString(5, txtContact.getText().trim());
            pst.setString(6, txtRoomNo.getText().trim());
            pst.setString(7, txtFee.getText().trim());

            pst.executeUpdate();

            String insAvail = "INSERT INTO doctor_availability (Doc_ID, Arrival_Date, Arrival_Time) VALUES (?, ?, ?)";
            pst = myCon.prepareStatement(insAvail);

            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String[] dates = {sdf.format(txtDate1.getDate()), sdf.format(txtDate2.getDate()), sdf.format(txtDate3.getDate()), sdf.format(txtDate4.getDate())};
            String[] times = {txtTime1.getFormatedTime(), txtTime2.getFormatedTime(), txtTime3.getFormatedTime(), txtTime4.getFormatedTime()};

            for (int i = 0; i < 4; i++) {
                if (!dates[i].isEmpty() && !times[i].isEmpty()) {
                    pst.setInt(1, docId);
                    pst.setString(2, dates[i]);
                    pst.setString(3, times[i]);

                    pst.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(this, "Doctor Added Successfully!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (myCon != null) {
                    myCon.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing: " + e);
            }
        }
        tbl_load.DoctorTableLoad();
        this.dispose();
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void cmbSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSpecializationActionPerformed

    }//GEN-LAST:event_cmbSpecializationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("flatlaf.useWindowDecorations", "false");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.getLogger(AddDoctor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new AddDoctor().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogoVariable;
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JComboBox<String> cmbSpecialization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtDName;
    private javax.swing.JLabel txtD_ID;
    private com.toedter.calendar.JDateChooser txtDate1;
    private com.toedter.calendar.JDateChooser txtDate2;
    private com.toedter.calendar.JDateChooser txtDate3;
    private com.toedter.calendar.JDateChooser txtDate4;
    private javax.swing.JTextField txtFee;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtRoomNo;
    private lu.tudor.santec.jtimechooser.JTimeChooser txtTime1;
    private lu.tudor.santec.jtimechooser.JTimeChooser txtTime2;
    private lu.tudor.santec.jtimechooser.JTimeChooser txtTime3;
    private lu.tudor.santec.jtimechooser.JTimeChooser txtTime4;
    // End of variables declaration//GEN-END:variables

    private void generateD_ID() {
        Statement st;
        try {

            st = con.getConnection().createStatement();

            // getting the max D_ID
            rs = st.executeQuery("SELECT MAX(D_Id) FROM doctor");

            if (rs.next()) {
                int maxId = rs.getInt(1);
                int newId = maxId + 1;
                txtD_ID.setText(String.valueOf(newId));
            } else {
                txtD_ID.setText("1");
            }
        } catch (Exception e) {
            System.out.println("Auto ID Error: " + e.getMessage());
        } finally {
            // Connection is closing
            try {
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.getConnection().close();
                }
            } catch (Exception e) {
                System.out.println("Error in Connection Closing" + e);
            }
        }
    }

}
