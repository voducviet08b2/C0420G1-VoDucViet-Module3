package bo;

import dao.CustomerTypeDAOimp;
import dao.CustomerTypeDao;
import model.CustomerType;

import java.util.List;

public class CustomerTypeBOimp implements CustomerTypeBO {
    private CustomerTypeDao customerTypeDao=new CustomerTypeDAOimp();

    @Override
    public List<CustomerType> findAll() {
        return customerTypeDao.findAll();
    }
}
