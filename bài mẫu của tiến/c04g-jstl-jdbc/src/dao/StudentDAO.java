package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    void save(Student student);
}
