package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ItemsDTO;

public class ItemsDAO {

	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";

	private static String GETITEMDETAIL =
			"SELECT t1.item_id, t1.item_name, t3.category_name, t2.color_name, t1.price, t1.manufacture, t4.stock FROM items t1\r\n" +
			"INNER JOIN colors t2 ON t1.color_id = t2.color_id \r\n" +
			"INNER JOIN categories t3 ON t1.category_id = t3.category_id" +
			"INNER JOIN items_stock t4 ON t1.item_id = t4.ite_id  WHERE t1.item_id = ?;";

	private Connection conn = null;

	/*
	 * 商品詳細を取得するメソッド
	 */
	public ItemsDTO getItemDetail(int itemId) {

		ItemsDTO itemsDto = new ItemsDTO();

		try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");


			try{
				PreparedStatement ps = conn.prepareStatement(GETITEMDETAIL);
				ps.setInt(1, itemId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					itemsDto.setItemName(rs.getString(2));
					itemsDto.setCategoryName(rs.getString(3));
					itemsDto.setColorName(rs.getString(4));
					itemsDto.setPrice(rs.getInt(5));
					itemsDto.setManufacture(rs.getString(6));
					itemsDto.setStock(rs.getInt(7));
				}

			}catch(SQLException e) {
					e.printStackTrace();
			}


		}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("DB接続エラー");
		}finally {
			try{
				if(conn!=null && !conn.isClosed()) {
				conn.close();
				System.out.println("DB切断完了");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}


		return itemsDto;
	}

	public List<ItemsDTO> GetItemsTable() {
		List<ItemsDTO> list = new ArrayList<>();

		try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");


			try{

				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Items");
				ResultSet rs = ps.executeQuery();
				List<ItemsDTO> itemList = new ArrayList<ItemsDTO>();
				while (rs.next()){
					ItemsDTO itemsDto =new ItemsDTO();

					//itemsテーブルのすべての行を格納（①）
					int itemId = rs.getInt("item_Id");
					itemsDto.setItemId(itemId);

					String itemName = rs.getString("item_Name");
					itemsDto.setItemName(itemName);

					int categoryId = rs.getInt("category_Id");
					itemsDto.setCategoryId(categoryId);

					int colorId = rs.getInt("color_Id");
					itemsDto.setColorId(colorId);

					String manufacture = rs.getString("manufacture");
					itemsDto.setManufacture(manufacture);

					int price = rs.getInt("price");
					itemsDto.setPrice(price);

					//変換するItemsDTOのリスト作成（②）＊
					itemList.add(itemsDto);
				}
				System.out.println(itemList.get(0).getItemName());

			}catch(SQLException e) {
					e.printStackTrace();
			}


		}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("DB接続エラー");
		}finally {
			try{
				if(conn!=null && !conn.isClosed()) {
				conn.close();
				System.out.println("DB切断完了");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}

		}



		//③をリターン　＊

		return list;
	}
}
