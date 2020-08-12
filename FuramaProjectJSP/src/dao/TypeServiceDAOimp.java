package dao;

import model.TypeRent;
import model.TypeService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeServiceDAOimp implements TypeServiceDAO {

    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_TYPESERVICE_SQL = "select id,ten_loai_dich_vu from loaidichvu";
    @Override
    public List<TypeService> findAll() {
        List<TypeService> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_TYPESERVICE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            TypeService typeService = null;

            while (resultSet.next()) {
                typeService = new TypeService();
                typeService.setId(resultSet.getInt("id"));
                typeService.setTenLoaiDichVu(resultSet.getString("ten_loai_dich_vu"));


                showList.add(typeService);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
