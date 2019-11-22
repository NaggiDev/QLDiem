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
public class ScoreQuery {

    private DBQuery qr;

    public ScoreQuery() {
        this.qr = new DBQuery();
    }

    public void AddScore(Diem a) throws SQLException {
        String sql = "INSERT INTO dbo.Diem(MaSV,MaMH,HocKy,DiemLan1,DiemLan2) VALUE(?,?,?,?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getMaSV());
            ps.setString(2, a.getMaMH());
            ps.setInt(3, a.getHocKy());
            ps.setInt(4, a.getDiemlan1());
            ps.setInt(5, a.getDiemlan2());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "NHAP DIEM THANH CONG");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NHAP DIEM THAT BAI, DIEM KHONG HOP LE");
            e.printStackTrace();
        }
    }

    public ArrayList<Diem> getScore() throws SQLException {
        ArrayList<Diem> res = new ArrayList();
        String sql = "SELECT * FROM dbo.Diem";
        ResultSet rs = qr.LoadData(sql);
        while (rs.next()) {
            Diem tmp = new Diem();
            tmp.setMaSV(rs.getString(1));
            tmp.setMaMH(rs.getString(2));
            tmp.setHocKy(rs.getInt(3));
            tmp.setDiemlan1(rs.getInt(4));
            tmp.setDiemlan2(rs.getInt(5));
            res.add(tmp);
        }
        return res;
    }

}
