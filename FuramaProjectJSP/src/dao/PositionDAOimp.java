package dao;

import model.Position;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAOimp implements PositionDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_POSITION_SQL = "select id,ten_vi_tri from vitri";
    @Override
    public List<Position> findAll() {
        List<Position> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_POSITION_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Position position = null;

            while (resultSet.next()) {
                position = new Position();
                position.setId(resultSet.getInt("id"));
                position.setTenViTri(resultSet.getString("ten_vi_tri"));


                showList.add(position);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
