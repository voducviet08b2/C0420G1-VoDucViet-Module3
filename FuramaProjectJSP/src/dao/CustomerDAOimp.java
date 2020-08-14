package dao;

import model.Customer;
import model.DTOCustomerContract;

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
    private final String SELECT_SEARCH_CUSTOMER_SQL = "select id,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi,id_loai_khach from khachhang where ho_ten like ?";
    private final String SELECT_CUSTOMER_CONTRACT="select k.id,k.ho_ten,h.ngay_lam_hop_dong,dvdk.ten_dich_vu_di_kem,d.ten_dich_vu\n" +
            "from khachhang k\n" +
            "inner join hopdong h on h.id_khach_hang=k.id\n" +
            "inner join hopdongchitiet hdct on hdct.id_hop_dong=h.id\n" +
            "inner join dichvudikem dvdk on hdct.id_dich_vu_di_kem=dvdk.id\n" +
            "inner join dichvu d on h.id_dich_vu=d.id;";
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

    @Override
    public List<Customer> findSearch(String keyword) {
        List<Customer> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_SEARCH_CUSTOMER_SQL);
            preparedStatement.setString(1, "%"+keyword+"%");
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
    public List<DTOCustomerContract> findAllCustomerContract() {
        List<DTOCustomerContract> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_CUSTOMER_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            DTOCustomerContract dtoCustomerContract = null;

            while (resultSet.next()) {
                dtoCustomerContract = new DTOCustomerContract();
                dtoCustomerContract.setId(resultSet.getInt("id"));
                dtoCustomerContract.setHoTen(resultSet.getString("ho_ten"));
                dtoCustomerContract.setNgayLamHopDong(resultSet.getString("ngay_lam_hop_dong"));
                dtoCustomerContract.setTenDichVuDiKem(resultSet.getString("ten_dich_vu_di_kem"));
                dtoCustomerContract.setTenDichVu(resultSet.getString("ten_dich_vu"));


                showList.add(dtoCustomerContract);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
