import java.io.*;
import java.util.*;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.layout.Priority;

public class JavaFX
{
    public static String[][] Contacts;
    
    public static void LaunchFX()
    {
        //System.out.println("TEST");
        
        new JFXPanel();
        
        Platform.runLater(() -> initialiseGUI());
    }
    
    public static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("Contact Book  -  V-1.0.0");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        Scene scene = new Scene (rootPane, 1280, 720);
        scene.getStylesheets().add("CSS.css");
        stage.setScene(scene);
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setOnCloseRequest((WindowEvent we) -> Terminate());
        
        ////Gets peoples addresses from a txt file and saves them to an array
        try{
            Contacts = GetContacts();
        } catch(IOException e) {
            System.out.println("IOException problem");
        }
        
        ////    Main Page    ////
        //filling profile picutre
        Rectangle rPP = new Rectangle();
        rPP.setX(200 + 100);
        rPP.setY(50 + 50);
        rPP.setWidth(150);
        rPP.setHeight(150);
        
        Group mainG = new Group();
        mainG.getChildren().addAll(rPP);
        
        
        
        
        //////////    Contact Bar    //////////
        Button NewContact = new Button ("New Contact");
        NewContact.setId("FuncBtn");
        NewContact.setPrefWidth(200);
        NewContact.setPrefHeight(50);
        
        VBox SortBox = new VBox();
        SortBox.setPadding(new Insets(0, 0 , 0, 0));
        SortBox.setSpacing(0);
        SortBox.setStyle("-fx-background-color: #9ea2a3;");
        SortBox.setPrefWidth(200);
        SortBox.setPrefHeight(50);
        SortBox.setLayoutX(0);
        SortBox.setLayoutY(0);
        
        Button SortBtn = new Button ("Sort");
        SortBtn.setId("FuncBtn");
        SortBtn.setPrefWidth(200);
        SortBtn.setPrefHeight(50);
        SortBox.getChildren().add(SortBtn);
        
        VBox contactBox = new VBox();
        contactBox.setPadding(new Insets(0, 0 , 0, 0)); //(top/right/bottom/left)
        contactBox.setSpacing(0);
        contactBox.setStyle("-fx-background-color: #9ea2a3;");
        contactBox.setPrefWidth(200);
        contactBox.setPrefHeight(620);
        contactBox.setLayoutX(0);
        contactBox.setLayoutY(50);
        
        VBox newContactBox = new VBox();
        newContactBox.setPadding(new Insets(0, 0 , 0, 0));
        newContactBox.setSpacing(0);
        newContactBox.setStyle("-fx-background-color: #9ea2a3;");
        newContactBox.setPrefWidth(200);
        newContactBox.setPrefHeight(50);
        newContactBox.setLayoutX(0);
        newContactBox.setLayoutY(640);
        newContactBox.getChildren().add(NewContact);
        
        ////sets the amount of contact buttons to the Vbox 
        for (int i = 0; i<Contacts[0].length; i++)
        {
            Button btn = new Button(Contacts[0][i]);
            btn.setId("contactButton");
            btn.setPrefWidth(200);
            btn.setPrefHeight(50);
            final int j = i;
            btn.setOnAction((ActionEvent ae) -> UpdateGroup(j, mainG));
            contactBox.getChildren().addAll(btn);
        }
        
        Group LeftBar = new Group();
        LeftBar.getChildren().addAll(SortBox, contactBox, newContactBox);
        
        //contactBox.getChildren().addAll(NewContact);
        
        
        
        ////   Navigation Bar    ////
        Button EditBtn = new Button ("Edit");
        EditBtn.setId("FuncBtn");
        EditBtn.setPrefWidth(75);
        EditBtn.setPrefHeight(50);
        
        HBox NavBar = new HBox();
        NavBar.setPadding(new Insets(0));
        NavBar.setStyle("-fx-background-color: #9ea2a3;");
        NavBar.setPrefWidth(1080);
        NavBar.setPrefHeight(50);
        NavBar.setLayoutX(200);
        NavBar.setLayoutY(0);
        NavBar.setPadding(new Insets(0, 0 , 0, 999)); //(top/right/bottom/left)
        NavBar.getChildren().addAll(EditBtn);
        
        
        rootPane.getChildren().addAll(LeftBar, NavBar, mainG);
        stage.show();
        
    }
    
    public static String[][] GetContacts() throws IOException
    {
        FileReader fr = new FileReader ("Contacts.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int numOflines =0;
        do
        {
            numOflines++;
        } while ((line = br.readLine()) != null);
        System.out.println("number Of lines: " + numOflines);
        br.close();
        
        String[][] Contacts = new String[3][numOflines];
        fr = new FileReader ("Contacts.txt");
        br = new BufferedReader(fr);
        line = br.readLine();
        
        int j=0;
        do
        {
            String[] Components = line.split(", ");
            System.out.println("Component:  " + Components[0] + " " + Components[1] + " " + Components[2]);
            System.out.println("Components.length: " + Components.length);
            for (int i = 0; i<Components.length; i++)
            {
                Contacts[i][j] = Components[i];
            }
            j++;
        } while ((line = br.readLine()) != null);
        
        /*System.out.println("'''");
        for (int i=0; i<2; i++)
        {
            System.out.println(Contacts[0][i] + " " + Contacts[1][i] + " " + Contacts[2][i]);
        }
        //System.out.println(i);*/
        br.close();
        
        return (Contacts);
    }
    
    public static void UpdateGroup(int i, Group mainG)
    {
        Random rand = new Random();
        int r = ((int)(rand.nextFloat()*255));
        int g = ((int)(rand.nextFloat()*255));
        int b = ((int)(rand.nextFloat()*255));
        System.out.println(r + " " + g + " " + b); 
        
        
        System.out.println("J = " + i);
        System.out.println("Contact [0][0]: " + Contacts[0][i]);
        
        mainG.getChildren().clear();
        
        Label Name = new Label(Contacts[0][i]);
        Name.setLayoutX(500);
        Name.setLayoutY(100);
        Name.setId("Name");
        
        Label Address = new Label(Contacts[0][i] + "'s home address: \n\t" + Contacts[1][i]);
        Address.setLayoutX(500);
        Address.setLayoutY(150);
        Address.setId("Address");
        
        Rectangle fillInProfilePic = new Rectangle();
        fillInProfilePic.setX(200 + 100);
        fillInProfilePic.setY(50 + 50);
        fillInProfilePic.setWidth(150);
        fillInProfilePic.setHeight(150);
        fillInProfilePic.setFill(Color.rgb(r, g, b, 1));
        //fillInProfilePic.setFill(Color.rgb(0,5,255, 1));
        mainG.getChildren().addAll(Name, Address, fillInProfilePic);
        
    }
    
    public static void Terminate()
    {
        System.exit(0);
    }
}
