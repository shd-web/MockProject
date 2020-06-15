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
import dto.CartDTO;

/**
 * Servlet implementation class CartControlServlet
 */
@WebServlet(urlPatterns = {"/cart"})
public class CartControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		CartDAO cartDao = new CartDAO();
		int countCart = cartDao.cartCount();
		session.setAttribute("countCart", countCart);
		//カートに商品が入っているとき
		if(countCart != 0) {

			List<CartDTO> cartList = new ArrayList<CartDTO>();
			cartList = cartDao.cartDto();


			session.setAttribute("cartList", cartList);

			int sum = 0;
			for(CartDTO cartDto : cartList) {
				sum += cartDto.getPrice() * cartDto.getQuantity();
			}
			//金額の合計をsessionに登録
			session.setAttribute("sum", sum);
		}


		//相対パス指定
		String path = "/WEB-INF/cart.jsp";
		//RequestDispatcherオブジェクトの取得
		RequestDispatcher rd = request.getRequestDispatcher(path);
		//指定したpathにフォワード（転送）
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
