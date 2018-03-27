/*
 * Course:CS 1302
 * Section 09
 * Professor: Carlos Cepeda Mora
 * Name:Stephan Mah
 * Assignment #:JavaFX Project
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*Creates the main window that all other screens reside in*/
public class mainPane extends Application {
   private static Stage stage;
   private static Scene scene;
   private static HBox buttons = new HBox(150);   
   static Button welcome = new Button();
   static Button author = new Button();
   static Button game = new Button();
   static Button back = new Button();
   static Button quit = new Button();
  
   @Override
   public void start(Stage primaryStage) {
      BorderPane mainBPane = new BorderPane();
      Pane imagePane = new Pane();
      
      //Creates background
      Image bg = new Image("https://i.imgur.com/cWvwBw0.png",750, 650, true, true);
      ImageView backGround = new ImageView(bg);
      imagePane.getChildren().addAll(backGround);
      backGround.fitHeightProperty().bind(mainBPane.heightProperty());
      backGround.fitWidthProperty().bind(primaryStage.widthProperty());
      mainBPane.setCenter(imagePane);
      
      
      //Creates and styles menu bar
      DropShadow shadow = new DropShadow(15.0,Color.web("#607D8B"));
      welcome.setStyle("-fx-font: 15 arial; -fx-base: #78d5d7;");
      welcome.setEffect(shadow);
      welcome.setText("Welcome");
      welcome.setOnAction(e -> mainBPane.setCenter(welcomePane.welcomeScreen()));

      author.setStyle("-fx-font: 15 arial; -fx-base: #78d5d7;");
      author.setEffect(shadow);
      author.setText("Author");
      author.setOnAction(e -> mainBPane.setCenter(authorPane.authorScreen()));

      game.setStyle("-fx-font: 15 arial; -fx-base: #78d5d7;");
      game.setEffect(shadow);
      game.setText("Game");
      game.setOnAction(e -> mainBPane.setCenter(gamePane.gameScreen()));
		
      buttons.setStyle("-fx-padding: 15;" + "-fx-border-style: dashed;"
		        + "-fx-border-width: 2;" + "-fx-border-insets: 15;"
		        + "-fx-border-radius: 20;" + "-fx-border-color:#BDBDBD;");
     
      buttons.setStyle("-fx-background-color: #3F51B5");
      buttons.setAlignment(Pos.BASELINE_CENTER);
      buttons.getChildren().addAll(welcome,author,game);

      Scene scene = new Scene(mainBPane,900,500);

      setStage(primaryStage);
      primaryStage.setTitle("JavaFXProject");
      primaryStage.setScene(scene);
      stage.setMaximized(true);
      mainBPane.setBottom(buttons);
      primaryStage.show();
      
   }

   public static Stage getStage() {
      return stage;
   }

   public static void setStage(Stage stage) {
      mainPane.stage = stage;
   }

   public static Scene getScene() {
      return scene;
   }

   public static void setScene(Scene scene) {
      mainPane.scene = scene;

   }
   public static void main (String [] args) {
	   launch(args);
   }
}
