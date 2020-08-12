package model;

public class Position {
    private int id;
    private String tenViTri;

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public Position(int id, String tenViTri) {
        this.id = id;
        this.tenViTri = tenViTri;
    }
}
