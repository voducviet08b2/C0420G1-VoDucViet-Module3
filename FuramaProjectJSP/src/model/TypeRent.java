package model;

public class TypeRent {
    private int id;
    private String tenKieuThue;
    private String gia;

    public TypeRent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKieuThue() {
        return tenKieuThue;
    }

    public void setTenKieuThue(String tenKieuThue) {
        this.tenKieuThue = tenKieuThue;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public TypeRent(int id, String tenKieuThue, String gia) {
        this.id = id;
        this.tenKieuThue = tenKieuThue;
        this.gia = gia;
    }
}
