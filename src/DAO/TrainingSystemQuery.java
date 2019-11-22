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
public class TrainingSystemQuery {

    private DBQuery qr;

    public TrainingSystemQuery() {
        this.qr = new DBQuery();
    }

    public void AddTS(HeDaoTao a) throws SQLException {
        String sql = "INSERT INTO dbo.HeDT (MaHeDT, TenHeDT) VALUE(?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getMaHe());
            ps.setString(2, a.getTenHe());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "THEM THANH CONG");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "THEM THAT BAI, HE DAO TAO KHONG HOP LE");
            e.printStackTrace();
        }
    }

    public ArrayList<HeDaoTao> getTS() throws SQLException {
        ArrayList<HeDaoTao> res = new ArrayList();
        String sql = "SELECT * FROM dbo.HeDT";
        ResultSet rs = qr.LoadData(sql);
        while (rs.next()) {
            HeDaoTao tmp = new HeDaoTao();
            tmp.setMaHe(rs.getString(1));
            tmp.setTenHe(rs.getString(2));
            res.add(tmp);
        }
        return res;
    }
}
