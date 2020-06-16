package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import util.QuantityTuple;

public class HistoryDAO {

	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";


	private static String INSERTPURCHASEHISTORY =
			"INSERT INTO history (account_id, other_address, purchase_date) VALUES (?, ?, ?); ";
	private static String GETHISTORYID =
			"SELECT max(history_id) FROM history WHERE account_id = ?;";

	private static String INSERTPURCHASEITEMS =
			"INSERT INTO history_items (history_id, item_id, quantity) VALUES (?, ?, ?);";

	private static String CHANGESTOCK =
			"UPDATE items_stock SET stock = stock - ?, update_date = ? WHERE item_id = ?;";

	private Connection conn = null;

	/*
	 * 履歴テーブルにアカウントIDと配送住所を追加するメソッド
	 */
	public boolean insertPurchaseHistory(List<QuantityTuple> quantityList,String accountId, String shippingAddress) {

		int historyId = -1;
		boolean isSuccess = false;
		try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");
			conn.setAutoCommit(false);

			try{

				PreparedStatement ps = conn.prepareStatement(INSERTPURCHASEHISTORY);
				java.util.Date utilDate = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				ps.setString(1, accountId);
				ps.setString(2, shippingAddress);
				ps.setDate(3, sqlDate);
				int result = ps.executeUpdate();
				if(result > 0) System.out.println("履歴テーブルへの挿入成功！");
				else System.out.println("履歴テーブルへの挿入失敗...");

				//history_idの取得
				ps = conn.prepareStatement(GETHISTORYID);
				ps.setString(1, accountId);
				ResultSet rs = ps.executeQuery();
				if(rs != null && rs.next()) {
					historyId = rs.getInt(1);
					System.out.println("HistoryIdの取得が成功！　HistoryId :"+ historyId);
				}
				else System.out.println("HistoryIdが取得できませんでした。");

				int result2 = 0, result3 = 0;
				for(QuantityTuple quantityTuple: quantityList) {
					System.out.println("一つ目の商品の数量："+quantityList.get(0).quantity);
					//履歴商品テーブルに商品IDと数量を追加
					ps = conn.prepareStatement(INSERTPURCHASEITEMS);
					ps.setInt(1, historyId);
					ps.setInt(2, quantityTuple.itemId);
					ps.setInt(3, quantityTuple.quantity);
					result2 = ps.executeUpdate();
					if(result2 > 0) System.out.println("履歴商品テーブルへの挿入成功！");
					else System.out.println("履歴商品テーブルへの挿入失敗...");
					//---------------------------------------------------------

					//在庫テーブルの在庫を取得し、購入数の分減らしてUPDATE
					ps = conn.prepareStatement(CHANGESTOCK);
					ps.setInt(1, quantityTuple.quantity);
					ps.setDate(2, sqlDate);
					ps.setInt(3, quantityTuple.itemId);
					result3 = ps.executeUpdate();
					if(result3 > 0) System.out.println("在庫テーブルの更新成功！");
					else System.out.println("在庫テーブルの更新失敗...");

				}

				if(result > 0 && result2 > 0 && result3 > 0) isSuccess = true;

				conn.commit();

			}catch(SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
					System.out.println("コミット失敗");
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
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
		return isSuccess;
	}


}
