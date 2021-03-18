/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docapp.ui;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import docapp.businesslogic.DocApp;
import docapp.persistence.DocAppAdapter;
import docapp.persistence.DocAppDbRepository;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;


/**
 *
 * @author 117394951
 */



public class DocAppV01 extends Application{
    
    String username, password;
    
    Stage window;
    
    //Naming each scene
    Scene login, menu, services, make, app;
    
    
    @Override
    public void start(Stage primaryStage) {
        List<DocApp> myDocApps = DocAppAdapter.readAllDocApps();
        
        window=primaryStage;
        window.initStyle(StageStyle.TRANSPARENT);
        window.setTitle("UCC Student Health");
      
                GridPane grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(10);

                Text txtTitle = new Text ("Welcome");
                txtTitle.setFont (Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(txtTitle, 1,0);

                Label lblUserName = new Label ("User Name:");
                grid.add(lblUserName, 1, 1);

                TextField userTextField = new TextField();
                userTextField.setPrefWidth(160);
                grid.add(userTextField, 2, 1);

                Label lblPassword = new Label ("Password:");
                grid.add(lblPassword, 1, 2);

                PasswordField PasswordField = new PasswordField();
                userTextField.setPrefWidth(160);
                grid.add (PasswordField, 2, 2);

                final Text actionText = new Text();
                grid.add(actionText, 2, 6);

                Button btn = new Button ("Sign in");
                grid.add(btn,2 ,4);

                
            BorderPane login2 = new BorderPane();
                
                //creating header menu bar
                HBox headerlog = new HBox();
                headerlog.setPadding(new Insets(15, 12, 15, 12));
                headerlog.setSpacing(10);
                Button exit = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/exit2.png"), 50, 50, true, true)));
                exit.setStyle("-fx-background-color: transparent");
                headerlog.setAlignment(Pos.TOP_RIGHT);
                ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/ucclogo.png"),100,50,true,true));

                                    exit.setOnAction(e -> 
                                                       {  primaryStage.close();
                                                       });
                                    
                headerlog.getChildren().add(logo);
                headerlog.getChildren().add(exit);
                
                login2.setTop(headerlog);
                login2.setCenter(grid);
                login2.setStyle("-fx-background-color: white");

    Scene login = new Scene (login2, 510,500);
 
    //menu form
    //layout using border pane and Vbox's
                //creating header menu bar
                HBox headerlog2 = new HBox();
                headerlog2.setPadding(new Insets(15, 12, 15, 12));
                headerlog2.setSpacing(10);
                ImageView logo2 = new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/ucclogo.png"),100,50,true,true));
                Button exit2 = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/exit2.png"), 50, 50, true, true)));
                exit2.setStyle("-fx-background-color: transparent");
                headerlog2.setAlignment(Pos.TOP_RIGHT);

                                    exit2.setOnAction(e -> 
                                                       {  primaryStage.close();
                                                       });
                                    
                Button back = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/back.png"), 50, 50, true, true)));
                                    back.setOnAction(e -> 
                                                       {   primaryStage.setScene(login);
                                                           primaryStage.show();
                                                       });
                back.setStyle("-fx-background-color: transparent");
                headerlog2.getChildren().add(logo2);
                headerlog2.getChildren().add(back);
                headerlog2.getChildren().add(exit2);
    
                VBox boxmenu = new VBox();
                VBox info = new VBox();
                info.setSpacing(25);
                boxmenu.setSpacing(37);

                BorderPane border = new BorderPane();
                border.setLeft(boxmenu);
                border.setRight(info);
                border.setTop(headerlog2);
                border.setStyle("-fx-background-color: white");


                Button makeApp = new Button("Make an Appointment");
                makeApp.setPrefWidth(200);
                Button cancelApp = new Button("Cancel an Appointment");
                cancelApp.setPrefWidth(200);
                Button contact = new Button("Contact us");
                contact.setPrefWidth(200);
                Button opHrs = new Button("Opening Hours");
                opHrs.setPrefWidth(200);
                Button findUs = new Button("Find Us");
                findUs.setPrefWidth(200);

                boxmenu.getChildren().add(makeApp);
                boxmenu.getChildren().add(cancelApp);
                boxmenu.getChildren().add(contact);
                boxmenu.getChildren().add(opHrs);
                boxmenu.getChildren().add(findUs);

       
                //To appear when contact us button is clicked
                TextArea contactUS = new TextArea("Contact Details: \nStudent Health Department, \nArdpatrick College Road, \nCork \n(021) 4902311" );
                contactUS.setPrefSize(250, 170);
                info.getChildren().add(contactUS);
                //button pressed    
                contactUS.setVisible(false);
                
                

                //To appear when Opening Hours button is clicked
                TextArea Ophrs = new TextArea("Opening Hours \nTerm Time Opening Hours \nMonday-Friday \nMorning: 9:15am- 12:15pm \nAfternoon: 2:15pm- 4:15pm");
                Ophrs.setPrefSize(250, 170);
                info.getChildren().add(Ophrs);
                //button pressed    
                Ophrs.setVisible(false);
                
                
                
                //Find us
                TextArea map = new TextArea("Find Us: \nStudent Health Department, \nArdpatrick College Road, \nCork \nIreland");
                map.setPrefSize(250, 170);
                info.getChildren().add(map);
                //button pressed    
                map.setVisible(false);
                
                
                                contact.setOnAction(new EventHandler<ActionEvent>()
                                        {
                                            @Override
                                            public void handle (ActionEvent event){
                                                contactUS.setVisible(true);
                                                Ophrs.setVisible(false);
                                                map.setVisible(false);
                                            }
                                        });
                                opHrs.setOnAction(new EventHandler<ActionEvent>()
                                        {
                                            @Override
                                            public void handle (ActionEvent event){
                                                Ophrs.setVisible(true);
                                                contactUS.setVisible(false);
                                                map.setVisible(false);
                                            }
                                        });
                                findUs.setOnAction(new EventHandler<ActionEvent>()
                                        {
                                            @Override
                                            public void handle (ActionEvent event){
                                                map.setVisible(true);
                                                contactUS.setVisible(false);
                                                Ophrs.setVisible(false);
                                            }
                                        });
                                
                
    Scene menu = new Scene(border, 510, 500);
    
                                TextField usern = new TextField();
                                //login button to switch scenes from log in to menu
                                //Also validation for the log in
                                btn.setOnAction(t->{
                                    username = userTextField.getText();
                                    password = PasswordField.getText();
                                    
                                    DocAppDbRepository Adam = new DocAppDbRepository();
                                    Boolean DBChk = Adam.DBCheck(username, password);
                                    if (DBChk == true) {
                                        System.out.println("Username: " + username);
                                       primaryStage.setScene(menu);
                                            primaryStage.show();
                                            usern.setText(username);
                                    } else 
                                        if (DBChk == false){
                                            Alert ErrorUser = new Alert(Alert.AlertType.ERROR, "Your username or password is incorrect.");
                                            ErrorUser.setTitle("Error");
                                            ErrorUser.showAndWait();
                                        
                                    }
                                });

       
    //services
            //creating header menu bar
                HBox headerlog3 = new HBox();
                headerlog3.setPadding(new Insets(15, 12, 15, 12));
                headerlog3.setSpacing(10);
                ImageView logo3 = new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/ucclogo.png"),100,50,true,true));
                Button exit3 = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/exit2.png"), 50, 50, true, true)));
                exit3.setStyle("-fx-background-color: transparent");
                headerlog3.setAlignment(Pos.TOP_RIGHT);

                                    exit3.setOnAction(e -> 
                                                       {  primaryStage.close();
                                                       });
                                               
                Button back1 = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/back.png"), 50, 50, true, true)));
                                    back1.setOnAction(e -> 
                                                       {   primaryStage.setScene(menu);
                                                           primaryStage.show();
                                                       });
                back1.setStyle("-fx-background-color: transparent");
                headerlog3.getChildren().add(logo3);
                headerlog3.getChildren().add(back1);
                headerlog3.getChildren().add(exit3);
                
                GridPane SMenu = new GridPane();
                SMenu.setMinSize(400,200);
                SMenu.setVgap(15);
                SMenu.setHgap(15);
                SMenu.setAlignment(Pos.CENTER);

                Text TextServ = new Text("Availible Services");
                TextServ.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                Text Textcharge = new Text("Charges");
                Textcharge.setFont(Font.font("Arial", FontWeight.BOLD, 18)); 

                Button dr_nurse = new Button("Dr./Nurse/Psychiatrist");
                dr_nurse.setPrefWidth(250);
                Button conceptra = new Button("Contraception Consult");
                conceptra.setPrefWidth(250);
                Button trav = new Button("Travel Consultation");
                trav.setPrefWidth(250);
                Button physio = new Button("Physiotherapy");
                physio.setPrefWidth(250);
                Button sport = new  Button("Sports Injury Clinic");
                sport.setPrefWidth(250);
                Button vac = new Button("Vaccines");
                vac.setPrefWidth(250);
                Button morning = new Button("Morning After Pill");
                morning.setPrefWidth(250);
                Button eye = new Button("Eye Test");
                eye.setPrefWidth(250);

                Text free = new Text("Free");
                Text twenty = new Text("20");
                Text twenty2 = new Text("20");
                Text thiry = new Text("30");
                Text twentyfive = new Text("25");
                Text fifteen = new Text("15");
                Text various = new Text("Various");
                Text morn = new Text("15/25");

                SMenu.add(Textcharge,3, 0);
                SMenu.add(TextServ, 0,0);
                SMenu.add(dr_nurse, 0,1);
                SMenu.add(free, 3,1);
                SMenu.add(conceptra, 0,2);
                SMenu.add(twenty, 3,2);
                SMenu.add(trav,0,3);
                SMenu.add(thiry,3,3);
                SMenu.add(physio,0,4);
                SMenu.add(twentyfive, 3,4);
                SMenu.add(sport,0,5);
                SMenu.add(fifteen,3,5);
                SMenu.add(various,3,6);
                SMenu.add(vac,0,6);
                SMenu.add(morning,0,7);
                SMenu.add(morn,3,7);
                SMenu.add(eye,0,8);
                SMenu.add(twenty2,3,8);
            
              
                BorderPane serv = new BorderPane();
                serv.setTop(headerlog3);
                serv.setCenter(SMenu);
                serv.setStyle("-fx-background-color: white");
                
Scene services = new Scene(serv, 510, 500);
            
            
            
            

                        //make appointment button to switch scene to services page
                            makeApp.setOnAction(event -> {
                                    
                                      primaryStage.setScene(services);
                                            primaryStage.show();
                                    });
                            
                            
                            //Confirm app button will send app info to database
                        cancelApp.setOnAction(event -> {
                            DocApp doc = new DocApp();
                            String f = DocAppAdapter.deleteDocApp(doc);
                            System.out.println(f);   
                           
                        }); 
                            
                          
                            
            
 //Select appointment scene
                HBox headerlog4 = new HBox();
                headerlog4.setPadding(new Insets(15, 12, 15, 12));
                headerlog4.setSpacing(10);
                ImageView logo4 = new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/ucclogo.png"),100,50,true,true));
                Button exit4 = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/exit2.png"), 50, 50, true, true)));
                exit4.setStyle("-fx-background-color: transparent");
                headerlog4.setAlignment(Pos.TOP_RIGHT);

                                    exit4.setOnAction(e -> 
                                                       {  primaryStage.close();
                                                       });
                Button back2 = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/back.png"), 50, 50, true, true)));
                                    back2.setOnAction(e -> 
                                                       {   primaryStage.setScene(services);
                                                           primaryStage.show();
                                                       });
                back2.setStyle("-fx-background-color: transparent");
                headerlog4.getChildren().add(logo4);
                headerlog4.getChildren().add(back2);
                headerlog4.getChildren().add(exit4);
                
                // Create the DatePicker.
                        TextField day = new TextField();
                        TextField time1 = new TextField();
                DatePicker datePicker = new DatePicker();
                datePicker.setPrefWidth(160);
                datePicker.setDayCellFactory(picker -> new DateCell() {
                                                public void updateItem(LocalDate date, boolean empty) {
                                                    super.updateItem(date, empty);
                                                    LocalDate today = LocalDate.now();

                                                    setDisable(empty || date.compareTo(today) < 0 );
                                                }
                                                });
                //LocalDate date = datePicker.getValue();
                
                                                // Add some action (in Java 8 lambda syntax style).
                                                datePicker.setOnAction(event -> {
                                                            LocalDate appdate = datePicker.getValue();
                                                            System.out.println("Selected date: " + appdate);
                                                            day.setText(appdate.toString());
                                                });
                                                
                //LocalDate date = datePicker.getValue();
                
                //Combo box used for user to select a time slot. only times available are within opening hours
                
                ComboBox selectHours = new ComboBox();
                selectHours.setPrefWidth(160);
                selectHours.getItems().addAll(
                        "9:00",
                        "9:15",
                        "9:30",
                        "9:45",
                        "10:00",
                        "10:15",
                        "10:30",
                        "10.45",
                        "11:00",
                        "11:15",
                        "11:30",
                        "11:45",
                        "12:00",
                        "12:15",
                        "12:30",
                        "12:45",
                        "14:00",
                        "14:15",
                        "14:30",
                        "14:45",
                        "15:00",
                        "15:15",
                        "15:30",
                        "15:45",
                        "16:00",
                        "16:15"   
                    );
                selectHours.getValue();
                
                                    // Add some action (in Java 8 lambda syntax style).
                                    selectHours.setOnAction(event -> {
                                            String apptime = (String) selectHours.getValue();
                                            System.out.println("Selected time: " + apptime);
                                            time1.setText( apptime);
                                    });        
                                    String apptime = (String) selectHours.getValue();

                
                Button book = new Button("See Details"); 
                book.setPrefWidth(160);
                Label lblTime = new Label("Select Time");
                Label lblDate = new Label("Select Date");
                
                // Add the DatePicker to the Stage.
                StackPane root = new StackPane();
                root.getChildren().add(datePicker);


                GridPane cal = new GridPane();
                cal.setAlignment(Pos.CENTER);
                cal.setHgap(15);
                cal.setVgap(15);

                cal.add(lblDate,0,1);
                cal.add(datePicker, 1,1);
                cal.add(lblTime, 0,2);
                cal.add(selectHours, 1, 2);
                cal.add(book,1,3);
                
                BorderPane makeap = new BorderPane();
                makeap.setTop(headerlog4);
                makeap.setCenter(cal);
                makeap.setStyle("-fx-background-color: white");
                    
Scene make = new Scene(makeap, 510, 500);                
 
                    
                                            eye.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });
                                  

