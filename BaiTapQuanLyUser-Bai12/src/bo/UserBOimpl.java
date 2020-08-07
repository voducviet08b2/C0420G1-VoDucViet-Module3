package bo;

import dao.UserDAO;
import dao.UserDAOimpl;
import dao.UserDAOimpl2;
import model.User;

import java.util.List;

public class UserBOimpl implements UserBO {
    private UserDAO userDAO=new UserDAOimpl();
    private UserDAO userDAOimpl2=new UserDAOimpl2();
    @Override
    public List<User> CallFindAll() {
        return this.userDAOimpl2.findAll();
    }
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
    public void updatePro(User user) {
        userDAOimpl2.update(user);
    }

    @Override
    public void deletePro(User user) {
        userDAOimpl2.delete(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
