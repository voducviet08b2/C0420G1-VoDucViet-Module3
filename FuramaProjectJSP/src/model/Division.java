package model;

public class Division {
    private int id;
    private String tenBoPhan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public Division() {
    }

    public Division(int id, String tenBoPhan) {
        this.id = id;
        this.tenBoPhan = tenBoPhan;
    }
}
