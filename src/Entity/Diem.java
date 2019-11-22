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
public class Diem {
    private String MaSV,MaMH;
    private int diemlan1,diemlan2,HocKy;

    public Diem() {
    }

    public Diem(String MaSV, String MaMH, int diemlan1, int diemlan2, int HocKy) {
        this.MaSV = MaSV;
        this.MaMH = MaMH;
        this.diemlan1 = diemlan1;
        this.diemlan2 = diemlan2;
        this.HocKy = HocKy;
    }
    
    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public int getDiemlan1() {
        return diemlan1;
    }

    public void setDiemlan1(int diemlan1) {
        this.diemlan1 = diemlan1;
    }

    public int getDiemlan2() {
        return diemlan2;
    }

    public void setDiemlan2(int diemlan2) {
        this.diemlan2 = diemlan2;
    }

    public int getHocKy() {
        return HocKy;
    }

    public void setHocKy(int HocKy) {
        this.HocKy = HocKy;
    }

    public Object[] toObject(){
        return new Object[]{this.MaSV ,this.MaMH,this.HocKy,this.diemlan1,this.diemlan2};
    }
   
}
