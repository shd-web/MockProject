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
import dao.AccountDeleteDAO;

/**
 * Servlet implementation class AccountDAO2
 */
@WebServlet(name="/AccountCheck",urlPatterns= {"/AccountCheck"})
public class AccountCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCheck() {
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
        AccountsBeans aabb = new AccountsBeans();
        aabb.setId(id);
        aabb.setPass(pass);

        // アカウントの有無を検索
        // 検索したアカウント情報を取得
        AccountDeleteDAO ad = new AccountDeleteDAO();
        AccountsBeans returnAabb = ad.deleteAccount(aabb);

        if(returnAabb.getId() != null) {
            // セッションにアカウント情報＆ロールを登録
            HttpSession session = request.getSession();
            session.setAttribute("account", returnAabb);


            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/delete_success.jsp");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/delete_error.jsp");
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