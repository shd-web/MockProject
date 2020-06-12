package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import dto.OrderDTO;

/**
 * Servlet implementation class CartControlServlet
 */
@WebServlet(urlPatterns = {"/purchase"})
public class PurchaseControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//セッションのアカウントIDを使ってDBから購入者の名前と住所を取得
		HttpSession session= request.getSession();
		//中根さんの方と結合するまで適当にaccountIdをセッションに登録-----
		session.setAttribute("accountId", 2);
		session.setAttribute("accountName", "安藤　志帆");
		//----------------------------------------------------------------
		OrderDAO orderDao = new OrderDAO();
		OrderDTO orderDto= new OrderDTO();
		orderDto = orderDao.accountDto((int)session.getAttribute("accountId"));

		String path = "/WEB-INF/purchase.jsp";	//相対パス指定
		request.setAttribute("shippingAddress", orderDto.getAddress());
		//RequestDispatcherオブジェクトの取得
		RequestDispatcher rd = request.getRequestDispatcher(path);
		//指定したpathにフォワード（転送）
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
