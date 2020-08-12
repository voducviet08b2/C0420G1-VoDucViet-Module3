package bo;

import model.Employee;

import java.util.List;

public interface EmployeeBO {
    List<Employee> findAll();
    void create(Employee employee);
    void update(Employee employee);
    void delete(int id);
}
