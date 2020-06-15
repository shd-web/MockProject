package JavaBeans;

import java.io.Serializable;

public class AccountsBeans implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accountId;
    private String pass;
    private String name;
    private int role;

   public String getAccoutId() {
	   return accountId;
   }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
	public void setId(String accountId2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
