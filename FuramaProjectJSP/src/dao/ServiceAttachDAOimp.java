package dao;

import model.Position;
import model.ServiceAttach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceAttachDAOimp implements ServiceAttachDAO {
    private BaseDAO baseDAO=new BaseDAO();
    private final String SELECT_ALL_SQL="select id,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung from dichvudikem";
    @Override
    public List<ServiceAttach> findAll() {
        List<ServiceAttach> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ServiceAttach serviceAttach = null;

            while (resultSet.next()) {
                serviceAttach = new ServiceAttach();
                serviceAttach.setId(resultSet.getInt("id"));
                serviceAttach.setTenDichVuDiKem(resultSet.getString("ten_dich_vu_di_kem"));
                serviceAttach.setGia(resultSet.getInt("gia"));
                serviceAttach.setDonVi(resultSet.getInt("don_vi"));
                serviceAttach.setTrangThaiKhaDung(resultSet.getString("trang_thai_kha_dung"));
                showList.add(serviceAttach);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
