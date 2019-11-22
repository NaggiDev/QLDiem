/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lemony
 */
public class SinhVien implements Serializable{

    public SinhVien() {
    }

    public SinhVien(String tenSv, String maSv, Date dob, boolean gioitinh,String quequan,String maLop) {
        this.tenSv = tenSv;
        this.maSv = maSv;
        this.dob = dob;
        this.quequan = quequan;
        this.gioitinh = gioitinh;
        this.maLop=maLop;
        
    }
    private String tenSv;
    private String maSv;
    private Date dob;
    private String quequan;
    private boolean gioitinh;
    private String maLop;

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public Object[] toObject() {
        return new Object[]{this.maSv, this.tenSv, this.dob, this.quequan, this.gioitinh,this.maLop};
    }
}
