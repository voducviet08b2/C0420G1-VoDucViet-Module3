package dao;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeDao {
    List<CustomerType> findAll();
}
