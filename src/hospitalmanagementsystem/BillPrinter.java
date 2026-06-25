/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class BillPrinter implements Printable{
    
    private String nic, pName, spec, dName, date, time, token, fee;

    
    public void printReceipt(String nic, String pName, String spec, String dName, String date, String time, String token, String fee) {
        this.nic = nic;
        this.pName = pName;
        this.spec = spec;
        this.dName = dName;
        this.date = date;
        this.time = time;
        this.token = token;
        this.fee = fee;

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(this);

        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, "Printing Failed: " + ex.getMessage());
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        int y = 20; 
        int yShift = 15; 

        // Setting the Topic
        g2d.setFont(new Font("Monospaced", Font.BOLD, 14));
        g2d.drawString("   NIROGA HOSPITAL  ", 10, y); y += yShift;
        
        // Setting Hospital details
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g2d.drawString("      Ambalangoda, Sri Lanka     ", 10, y); y += yShift;
        g2d.drawString("        Tel: 011-2345678      ", 10, y); y += yShift;
        g2d.drawString("------------------------------", 10, y); y += yShift;
        g2d.drawString("     APPOINTMENT RECEIPT      ", 10, y); y += yShift;
        g2d.drawString("------------------------------", 10, y); y += yShift;
        
               
        g2d.setFont(new Font("Monospaced", Font.BOLD, 12));
        g2d.drawString(" Token No : " + token, 10, y); y += yShift;
        
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g2d.drawString(" NIC      : " + nic, 10, y); y += yShift;
        g2d.drawString(" Patient  : " + pName, 10, y); y += yShift;
        g2d.drawString(" Spec.    : " + spec, 10, y); y += yShift;
        g2d.drawString(" Doctor   : " + dName, 10, y); y += yShift;
        g2d.drawString(" Date     : " + date, 10, y); y += yShift;
        g2d.drawString(" Time     : " + time, 10, y); y += yShift;
        g2d.drawString("------------------------------", 10, y); y += yShift;
        
        
        g2d.setFont(new Font("Monospaced", Font.BOLD, 12));
        g2d.drawString(" Total Fee: Rs." + fee, 10, y); y += yShift;
        
        
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));
        g2d.drawString("------------------------------", 10, y); y += yShift;
        g2d.drawString("  Thank You! Get Well Soon!   ", 10, y); y += yShift;
        g2d.drawString("------------------------------", 10, y); y += yShift;

        return PAGE_EXISTS;
    }
}
