package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemDetailControlServlet
 */
@WebServlet(name = "/ItemDetailControlServlet", urlPatterns = {"/itemDetail"})
public class ItemDetailControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemIdString = request.getParameter("itemId");
		int itemId = 0;
		if(itemIdString != null) itemId = Integer.parseInt(itemIdString);
		else System.out.println("itemIdStringはnullです。");
		request.setAttribute("itemId", itemId);

		String path = "/WEB-INF/item_detail.jsp";	//相対パス指定
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
