package firstproject.leminh.chuong7;

import android.graphics.drawable.Drawable;

public class NhanVien {
    private String manv;
    private String tennv;
    private int gender;

    public NhanVien(String manv, String tennv, int gender) {
        this.manv = manv;
        this.tennv = tennv;
        this.gender = gender;
    }
    public String getManv() {
        return this.manv;
    }

    public String getTennv() {
        return tennv;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender){
        gender = gender;
    }
    public void setManv(String manv){
        this.manv = manv;
    }
    public void setTennv(String tennv){
        this.tennv = tennv;
    }
}
