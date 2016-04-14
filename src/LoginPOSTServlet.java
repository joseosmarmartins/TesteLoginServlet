import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginPostServlet",
        urlPatterns = "/LoginPostServlet")
public class LoginPOSTServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login Post Servlet </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Login Post </h1>");
        out.println("<form method='post' action='LoginPostServlet'>");
        out.println("<label>Nome:</label>");
        out.println("<input type='text' value='' name='user'>");
        out.println("<label>Senha:</label>");
        out.println("<input type='password' value='' name='senha'>");
        out.println("<input type='submit' value='Enviar'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");

        if ((user != null && !user.isEmpty()) && (senha != null && !senha.isEmpty())) {
            RequestDispatcher rd = request.getRequestDispatcher("/LoginOkPost");
            rd.include(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/LoginErrorPost");
            rd.include(request, response);
        }
    }
}
