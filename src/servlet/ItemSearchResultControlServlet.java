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

import dao.ItemsDAO;
import dto.ItemsDTO;

/**
 * Servlet implementation class ItemSearchResultControlServlet
 */
@WebServlet(name = "ItemSearchResultServ", urlPatterns = {"/item_search_result"})
public class ItemSearchResultControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSearchResultControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return
	 * @return
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		//String keyword = request.getParameter("keyword");

		//itemsテーブルのリストを作成
		List<ItemsDTO> itemList1 = new ArrayList<ItemsDTO>();
		ItemsDAO itemsDao = new ItemsDAO();

		//itemList1にitemsDaoで作成したものを代入
		itemList1 = itemsDao.GetItemsTable();

		System.out.println(itemList1.get(0));

		List<ItemsDTO> itemList2 = new ArrayList<ItemsDTO>();

		for(ItemsDTO item: itemList1) {
			String str = item.getItemName();
			if(str.contains("スニーカー")) {
				itemList2.add(item);
			}
		}
		request.setAttribute("itemList2", itemList2);


		String path = "/WEB-INF/item_search_result.jsp" ;
		RequestDispatcher rd=request.getRequestDispatcher(path);
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
