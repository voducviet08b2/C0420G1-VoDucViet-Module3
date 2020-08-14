package controller;

import bo.CustomerBO;
import bo.CustomerBOimp;
import bo.CustomerTypeBO;
import bo.CustomerTypeBOimp;
import model.Customer;
import model.CustomerType;
import model.DTOCustomerContract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    private CustomerBO customerBO=new CustomerBOimp();
    private CustomerTypeBO customerTypeBO=new CustomerTypeBOimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "confirmCreate":
                confirmCreate(request,response);
                break;
            case "update":
                update(request,response);
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
            case "showCustomerContract":
                showCustomerContract(request,response);
                break;
            default:
                show(request,response);
                break;
        }
    }

    public void show(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Customer> customerList=customerBO.findAll();
        request.setAttribute("customerList",customerList);
        List<CustomerType> customerTypeList=customerTypeBO.findAll();
        int count=customerList.size();
        request.setAttribute("count",count);
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeList",customerTypeList);
        request.getRequestDispatcher("Customer/showCustomer.jsp").forward(request,response);
    }
    public void create(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<CustomerType> customerTypeList=customerTypeBO.findAll();
        request.setAttribute("customerTypeList",customerTypeList);
        request.getRequestDispatcher("Customer/createCustomer.jsp").forward(request,response);
    }

    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
       int id=Integer.parseInt(request.getParameter("id"));
        int idSearch=0;
        List<Customer> customerList = customerBO.findAll();
        for(int i=0;i<customerList.size();i++){
            if(id==customerList.get(i).getId()){
                idSearch=i;
            }
        }
        String hoTen=customerList.get(idSearch).getHoTen();
        String ngaySinh=customerList.get(idSearch).getNgaySinh();
        String soCMND=customerList.get(idSearch).getSoCMND();
        String sdt=customerList.get(idSearch).getSdt();
        String email=customerList.get(idSearch).getEmail();
        String diaChi=customerList.get(idSearch).getDiaChi();
        String idLoaiKhach=customerList.get(idSearch).getIdLoaiKhach();

        List<CustomerType> customerTypeList=customerTypeBO.findAll();

        request.setAttribute("id",id);
        request.setAttribute("hoTen",hoTen);
        request.setAttribute("soCMND",soCMND);
        request.setAttribute("sdt",sdt);
        request.setAttribute("email",email);
        request.setAttribute("diaChi",diaChi);
        request.setAttribute("ngaySinh",ngaySinh);

        request.setAttribute("customerTypeList",customerTypeList);

        request.getRequestDispatcher("Customer/updateCustomer.jsp").forward(request,response);
    }

    public void confirmCreate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String hoTen=request.getParameter("hoTen");
        String ngaySinh=request.getParameter("ngaySinh");
        String soCMND=request.getParameter("soCMND");
        String sdt=request.getParameter("sdt");
        String email=request.getParameter("email");
        String diaChi=request.getParameter("diaChi");
        String idLoaiKhach=request.getParameter("idLoaiKhach");
        Customer customer=new Customer();
        customer.setHoTen(hoTen);
        customer.setNgaySinh(ngaySinh);
        customer.setSoCMND(soCMND);
        customer.setSdt(sdt);
        customer.setEmail(email);
        customer.setDiaChi(diaChi);
        customer.setIdLoaiKhach(idLoaiKhach);
        this.customerBO.create(customer);
        this.show(request,response);
    }
    public void confirmUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        String hoTen=request.getParameter("hoTen");
        String ngaySinh=request.getParameter("ngaySinh");
        String soCMND=request.getParameter("soCMND");
        String sdt=request.getParameter("sdt");
        String email=request.getParameter("email");
        String diaChi=request.getParameter("diaChi");
        String idLoaiKhach=request.getParameter("idLoaiKhach");

        Customer customer=new Customer();
        customer.setId(id);
        customer.setHoTen(hoTen);
        customer.setNgaySinh(ngaySinh);
        customer.setSoCMND(soCMND);
        customer.setSdt(sdt);
        customer.setEmail(email);
        customer.setDiaChi(diaChi);
        customer.setIdLoaiKhach(idLoaiKhach);

        this.customerBO.update(customer);
        this.show(request,response);
    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        this.customerBO.delete(id);
        this.show(request,response);
    }

    public void search(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
       String keyword=request.getParameter("keyword");
        List<Customer> customerList=customerBO.findSearch(keyword);
        request.setAttribute("customerList",customerList);
        List<CustomerType> customerTypeList=customerTypeBO.findAll();
        int count=customerList.size();
        request.setAttribute("count",count);
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeList",customerTypeList);
        request.getRequestDispatcher("Customer/showCustomer.jsp").forward(request,response);
    }
    public void showCustomerContract(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<DTOCustomerContract> listShow=this.customerBO.findAllCustomerContract();
        request.setAttribute("listShow",listShow);
        request.getRequestDispatcher("Customer/showCustomerContract.jsp").forward(request,response);
    }
}
