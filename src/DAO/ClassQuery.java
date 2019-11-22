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
public class ClassQuery {
    
    private DBQuery qr;

    public ClassQuery() {
        this.qr = new DBQuery();
    }

    public void AddClass(Lop a) throws SQLException {
        String sql = "INSERT INTO dbo.Lop(MaLop,TenLop,MaKhoa,MaHeDT,MaKhoaHoc) VALUE(?,?,?,?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getMaLop());
            ps.setString(2, a.getTenLop());
            ps.setString(3, a.getMaKhoa());
            ps.setString(4, a.getMaHeDaoTao());
            ps.setString(5, a.getMaKhoaHoc());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "NHAP LOP THANH CONG");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NHAP LOP THAT BAI, LOP KHONG HOP LE");
            e.printStackTrace();
        }
    }

    public ArrayList<Lop> getClasses() throws SQLException {
        ArrayList<Lop> res = new ArrayList();
        String sql = "SELECT * FROM dbo.Lop";
        ResultSet rs = qr.LoadData(sql);
        while (rs.next()) {
            Lop tmp = new Lop();
            tmp.setMaLop(rs.getString(1));
            tmp.setTenLop(rs.getString(2));
            tmp.setMaKhoa(rs.getString(3));
            tmp.setMaHeDaoTao(rs.getString(4));
            tmp.setMaKhoaHoc(rs.getString(5));
            res.add(tmp);
        }
        return res;
    }
}
