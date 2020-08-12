package dao;

import model.Division;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionDAOimp implements DivisionDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_division_SQL = "select id,ten_bo_phan from bophan";
    @Override
    public List<Division> findAll() {
        List<Division> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_division_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Division division = null;

            while (resultSet.next()) {
                division = new Division();
                division.setId(resultSet.getInt("id"));
                division.setTenBoPhan(resultSet.getString("ten_bo_phan"));
                

                showList.add(division);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
