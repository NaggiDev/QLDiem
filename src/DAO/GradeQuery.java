/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lemony
 */
public class GradeQuery {

    private DBQuery qr;

    public GradeQuery() {
        this.qr = new DBQuery();
    }

    public void AddGrade(KhoaHoc a) throws SQLException {
        String sql = "INSERT INTO dbo.HeDT (maKhoaHocDT, TenHeDT) VALUE(?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getMaKhoaHoc());
            ps.setString(2, a.getTenKhoaHoc());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "THEM THANH CONG");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "THEM THAT BAI, HE DAO TAO KHONG HOP LE");
            e.printStackTrace();
        }
    }

    public ArrayList<KhoaHoc> getGrade() throws SQLException {
        ArrayList<KhoaHoc> res = new ArrayList();
        String sql = "SELECT * FROM dbo.KhoaHoc";
        ResultSet rs = qr.LoadData(sql);
        while (rs.next()) {
            KhoaHoc tmp = new KhoaHoc();
            tmp.setMaKhoaHoc(rs.getString(1));
            tmp.setTenKhoaHoc(rs.getString(2));
            res.add(tmp);
        }
        return res;
    }
}
