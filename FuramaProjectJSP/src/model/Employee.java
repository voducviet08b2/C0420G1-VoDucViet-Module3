package model;

public class Employee {
    private int id;
    private String hoTen;
    private String ngaySinh;
    private String soCMND;
    private int luong;
    private String sdt;

    public Employee(int id, String hoTen, String ngaySinh, String soCMND, int luong, String sdt, String email, String diaChi, String idViTri, String idTrinhDo, String idBoPhan) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.idViTri = idViTri;
        this.idTrinhDo = idTrinhDo;
        this.idBoPhan = idBoPhan;
    }

    public Employee() {
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

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
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

    public String getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(String idViTri) {
        this.idViTri = idViTri;
    }

    public String getIdTrinhDo() {
        return idTrinhDo;
    }

    public void setIdTrinhDo(String idTrinhDo) {
        this.idTrinhDo = idTrinhDo;
    }

    public String getIdBoPhan() {
        return idBoPhan;
    }

    public void setIdBoPhan(String idBoPhan) {
        this.idBoPhan = idBoPhan;
    }

    private String email;
    private String diaChi;
    private String idViTri;
    private String idTrinhDo;
    private String idBoPhan;


}
