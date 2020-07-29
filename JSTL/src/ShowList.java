import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
@WebServlet(name = "ShowList",urlPatterns = "/showList")
public class ShowList extends HttpServlet {
    private static String URL="http://www.nettruyen.com";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listStudent=new ArrayList<>();
        Student student1=new Student(1,"Viet","12/01/1923");
        Student student2=new Student(2,"Tuong","13/2/1992");
        listStudent.add(student1);
        listStudent.add(student2);

        request.setAttribute("listStudent",listStudent);
        request.setAttribute("test",student1.getTitleHTML());
        request.getRequestDispatcher("showlist.jsp").forward(request,response);
    }

}
