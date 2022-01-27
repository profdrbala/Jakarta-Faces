/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author Dr. Bala
 */
@Named
@RequestScoped
public class AJAX {
private String name;
    /**
     * Creates a new instance of UserInfo
     */
    public AJAX() {
    }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }

}
