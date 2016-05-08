package finalProjectPackage;
	
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;

public class FinalPackageDriver extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
						
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("fractalGenerator.fxml"));
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("finalProjectPackage.css").toExternalForm());		
				
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		System.out.print("Hello.");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
