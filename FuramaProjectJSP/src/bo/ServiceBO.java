package bo;

import model.Service;

import java.util.List;

public interface ServiceBO {
    List<Service> findAll();
    void create(Service service);
}
