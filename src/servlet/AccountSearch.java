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

/**
 * Servlet implementation class AccountDAO2
 */
@WebServlet(name="/AccountSearch",urlPatterns= {"/AccountSearch"})
public class AccountSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	response.setContentType("text/html;charset=UTF-8");
    	String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        // login.jspから受け取ったログインIDとpassをビーンズにセット
        AccountsBeans ab = new AccountsBeans();
        ab.setId(id);
        ab.setPass(pass);

        // アカウントの有無を検索
        // 検索したアカウント情報を取得
        AccountsDAO ad = new AccountsDAO();
        AccountsBeans returnAb = ad.findAccount(ab);

        HttpSession session = request.getSession();
        if(returnAb != null) {
            // セッションにアカウント情報＆ロールを登録

            session.setAttribute("account", returnAb);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login_success.jsp");
            rd.forward(request, response);

        } else {
        	System.out.println("登録されていないユーザーです");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login_error.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request,response);
    }
}