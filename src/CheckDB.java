import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CartDTO;

public class CheckDB {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String url = "jdbc:postgresql://localhost/ciot";
		String user = "ciot";
		String pass = "ciot";
		Connection conn = null;

		//ここを変える
		String GETCART=
				"SELECT t2.stock, t3.item_name, t4.color_name, t3.manufacture, t3.price, t2.item_id FROM cart t1 \r\n" +
				"INNER JOIN items_stock t2 ON t1.item_id = t2.item_id\r\n" +
				"INNER JOIN items t3 ON t1.item_id = t3.item_id\r\n" +
				"INNER JOIN colors t4 ON t4.color_id= t1.color_id;";


		List<CartDTO> cartList = new ArrayList<CartDTO>();

		try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");


			try(PreparedStatement ps = conn.prepareStatement(GETCART)){
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {

					//ここから変える
					CartDTO cart = new CartDTO();
					cart.setStock(rs.getInt(1));
					cart.setItemName(rs.getString(2));
					cart.setColorName(rs.getString(3));
					cart.setManufacturer(rs.getString(4));
					cart.setPrice(rs.getInt(5));
					cart.setItemId(rs.getInt(6));
					cartList.add(cart);
					//ここまで変える

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
	}

}
