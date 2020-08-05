package bo;

import model.User;

import java.util.List;

public interface UserBO {
    List<User> findAll();
    void save(User user);
    void update(User user);
}
