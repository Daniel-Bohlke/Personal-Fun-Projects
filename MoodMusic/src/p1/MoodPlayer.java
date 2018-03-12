package p1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MoodPlayer extends Application{
	static Scanner input = new Scanner(System.in);
	 Desktop desktop = Desktop.getDesktop();
	public void start(Stage primaryStage) throws Exception{
		
	HBox numberPane = new HBox();
	numberPane.setSpacing(3);
	numberPane.setAlignment(Pos.CENTER);
	Label selectlbl = new Label("Please Select Your Mood:");
	Button Sad = new Button("Sad");
	Sad.setOnAction(e -> {
		File sadsong = new File("you had a bad day with lyrics.mp3");
		try {
			desktop.open(sadsong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	Button Angry = new Button("Angry");
	Angry.setOnAction(e -> {
		File angrysong = new File("korn-here to stay (lyrics).mp3");
		try {
			desktop.open(angrysong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	Button Happy = new Button("Happy");
	Happy.setOnAction(e -> {
		File happysong = new File("Pharrell Williams - Happy.mp3");
		try {
			desktop.open(happysong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	Button Weeb = new Button("Weeb");
	Weeb.setOnAction(e -> {
		File weebsong = new File("05-yoru-no-mukou.mp3");
		try {
			desktop.open(weebsong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	Button Proud = new Button("Proud");
	Proud.setOnAction(e -> {
		File proudsong = new File("131-ocean.mp3");
		try {
			desktop.open(proudsong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	Button Adventurous = new Button("Adventurous");
	Adventurous.setOnAction(e -> {
		File adventuresong = new File("138-dragon-roost-island.mp3");
		try {
			desktop.open(adventuresong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	Button Stressed = new Button("Stressed");
	Stressed.setOnAction(e -> {
		File stresssong = new File("Best Relaxing Spa Music (Mp3Goo.com).mp3");
		try {
			desktop.open(stresssong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	Button SomethingElse = new Button("Something Else");
	SomethingElse.setOnAction(e -> {
		File elsesong = new File("Elevator-music.mp3");
		try {
			desktop.open(elsesong);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	});
	HBox operatorPane = new HBox();
	operatorPane.setSpacing(10);
	operatorPane.setAlignment(Pos.CENTER);
	operatorPane.getChildren().addAll(selectlbl, Sad, Angry, Happy, Proud, Adventurous, Stressed, Weeb, SomethingElse);
	
	BorderPane borderPane = new BorderPane(numberPane);
	BorderPane.setMargin(numberPane, new Insets(10, 10, 10, 10));
	
	borderPane.setBottom(operatorPane);
    BorderPane.setMargin(operatorPane, new Insets(10, 10, 10, 10));
    primaryStage.setScene(new Scene(borderPane, borderPane.getPrefWidth(),borderPane.getPrefWidth()));
    primaryStage.setTitle("MoodPlayer");
    primaryStage.show();
	}
}