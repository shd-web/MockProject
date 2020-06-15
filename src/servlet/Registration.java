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


/**
 * Servlet implementation class AccountRegister
 */
@WebServlet(name="/Registration", urlPatterns= {"/registration"})
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String path = "/registration.jsp";
    	// --↓Debug Print06_03 Add ------
    	System.out.println("doGet;path = " + path);
    	// --↑Debug Print06_03 Add ------

    	RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String accountId = request.getParameter("accountId");
        String pass = request.getParameter("pass");

        // register.jspから受け取った値をビーンズにセット
        AccountsBeans ab = new AccountsBeans();
        ab.setName(name);
        ab.setAccountId(accountId);
        ab.setPass(pass);

        // アカウントをDBに登録
        // セッションにアカウント情報を保存
        HttpSession session = request.getSession();
        session.setAttribute("account", ab);

        RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
        rd.forward(request, response);

    }

}
