
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr. Bala
 */
@Named("data")
@RequestScoped
public class UserData {
    private int id;
    private String name;
    private int phone;
    
    ArrayList usersList ;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    Connection connection;
    
    // Used to establish connection
    public Connection getConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");   
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB","bala","bala");
        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
    // Used to fetch all records
    public ArrayList usersList(){
        try{
            usersList = new ArrayList();
            connection = getConnection();
            Statement stmt=connection.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from contact");  
            while(rs.next()){
                UserData user = new UserData();
                user.setId(rs.getInt("cid"));
                user.setName(rs.getString("name"));
                user.setId(rs.getInt("phone"));

                usersList.add(user);
            }
            connection.close();        
        }catch(Exception e){
            System.out.println(e);
        }
        return usersList;
    }
    // Used to save user record
    public void save(){
        int result = 0;
        String err="";
        try{
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into contact(cid,name,phone) values(?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, phone);
            
            result = stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            err=e.toString();
        }
        if(result !=0)
            FacesContext.getCurrentInstance().addMessage("add", new FacesMessage(err));
        else
            FacesContext.getCurrentInstance().addMessage("add", new FacesMessage(err));
    }
    // Used to fetch record to update
    public String edit(int id) throws SQLException{
        UserData user = null;
        System.err.println("id is "+ id);
            connection = getConnection();
            Statement stmt=connection.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from contact where cid = "+id);
            rs.next();
            user = new UserData();
            user.setId(rs.getInt("cid"));
            user.setName(rs.getString("name"));
            user.setPhone(rs.getInt("phone"));
            
            sessionMap.put("editUser", user);
            connection.close();
            return "DatabaseUpdateContact.xhtml";
    }
    // Used to update user record
    public String update(UserData u){
        //int result = 0;
        try{
            connection = getConnection();  
            PreparedStatement stmt=connection.prepareStatement("update contact set name=?,phone=? where cid=?");  
            stmt.setString(1,u.getName());   
            stmt.setInt(6,u.getPhone());  
            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println();
        }
            return "DatabaseAccess";     
    }
    // Used to delete user record
    public String delete(int id){
        System.out.println("\n\n"+id+"\n\n");
        try{
            connection = getConnection();  
            PreparedStatement stmt = connection.prepareStatement("delete from contact where cid = "+id);  
            stmt.executeUpdate();  
        }catch(Exception e){
            return e.toString();
        }
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    
    

}