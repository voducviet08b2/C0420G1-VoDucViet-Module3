package controller;

import bo.ServiceBO;
import bo.ServiceBOimp;
import dao.TypeRentDAO;
import dao.TypeRentDAOimp;
import dao.TypeServiceDAO;
import dao.TypeServiceDAOimp;
import model.Service;
import model.TypeRent;
import model.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/serviceServlet")
public class ServiceServlet extends HttpServlet {
    private TypeRentDAO typeRentDAO =new TypeRentDAOimp();
    private TypeServiceDAO typeServiceDAO =new TypeServiceDAOimp();
    private ServiceBO serviceBO=new ServiceBOimp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TypeRent> typeRentList=typeRentDAO.findAll();
        List<TypeService> typeServiceList=typeServiceDAO.findAll();
        request.setAttribute("typeRentList",typeRentList);
        request.setAttribute("typeServiceList",typeServiceList);
        request.getRequestDispatcher("Service/createService.jsp").forward(request,response);
        String action=request.getParameter("action");
        if(action.equals("confirmCreate")){
            confirmCreate(request,response);
        }
    }
    public void confirmCreate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String tenDichVu=request.getParameter("tenDichVu");
        String dienTich=request.getParameter("dienTich");
        String soTang=request.getParameter("soTang");
        String soNguoiToiDa=request.getParameter("soNguoiToiDa");
        String chiPhiThue=request.getParameter("chiPhiThue");
        String trangThai=request.getParameter("trangThai");
        String idKieuThue=request.getParameter("idKieuThue");
        String idLoaiDichVu=request.getParameter("idLoaiDichVu");
        Service service=new Service();
        service.setTenDichVu(tenDichVu);
        service.setDienTich(dienTich);
        service.setSoTang(soTang);
        service.setSoNguoiToiDa(Integer.parseInt(soNguoiToiDa));
        service.setChiPhiThue(Integer.parseInt(chiPhiThue));
        service.setTrangThai(trangThai);
        service.setIdKieuThue(idKieuThue);
        service.setIdLoaiDichVu(idLoaiDichVu);
        serviceBO.create(service);

    }
}
