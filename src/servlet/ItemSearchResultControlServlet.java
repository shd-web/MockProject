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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/WEB-INF/item_search_result.jsp" ;
		List<ItemsDTO> itemList = new ArrayList<ItemsDTO>();
		ItemsDTO item1 = new ItemsDTO();
				item1.setItemId(1);
		ItemsDTO item2 = new ItemsDTO();
				item2.setColorId(1);
		ItemsDTO item3 = new ItemsDTO();
				item3.setManufacture(2);
		ItemsDTO item4 = new ItemsDTO();
				item4.setPrice(100);
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		request.setAttribute("myList", itemList);
		RequestDispatcher rd = request.getRequestDispatcher(path);
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
