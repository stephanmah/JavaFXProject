/*
 * Course:CS 1302
 * Section 09
 * Professor: Carlos Cepeda Mora
 * Name:Stephan Mah
 * Assignment #:JavaFX Project
 */

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class welcomePane extends Pane {
	public static Pane welcomeScreen() {
		Pane welcomePane = new Pane();
		welcomePane.setStyle("-fx-background-color: #3F51B5");
		Label welcomeMessage = new Label("Welcome to my JavaFX Project!");
		
	      welcomeMessage.setUnderline(true);
	      welcomeMessage.setMaxWidth(Double.MAX_VALUE);
	      welcomeMessage.setAlignment(Pos.CENTER);
	      welcomeMessage.setFont(new Font("Serif", 25));
	      welcomeMessage.setTextFill(Color.web("#2c2e87"));
	      welcomeMessage.setTranslateX(450);

	      //Welcome message animation
	      FadeTransition welcomeFade = new FadeTransition(Duration.seconds(3),welcomeMessage);
	      welcomeFade.setFromValue(0.5);
	      welcomeFade.setToValue(1);
	      welcomeFade.play();
	      welcomeMessage.setAlignment(Pos.CENTER);
	      
	      //Scene transition animation
	      FadeTransition welcomeSceneFade = new FadeTransition(Duration.seconds(1.5),welcomePane);
	      welcomeSceneFade.setFromValue(0);
	      welcomeSceneFade.setToValue(1);
	      welcomeSceneFade.play();
	      
	      //Assignment information
	      Text stephanMah = new Text("Programming Principles II\nProfessor Cepeda Mora\nStephan Mah\nMarch 22,2018");
	      stephanMah.setStyle("-fx-font: 25 arial;");
	      stephanMah.setStroke(Color.web("#212121"));
	      stephanMah.setFill(Color.web("#212121"));
	      stephanMah.setX(15);
	      stephanMah.setY(45);
	      
	      //Loads view of github
	      WebView webView = new WebView();
	      webView.getEngine().load("https://github.com/stephanmah/JavaFXProject");
	      webView.setPrefSize(1000, 500);
	      webView.setTranslateX(150);
	      webView.setTranslateY(150);
			
			welcomePane.getChildren().addAll(welcomeMessage,stephanMah,webView);
	      

		return welcomePane;
	}

}
