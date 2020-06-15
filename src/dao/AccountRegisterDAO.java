package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JavaBeans.AccountsBeans;

public class AccountRegisterDAO {
    // データベース接続に使用する情報
        final String ciotId = "ciot";
        final String ciotPass = "ciot";
        final String ciotUrl = "";

    public  AccountRegisterDAO(AccountsBeans ab) {

        try (Connection con = DriverManager.getConnection(ciotUrl, ciotId, ciotPass)) {

            String sql = "INSERT INTO account (loginId, pass, name, roleId) VALUES (?, ?, ?, ?)";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, ab.getLoginId());
            ps.setString(2, ab.getPass());
            ps.setString(3, ab.getName());
            ps.setInt(4, ab.getRole());

            int r = ps.executeUpdate();

            if(r != 0) {
                System.out.println("新規登録成功！");
            } else {
                System.out.println("新規登録失敗");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}