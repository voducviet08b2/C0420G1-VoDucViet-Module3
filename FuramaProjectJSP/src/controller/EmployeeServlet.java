package controller;

import bo.CustomerBO;
import bo.CustomerBOimp;
import bo.EmployeeBO;
import bo.EmployeeBOimp;
import dao.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeBO employeeBO=new EmployeeBOimp();
    private DivisionDAO divisionDAO=new DivisionDAOimp();
    private PositionDAO positionDAO=new PositionDAOimp();
    private DegreeDAO degreeDAO=new DegreeDAOimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
               update(request,response);
                break;
            case "confirmCreate":
                confirmCreate(request,response);
                break;
            case "confirmUpdate":
                confirmUpdate(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                show(request,response);
                break;
        }
    }
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList=employeeBO.findAll();
        request.setAttribute("employeeList",employeeList);
        List<Position> positionList=positionDAO.findAll();
        List<Degree> degreeList=degreeDAO.findAll();
        List<Division> divisionList=divisionDAO.findAll();
        int count=employeeList.size();
        request.setAttribute("count",count);
        request.setAttribute("positionList",positionList);
        request.setAttribute("degreeList",degreeList);
        request.setAttribute("divisionList",divisionList);
        request.getRequestDispatcher("Employee/showEmployee.jsp").forward(request,response);
    }
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList=positionDAO.findAll();
        List<Degree> degreeList=degreeDAO.findAll();
        List<Division> divisionList=divisionDAO.findAll();
        request.setAttribute("positionList",positionList);
        request.setAttribute("degreeList",degreeList);
        request.setAttribute("divisionList",divisionList);
        request.getRequestDispatcher("Employee/createEmployee.jsp").forward(request,response);
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        int idSearch=0;
        List<Employee> employeeList = employeeBO.findAll();
        for(int i=0;i<employeeList.size();i++){
            if(id==employeeList.get(i).getId()){
                idSearch=i;
            }
        }
        String hoTen=employeeList.get(idSearch).getHoTen();
        String ngaySinh=employeeList.get(idSearch).getNgaySinh();
        String soCMND=employeeList.get(idSearch).getSoCMND();
        int luong=employeeList.get(idSearch).getLuong();
        String sdt=employeeList.get(idSearch).getSdt();
        String email=employeeList.get(idSearch).getEmail();
        String diaChi=employeeList.get(idSearch).getDiaChi();
        String idViTri=employeeList.get(idSearch).getIdViTri();
        String idTrinhDo=employeeList.get(idSearch).getIdTrinhDo();
        String idBoPhan=employeeList.get(idSearch).getIdBoPhan();

        List<Position> positionList=positionDAO.findAll();
        List<Degree> degreeList=degreeDAO.findAll();
        List<Division> divisionList=divisionDAO.findAll();

        request.setAttribute("id",id);
        request.setAttribute("hoTen",hoTen);
        request.setAttribute("soCMND",soCMND);
        request.setAttribute("luong",luong);
        request.setAttribute("sdt",sdt);
        request.setAttribute("email",email);
        request.setAttribute("diaChi",diaChi);
        request.setAttribute("ngaySinh",ngaySinh);

        request.setAttribute("positionList",positionList);
        request.setAttribute("degreeList",degreeList);
        request.setAttribute("divisionList",divisionList);

        request.getRequestDispatcher("Employee/updateEmployee.jsp").forward(request,response);
    }
    public void confirmCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen=request.getParameter("hoTen");
        String ngaySinh=request.getParameter("ngaySinh");
        String soCMND=request.getParameter("soCMND");
        int luong=Integer.parseInt(request.getParameter("luong"));
        String sdt=request.getParameter("sdt");
        String email=request.getParameter("email");
        String diaChi=request.getParameter("diaChi");
        String idViTri=request.getParameter("idViTri");
        String idTrinhDo=request.getParameter("idTrinhDo");
        String idBoPhan=request.getParameter("idBoPhan");
        Employee employee=new Employee();
        employee.setHoTen(hoTen);
        employee.setNgaySinh(ngaySinh);
        employee.setSoCMND(soCMND);
        employee.setLuong(luong);
        employee.setSdt(sdt);
        employee.setEmail(email);
        employee.setDiaChi(diaChi);
        employee.setIdViTri(idViTri);
        employee.setIdTrinhDo(idTrinhDo);
        employee.setIdBoPhan(idBoPhan);
        this.employeeBO.create(employee);
        this.show(request,response);
    }
    public void confirmUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String hoTen=request.getParameter("hoTen");
        String ngaySinh=request.getParameter("ngaySinh");
        String soCMND=request.getParameter("soCMND");
        int luong=Integer.parseInt(request.getParameter("luong"));
        String sdt=request.getParameter("sdt");
        String email=request.getParameter("email");
        String diaChi=request.getParameter("diaChi");
        String idViTri=request.getParameter("idViTri");
        String idTrinhDo=request.getParameter("idTrinhDo");
        String idBoPhan=request.getParameter("idBoPhan");

        Employee employee=new Employee();
        employee.setHoTen(hoTen);
        employee.setNgaySinh(ngaySinh);
        employee.setSoCMND(soCMND);
        employee.setLuong(luong);
        employee.setSdt(sdt);
        employee.setEmail(email);
        employee.setDiaChi(diaChi);
        employee.setIdViTri(idViTri);
        employee.setIdTrinhDo(idTrinhDo);
        employee.setIdBoPhan(idBoPhan);
        employee.setId(id);
        this.employeeBO.update(employee);
        this.show(request,response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        this.employeeBO.delete(id);
        this.show(request,response);
    }
    public void search(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String keyword=request.getParameter("keyword");
        List<Employee> employeeList=employeeBO.findSearch(keyword);
        request.setAttribute("employeeList",employeeList);
        List<Position> positionList=positionDAO.findAll();
        List<Degree> degreeList=degreeDAO.findAll();
        List<Division> divisionList=divisionDAO.findAll();
        int count=employeeList.size();
        request.setAttribute("count",count);
        request.setAttribute("positionList",positionList);
        request.setAttribute("degreeList",degreeList);
        request.setAttribute("divisionList",divisionList);
        request.getRequestDispatcher("Employee/showEmployee.jsp").forward(request,response);
    }
}
