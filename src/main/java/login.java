import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class login extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple hardcoded authentication (replace with DB check)
        if ("sri".equals(username) && "varsh".equals(password)) {
            response.sendRedirect("index.html"); // Redirect to registration page
        } else {
            response.getWriter().println("<h3>Invalid credentials! Try again.</h3>");
        }
    }
}
