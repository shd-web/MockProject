package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.OrderDTO;

public class OrderDAO {

	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";

	private static String GETACCOUNT =
			"SELECT account_id, account_name, address FROM accounts WHERE account_id = ?";

	private Connection conn = null;

	public OrderDTO accountDto(int accountId) {

		OrderDTO orderDto = new OrderDTO();

		try{
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");


			try{
				PreparedStatement ps = conn.prepareStatement(GETACCOUNT);
				ps.setInt(1, accountId);
				ResultSet rs = ps.executeQuery();

				//DBのすべての行を読み、リストに格納
				if(rs.next()) {
					orderDto.setAccountId(rs.getInt(1));
					orderDto.setAccountName(rs.getString(2));
					orderDto.setAddress(rs.getString(3));
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

		return orderDto;
	}
}
