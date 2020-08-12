package model;

public class TypeService {
    private int id;

    public TypeService(int id, String tenLoaiDichVu) {
        this.id = id;
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    private String tenLoaiDichVu;

    public TypeService() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }
}
