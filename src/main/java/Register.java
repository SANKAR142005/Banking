import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import org.json.JSONObject;
@WebServlet("/Register")
public class Register extends HttpServlet {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder jsonInput = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonInput.append(line);
        }

        JSONObject inputJson = new JSONObject(jsonInput.toString());
        String username = inputJson.getString("username");
        String password = inputJson.getString("password");
        String email = inputJson.getString("email");
        String accountType = inputJson.getString("accountType");

        System.out.println("User Registration Details:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Account Type: " + accountType);

        JSONObject responseJson = new JSONObject(accountType);
        
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || accountType.isEmpty()) {
            responseJson.put("status", "error");
            responseJson.put("message", "All fields are required.");
        } else {
            responseJson.put("status", "success");
            responseJson.put("message", "Registration successful.");
        }

        PrintWriter out = response.getWriter();
        out.print(responseJson.toString());
        out.flush();
    }
}
