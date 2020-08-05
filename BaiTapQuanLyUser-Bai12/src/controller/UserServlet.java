package controller;

import bo.UserBO;
import bo.UserBOimpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/userservlet")
public class UserServlet extends HttpServlet {
    private UserBO userBO = new UserBOimpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "confirmupdate":
                confirmUpdate(request,response);
                break;
            case "create":
                createUser(request,response);
                break;
            case "edit":
                updateUser(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "order":
                showListOrderBy(request,response);
                break;
            case "search":
                searchKeyword(request,response);
                break;

            default:
                showList(request,response);
                break;
        }
    }
    public void searchKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country=request.getParameter("keyword");
        List<User> listUser = userBO.searchByCountry(country);
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
    public void showListOrderBy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userBO.findAllOrderBy();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userBO.findAll();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
    public void createUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        this.userBO.save(user);
        this.showList(request,response);
    }

    public void updateUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{


        int id=Integer.parseInt(request.getParameter("id"));
        int idSearch=0;
        List<User> listUser = userBO.findAll();
        for(int i=0;i<listUser.size();i++){
            if(id==listUser.get(i).getId()){
                idSearch=i;
            }
        }
        String name=listUser.get(idSearch).getName();
        String email=listUser.get(idSearch).getEmail();
        String country=listUser.get(idSearch).getCountry();
        request.setAttribute("id",id);
        request.setAttribute("name",name);
        request.setAttribute("email",email);
        request.setAttribute("country",country);
        request.getRequestDispatcher("edit.jsp").forward(request,response);

    }

    public void confirmUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        this.userBO.update(user);
        this.showList(request,response);
    }

    public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        //int idList=id-1;
        int idSearch=0;
        List<User> listUser = userBO.findAll();
        for(int i=0;i<listUser.size();i++){
          if(id==listUser.get(i).getId()){
              id=i;
          }
        }
        User user=listUser.get(id);
        this.userBO.delete(user);
        this.showList(request,response);
    }
}
