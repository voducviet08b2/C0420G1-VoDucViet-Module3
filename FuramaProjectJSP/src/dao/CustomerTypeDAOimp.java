package dao;

import model.Customer;
import model.CustomerType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDAOimp implements CustomerTypeDao {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_CUSTOMERTYPE_SQL = "select id,ten_loai_khach from loaikhach";
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMERTYPE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType = null;

            while (resultSet.next()) {
                customerType = new CustomerType();
                customerType.setId(resultSet.getInt("id"));
                customerType.setTenLoaiKhach(resultSet.getString("ten_loai_khach"));

                showList.add(customerType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
