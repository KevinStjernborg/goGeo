package Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GeoGO extends Application{
	Stage window;
	Scene scene1, scene2, scene3;
	Button button1, button2, button3, button4, button5;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
	window = primaryStage;
	
		Label lbl1 = new Label("Instruktioner bla bla bla ");
		button1 = new Button("Nytt spel");
		button2 = new Button("Instruktioner");
		button3 = new Button("Avsluta");
		button5 = new Button("Tillbaka");
		button1.setOnAction(e-> window.setScene(scene2));
        button2.setOnAction(e-> window.setScene(scene3));
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(button1,button2, button3);
		scene1 = new Scene(layout, 300, 250);
		
		
		
		button4 = new Button("Europa");
		button4.setOnAction(e-> window.setScene(scene1));
		button5.setOnAction(e-> window.setScene(scene1));
		button3.setOnAction(e-> window.close());
		
	
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button4);
		scene2 = new Scene(layout2, 600, 300);
		
		VBox layout3 = new VBox();
		layout3.getChildren().addAll(lbl1, button5);
		scene3 = new Scene(layout3, 300, 250);
		
		
		
		window.setScene(scene1);
		window.setTitle("GoGEO");
		//primaryStage.setScene(scene);
		window.show();
		
	}

}
