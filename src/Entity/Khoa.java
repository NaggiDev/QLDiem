/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Lemony
 */
public class Khoa {

    private String maKhoa, tenKhoa, diaChi,DienThoai;

    public Khoa(String maKhoa, String tenKhoa, String diaChi, String DienThoai) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.diaChi = diaChi;
        this.DienThoai = DienThoai;
    }

    public Khoa() {
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }
       
    public Object[] toObject() {
        return new Object[]{this.maKhoa, this.tenKhoa, this.diaChi,this.DienThoai};
    }
}
