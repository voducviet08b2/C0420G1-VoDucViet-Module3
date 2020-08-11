package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();
    void create(Customer customer);
    void update(Customer customer);
    void delete(int id);
}
