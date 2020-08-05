package bo;

import model.User;

import java.util.List;

public interface UserBO {
    List<User> findAll();
    List<User> findAllOrderBy();
    List<User> searchByCountry(String country);
    void save(User user);
    void update(User user);
    void delete(User user);
}
