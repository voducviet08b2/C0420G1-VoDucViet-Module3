package dao;

import model.Employee;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimp implements EmployeeDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_employee_SQL = "select id,ho_ten,ngay_sinh,so_cmnd,luong,sdt,email,dia_chi,id_vi_tri" +
            ",id_trinh_do,id_bo_phan from nhanvien";
    private static final String SAVE_INSERT_SQL =
            "insert into nhanvien (ho_ten, ngay_sinh,so_cmnd,luong,sdt,email,dia_chi,id_vi_tri,id_trinh_do,id_bo_phan) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "update nhanvien set " +
            "ho_ten = ?,ngay_sinh= ?, so_cmnd =?, luong=?, sdt =?, email =?, dia_chi =?, id_vi_tri =?," +
            "id_trinh_do =?,id_bo_phan =? where id = ?;";
    private static final String DELETE_SQL = "delete from nhanvien where id=?";
    private final String SELECT_SEARCH_employee_SQL = "select id,ho_ten,ngay_sinh,so_cmnd,luong,sdt,email,dia_chi,id_vi_tri" +
            ",id_trinh_do,id_bo_phan from nhanvien where ho_ten like ?";
    @Override
    public List<Employee> findAll() {
        List<Employee> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_employee_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;

            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setHoTen(resultSet.getString("ho_ten"));
                employee.setNgaySinh(resultSet.getString("ngay_sinh"));
                employee.setSoCMND(resultSet.getString("so_cmnd"));
                employee.setLuong(resultSet.getInt("luong"));
                employee.setSdt(resultSet.getString("sdt"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDiaChi(resultSet.getString("dia_chi"));
                employee.setIdViTri(resultSet.getString("id_vi_tri"));
                employee.setIdTrinhDo(resultSet.getString("id_trinh_do"));
                employee.setIdBoPhan(resultSet.getString("id_bo_phan"));
                showList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }

    @Override
    public void create(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_INSERT_SQL);
            preparedStatement.setString(1,employee.getHoTen());
            preparedStatement.setString(2, employee.getNgaySinh());
            preparedStatement.setString(3, employee.getSoCMND());
            preparedStatement.setInt(4, employee.getLuong());
            preparedStatement.setString(5, employee.getSdt());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getDiaChi());
            preparedStatement.setString(8, employee.getIdViTri());
            preparedStatement.setString(9, employee.getIdTrinhDo());
            preparedStatement.setString(10, employee.getIdBoPhan());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1,employee.getHoTen());
            preparedStatement.setString(2, employee.getNgaySinh());
            preparedStatement.setString(3, employee.getSoCMND());
            preparedStatement.setInt(4, employee.getLuong());
            preparedStatement.setString(5, employee.getSdt());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getDiaChi());
            preparedStatement.setString(8, employee.getIdViTri());
            preparedStatement.setString(9, employee.getIdTrinhDo());
            preparedStatement.setString(10, employee.getIdBoPhan());
            preparedStatement.setInt(11, employee.getId());
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
    public List<Employee> findSearch(String keyword) {
        List<Employee> showList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_SEARCH_employee_SQL);
            preparedStatement.setString(1,"%"+keyword+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;

            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setHoTen(resultSet.getString("ho_ten"));
                employee.setNgaySinh(resultSet.getString("ngay_sinh"));
                employee.setSoCMND(resultSet.getString("so_cmnd"));
                employee.setLuong(resultSet.getInt("luong"));
                employee.setSdt(resultSet.getString("sdt"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDiaChi(resultSet.getString("dia_chi"));
                employee.setIdViTri(resultSet.getString("id_vi_tri"));
                employee.setIdTrinhDo(resultSet.getString("id_trinh_do"));
                employee.setIdBoPhan(resultSet.getString("id_bo_phan"));
                showList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showList;
    }
}
