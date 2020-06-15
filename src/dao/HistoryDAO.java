package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.QuantityTuple;
import util.StockTuple;


public class HistoryDAO {

	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";

	private static String INSERTPURCHASEHISTORY =
			"INSERT INTO history (item_id, purchase_date) VALUES (?, ?)";

	private static String GETSTOCK =
			"SELECT stock FROM items_stock WHERE item_id = ?";

	private static String CHANGESTOCK =
			"UPDATE items_stock SET stock = ? WHERE item_id = ?";

	private Connection conn = null;

	public void insertHistory(List<QuantityTuple> quantityList){

		try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");


			try{
				//履歴テーブルに履歴を追加------履歴テーブルのitem_idをリストにしたら再確認
				for(QuantityTuple quantityTuple: quantityList) {
					PreparedStatement ps = conn.prepareStatement(INSERTPURCHASEHISTORY);
					java.util.Date utilDate = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					ps.setInt(1, quantityTuple.itemId);
					ps.setDate(2, sqlDate);
					ps.executeUpdate();
					//---------------------------------------------------------

					//在庫テーブルの在庫を取得し、購入数の分減らしてUPDATE
					ps = conn.prepareStatement(GETSTOCK);
					ps.setInt(1, quantityTuple.itemId);
					ResultSet rs = ps.executeQuery();
					List<StockTuple> stockList = new ArrayList<StockTuple>();
					while(rs.next()) {
						StockTuple stockTuple = new StockTuple();
						stockTuple.stock = rs.getInt(1);
					}

					ps = conn.prepareStatement(CHANGESTOCK);
					ps.setInt(1, quantityTuple.quantity);
					ps.setInt(2, quantityTuple.itemId);
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
