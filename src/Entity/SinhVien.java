/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.util.Date;

/**
 *
 * @author Lemony
 */
public class SinhVien {

    public SinhVien() {
    }

    public SinhVien(String tenSv, int maSv, Date dob, String address, String gioitinh) {
        this.tenSv = tenSv;
        this.maSv = maSv;
        this.dob = dob;
        this.address = address;
        this.gioitinh = gioitinh;
    }
    String tenSv;
    int maSv;
    Date dob;
    String address;
    String gioitinh;
    
    public Object[] toObject(){
        return new Object[]{this.tenSv,this.maSv,this.dob,this.address,this.gioitinh};
    }
}