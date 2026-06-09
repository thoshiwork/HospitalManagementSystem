/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

import java.sql.*;
import java.sql.Connection;
/**
 *
 * 
 * @author USER
 */
public class Connect {
    Connection conn;
    Double salary;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nirogahospital_db", "root", "");
            System.out.println("Successfully Connected!");
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            System.getLogger(Connect.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }
}
