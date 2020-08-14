package dao;

import model.Service;

import java.util.List;

public interface ServiceDAO {
    void create(Service service);
    List<Service> findAll();
}
