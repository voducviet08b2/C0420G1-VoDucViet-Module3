package model;

public class ContractDetail {
    private int id;
    private String idHopDong;
    private String idDichVuDiKem;
    private int soLuong;

    public ContractDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(String idHopDong) {
        this.idHopDong = idHopDong;
    }

    public String getIdDichVuDiKem() {
        return idDichVuDiKem;
    }

    public void setIdDichVuDiKem(String idDichVuDiKem) {
        this.idDichVuDiKem = idDichVuDiKem;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public ContractDetail(int id, String idHopDong, String idDichVuDiKem, int soLuong) {
        this.id = id;
        this.idHopDong = idHopDong;
        this.idDichVuDiKem = idDichVuDiKem;
        this.soLuong = soLuong;
    }
}
