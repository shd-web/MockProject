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
	    	String path = "/WEB-INF/my_page.jsp";
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
	        String id = request.getParameter("id");
	        String pass = request.getParameter("pass");
	        System.out.println(1);
	        // login.jspから受け取ったログインIDとpassをビーンズにセット
	        AccountsBeans ab = new AccountsBeans();
	        ab.setId(id);
	        ab.setPass(pass);

	        // アカウントの有無を検索
	        // 検索したアカウント情報を取得
	        AccountsDAO ad = new AccountsDAO();
	        AccountsBeans returnAb = ad.findAccount(ab);
	        if(returnAb != null) {
	            // セッションにアカウント情報＆ロールを登録
	            System.out.println("MyAccountCheck実行");
	        } else {
	        	System.out.println("エラー");
	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login_error.jsp");
	            rd.forward(request, response);
	        }
	    }
	}