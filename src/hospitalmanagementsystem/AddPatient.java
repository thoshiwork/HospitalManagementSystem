/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagementsystem;

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
public class AddPatient extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddPatient.class.getName());

    private Dashboard mdashboard;
    Dashboard tbl_load = new Dashboard();

    public AddPatient() {
        initComponents();
    }

    public AddPatient(Dashboard dashboard) {
        initComponents();
        this.mdashboard = dashboard;

        //Opens the window in the center of the display
        this.setLocationRelativeTo(null);

        PatientIdGen();

    }
    PreparedStatement pst;
    Connect con = new Connect();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoVariable = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPID = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnAddPatient = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtNIC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

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

        lblPID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(lblPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 190, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, 560, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 53, 71));
        jLabel2.setText("Patient Register Form");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 34));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(42, 53, 71));
        jLabel6.setText("P_ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 40, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(90, 106, 133));
        jLabel8.setText("Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 550, 40));

        txtName.setBackground(new java.awt.Color(241, 245, 249));
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 550, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(90, 106, 133));
        jLabel9.setText("Date of Birth");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 230, 40));

        txtDOB.setBackground(new java.awt.Color(241, 245, 249));
        txtDOB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 230, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(90, 106, 133));
        jLabel10.setText("Address");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 550, 40));

        txtAddress.setBackground(new java.awt.Color(241, 245, 249));
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 550, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(90, 106, 133));
        jLabel12.setText("Contact Number");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 550, 40));

        txtContact.setBackground(new java.awt.Color(241, 245, 249));
        txtContact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 550, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(90, 106, 133));
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 550, 40));

        txtEmail.setBackground(new java.awt.Color(241, 245, 249));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 550, 40));

        btnAddPatient.setBackground(new java.awt.Color(16, 185, 129));
        btnAddPatient.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddPatient.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPatient.setText("Add Patient");
        btnAddPatient.addActionListener(this::btnAddPatientActionPerformed);
        jPanel1.add(btnAddPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 270, 40));

        jButton1.setBackground(new java.awt.Color(107, 114, 128));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear Form");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 270, 40));

        txtNIC.setBackground(new java.awt.Color(241, 245, 249));
        txtNIC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 118, 110)));
        jPanel1.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 230, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(90, 106, 133));
        jLabel11.setText("NIC");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        try {
            String name, nic, contact, email, dob, id = null, address;
            name = txtName.getText();
            address = txtAddress.getText();
            nic = txtNIC.getText();
            dob = txtDOB.getText();
            contact = txtContact.getText();
            email = txtEmail.getText();
            pst = con.getConnection().prepareStatement("INSERT into patient(P_id,Name,NIC,Date_of_Birth,Contact, Email, Address) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, nic);
            pst.setString(4, dob);
            pst.setString(5, contact);
            pst.setString(6, email);
            pst.setString(7, address);

            JOptionPane.showMessageDialog(this, "Patient Added to the System!");
            clear();
            pst.executeUpdate();

            if (mdashboard != null) {
                mdashboard.PatientTableLoad();
            }
            this.dispose();

        } catch (SQLException ex) {
            System.getLogger(AddPatient.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_btnAddPatientActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("flatlaf.useWindowDecorations", "false");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.getLogger(AddPatient.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new AddPatient(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogoVariable;
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPID;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void clear() {
        txtAddress.setText("");
        txtContact.setText("");
        txtDOB.setText("");
        txtName.setText("");
        txtEmail.setText("");

    }

    //generate P_id
    private void PatientIdGen() {
        try {
            pst = con.getConnection().prepareStatement("SELECT MAX(P_id) AS max_id FROM patient");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int L_id = rs.getInt("max_Id");
                int N_id = L_id + 1;
                lblPID.setText(String.valueOf(N_id));
            } else {
                lblPID.setText("1");
            }
        } catch (SQLException ex) {
            System.getLogger(AddPatient.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

}
