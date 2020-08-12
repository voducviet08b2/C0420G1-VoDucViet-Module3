package dao;

import model.CustomerType;
import model.TypeRent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeRentDAOimp implements TypeRentDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_TYPERENT_SQL = "select id,ten_kieu_thue,gia from kieuthue";
    @Override
    public List<TypeRent> findAll() {
        List<TypeRent> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_TYPERENT_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            TypeRent typeRent = null;

            while (resultSet.next()) {
                typeRent = new TypeRent();
                typeRent.setId(resultSet.getInt("id"));
                typeRent.setTenKieuThue(resultSet.getString("ten_kieu_thue"));
                typeRent.setGia(resultSet.getString("gia"));

                showList.add(typeRent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
