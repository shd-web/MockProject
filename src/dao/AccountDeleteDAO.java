package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JavaBeans.AccountsBeans;

public class AccountDeleteDAO {

	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";
    Connection con = null;
    // ログインアカウントを探す
    public AccountsBeans deleteAccount(AccountsBeans aabb) {

        // 戻り値の用意
        AccountsBeans returnAabb = new AccountsBeans();

        // データベースへ接続
        try {
        	con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");
            String sql = "UPDATE accounts SET delete_date=CURRENT_DATE WHERE account_id=? AND account_pass=?";
            PreparedStatement ps= con.prepareStatement(sql);
            
            System.out.println("sqr = " + sql);
            //ps.setString(1, aabb.getId());
            String id=aabb.getId();
            ps.setString(1, id);

            String pass=aabb.getPass();
            ps.setString(2, pass);
            //ps.setString(4, aabb.getAddress());

            int rs = ps.executeUpdate();
            System.out.println(rs+"件削除成功");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return returnAabb;
    }
}


