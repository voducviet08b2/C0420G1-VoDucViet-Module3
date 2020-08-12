package model;

public class Service {
    private int id;
    private String tenDichVu;
    private String dienTich;
    private String soTang;
    private int soNguoiToiDa;
    private int chiPhiThue;
    private String trangThai;
    private String idKieuThue;
    private String idLoaiDichVu;

    public Service(int id, String tenDichVu, String dienTich, String soTang, int soNguoiToiDa, int chiPhiThue, String trangThai, String idKieuThue, String idLoaiDichVu) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.soTang = soTang;
        this.soNguoiToiDa = soNguoiToiDa;
        this.chiPhiThue = chiPhiThue;
        this.trangThai = trangThai;
        this.idKieuThue = idKieuThue;
        this.idLoaiDichVu = idLoaiDichVu;
    }

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public int getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(int chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdKieuThue() {
        return idKieuThue;
    }

    public void setIdKieuThue(String idKieuThue) {
        this.idKieuThue = idKieuThue;
    }

    public String getIdLoaiDichVu() {
        return idLoaiDichVu;
    }

    public void setIdLoaiDichVu(String idLoaiDichVu) {
        this.idLoaiDichVu = idLoaiDichVu;
    }
}
