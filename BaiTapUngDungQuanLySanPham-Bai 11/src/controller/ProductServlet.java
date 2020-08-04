package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //listProducts(request, response);
        String action=request.getParameter("action");
        if(action=="null"){
            action="";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "view":
                break;
            case "a":
                listProducts(request, response);
                break;

        }
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createProduct.jsp").forward(request,response);
    }
    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
