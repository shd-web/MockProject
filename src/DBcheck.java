import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBcheck {
	public static void main (String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("JDBCドライバの登録完了");
		}catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません");
			e.printStackTrace();
			return;
		}
   String url="jdbc:postgresql://localhost/ciot";
	String user="ciot";
	String password = "ciot";
	String sql = "SELECT*FROM items";
	Connection con = null;
	PreparedStatement ps = null;
	try {
		con=DriverManager.getConnection(url,user,password);
		System.out.println("DB接続完了");
       // ステートメントオブジェクトを生成
       Statement stmt = con.createStatement();
       

       ps = con.prepareStatement(sql);
       ResultSet rs1 = ps.executeQuery();
       /*
       try {
           while(rs1.next()){
            
			System.out.print("商品ID:"+rs1.getInt("item_id") +",");
          
			System.out.print("商品名:" +rs1.getString ("item_name")+",");
         
			System.out.print("価格:" + rs1.getInt("price") +",");
    
			System.out.print("カテゴリID:" +rs1.getInt("category_id") +",");                  
			System.out.print("登録日:" +rs1.getDate("created_date") +"," + "\n");

           }
       } finally {
           rs1.close();
       }*/
       stmt.close();
       con.close();
       System.out.println("DB切断完了");
   } catch (Exception e) {
       e.printStackTrace();
   }finally{
		try {
			if(con!=null && !con.isClosed()) {
				con.close();
				System.out.println("DB切断完了");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}

}
