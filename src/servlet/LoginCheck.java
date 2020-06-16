package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBeans.AccountsBeans;
import dao.AccountsDAO;

@WebServlet(name="/LoginCheck",urlPatterns= {"/loginCheck"})
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String path = "";
    	
    	String id = (String)request.getAttribute("id");
    	String pass = (String)request.getAttribute("pass");
    	AccountsDAO bc = new AccountsDAO();
    	
    	AccountsBeans beans = new AccountsBeans();
    	beans.setId(id);
    	beans.setPass(pass);
    	
    	if(bc.findAccount(beans) != null) {
    		path = "/login_success.jsp";
    	}else {
    		path = "/login_error.jsp";
   
    	}
    	RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
    	
}

