package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBeans.AccountsBeans;
import dao.AccountsDAO;


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
	        // TODO Auto-generated method stub
	    	String path = "/my_page.jsp";
	    	// --↓Debug Print06_03 Add ------
	    	System.out.println("doGet;path = " + path);
	    	// --↑Debug Print06_03 Add ------

	    	RequestDispatcher rd = request.getRequestDispatcher(path);
	        rd.forward(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost1(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        String name = request.getParameter("name");
	        String pass = request.getParameter("pass");
	        System.out.println(1);
	        // login.jspから受け取ったログインIDとpassをビーンズにセット
	        AccountsBeans ab = new AccountsBeans();
	        ab.setName(name);
	        ab.setPass(pass);

	        // アカウントの有無を検索
	        // 検索したアカウント情報を取得
	        AccountsDAO ad = new AccountsDAO();
	        AccountsBeans returnAb = ad.findAccount(ab);
	        System.out.println(2);
	        if(returnAb != null) {
	            // セッションにアカウント情報＆ロールを登録
	            HttpSession session = request.getSession();
	            session.setAttribute("account", returnAb);

	            RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
	            rd.forward(request, response);

	        } else {
	            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
	            rd.forward(request, response);
	        }
	    }
	}
