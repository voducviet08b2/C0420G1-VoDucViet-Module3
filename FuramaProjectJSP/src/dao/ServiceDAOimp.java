package dao;

import model.Position;
import model.Service;
import model.TypeRent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOimp implements ServiceDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SAVE_INSERT_SQL =
            "insert into dichvu (ten_dich_vu, dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,trang_thai,id_kieu_thue,id_loai_dich_vu) " +
                    "values (?, ?, ?, ?, ?, ?, ?,?)";
    private final String SELECT_ALL_SERVICE_SQL = "select id, ten_dich_vu from dichvu";

    @Override
    public void create(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_INSERT_SQL);
            preparedStatement.setString(1,service.getTenDichVu());
            preparedStatement.setString(2, service.getDienTich());
            preparedStatement.setString(3, service.getSoTang());
            preparedStatement.setInt(4, service.getSoNguoiToiDa());
            preparedStatement.setInt(5, service.getChiPhiThue());
            preparedStatement.setString(6, service.getTrangThai());
            preparedStatement.setString(7, service.getIdKieuThue());
            preparedStatement.setString(8, service.getIdLoaiDichVu());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Service> findAll() {
        List<Service> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_SERVICE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service = null;

            while (resultSet.next()) {
                service = new Service();
                service.setId(resultSet.getInt("id"));
                service.setTenDichVu(resultSet.getString("ten_dich_vu"));


                showList.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
