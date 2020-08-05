package bo;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> findAll() {
        return this.studentDAO.findAll();
    }

    @Override
    public boolean validateStudentName() {
        // regex pattern
        return false;
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }
}
