package dao;

import model.Student;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOCallSPImpl implements  StudentDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_SP = "{call find_by_name(?)}";

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(FIND_ALL_SP);
            callableStatement.setString(1, "t");
//            callableStatement.setString("v_name", "t");

            ResultSet resultSet = callableStatement.executeQuery();

            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setId(resultSet.getInt("id"));

                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void saveClassAndStudent() {

    }
}
