package bo;

import dao.ServiceDAO;
import dao.ServiceDAOimp;
import model.Service;

public class ServiceBOimp implements ServiceBO {
    private ServiceDAO serviceDAO=new ServiceDAOimp();
    @Override
    public void create(Service service) {
        serviceDAO.create(service);
    }
}
