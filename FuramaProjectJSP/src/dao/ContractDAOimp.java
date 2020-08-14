package dao;

import model.Contract;
import model.Customer;
import model.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOimp implements ContractDAO{

    private BaseDAO baseDAO = new BaseDAO();
    private static final String SAVE_INSERT_SQL =
            "insert into hopdong (ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien,id_nhan_vien,id_khach_hang,id_dich_vu) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_ALL_CONTRACT_SQL = "select id from hopdong";
    @Override
    public List<Contract> findAll() {
        List<Contract> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CONTRACT_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contract contract = null;

            while (resultSet.next()) {
                contract = new Contract();
                contract.setId(resultSet.getInt("id"));

                showList.add(contract);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }

    @Override
    public void create(Contract contract) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_INSERT_SQL);
            preparedStatement.setString(1,contract.getNgayLamHopDong());
            preparedStatement.setString(2,contract.getNgayKetThuc());
            preparedStatement.setInt(3,contract.getTienDatCoc());
            preparedStatement.setInt(4,contract.getTongTien());
            preparedStatement.setString(5,contract.getIdNhanVien());
            preparedStatement.setString(6,contract.getIdKhachHang());
            preparedStatement.setString(7,contract.getIdDichVu());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
