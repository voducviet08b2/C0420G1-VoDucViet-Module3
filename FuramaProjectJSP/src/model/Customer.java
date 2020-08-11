package model;

public class Customer {
    private int id;
    private String hoTen;
    private String ngaySinh;
    private String soCMND;
    private String sdt;
    private String email;
    private String diaChi;
    private String idLoaiKhach;

    public Customer() {
    }

    public Customer(int id, String hoTen, String ngaySinh, String soCMND, String sdt, String email, String diaChi, String idLoaiKhach) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.idLoaiKhach = idLoaiKhach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getIdLoaiKhach() {
        return idLoaiKhach;
    }

    public void setIdLoaiKhach(String idLoaiKhach) {
        this.idLoaiKhach = idLoaiKhach;
    }
}
