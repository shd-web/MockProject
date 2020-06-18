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
import dao.OrderDAO;
import dto.CartDTO;
import dto.OrderDTO;
import util.QuantityTuple;

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

		/**
		 * 注文商品の数量と商品IDを取得し、QuantityTuple型リストにする。
		 * 数量が：
		 * 正常→選択された数字
		 * 異常→-1
		 */
		int numOfItems = Integer.parseInt(request.getParameter("numOfItems"));
		String[] quantityString = (String[])request.getParameterValues("quantity");
		List<QuantityTuple> changeQuantityList = new ArrayList<QuantityTuple>();

		for(int i = 0; i < quantityString.length; i++) {
			QuantityTuple intTuple = new QuantityTuple();
			int quantity = Integer.parseInt(quantityString[i]);
			String itemIdString = request.getParameter("itemId" + (i+1));
			int itemId = Integer.parseInt(itemIdString);
			intTuple.quantity = quantity;
			intTuple.itemId = itemId;
			changeQuantityList.add(intTuple);
			System.out.println(intTuple.quantity);
		}


		//DBのカートテーブルの数量を修正、修正後のカート取得、セッションに登録
		HttpSession session = request.getSession();
		CartDAO cartDao = new CartDAO();
		List<CartDTO> cartList = new ArrayList<CartDTO>();
		cartDao.cartChange(changeQuantityList);
		cartList =  cartDao.cartDto();

		session.setAttribute("cartList", cartList);

		//セッションのアカウントIDを使ってDBから購入者の名前と住所を取得
		OrderDAO orderDao = new OrderDAO();
		OrderDTO orderDto= new OrderDTO();
		orderDto = orderDao.accountDto((String)session.getAttribute("accountId"));

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
