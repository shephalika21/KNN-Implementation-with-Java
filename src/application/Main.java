/*
 * Programmed by Shephalika Shekhar
 */
package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//main class to load first page of application
public class Main extends Application {

	// this is stage variable
	public static Stage primaryStage;

	/*
	 * this method will set the stage to run JavaFX applications and this is
	 * default method and must be override.
	 * 
	 * when will run the program this loads the first page
	 */

	public void start(Stage primaryStage1) {

		try {
			this.primaryStage = primaryStage1;
			Parent loaderlogin;
			loaderlogin = FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scenes = new Scene(loaderlogin);
			Main.primaryStage.setTitle("KNN Classifier");
			Main.primaryStage.setScene(scenes);
			Main.primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		launch(args);

	}
}