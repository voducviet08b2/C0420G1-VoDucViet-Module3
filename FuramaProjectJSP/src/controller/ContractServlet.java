package controller;

import bo.*;
import dao.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/contractServlet")
public class ContractServlet extends HttpServlet {
    private EmployeeBO employeeBO=new EmployeeBOimp();
    private CustomerBO customerBO=new CustomerBOimp();
    private ServiceBO serviceBO=new ServiceBOimp();
    private ContractBO contractBO=new ContractBOimp();
    private ServiceAttachDAO serviceAttachDAO=new ServiceAttachDAOimp();
    private ContractDetailBO contractDetailBO=new ContractDetailBOimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "confirmCreate":
                confirmCreate(request,response);
                break;
            case "createContractDetail":
                createContractDetail(request,response);
                break;
            case "confirmCreateContractDetail":
                confirmCreateContractDetail(request,response);
            default:
                create(request,response);
                break;
        }
    }

    public void create(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Employee> employeeList=employeeBO.findAll();
        List<Customer> customerList=customerBO.findAll();
        List<Service> serviceList=serviceBO.findAll();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        request.getRequestDispatcher("Contract/createContract.jsp").forward(request,response);

    }
    public void confirmCreate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String ngayLamHopDong=request.getParameter("ngayLamHopDong");
        String ngayKetThuc=request.getParameter("ngayKetThuc");
        String tienDatCoc=request.getParameter("tienDatCoc");
        String tongTien=request.getParameter("tongTien");
        String idNhanVien=request.getParameter("idNhanVien");
        String idKhachHang=request.getParameter("idKhachHang");
        String idDichVu=request.getParameter("idDichVu");


        Contract contract=new Contract();
        contract.setNgayLamHopDong(ngayLamHopDong);
        contract.setNgayKetThuc(ngayKetThuc);
        contract.setTienDatCoc(Integer.parseInt(tienDatCoc));
        contract.setTongTien(Integer.parseInt(tongTien));
        contract.setIdNhanVien(idNhanVien);
        contract.setIdKhachHang(idKhachHang);
        contract.setIdDichVu(idDichVu);
        contractBO.create(contract);

    }
    public void createContractDetail(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Contract> contractList=contractBO.findAll();
        List<ServiceAttach> serviceAttachList=serviceAttachDAO.findAll();
        request.setAttribute("contractList",contractList);
        request.setAttribute("serviceAttachList",serviceAttachList);
        request.getRequestDispatcher("Contract/createContractDetail.jsp").forward(request,response);
    }
    public void confirmCreateContractDetail(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String idHopDong=request.getParameter("idHopDong");
        String idDichVuDiKem=request.getParameter("idDichVuDiKem");
        String soLuong=request.getParameter("soLuong");



        ContractDetail contractDetail=new ContractDetail();
        contractDetail.setIdHopDong(idHopDong);
        contractDetail.setIdDichVuDiKem(idDichVuDiKem);
        contractDetail.setSoLuong(Integer.parseInt(soLuong));

        contractDetailBO.create(contractDetail);
        request.getRequestDispatcher("Contract/createContract.jsp").forward(request,response);
    }
}
