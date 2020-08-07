package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private BaseDAO baseDAO = new BaseDAO();
    private static final String FIND_ALL_SQL = "select id, `name`, date_of_birth from student";
    private static final String SAVE_INSERT_SQL =
            "insert into student (`name`, date_of_birth) " +
            "values (?, ?)";
    private static final String SAVE_INSERT_CLASS_SQL =
            "insert into class (id, `name`, type_of_class_id) " +
            "values (?, ?, ?)";
    private static final String SAVE_INSERT_CLASS_STUDENT_SQL =
            "insert into student (`name`, date_of_birth, class_id) " +
            "values (?, ?, ?)";
//    private static Map<Integer, Student> studentMap;
//
//    static {
//        studentMap = new HashMap<>();
//        studentMap.put(1, new Student(1, "Tien", "2000", 7));
//        studentMap.put(2, new Student(2, "Tien Quoc", "2005", 4));
//        studentMap.put(3, new Student(3, "Thinh", "2005", 9));
//    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().prepareStatement(FIND_ALL_SQL);
//            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall();

            ResultSet resultSet = preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()) {
                student = new Student();

                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setId(resultSet.getInt("id"));

//                student.setName(resultSet.getString(2));
//                student.setDateOfBirth(resultSet.getString(3));
//                student.setId(resultSet.getInt(1));

                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public void save(Student student) {

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SAVE_INSERT_SQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveClassAndStudent() {
        Connection connection = this.baseDAO.getConnection();
        try {

            connection.setAutoCommit(false);

            PreparedStatement pSInsertClass = connection.prepareStatement(SAVE_INSERT_CLASS_SQL);

            pSInsertClass.setString(1, "4");
            pSInsertClass.setString(2, "C0820G1");
            pSInsertClass.setString(3, "1");

            pSInsertClass.executeUpdate();

            PreparedStatement pSInsertStudent = connection.prepareStatement(SAVE_INSERT_CLASS_STUDENT_SQL);

            pSInsertStudent.setString(1, "Tien C08");
            pSInsertStudent.setString(2, "2020-08");
            pSInsertStudent.setString(3, "4");

            pSInsertStudent.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