                                      morning.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });

                                      vac.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });

                                      sport.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });

                                      physio.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });

                                      trav.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });

                                  dr_nurse.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });

                                  conceptra.setOnAction(e -> 
                                  {  primaryStage.setScene(make);
                                          primaryStage.show();
                                  });
                
//Receipt booking confirmation scene        
                HBox headerlog5 = new HBox();
                headerlog5.setPadding(new Insets(15, 12, 15, 12));
                headerlog5.setSpacing(10);
                ImageView logo5 = new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/ucclogo.png"),100,50,true,true));
                Button exit5 = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/exit2.png"), 50, 50, true, true)));
                exit5.setStyle("-fx-background-color: transparent");
                headerlog5.setAlignment(Pos.TOP_RIGHT);

                                    exit5.setOnAction(e -> 
                                                       {  primaryStage.close();
                                                       });
                Button back3 = new Button ("",new ImageView(new Image(getClass().getResourceAsStream("/docappv.ui.icons/back.png"), 50, 50, true, true)));
                                    back3.setOnAction(e -> 
                                                       {   primaryStage.setScene(make);
                                                           primaryStage.show();
                                                       });
                back3.setStyle("-fx-background-color: transparent");
                headerlog5.getChildren().add(logo5);
                headerlog5.getChildren().add(back3);
                headerlog5.getChildren().add(exit5);                  
                BorderPane reciept = new BorderPane();
                

                //VBox conf = new VBox();
                //conf.setSpacing(20);
                
                //Label booking = new Label("\n      Appointment Confirmation");
                //booking.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                //conf.getChildren().add(booking);
                

               //Appointment information will be displayed in a top border pane
                        
                        GridPane inforeciept = new GridPane();
                        inforeciept.setAlignment(Pos.CENTER);
                        
                        Label booking = new Label("Appointment");
                        booking.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                        inforeciept.add(booking,0,0);
                        
                        //inforeciept.setSpacing(20);
                        Label anim = new Label("Name: ");
                        usern.setEditable(false);
                        inforeciept.add(anim,0,1);
                        inforeciept.add(usern,1,1);
                        
                        //Button btnConfirm = new Button(); 
                        //btnConfirm.setPrefWidth(160);
                        
                        //Label la = new Label("Date: " + date.toString());
                        Label la1 = new Label("Date: ");
                        day.setEditable(false);
                        day.setPrefWidth(160);
                        inforeciept.add(la1, 0,2);
                        inforeciept.add(day, 1,2);
                        
                        Label am1 = new Label("Time: ");
                        time1.setEditable(false);
                        time1.setPrefWidth(160);
                        inforeciept.add(am1,0,3);
                        inforeciept.add(time1,1,3);
                        
                        //Label am = new Label("Time: " + time);
                        
                        
                        Button btnConfirm = new Button("Request Appointment"); 
                        btnConfirm.setPrefWidth(190);
                        inforeciept.add(btnConfirm, 1,4);
                        
                        
                        //inforeciept.getChildren().add(anim);
                        //inforeciept.getChildren().add(la);
                        //inforeciept.getChildren().add(am);
                        //inforeciept.getChildren().add(btnConfirm);
                        
                        
                        //Confirm app button will send app info to database
                        btnConfirm.setOnAction(event -> {
                                                String name = usern.getText();
                                                String time = time1.getText();
                                                String date = day.getText();
                                                DocApp f = DocAppAdapter.createDocApp(name, time, date);
                                                myDocApps.add(f);
                                                btnConfirm.setDisable(true); 
                                               Label confirm = new Label("Your appointment is confirmed.");
                                               inforeciept.add(confirm,1,6);
                                            });    
                        

        
        

                reciept.setTop(headerlog5);
                reciept.setCenter(inforeciept);
                reciept.setStyle("-fx-background-color: white");

                
                
        
        
        
Scene app = new Scene (reciept,510,500);
 
        book.setOnAction(e -> 
        { primaryStage.setScene(app);
            primaryStage.show();
        });
    
       // a scene goes onto the primary stage but first give it a title 
       primaryStage.setTitle("UCC Health Service");
       //pass the scene through the primary stage 
       primaryStage.setScene(make);
       //show the primary stage 
       primaryStage.show();
       
    }  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
