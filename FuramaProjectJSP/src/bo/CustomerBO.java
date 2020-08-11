package bo;

import model.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAll();
    void create(Customer customer);
    void update(Customer customer);
    void delete(int id);
}
