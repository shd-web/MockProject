package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JavaBeans.AccountsBeans;


public class AccountsDAO {

    // データベース接続に使用する情報
    final String user = "ciot";
    final String password = "ciot";
    final String url = "jdbc:postgresql://localhost/ciot";
    Connection con = null;
    // ログインアカウントを探す
    public AccountsBeans findAccount(AccountsBeans ab) {

        // 戻り値の用意
        AccountsBeans returnAb = new AccountsBeans();

        // データベースへ接続
        try {
        	con = DriverManager.getConnection(url,user,password);

            String sql = "SELECT accountId, accountPass, accountName, roleId FROM account WHERE account_name = ? AND accountPass = ?";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, ab.getAccoutId());
            ps.setString(2, ab.getPass());

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
                returnAb.setAccountId(rs.getString("AccountId"));
                returnAb.setPass(rs.getString("pass"));
                returnAb.setName(rs.getString("name"));
                returnAb.setRole(rs.getInt("roleId"));
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
