package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JavaBeans.AccountsBeans;

public class AccountRegisterDAO {
	// データベース接続に使用する情報
	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";
	Connection con = null;

	// ログインアカウントを探す
	public boolean regAccount(AccountsBeans ra) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");
			String sql = "INSERT INTO accounts (account_id, account_pass, account_name, address,record_date) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement ps= con.prepareStatement(sql);

			ps.setString(1, ra.getId());
			ps.setString(2, ra.getPass());
			ps.setString(3, ra.getName());
			ps.setString(4, ra.getAddress());
			Date dt = new Date(new java.util.Date().getTime());
			ps.setDate(5, dt);
			System.out.println("sql="+sql);
			int r = ps.executeUpdate();
                System.out.println(r+"件新規登録成功！");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
}
