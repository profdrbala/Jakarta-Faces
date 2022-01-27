
import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ValueChangeEvent;

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
public class EventMgt {
private String depatName;
private Map<String,String> deptList;
private String msg;
    /**
     * Creates a new instance of UserData
     */
    public EventMgt() {
        deptList=new LinkedHashMap<String,String>();
        deptList.put("CS", "CS");
        deptList.put("IT", "IT");
        deptList.put("SE", "SE");
    }
    public void valueChanged(ValueChangeEvent e){
        depatName=e.getNewValue().toString();
    }
    public void actionDone(ActionEvent e){
        msg="Welcome to Webinar";
    }
    public String getDepatName() {
        return depatName;
    }

    public void setDepatName(String depatName) {
        this.depatName = depatName;
    }

    public Map<String, String> getDeptList() {
        return deptList;
    }

    public void setDeptList(Map<String, String> deptList) {
        this.deptList = deptList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
