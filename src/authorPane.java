/*
 * Course:CS 1302
 * Section 09
 * Professor: Carlos Cepeda Mora
 * Name:Stephan Mah
 * Assignment #:JavaFX Project
 */

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class authorPane extends Pane{
	   
   public static Pane authorScreen() {
      Pane authorPane = new Pane();
      authorPane.setStyle("-fx-background-color: #3F51B5");
   	//Author information
      Text authorInfo = new Text("Name:Stephan Mah \nEducation Status:Freshman\nHobbies:Basketball,League of Legends,Computers");
      authorInfo.setStyle("-fx-font: 25 arial;");
      authorInfo.setStroke(Color.web("#3F51B5"));
      authorInfo.setFill(Color.web("212121"));
      authorInfo.setTranslateX(450);
      authorInfo.setTranslateY(50);
   	
   	//Image of the handsome author and family
      Image image = new Image("https://i.imgur.com/t9TOIpO.jpg");
      ImageView babySteph = new ImageView(image);
   	
      WebView webView = new WebView();
      webView.getEngine().load("https://www.youtube.com/embed/SU42APLTsPs");
      webView.setPrefSize(640, 390);
      webView.setTranslateX(450);
      webView.setTranslateY(200);
   	
   	
   	//Scene transition animation
      FadeTransition authorSceneFade = new FadeTransition(Duration.seconds(1.5),authorPane);
      authorSceneFade.setFromValue(0);
      authorSceneFade.setToValue(1);
      authorSceneFade.play();
   			
      authorPane.getChildren().addAll(authorInfo,babySteph,webView);
      return authorPane;
   
   }
}