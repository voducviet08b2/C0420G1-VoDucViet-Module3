package bo;

import model.Student;

import java.util.List;

public interface StudentBO {
    List<Student> findAll();
    boolean validateStudentName();
    void save(Student student);
}
