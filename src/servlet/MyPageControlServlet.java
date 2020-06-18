package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


	@WebServlet(name= "/MyPageControlServlet", urlPatterns= {"/myPage"})
	public class MyPageControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;


	    public MyPageControlServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
	     * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	String path = "/WEB-INF/my_page_detail.jsp";
	    	RequestDispatcher rd = request.getRequestDispatcher(path);
	        rd.forward(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost1(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	doGet(request, response);
	    }
	}