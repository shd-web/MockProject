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
import dao.AccountRegisterDAO;

/**
 * Servlet implementation class AccountDAO2
 */
@WebServlet(name="/RegistrationTry",urlPatterns= {"/RegistrationTry"})
public class RegistrationTry extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationTry() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	response.setContentType("text/html;charset=UTF-8");
    	String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String address = request.getParameter("address");
        String id = request.getParameter("id");

        // login.jspから受け取ったログインIDとpassをビーンズにセット
        AccountsBeans ab = new AccountsBeans();
        ab.setName(name);
        ab.setPass(pass);
        ab.setAddress(address);
        ab.setId(id);

        // アカウントの有無を検索
        // 検索したアカウント情報を取得
        AccountRegisterDAO rg = new AccountRegisterDAO();
        boolean returnRA = rg.regAccount(ab);

        if(returnRA == true) {
            // セッションにアカウント情報＆ロールを登録
            HttpSession session = request.getSession();
            session.setAttribute("account", returnRA);

            RequestDispatcher rd = request.getRequestDispatcher("registration_success.jsp");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("registration_error.jsp");
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