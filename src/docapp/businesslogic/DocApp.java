/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docapp.businesslogic;

import java.io.Serializable;

/**
 *
 * @author 117394951
 */


public class DocApp implements Serializable {
    
    private int ID;
    private String name, time, date;
    

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        }
    }

    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        if (this.ID==0) {
            this.ID = ID;
        }
    }
    
    
    
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        if (!date.equals("")) {
            this.date = date;
        }
    }
    
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        if (!time.equals("")) {
            this.time = time;
        }
    }

    

    public DocApp() {
        this.ID  = 0;
        this.name = "";
        this.time = "";
        this.date = "";
        
    }

    public DocApp(int ID, String name, String time, String date) {
        this.ID = ID;
        this.name = name;
        this.time = time;
        this.date = date;
        
    }

    @Override
   public String toString() {
        return "DocApp{ ID: " + ID + "name: " + name + "date: "  + date + "time: " + time + '}';
    }
    
    
}
