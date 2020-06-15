package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HistoryDAO;
import dto.CartDTO;
import util.QuantityTuple;

/**
 * Servlet implementation class PurchaseCompleteServlet
 */
@WebServlet(urlPatterns = {"/purchaseComplete"})
public class PurchaseCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションからカートリストを取得し、数量と商品IDをIntTuple型のリストに格納
		HttpSession session = request.getSession();
		List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");

		List<QuantityTuple> quantityList = new ArrayList<QuantityTuple>();
		for(CartDTO cart : cartList) {
			QuantityTuple quantityTuple = new QuantityTuple();
			quantityTuple.quantity = cart.getQuantity();
			quantityTuple.itemId = cart.getItemId();
		}
		//履歴テーブルに行を追加
		HistoryDAO historyDao = new HistoryDAO();
		historyDao.insertHistory(quantityList);

		String path = "/WEB-INF/purchase_complete.jsp";	//相対パス指定
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
