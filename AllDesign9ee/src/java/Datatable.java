
import java.util.ArrayList;
import java.util.List;
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
public class Datatable {
private String userName;
private String loc;
private long ph;

private static List<Datatable> list=new ArrayList<Datatable>();

    /**
     * Creates a new instance of DataTable
     */
    public Datatable() {
    }

    public Datatable(String userName, String loc, long ph) {
        this.userName = userName;
        this.loc = loc;
        this.ph = ph;
    }
    public void addNew(){
        Datatable dt=new Datatable(userName,loc,ph);
        list.add(dt);
    }
    public void clearTable(){
        list.clear();
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

    public List<Datatable> getList() {
        return list;
    }

    public void setList(List<Datatable> list) {
        this.list = list;
    }


    
}
