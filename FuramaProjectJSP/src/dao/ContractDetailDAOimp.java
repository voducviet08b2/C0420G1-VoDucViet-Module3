package dao;

import model.ContractDetail;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDetailDAOimp implements ContractDetailDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SAVE_INSERT_SQL =
            "insert into hopdongchitiet (id_hop_dong, id_dich_vu_di_kem,so_luong) " +
                    "values (?, ?, ?)";


    @Override
    public void create(ContractDetail serviceAttach) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_INSERT_SQL);
            preparedStatement.setString(1,serviceAttach.getIdHopDong());
            preparedStatement.setString(2, serviceAttach.getIdDichVuDiKem());
            preparedStatement.setInt(3, serviceAttach.getSoLuong());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
