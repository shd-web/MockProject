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


/**
 * Servlet implementation class MyPageDeleteControlServlet
 */
@WebServlet(name="/MyPageDeleteControlServlet",urlPatterns= {"/delete"})
public class MyPageDeleteControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String path = "/WEB-INF/delete.jsp";
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