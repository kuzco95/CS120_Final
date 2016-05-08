package finalProjectPackage;
//combobox code from: https://www.youtube.com/watch?v=o13Qpxyk4Tg
//slider code from: https://www.youtube.com/watch?v=x3jhTJTDIwQ

import javafx.application.Application;

import javafx.fxml.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.Button;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.event.*;


public class SecondaryClass implements Initializable {
	
	public int topPicked;
	public int botPicked;
	public double topAngle;
	public double bottomAngle;
	
	public int resetPressed;

	@FXML	
	protected ComboBox<String> colorChooser;
	
	@FXML	
	protected ComboBox<String> topIts;

	@FXML	
	protected ComboBox<String> botIts;
	
	@FXML
	protected Slider topSlider;

	@FXML
	protected Slider bottomSlider;

	protected static final double INIT_VALUE = 180;
	
	ObservableList<String> colors = FXCollections.observableArrayList(
			"Magenta", "Blue", "Cyan", "Green", "Yellow", "Orange", "Red", 
			"Pink", "Gray", "White"
			);
	
	ObservableList<String> primeIt = FXCollections.observableArrayList(
			"8", "9", "10", "11", "12", "13", "14", 
			"15", "16", "17"
			);
	ObservableList<String> secIt = FXCollections.observableArrayList(
			"8", "9", "10", "11", "12", "13", "14", 
			"15", "16", "17"
			);
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		colorChooser.setItems(colors);
		topIts.setItems(primeIt);
		botIts.setItems(secIt);
		topSlider.setValue(INIT_VALUE);
		bottomSlider.setValue(INIT_VALUE);

	}
	
	
	@FXML
	public void customButtonPressed(Event Event){
		resetPressed = 2;
		
	}
	
	@FXML
	public void startButtonPressed(Event Event){
		
		if(resetPressed == 1){
			int n = 2;
			int topNum = 30;
			int botNum = 30;
				
					topPicked = 11;
					botPicked = 9;
				
			
			topAngle = 20;
			bottomAngle = 200;
			
			PrimaryClass newPrime = new PrimaryClass(n, topPicked, botPicked, topAngle, bottomAngle);
			newPrime.newMaine();
			
			
		}else{
		
			int n = 0;
			int topNum = 30;
			int botNum = 30;
		
		try{
		topPicked = Integer.parseInt(topIts.getValue());
		botPicked = Integer.parseInt(botIts.getValue());		
		}catch(Exception e){
			topPicked = 11;
			botPicked = 8;
		}
		String colorPicked = colorChooser.getValue();
		if(colorPicked == "Magenta"){
			n = 7;
		};
		if(colorPicked == "Blue"){
			n = 0;
		};
		if(colorPicked == "Cyan"){
			n = 8;
		};
		if(colorPicked == "Green"){
			n = 2;
		};
		if(colorPicked == "Yellow"){
			n = 9;
		};
		if(colorPicked == "Orange"){
			n = 5;
		};
		if(colorPicked == "Red"){
			n = 3;
		};
		if(colorPicked == "Pink"){
			n = 1;
		};
		if(colorPicked == "Gray"){
			n = 6;
		};
		if(colorPicked == "White"){
			n = 4;
		};
		
		topAngle = topSlider.getValue();
		bottomAngle = bottomSlider.getValue();

//		System.out.print(topSlider.getValue());//, NumberFormat.getNumberInstance());
		
		
		PrimaryClass newPrime = new PrimaryClass(n, topPicked, botPicked, topAngle, bottomAngle);
		newPrime.newMaine();	
		}
	}
	
	@FXML
	public void endButtonPressed(Event Event){
		System.exit(0);
	}
	
	@FXML
	public void resetButtonPressed(Event Event){
		resetPressed = 1;
		
	}
	
//	@FXML
//	public void Canvas(Event Event){
//		System.out.println("Canvas activated");
//		
//	}
	
	
}//end method
