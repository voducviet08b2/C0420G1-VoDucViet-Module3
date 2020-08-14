package bo;

import dao.EmployeeDAO;
import dao.EmployeeDAOimp;
import model.Employee;

import java.util.List;

public class EmployeeBOimp implements EmployeeBO{
    private EmployeeDAO employeeDAO=new EmployeeDAOimp();
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }
    @Override
    public void update(Employee employee){
        employeeDAO.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public List<Employee> findSearch(String keyword) {
        return employeeDAO.findSearch(keyword);
    }
}
