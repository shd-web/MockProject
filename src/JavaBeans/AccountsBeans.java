package JavaBeans;

import java.io.Serializable;

public class AccountsBeans implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String pass;
    private String name;
    private String address;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
		
}
