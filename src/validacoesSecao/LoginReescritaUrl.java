package validacoesSecao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginReescritaUrl")
public class LoginReescritaUrl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendLoginForm(response, false);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = 	request.getParameter("user");
        String senha = request.getParameter("pass");

        if(login(nome,senha)){
            response.sendRedirect("/LoginOkGET?user=" + nome + "&pass=" + senha);
        }else{
            sendLoginForm(response, true);
        }
    }

    private boolean login(String user, String pass){
        return user.equals("jose") && pass.equals("123456");
    }

    private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Login Form</h1>");

        if(withErrorMessage)
            out.println("<h2 style='color: red'>Login Failed. Please try again. <br></h2>");

        out.println("<form method='post' action='LoginReescritaUrl'>");
        out.println("Nome Usu�rio:");
        out.println("<input type='text' name='user'/> <br>");
        out.println("Senha: ");
        out.println("<input type='password' name='pass'/>");
        out.println("<input type='submit' value='Enviar'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}