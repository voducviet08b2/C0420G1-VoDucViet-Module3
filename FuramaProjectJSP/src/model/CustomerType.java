package model;

public class CustomerType {
    private int id;
    private String tenLoaiKhach;

    public CustomerType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiKhach() {
        return tenLoaiKhach;
    }

    public void setTenLoaiKhach(String tenLoaiKhach) {
        this.tenLoaiKhach = tenLoaiKhach;
    }

    public CustomerType(int id, String tenLoaiKhach) {
        this.id = id;
        this.tenLoaiKhach = tenLoaiKhach;
    }
}
