package docapp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import docapp.businesslogic.DocApp;
import java.sql.PreparedStatement;

/**
 *
 * @author 117394951 
 */

public class DocAppDbRepository {
    
    private Connection dataPersistenceLayer;
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/Appointments1";
    private Properties connectionProperties = new Properties();
    
    
    public DocAppDbRepository() {
        connectionProperties.put("user", "user1");
        connectionProperties.put("password", "pass1");
    }
    
    public Boolean DBCheck(String username , String password){
        try{
            this.dataPersistenceLayer = DriverManager.getConnection(DB_CONNECTION, connectionProperties);
            PreparedStatement chk = this.dataPersistenceLayer.prepareStatement("SELECT Name , Password FROM Students WHERE Name = '"+username + "' AND Password = '"+password+"'");
            ResultSet match = chk.executeQuery();
            if (match.next()){
                return true;
                
            } else {
                return false;
            }
        } catch(Exception exc){
            System.out.println(exc);
        } return null;
    }
    
    public List<DocApp> retrieve() {
        List<DocApp> docApps = new ArrayList<>();
        DocApp docApp = null;
       
        try {
            this.dataPersistenceLayer = DriverManager.getConnection(DB_CONNECTION, connectionProperties);
            
            Statement sql = this.dataPersistenceLayer.createStatement();
            ResultSet records = sql.executeQuery("SELECT * FROM USER1.APPOINTMENTS");
            while (records.next()){
                docApp = new DocApp();
                docApp.setID(records.getInt("ID"));
                docApp.setName(records.getString("Name"));
                docApp.setTime(records.getString("Time"));
                docApp.setDate(records.getString("Date"));
                docApps.add(docApp);
            }
        } catch (SQLException sqlex) {
            System.out.println ("Database read error");
            System.out.println(sqlex);
        } 
        return docApps;
    }
    
    public void persist(List<DocApp> docApps) {
        DocApp docApp = null;
        try {
            this.dataPersistenceLayer = DriverManager.getConnection(DB_CONNECTION, connectionProperties);
            Statement sql = this.dataPersistenceLayer.createStatement();
            sql.execute("TRUNCATE TABLE USER1.APPOINTMENTS");
            for (int i =0; i < docApps.size(); i++) {
                docApp = docApps.get(i);
                sql.executeUpdate("INSERT INTO USER1.APPOINTMENTS (ID, NAME, TIME, DATE) VALUES ("
                        + docApp.getID() + ", '"
                        + docApp.getName() + "', '"
                        + docApp.getTime () + "', '"
                        + docApp.getDate() + "' )");
            }
        } catch (SQLException sqlex) {
            System.out.println ("Database write error");
            System.out.println(sqlex);
        }
    }
}
