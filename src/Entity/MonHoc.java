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
public class MonHoc implements Serializable {

    private int sotin;
    private String mamonhoc,tenmon;

    public MonHoc(String mamonhoc, int sotin, String tenmon) {
        this.mamonhoc = mamonhoc;
        this.sotin = sotin;
        this.tenmon = tenmon;
    }

    public MonHoc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    public int getSotin() {
        return sotin;
    }

    public void setSotin(int sotin) {
        this.sotin = sotin;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public Object[] toObject() {
        return new Object[]{this.mamonhoc, this.tenmon, this.sotin};
    }

}
