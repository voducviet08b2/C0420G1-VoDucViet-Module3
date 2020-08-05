package controller;

import bo.StudentBO;
import bo.StudentBOImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/studentServletPath")
public class StudentServlet extends HttpServlet {
    private StudentBO studentBO = new StudentBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getParameter("actionName");

        if (actionName == null) {
            actionName = "";
        }

        switch (actionName) {
            case "create":
                createNewStudent(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1, "Tien", "2000", 7));
//        studentList.add(new Student(2, "Tien Quoc", "2005", 4));
//        studentList.add(new Student(3, "Thinh", "2005", 9));

        String actionName = request.getParameter("actionName");

        if (actionName == null) {
            actionName = "";
        }

        switch (actionName) {
            case "create":
                goCreateStudent(request, response);
                break;
            default:
                showStudentList(request, response);
                break;
        }

    }

    private void createNewStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("nameStudent");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student student = new Student();
        student.setName(name);
        student.setDateOfBirth(dateOfBirth);

        this.studentBO.save(student);

        this.showStudentList(request, response);
    }

    private void goCreateStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("actionName", "create");
        request.getRequestDispatcher("create_update.jsp").forward(request, response);
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> studentList = studentBO.findAll();

        request.setAttribute("studentListServlet", studentList);

        String inputUser = "<p style='color: red'>abc</p>";

        request.setAttribute("inputUser", inputUser);

        request.getRequestDispatcher("list.jsp").forward(request, response);
//        response.sendRedirect("list.jsp");
    }
}
