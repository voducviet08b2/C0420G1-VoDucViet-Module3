package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    void save(User user);
    void update(User user);
}
