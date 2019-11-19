/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;
/**
 *
 * @author Lemony
 */
public class DBConnector {
    
    private Connection conn;
    
    public DBConnector() throws SQLException{
     conn = connectToDB();
    }
    
    public DBConnector(Connection conn){
        this.conn = conn;
    }
    public Connection connectToDB() throws SQLException{
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/songs?useSSL=false";
        String username = "root";
        String password = "1234";
        try {            
            conn = DriverManager.getConnection(url, username, password);
        } catch ( SQLException  e) {
            
        }
        return conn;
    }
    
    public ResultSet query(String sql) throws SQLException {  // chi nhan ve ket qua           
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);        
        return resultSet;
    }
    
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    
    public Connection getConnection() {
        return conn;
    }
}
