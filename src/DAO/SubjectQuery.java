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
public class SubjectQuery {

    private DBQuery qr;

    public SubjectQuery() {
        this.qr = new DBQuery();
    }

    public void AddSubject(MonHoc a) throws SQLException {
        String sql = "INSERT INTO dbo.MonHoc (MaMH,TenMH,SoTinChi) VALUE(?,?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getMamonhoc());
            ps.setString(2, a.getTenmon());
            ps.setInt(3, a.getSotin());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "THEM MON HOC THANH CONG");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "THEM THAT BAI, MON HOC KHONG HOP ");
            e.printStackTrace();
        }
    }

    public ArrayList<MonHoc> getSubject() throws SQLException {
        ArrayList<MonHoc> res = new ArrayList();
        String sql = "SELECT * FROM dbo.MonHoc";
        ResultSet rs = qr.LoadData(sql);
        while (rs.next()) {
            MonHoc tmp = new MonHoc();
            tmp.setMamonhoc(rs.getString(1));
            tmp.setTenmon(rs.getString(2));
            tmp.setSotin(rs.getInt(3));
            res.add(tmp);
        }
        return res;
    }
}
