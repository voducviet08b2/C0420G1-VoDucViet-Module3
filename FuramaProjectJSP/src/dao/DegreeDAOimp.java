package dao;

import model.Degree;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DegreeDAOimp implements DegreeDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_DEGREE_SQL = "select id,trinh_do from trinhdo";
    @Override
    public List<Degree> findAll() {
        List<Degree> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_DEGREE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Degree degree = null;

            while (resultSet.next()) {
                degree = new Degree();
                degree.setId(resultSet.getInt("id"));
                degree.setTrinhDo(resultSet.getString("trinh_do"));
                

                showList.add(degree);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
