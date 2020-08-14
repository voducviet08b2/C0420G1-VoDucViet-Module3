package model;

public class ServiceAttach {
    private int id;
    private String tenDichVuDiKem;
    private int gia;
    private int donVi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDichVuDiKem() {
        return tenDichVuDiKem;
    }

    public void setTenDichVuDiKem(String tenDichVuDiKem) {
        this.tenDichVuDiKem = tenDichVuDiKem;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getDonVi() {
        return donVi;
    }

    public void setDonVi(int donVi) {
        this.donVi = donVi;
    }

    public String getTrangThaiKhaDung() {
        return trangThaiKhaDung;
    }

    public void setTrangThaiKhaDung(String trangThaiKhaDung) {
        this.trangThaiKhaDung = trangThaiKhaDung;
    }

    public ServiceAttach() {
    }

    public ServiceAttach(int id, String tenDichVuDiKem, int gia, int donVi, String trangThaiKhaDung) {
        this.id = id;
        this.tenDichVuDiKem = tenDichVuDiKem;
        this.gia = gia;
        this.donVi = donVi;
        this.trangThaiKhaDung = trangThaiKhaDung;
    }

    private String trangThaiKhaDung;

}
