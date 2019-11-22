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
public class KhoaHoc {

    private String MaKhoaHoc, TenKhoaHoc;

    public KhoaHoc(String MaKhoaHoc, String TenKhoaHoc) {
        this.MaKhoaHoc = MaKhoaHoc;
        this.TenKhoaHoc = TenKhoaHoc;
    }

    public KhoaHoc() {
    }

    public String getMaKhoaHoc() {
        return MaKhoaHoc;
    }

    public void setMaKhoaHoc(String MaKhoaHoc) {
        this.MaKhoaHoc = MaKhoaHoc;
    }

    public String getTenKhoaHoc() {
        return TenKhoaHoc;
    }

    public void setTenKhoaHoc(String TenKhoaHoc) {
        this.TenKhoaHoc = TenKhoaHoc;
    }

    public Object[] toObject() {
        return new Object[]{this.MaKhoaHoc, this.TenKhoaHoc};
    }
}
