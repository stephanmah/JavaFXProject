/*
 * Course:CS 1302
 * Section 09
 * Professor: Carlos Cepeda Mora
 * Name:Stephan Mah
 * Assignment #:JavaFX Project
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class gamePane extends Pane {
	private static final int NUM_OF_PAIRS = 8;
	private static final int NUM_OF_ROWS = 4;
	
	private static Card selected = null;
	private static int clickCount = 2;
	
	
	public static Pane gameScreen() {
		//Creates a pane that colors the game
				Pane gamePane = new Pane();
				gamePane.setStyle("-fx-background-color: #3F51B5");

				Text instructions = new Text();
				instructions.setText("Choose two cards that match.\n If they are the same card, you have a match. \nOtherwise,keep trying untill you find all 8 matches!\n Press the game button to start over\nScore: ");
				instructions.setStroke(Color.BLUE);
				instructions.setStyle("-fx-font: 18 arial;");
				instructions.setTranslateY(30);
				
				//Cards that will be displayed on game scene
				List<Card> cards = new ArrayList<>();
				char x = 'A';
				//Gives each card a letter based on its position in the arrayList
				for (int i = 0; i < NUM_OF_PAIRS; i++) {
					cards.add(new Card(String.valueOf(x)));
					cards.add(new Card(String.valueOf(x)));
					x++;
				}
				
				//Shuffles the order of the cards
				Collections.shuffle(cards);
				
				//Places cards down based on its position the arrayList
				for(int i = 0; i < cards.size(); i++) {
					Card card = cards.get(i);
					card.setTranslateX(150 * (i % NUM_OF_ROWS)+600);
					card.setTranslateY(150 * (i / NUM_OF_ROWS));
					gamePane.getChildren().addAll(card);
					
				}
		
				gamePane.getChildren().addAll(instructions);
				return gamePane; 
		}
			static class Card extends StackPane {
				private Text text = new Text();
				
				
				public Card(String value) {
					Rectangle border = new Rectangle(150,150);
					border.setFill(null);
					border.setStroke(Color.BLACK);
					
					text.setText(value);
					text.setFont(Font.font(60));
					text.setStroke(Color.WHITE);;
					setAlignment(Pos.CENTER);
					
					
					setOnMouseClicked(this::handleMouseClicked);
					//Makes cards hidden by default
					hide();
					
					getChildren().addAll(border,text);
					
				}
				//Sets card's clicked behavior	
				public void handleMouseClicked(MouseEvent event) {
					//Does nothing if clicked card has been matched
					if (isShowing() || clickCount == 0)
			            return;

			        //Designates clicked card as "Selected" for further manipulation
			        if (selected == null) {
			            selected = this;
			            show(() -> {});
			        }
			        else {
			            show(() -> {
			            	//Hides the value of two selected cards if they are not the same
			                if (!hasSameValue(selected)) {
			                    selected.hide();
			                    this.hide();
			                }

			                selected = null;
			                clickCount = 2;
			            });
			        }
			        
			    }

				public boolean isShowing() {
					
					return text.getOpacity() == 1;
				}
				
				public void show(Runnable action) {
					FadeTransition ft = new FadeTransition(Duration.seconds(0.5),text);
					ft.setToValue(1);
					ft.setOnFinished(e -> action.run());
					ft.play();
				}
				
				public void hide() {
					FadeTransition ft = new FadeTransition(Duration.seconds(0.5),text);
					ft.setToValue(0);
					ft.play();
					
					}
				//Returns true if two cards have the same letter value
				public boolean hasSameValue(Card other) {
					return text.getText().equals(other.text.getText());
					
				
				}
				
				
				
			}
			
			
			


	}

