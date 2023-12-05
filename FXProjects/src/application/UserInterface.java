package application;
//import all the necessary packages
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UserInterface extends Application{
	//Scenes
	Scene mainPage, playSongs, profile;
	//Buttons for switching scenes
	Button profileB, musicB, mainMenuSB, mainMenuPB;
	//Buttons for music
	Button playPauseB, skipFB, skipBB;
	//Buttons for profile
	Button subB, unsubB;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception{
		//Set the window's title.
		window.setTitle("Generic Music Streaming Platform");
		//Buttons for the main page
		//Button for going to your profile
		profileB = new Button("Profile");
		//Sets the functions to be called when the button is pressed
		profileB.setOnAction(e -> window.setScene(profile));
		//Button for playing songs
		musicB = new Button("Play Music");
		musicB.setOnAction(e -> window.setScene(playSongs));
		//Button for returning to the main menu
		mainMenuSB = new Button("Main Menu");
		mainMenuSB.setOnAction(e -> window.setScene(mainPage));
		mainMenuPB = new Button("Main Menu");
		mainMenuPB.setOnAction(e -> window.setScene(mainPage));
		
		//Buttons for music page
		playPauseB = new Button("Play/Pause");
		skipFB = new Button(">|");
		skipBB = new Button("|<");
		//Buttons for profile page
		subB = new Button("Subscribe");
		unsubB = new Button("Unsubscribe");
		//Welcome text
		Label welcomeT = new Label("Welcome to Generic Music Streaming Platform!");
		
		//Layout for the main page
		GridPane layoutM = new GridPane();
		GridPane.setConstraints(welcomeT, 1, 0);
		GridPane.setConstraints(profileB, 0, 3);
		GridPane.setConstraints(musicB, 3, 3);
		layoutM.getChildren().addAll(welcomeT, profileB, musicB);
		
		//Layout for the music player page
		GridPane layoutS = new GridPane();
		GridPane.setConstraints(mainMenuSB, 0, 0);
		GridPane.setConstraints(skipBB, 0, 3);
		GridPane.setConstraints(playPauseB, 1, 3);
		GridPane.setConstraints(skipFB, 2, 3);
		layoutS.getChildren().addAll(mainMenuSB, skipBB, playPauseB, skipFB);
		
		//Layout for the profile page
		GridPane layoutP = new GridPane();
		GridPane.setConstraints(mainMenuPB, 0, 0);
		GridPane.setConstraints(subB, 0, 1);
		GridPane.setConstraints(unsubB, 1, 1);
		layoutP.getChildren().addAll(mainMenuPB, subB, unsubB);
		
		//Creates the main scene
		mainPage = new Scene(layoutM, 500, 500);
		//creates the music player scene
		playSongs = new Scene(layoutS, 500, 500);
		//Creates the profile scene
		profile = new Scene(layoutP, 500, 500);
		
		//Initial scene called on program run
		window.setScene(mainPage);
		//Show the window
		window.show();
	}

	
}
