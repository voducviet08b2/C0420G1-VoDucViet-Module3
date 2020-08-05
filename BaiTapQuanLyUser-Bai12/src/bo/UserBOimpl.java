package bo;

import dao.UserDAO;
import dao.UserDAOimpl;
import model.User;

import java.util.List;

public class UserBOimpl implements UserBO {
    private UserDAO userDAO=new UserDAOimpl();

    @Override
    public List<User> findAll() {
        return this.userDAO.findAll();
    }
    @Override
    public List<User> findAllOrderBy() {
        return this.userDAO.findAllOrderBy();
    }

    @Override
    public List<User> searchByCountry(String country) {
        return this.userDAO.searchByCountry(country);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }
    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
