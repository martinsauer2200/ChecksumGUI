package de.martinsauer.checksumgui;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChecksumGUI extends Application {
	
	/**
	 * Creates a very very basic window where the user can input a number in a text field
	 * and the checksum gets calculated and printed out if he presses the button.
	 * 
	 * Not fancy since its my first try on GUI based stuff.
	 * 
	 * Also not checking for invalid input.
	 * 
	 * @author Martin Sauer, 9th Dec. 2020
	 */
	public void start(Stage primaryStage) {	
		primaryStage.setTitle("Checksum GUI");
		
		VBox root = new VBox();
		
		Label text = new Label("Enter a number to calculate its checksum");
		
		TextField tf = new TextField("number");
		
		Button button1 = new Button("Calculate checksum");
		button1.setOnAction(event -> {
			int solution = 0; 
			String output = "";
			char[] input = tf.getText().toCharArray();
			for (char element : input) {
				int current = Character.getNumericValue(element);
				solution += current;
				output += Integer.toString(current);
			}
			text.setText(output + " -> " + solution);
			tf.setText("");
		});
		
		root.getChildren().addAll(text, tf, button1);
		
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
