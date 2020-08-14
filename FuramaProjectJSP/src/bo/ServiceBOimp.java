package bo;

import dao.ServiceDAO;
import dao.ServiceDAOimp;
import model.Service;

import java.util.List;

public class ServiceBOimp implements ServiceBO {
    private ServiceDAO serviceDAO=new ServiceDAOimp();

    @Override
    public List<Service> findAll() {
        return serviceDAO.findAll();
    }

    @Override
    public void create(Service service) {
        serviceDAO.create(service);
    }
}
