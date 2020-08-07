package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
    List<User> searchByCountry(String country);
    List<User> findAllOrderBy();
}
