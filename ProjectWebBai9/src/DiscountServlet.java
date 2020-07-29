import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet",urlPatterns = "/discountServlet")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description=request.getParameter("description");
        String price=request.getParameter("price");
        String discount=request.getParameter("discount");
        double discountAmount=Double.parseDouble(price)*Double.parseDouble(discount)*0.01;
        request.setAttribute("resultServlet",discountAmount);
        request.setAttribute("priceServlet",price);
        request.setAttribute("discountServlet",discount);
        request.setAttribute("desServlet",description);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
