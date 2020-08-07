package dao;

import model.User;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl2 implements UserDAO {
    private BaseDAO baseDAO=new BaseDAO();
    private static final String PRO_FIND_ALL="{call get_all_user()}";
    private static final String PRO_UPDATE_ALL="{call update_user(?,?,?,?)}";
    private static final String PRO_DELETE_ALL="{call delete_user(?)}";
    @Override
    public List<User> findAll() {
        List<User> userList=new ArrayList<>();
        try{
            CallableStatement callableStatement=this.baseDAO.getConnection().prepareCall(PRO_FIND_ALL);
            ResultSet resultSet=callableStatement.executeQuery();
            User user=null;
            while(resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {
     try{
         CallableStatement callableStatement=this.baseDAO.getConnection().prepareCall(PRO_UPDATE_ALL);
         callableStatement.setString(1,user.getName());
         callableStatement.setString(2,user.getEmail());
         callableStatement.setString(3,user.getCountry());
         callableStatement.setInt(4,user.getId());
         callableStatement.executeQuery();
     }catch(SQLException e){
         e.printStackTrace();
     }
    }

    @Override
    public void delete(User user) {
        try{
            CallableStatement callableStatement=this.baseDAO.getConnection().prepareCall(PRO_DELETE_ALL);
            callableStatement.setInt(1,user.getId());
            callableStatement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> searchByCountry(String country) {
        return null;
    }

    @Override
    public List<User> findAllOrderBy() {
        return null;
    }
}
