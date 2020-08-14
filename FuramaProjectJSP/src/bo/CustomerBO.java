package bo;

import model.Customer;
import model.DTOCustomerContract;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAll();
    void create(Customer customer);
    void update(Customer customer);
    void delete(int id);
    List<Customer> findSearch(String keyword);
    List<DTOCustomerContract> findAllCustomerContract();
}
