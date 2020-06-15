package JavaBeans;

import java.io.Serializable;

public class AccountsBeans implements Serializable {
    private static final long serialVersionUID = 1L;

    private String pass;
    private String name;

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
		
}
