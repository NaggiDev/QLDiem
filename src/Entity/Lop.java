/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author Lemony
 */
public class Lop implements Serializable{
    private String maKhoa,maLop,maHeDaoTao,MaKhoaHoc,tenLop;

    public Lop(String maKhoa, String maLop, String maHeDaoTao, String MaKhoaHoc, String tenLop) {
        this.maKhoa = maKhoa;
        this.maLop = maLop;
        this.maHeDaoTao = maHeDaoTao;
        this.MaKhoaHoc = MaKhoaHoc;
        this.tenLop = tenLop;
    }

    public Lop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaHeDaoTao() {
        return maHeDaoTao;
    }

    public void setMaHeDaoTao(String maHeDaoTao) {
        this.maHeDaoTao = maHeDaoTao;
    }

    public String getMaKhoaHoc() {
        return MaKhoaHoc;
    }

    public void setMaKhoaHoc(String MaKhoaHoc) {
        this.MaKhoaHoc = MaKhoaHoc;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Object[] toObject(){
        return new Object[]{this.maLop,this.tenLop,this.maKhoa,this.maHeDaoTao,this.MaKhoaHoc};
    }
}
