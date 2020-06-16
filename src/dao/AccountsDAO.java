package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JavaBeans.AccountsBeans;


public class AccountsDAO {

    // データベース接続に使用する情報

	private static String url = "jdbc:postgresql://localhost/ciot";
	private static String user = "ciot";
	private static String pass = "ciot";
    Connection con = null;
    // ログインアカウントを探す
    public AccountsBeans findAccount(AccountsBeans ab) {

        // 戻り値の用意
        AccountsBeans returnAb = new AccountsBeans();

        // データベースへ接続
        try {
        	con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB接続完了");
            String sql = "SELECT account_pass, account_id FROM accounts WHERE account_pass = ? AND account_id = ? AND delete_date IS NULL";
            PreparedStatement ps= con.prepareStatement(sql);

            System.out.println("sqr = " + sql);
           // ps.setString(1, ab.getId());
            String pass=ab.getPass();
            ps.setString(1, pass);
            
            String id = ab.getId();
            ps.setString(2, id);
           // ps.setString(4, ab.getAddress());

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
            	String p = rs.getString("account_pass");
                returnAb.setPass(p);
                String n = rs.getString("account_id");
                returnAb.setName(n);
            } else {
                // アカウントがなければnullを返す
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return returnAb;
    }
}
