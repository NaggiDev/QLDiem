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
public class HeDaoTao {
    private String tenHe,maHe;


    public HeDaoTao(String maHe, String tenHe) {
        this.maHe = maHe;
        this.tenHe = tenHe;
    }

    public HeDaoTao() {
    }

    public String getMaHe() {
        return maHe;
    }

    public void setMaHe(String maHe) {
        this.maHe = maHe;
    }

    public String getTenHe() {
        return tenHe;
    }

    public void setTenHe(String tenHe) {
        this.tenHe = tenHe;
    }
    public Object[] toObject(){
        return new Object[]{this.maHe,this.tenHe};
    }
}
