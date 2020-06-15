package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMain
 */
@WebServlet(name="/RegistrationControlServlet",urlPatterns= {"/registration"})
public class RegistrationControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String path = "registration.jsp";
    	// --↓Debug Print06_03 Add ------
    	System.out.println("doGet;path = " + path);
    	// --↑Debug Print06_03 Add ------

    	RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request,response);
    }
}

