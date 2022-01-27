
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr. Bala
 */
@Named
@RequestScoped
//@SessionScoped
//@RequestScoped
//@ViewScoped
public class User {
private String userName;
private String loc;
private long ph;

    /**
     * Creates a new instance of User
     */
    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public long getPh() {
        return ph;
    }

    public void setPh(long ph) {
        this.ph = ph;
    }

    
    
}
