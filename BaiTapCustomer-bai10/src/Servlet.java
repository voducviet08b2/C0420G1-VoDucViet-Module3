import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns="/Customer_index")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        Customer cus1 = new Customer("Huỳnh Lê Phước Trí","1989-11-12", "Huế",".\\img\\tri.jpg");
        Customer cus2 = new Customer("Vũ Lê Tường","1989-07-24", "Quảng Nam",".\\img\\tuong.jpg");
        Customer cus3 = new Customer("Nguyễn Hoàng Hưng","1990-04-30", "Quảng Ngãi",".\\img\\hung.jpg");
        Customer cus4 = new Customer("Dụng Văn Kiện","1990-08-20", "Huế",".\\img\\kien.jpg");
        Customer cus5 = new Customer("Phạm Thanh Hiếu","1990-11-20", "Huế",".\\img\\hieu.jpg");
        Customer cus6 = new Customer("Lương Hữu Phước","1989-08-20", "Quảng Nam",".\\img\\phuoc.jpg");
        customerList.add(cus1);
        customerList.add(cus2);
        customerList.add(cus3);
        customerList.add(cus4);
        customerList.add(cus5);
        customerList.add(cus6);
        request.setAttribute("listCustomer",customerList);
        request.getRequestDispatcher("showCustomerList.jsp").forward(request,response);
    }
}
