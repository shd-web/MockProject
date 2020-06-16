package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CartDTO;
import util.QuantityTuple;

public class CartDAO {

	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";
	//カート画面には、CartテーブルのitemIdと一致する商品名(Itemsテーブル)、
	//色(Colorsテーブル)、写真、製造者(Itemsテーブル)、値段(Itemsテーブル)、
	//在庫(Items_stockテーブル)、数量(遷移元のページから送信されたもの)が必要
	 private static String GETCART=
			"SELECT t2.stock, t3.item_name, t4.color_name, t3.manufacture, t3.price, t2.item_id, t1.quantity FROM cart t1 \r\n" +
			"INNER JOIN items_stock t2 ON t1.item_id = t2.item_id\r\n" +
			"INNER JOIN items t3 ON t1.item_id = t3.item_id\r\n" +
			"INNER JOIN colors t4 ON t4.color_id= t1.color_id;";

	 private static String COUNTCART = "SELECT COUNT(*) FROM cart;";

	 private static String DELETEFROMCART = "DELETE FROM cart WHERE item_id = ?";

	 private static String DELETECARTALL =
			 "DELETE FROM cart;";

	 private static String CHANGECART = "UPDATE cart SET quantity = ? WHERE item_id = ?";

	 private static String INSERTCART= "INSERT INTO cart (item_id, color_id, quantity) VALUES (?, ?, ?)";

	 private Connection conn = null;


	 /*
	  * cartテーブルの行数を取得するメソッド
	  * 戻り値：cartテーブルの行数
	  */
	 public int cartCount() {

		 int countCart = -1;


		 try{
			 	//DBに接続
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("DB接続完了");

				//sql実行
				try(PreparedStatement ps = conn.prepareStatement(COUNTCART)){
					ResultSet rs = ps.executeQuery();

					//行数を読み込む
					if(rs.next()) {
						countCart = rs.getInt(1);
						System.out.println("count in DAO: "+countCart);
					}
				}catch(SQLException e) {
						e.printStackTrace();
				}
		//DB接続エラー
		 }catch(SQLException e) {
				e.printStackTrace();
				System.out.println("DB接続エラー");
		}finally {
			try{
				//DB切断
				if(conn!=null && !conn.isClosed()) {
				conn.close();
				System.out.println("DB切断完了");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return countCart;
	 }


	 /*
	  * cartテーブルの内容を取得するメソッド
	  * 戻り値：CartDTO
	  */
	 public List<CartDTO> cartDto() {


		List<CartDTO> cartList = new ArrayList<CartDTO>();

		try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");


			try(PreparedStatement ps = conn.prepareStatement(GETCART)){
				ResultSet rs = ps.executeQuery();

				//DBのすべての行を読み、リストに格納
				while(rs.next()) {
					CartDTO cart = new CartDTO(); //これは必ずwhileの中に書く！
					cart.setStock(rs.getInt(1));
					cart.setItemName(rs.getString(2));
					cart.setColorName(rs.getString(3));
					cart.setManufacturer(rs.getString(4));
					cart.setPrice(rs.getInt(5));
					cart.setItemId(rs.getInt(6));
					cart.setQuantity(rs.getInt(7));
					cartList.add(cart);
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
		return cartList;
	}

	 /*
	  * cartテーブルから一行削除するメソッド
	  */
	 public void cartDelete(int deletePlace) {

		try{
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("DB接続完了");

				try{
					PreparedStatement ps = conn.prepareStatement(DELETEFROMCART);
					ps.setInt(1, deletePlace);
					int result = ps.executeUpdate();
					if(result >0) System.out.println("カート内の商品の削除が成功しました。");
					else System.out.println("カート内の商品の削除が失敗しました。");

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

	 /*
	  * カートテーブルからすべての行を削除するメソッド
	  */
	 public void deleteCartAll() {

		 try{
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("DB接続完了");

				try{
					PreparedStatement ps = conn.prepareStatement(DELETECARTALL);
					int result = ps.executeUpdate();
					if(result >0) System.out.println("カート内のすべての商品の削除が成功しました。");
					else System.out.println("カート内のすべての商品の削除が失敗しました。");

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

	/**
	 * カート内の商品の数量を変更するメソッド
	 */
	 public void cartChange(List<QuantityTuple> changeQuantityList) {

		 try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");

			try{
				for(QuantityTuple intTuple : changeQuantityList) {
					PreparedStatement ps = conn.prepareStatement(CHANGECART);
					ps.setInt(1, intTuple.quantity);
					ps.setInt(2, intTuple.itemId);
					int result = ps.executeUpdate();
					if(result >0) System.out.println("カート内の商品の数量の変更が成功しました。");
					else System.out.println("カート内の商品の数量を変更が失敗しました。");
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

	 public boolean Insert(int itemId, int colorId, int quantity) {
		 boolean result = false;
		 try{
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("DB接続完了");

				try{
					 PreparedStatement ps = conn.prepareStatement(INSERTCART);
					 ps.setInt(1, itemId);
					 ps.setInt(2, colorId);
					 ps.setInt(3, quantity);
					 int resultInt = ps.executeUpdate();
					 if(resultInt >0) result = true;

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


		 return result;
	 }

}
