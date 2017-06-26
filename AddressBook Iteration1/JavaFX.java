import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class JavaFX
{
    public static void LaunchFX()
    {
        new JFXPanel();
        
        Platform.runLater(() -> initialiseGUI());
    }
    
    public static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("V-1.0.0  ");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setOnCloseRequest((WindowEvent we) -> Terminate());
        
        Button contact1Btn = new Button ("contact1Btn");
        Button contact2Btn = new Button ("contact2Btn");
        VBox contactBox = new VBox();
        contactBox.setPadding(new Insets(0));
        contactBox.setSpacing(0);
        contactBox.setStyle("-fx-background: #FF0000;");
        contactBox.setPrefWidth(200);
        
        contactBox.getChildren().addAll(contact1Btn, contact2Btn);
        rootPane.getChildren().add(contactBox);
        
        
        
        
        stage.show();
        
    }
    
    public static void Terminate()
    {
        System.exit(0);
    }
}
