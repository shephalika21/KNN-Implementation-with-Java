/*
 * Programmed by Shephalika Shekhar
 */
package application;
import implementation.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

//Main controller class to control all the features in the application
public class MainController implements Initializable {
	public String distancetype;
	public String train;
	public String test;
	public String k;
	Classifier c = new Classifier();

    @FXML
    private AnchorPane knn;

    @FXML
    private Label Klabel;

    @FXML
    private Label distancelabel;

    @FXML
    private ComboBox<String> distancecombo;
    
    @FXML
    private TextField K_inputtext;

    @FXML
    private Label classifierlabel;

    @FXML
    private Button btnsubmit;
    
    @FXML
    private Label trainingfilelabel;

    @FXML
    private Label testfilelabel;

    @FXML
    private TextField trainingfiletext;

    @FXML
    private TextField testfiletext;
    
    ObservableList<String> list = FXCollections.observableArrayList("Euclidean", "Manhattan");
    
    //Function to call classify method and display the results on screen
    @FXML
    public void btnsubmitload(ActionEvent event) throws NumberFormatException, IOException
	{	
    	distancetype=distancecombo.getValue();
    	train = trainingfiletext.getText().toString();
    	test = testfiletext.getText().toString();
    	k = K_inputtext.getText().toString();
    	
    	c.input(train, test, k, distancetype);
    	try {
			
			AnchorPane loaderlogin;
			loaderlogin = FXMLLoader.load(getClass().getResource("Results.fxml"));
			Scene scenes = new Scene(loaderlogin);
			Main.primaryStage.setTitle("KNN Classifier");
			Main.primaryStage.setScene(scenes);
			Main.primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    @FXML
    private Button btngraphs;

   
    @FXML
    public void btngraphload(ActionEvent event) throws NumberFormatException, IOException
	{

		loadmahattanchart();
		loadeucledianchart();
	}
    
    @FXML
    private BarChart<String, Double> charteucledian;

    @FXML
    private BarChart<String, Double> chartmanhattan;

    @FXML
    private Label labeleucledian;

    @FXML
    private Label labelmanhattan;

    @FXML
    private Label labelacc;

	//method to generate bar chart for k odd values from 1 to 19 for manhattan distance
	@SuppressWarnings("unchecked")
	public void loadmahattanchart() {
		XYChart.Series<String,Double> series = new XYChart.Series<>();
		train = trainingfiletext.getText().toString();
    	test = testfiletext.getText().toString();
		for(int k=1;k<20;k=k+2){
		
	    try {
			c.input(train, test, String.valueOf(k), "Manhattan");
			series.getData().add(new XYChart.Data<>(String.valueOf(k), Classifier.accuracy));
	    } catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		chartmanhattan.getData().addAll(series);
		}
	
	//method to generate bar chart for k odd values from 1 to 19 for euclidean distance
	@SuppressWarnings("unchecked")
	public void loadeucledianchart(){
		XYChart.Series<String,Double> series = new XYChart.Series<>();
		train = trainingfiletext.getText().toString();
    	test = testfiletext.getText().toString();
		for(int k=1;k<20;k=k+2){
		
	    try {
			c.input(train, test, String.valueOf(k), "Euclidean");
		
		series.getData().add(new XYChart.Data<>(String.valueOf(k), Classifier.accuracy));
	    } catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		charteucledian.getData().addAll(series);
		
	}
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		distancecombo.setItems(list);
		
	}
	
	}


