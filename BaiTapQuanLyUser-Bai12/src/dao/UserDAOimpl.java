package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO{
    private BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_SQL = "select id, `name`, email,country from users";
    private static final String FIND_ALL_SQL_ORDER_BY_NAME = "select id, `name`, email,country from users order by name";
    private static final String SAVE_INSERT_SQL =
            "insert into users (`name`, email,country) " +
                    "values (?, ?, ?)";
    private static final String UPDATE_USERS_SQL = "update users set " +
            "name = ?,email= ?, country =? where id = ?;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String SEARCH_USERS_SQL = "select id,`name`,email,country\n" +
            "from users\n" +
            "where country like ?;";
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_ALL_SQL);
//            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall();

            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

//                student.setName(resultSet.getString(2));
//                student.setDateOfBirth(resultSet.getString(3));
//                student.setId(resultSet.getInt(1));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_INSERT_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(User user){
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(SEARCH_USERS_SQL);
//            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall();
            preparedStatement.setString(1, "%"+country+"%");
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));



                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }



    @Override
    public List<User> findAllOrderBy() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_ALL_SQL_ORDER_BY_NAME);
//            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall();

            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));



                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }


}
