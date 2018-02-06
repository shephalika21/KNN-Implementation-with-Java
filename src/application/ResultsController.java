/*
 * Programmed by Shephalika Shekhar
 */
package application;

import implementation.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

//Results Controller class for showing the results on application screen
public class ResultsController implements Initializable {

    @FXML
    private Label resultslabel;

    @FXML
    private Label acclabel;

    @FXML
    private Label fileoutputlabel;

    @FXML
    private Label accoutputlabel;

    @FXML
    private Button btnback;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	
    		String s = String.valueOf(Classifier.accuracy);
    	accoutputlabel.setText(s+" %");
    	fileoutputlabel.setText("Predicted labels written to file Results.csv . Please check!");
	}
    
    @FXML
    public void btnbackload(ActionEvent event){
    	try {
			
			AnchorPane loaderlogin;
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
    
}
