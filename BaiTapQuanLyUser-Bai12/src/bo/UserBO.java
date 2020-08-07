package bo;

import model.User;

import java.util.List;

public interface UserBO {
    List<User> CallFindAll();
    List<User> findAll();
    List<User> findAllOrderBy();
    List<User> searchByCountry(String country);
    void updatePro(User user);
    void deletePro(User user);
    void save(User user);
    void update(User user);
    void delete(User user);
}
