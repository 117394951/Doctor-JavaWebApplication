package docapp.persistence;

import java.util.List;
import docapp.businesslogic.DocApp;

/**
 *
 * @author 117344143
 */
public class DocAppAdapter {
    
    //private static final FoodItemFileRepository db = new FoodItemFileRepository();
    private static final DocAppDbRepository db = new DocAppDbRepository();

    public static DocApp createDocApp(String name, String time, String date) {
        List<DocApp> tempListDocApps = db.retrieve();
        int newID = tempListDocApps.get(tempListDocApps.size()-1).getID() + 1;
        tempListDocApps.add(new DocApp(newID, name, time, date));
        db.persist(tempListDocApps);
        return tempListDocApps.get(tempListDocApps.size()-1);
    } 
    
   public static void createDocApp(DocApp f) {
       List<DocApp> tempListDocApps = db.retrieve();
       tempListDocApps.add(f);
       db.persist(tempListDocApps);
   }
   
   public static DocApp readDocApp(int ID) {
       List<DocApp> tempListDocApps = db.retrieve();
      for (DocApp t : tempListDocApps) {
           if (t.getID() == ID) {
              return t;
           }
       }
       return null;
   }
   
  public static List<DocApp> readAllDocApps() {
       List<DocApp> tempListDocApps = db.retrieve();
       
       //There are no items on file, so let's add a few
        if (tempListDocApps.isEmpty()) {
            tempListDocApps.add(new DocApp(0, "Clare", "9.30", "04-04-2019"));
            tempListDocApps.add(new DocApp(1, "Ali", "9.45", "04-04-2019"));
            tempListDocApps.add(new DocApp(2, "Rebecca", "10.00", "04-04-2019"));
            tempListDocApps.add(new DocApp(3, "Molly", "10.15", "04-04-2019"));
           db.persist(tempListDocApps);
            System.out.println("4 appointments created and saved");
        } else {
            System.out.println("Appointments found on file, total = " + tempListDocApps.size());
        }
        
       return tempListDocApps;
  }
   
   public static void updateDocApp(DocApp f) {
       List<DocApp> tempListDocApps = db.retrieve();
       for (int i = 0; i < tempListDocApps.size(); i++) {
           if (tempListDocApps.get(i).getID() == f.getID()) {
               tempListDocApps.set(i, f);
               db.persist(tempListDocApps);
               break;
           }
       }
   }
   
   public static String deleteDocApp(DocApp f) {
     List<DocApp> tempListDocApps = db.retrieve();
       for (DocApp t : tempListDocApps) {
           if (t.getID() == f.getID()) {
               tempListDocApps.remove(t);
               db.persist(tempListDocApps);
               return "done";
           }
       }
       return null;
   }
   
   

   
}
