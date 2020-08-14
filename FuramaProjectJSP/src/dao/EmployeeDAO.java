package dao;


import model.Employee;


import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    void create(Employee employee);
    void update(Employee employee);
    void delete(int id);
    List<Employee> findSearch(String keyword);
}
