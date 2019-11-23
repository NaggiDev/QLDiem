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

    public StudentQuery() {
        this.qr = new DBQuery();
    }
    
    /**
     *
     * @param a
     * @throws SQLException
     */
    public void AddStudent(SinhVien a) throws SQLException {
        String sql = "INSERT INTO dbo.SinhVien(MaSV, TenSV, GioiTinh, NgaySinh, QueQuan, MaLop) VALUE(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getMaSv());
            ps.setString(2, a.getTenSv());
            ps.setBoolean(3, a.getGioitinh());
            ps.setDate(4, new Date(a.getDob().getTime()));
            ps.setString(5, a.getQuequan());
            ps.setString(6, a.getMaLop());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "THEM SINH VIEN THANH CONG");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "THEM THAT BAI");
            e.printStackTrace();
        }
    }

    public ArrayList<SinhVien> getSinhVien() throws SQLException {
        ArrayList<SinhVien> res = new ArrayList();
        String sql = "SELECT * FROM dbo.SinhVien";
        ResultSet rs = qr.LoadData(sql);
        while (rs.next()) {
            SinhVien tmp = new SinhVien();
            tmp.setMaSv(rs.getString(1));
            tmp.setTenSv(rs.getString(2));
            tmp.setGioitinh(rs.getBoolean(3));
            tmp.setDob(rs.getDate(4));
            tmp.setQuequan(rs.getString(5));
            tmp.setMaLop(rs.getString(6));
            res.add(tmp);
        }
        return res;
    }
}
