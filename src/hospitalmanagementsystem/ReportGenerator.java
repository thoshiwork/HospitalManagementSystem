/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;
import java.sql.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author USER
 */
public class ReportGenerator {
    public void createPatientHistoryPDF(String nic, java.awt.Component parent, Connection c) {
        
        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Please enter a Patient NIC first!");
            return;
        }

        // PDF එක සේව් කරන තැන තෝරන්න දෙනවා
        JFileChooser dialog = new JFileChooser();
        dialog.setDialogTitle("Save Report");
        dialog.setSelectedFile(new File(nic + "_Medical_Report.pdf"));
        int check = dialog.showSaveDialog(parent);
        if (check != JFileChooser.APPROVE_OPTION) {
            return;
        }

        String filePath = dialog.getSelectedFile().getPath();
        if (!filePath.toLowerCase().endsWith(".pdf")) {
            filePath += ".pdf";
        }

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(filePath));
            doc.open();

            // 1. Header එක
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Niroga Hospital Pvt.Ltd", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);

            Paragraph subTitle = new Paragraph("Patient Medical History Report\n\n");
            subTitle.setAlignment(Element.ALIGN_CENTER);
            doc.add(subTitle);
            doc.add(new Paragraph("---------------------------------------------------------------------------------------------------\n"));

            // 2. ලෙඩාගේ විස්තර
            String patSql = "SELECT Name, Date_of_Birth, Contact FROM patient WHERE NIC = ?";
            PreparedStatement patPst = c.prepareStatement(patSql);
            patPst.setString(1, nic);
            ResultSet patRs = patPst.executeQuery();

            String pName = "N/A", pDob = "N/A", pContact = "N/A";

            if (patRs.next()) {
                pName = patRs.getString("Name");
                pDob = patRs.getString("Date_of_Birth");
                pContact = patRs.getString("Contact");
            } else {
                JOptionPane.showMessageDialog(parent, "No patient found for this NIC!");
                doc.close();
                return;
            }

            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            doc.add(new Paragraph("Patient Demographics:", boldFont));
            doc.add(new Paragraph("NIC Number    : " + nic));
            doc.add(new Paragraph("Patient Name : " + pName));
            doc.add(new Paragraph("Date of Birth   : " + pDob));
            doc.add(new Paragraph("Contact No      : " + pContact + "\n\n"));

            // 3. History ටේබල් එක
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            table.addCell(new Phrase("Date", boldFont));
            table.addCell(new Phrase("Doctor Name", boldFont));
            table.addCell(new Phrase("Specialization", boldFont));
            table.addCell(new Phrase("Time", boldFont));

            // 4. History ඩේටා
            String histSql = "SELECT a.App_Date, a.D_Name, d.Specialization, a.App_Time " +
                             "FROM appointment a " +
                             "INNER JOIN doctor d ON a.D_Name = d.D_Name " +
                             "INNER JOIN patient p ON a.P_Name = p.Name " +
                             "WHERE p.NIC = ? AND a.Status = 'Completed' " +
                             "ORDER BY a.App_Date DESC, a.App_Time DESC";

            PreparedStatement histPst = c.prepareStatement(histSql);
            histPst.setString(1, nic);
            ResultSet histRs = histPst.executeQuery();

            boolean hasHistory = false;
            while (histRs.next()) {
                hasHistory = true;
                table.addCell(histRs.getString("App_Date"));
                table.addCell(histRs.getString("D_Name"));
                table.addCell(histRs.getString("Specialization"));
                table.addCell(histRs.getString("App_Time"));
            }

            if (!hasHistory) {
                PdfPCell emptyCell = new PdfPCell(new Phrase("No completed appointments found."));
                emptyCell.setColspan(4);
                emptyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(emptyCell);
            }

            doc.add(table);

            // 5. Footer එක
            doc.add(new Paragraph("\n\n\n---------------------------------"));
            doc.add(new Paragraph("Authorized Signature"));

            Font italicFont = new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC);
            doc.add(new Paragraph("\n* This is a computer-generated report and does not require a physical signature.", italicFont));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            doc.add(new Paragraph("Report Generated On: " + sdf.format(new Date()), italicFont));

            doc.close(); 
            JOptionPane.showMessageDialog(parent, "Report Generated Successfully!");

            // 6. PDF එක ඔටෝ ඕපන් කරනවා
            try {
                Desktop.getDesktop().open(new File(filePath));
            } catch (Exception ex) {
                System.out.println("Could not open PDF.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "Error Generating Report: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
