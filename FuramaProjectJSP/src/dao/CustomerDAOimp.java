package dao;

import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOimp implements CustomerDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_CUSTOMER_SQL = "select id,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi,id_loai_khach from khachhang";
    private static final String SAVE_INSERT_SQL =
            "insert into khachhang (ho_ten, ngay_sinh,so_cmnd,sdt,email,dia_chi,id_loai_khach) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "update khachhang set " +
            "ho_ten = ?,ngay_sinh= ?, so_cmnd =?, sdt =?, email =?, dia_chi =?, id_loai_khach =? where id = ?;";
    private static final String DELETE_SQL = "delete from khachhang where id=?";
    @Override
    public List<Customer> findAll() {
        List<Customer> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;

            while (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setHoTen(resultSet.getString("ho_ten"));
                customer.setNgaySinh(resultSet.getString("ngay_sinh"));
                customer.setSoCMND(resultSet.getString("so_cmnd"));
                customer.setSdt(resultSet.getString("sdt"));
                customer.setEmail(resultSet.getString("email"));
                customer.setDiaChi(resultSet.getString("dia_chi"));
                customer.setIdLoaiKhach(resultSet.getString("id_loai_khach"));
                showList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }

    @Override
    public void create(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_INSERT_SQL);
            preparedStatement.setString(1,customer.getHoTen());
            preparedStatement.setString(2, customer.getNgaySinh());
            preparedStatement.setString(3, customer.getSoCMND());
            preparedStatement.setString(4, customer.getSdt());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getDiaChi());
            preparedStatement.setString(7, customer.getIdLoaiKhach());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, customer.getHoTen());
            preparedStatement.setString(2, customer.getNgaySinh());
            preparedStatement.setString(3, customer.getSoCMND());
            preparedStatement.setString(4, customer.getSdt());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getDiaChi());
            preparedStatement.setString(7, customer.getIdLoaiKhach());
            preparedStatement.setInt(8, customer.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(DELETE_SQL);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
