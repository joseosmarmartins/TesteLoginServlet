import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginGETServlet")
public class LoginGETServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login GET Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Login GET Servlet</h1>");
        out.println("<form method='post' action='LoginGETServlet'>");

        out.println("<label>User:</label>");
        out.println("<input type='text' name='user'/>");

        out.println("<br>");
        out.println("<br>");

        out.println("<label>Pass:</label>");
        out.println("<input type='password' name='pass'/>");

        out.println("<input type='submit' value='Enviar'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user");
        String senha = req.getParameter("pass");

        if ((login != null && !login.isEmpty()) && (senha != null && !senha.isEmpty())) {
            resp.sendRedirect("/LoginOkGET?user=" + login + "&pass=" + senha);
        } else {
            resp.sendRedirect("/LoginErroGET");
        }
    }
}
