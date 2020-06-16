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

import dao.CartDAO;
import dao.HistoryDAO;
import dto.CartDTO;
import dto.HistoryDTO;
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

		HttpSession session = request.getSession();

		//セッションからアカウントID、配送先住所を取得
		HistoryDAO historyDao = new HistoryDAO();
		HistoryDTO historyDto = new HistoryDTO();
		String shippingAddress = (String)request.getAttribute("shippingAddress");
		String accountId = (String)session.getAttribute("accountId");

		//セッションからカートリストを取得し数量と商品IDをQuantityTuple型のリストに格納
		List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");
		List<QuantityTuple> quantityList = new ArrayList<QuantityTuple>();
		for(CartDTO cart : cartList) {
			QuantityTuple quantityTuple = new QuantityTuple();
			quantityTuple.quantity = cart.getQuantity();
			quantityTuple.itemId = cart.getItemId();
			quantityList.add(quantityTuple);
		}

		//履歴テーブル、履歴商品テーブルに行挿入、在庫テーブルを更新
		//成功したらセッションからカートを削除
		boolean isSuccess
			= historyDao.insertPurchaseHistory(quantityList, accountId, shippingAddress);
		System.out.println("isSuccess:"+isSuccess);
		if(isSuccess) {
			CartDAO cartDao = new CartDAO();
			cartDao.deleteCartAll();
			session.removeAttribute("cartList");
		}

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
