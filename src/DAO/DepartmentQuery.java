package DAO;

import Entity.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Lemony
 */
public class DepartmentQuery {

    private DBQuery qr;

    public DepartmentQuery() {
        this.qr = new DBQuery();
    }

    public void AddDepartment(Khoa a) throws SQLException {
        String sql = "INSERT INTO dbo.Khoa(MaKhoa,TenKhoa,DiaChi,DienThoai) VALUE(?,?,?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getMaKhoa());
            ps.setString(2, a.getTenKhoa());
            ps.setString(3, a.getDiaChi());
            ps.setString(4, a.getDienThoai());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "NHAP THANH CONG");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NHAP THAT BAI, KHOA KHONG HOP LE");
            e.printStackTrace();
        }
    }

    public ArrayList<Khoa> getDepartment() throws SQLException {
        ArrayList<Khoa> res = new ArrayList();
        String sql = "SELECT * FROM dbo.Khoa";
        ResultSet rs = qr.LoadData(sql);
        while (rs.next()) {
            Khoa tmp = new Khoa();
            tmp.setMaKhoa(rs.getString(1));
            tmp.setTenKhoa(rs.getString(2));
            tmp.setDiaChi(rs.getString(3));
            tmp.setDienThoai(rs.getString(4));
            res.add(tmp);
        }
        return res;
    }

}