/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entity.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author Lemony
 */
public class StudentQuery {
    
    private DBQuery qr;
    
    public StudentQuery(){
        this.qr = new DBQuery();
    }
    
    public void AddStudent(String usr, String pwd, SinhVien a){
        String sql = "INSERT INTO SinhVien(MaSV,GioiTinh,NgaySinh,QueQuan,MaLop";
    }
}
