/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lemony
 */
public class DBQuery {
    public Connection conn = null; 
    
    public void getConnection() throws SQLException{ 
        try { 
          String userName ="sa"; 
          String password = "123456789"; 
          String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDiemSV;"; 
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
          conn = java.sql.DriverManager.getConnection(url,userName,password); 
        }  
        catch (ClassNotFoundException e) { 
            JOptionPane.showMessageDialog(null,"Ket noi CSDL that bai","Thong bao",1); 
        }          
    }      

    public ResultSet LoadData(String sql){ 
        ResultSet result = null; 
        try { 
            Statement statement = conn.createStatement(); 
            return statement.executeQuery(sql); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
             return null ; 
        } 
    }      

    public void UpdateData(String sql){         
        try { 
            Statement statement = conn.createStatement(); 
            statement.executeUpdate(sql); 
        }  
        catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    }    
}
