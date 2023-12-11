package application;
//import all the necessary packages
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
	//Text variables
	Text subT = new Text();
	Text songT = new Text();
	Song s1 = new Song();
	
	//String nameSong;
	//Variables for scene, column, and row sizes
	int WINDOWSIZE = 400;
	int SCENESIZE = 400;
	int COLUMNPERCENT = 22;
	int ROWPERCENT = 5;
	int spacing = 10;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception{
		//Set the window's title.
		window.setTitle("The Music Streaming Platform");
		//Prevents the window from changing size and risking breaking the code
		window.setMaxHeight(WINDOWSIZE);
		window.setMaxWidth(WINDOWSIZE);
		window.setMinHeight(WINDOWSIZE);
		window.setMinWidth(WINDOWSIZE);
		
		//creates the buttons for the scenes
		buttons(window);
		//Welcome text
		Text welcomeT = new Text();
		welcomeT.setText("Welcome to\nThe Music Streaming Platform!");
		welcomeT.setTextAlignment(TextAlignment.CENTER);
		//User profile text
		Text pNameT = new Text();
		pNameT.setText("Test User");
		pNameT.setTextAlignment(TextAlignment.CENTER);
		//Text to tell the user they are subscribed or not
		subT.setText("You are not subscribed");
		subT.setTextAlignment(TextAlignment.CENTER);
		//Text to display the song and artist
		songT.setText("");
		
		//column and Row sizing for the scenes
		ColumnConstraints c1 = new ColumnConstraints();
	    c1.setPercentWidth(COLUMNPERCENT);
	    ColumnConstraints c2 = new ColumnConstraints();
	    c2.setPercentWidth(COLUMNPERCENT);
	    ColumnConstraints c3 = new ColumnConstraints();
	    c3.setPercentWidth(COLUMNPERCENT);
	    RowConstraints r1 = new RowConstraints();
	    r1.setPercentHeight(ROWPERCENT);
	    RowConstraints r2 = new RowConstraints();
	    r2.setPercentHeight(ROWPERCENT);
	    RowConstraints r3 = new RowConstraints();
	    r3.setPercentHeight(ROWPERCENT);
	    
	    //Layout for the main page
	    GridPane layoutM = new GridPane();
	    //adds elements to specific spots in the grid
	    layoutM.add(welcomeT, 1, 0, 2, 1);
	    layoutM.add(profileB, 0, 3);
	    layoutM.add(musicB, 3, 3);
	    //spacing between elements in the grid
	  	layoutM.setHgap(spacing);
	  	layoutM.setVgap(spacing);
	    layoutM.setAlignment(Pos.CENTER);
	    //adds the column and row constraints
	    layoutM.getColumnConstraints().addAll(c1, c2, c3);
		layoutM.getRowConstraints().addAll(r1, r2, r3);
	    
		//Layout for the music player page
		GridPane layoutS = new GridPane();
		//adds elements to specific spots in the grid
		layoutS.add(songT, 1, 1, 2, 1);
		layoutS.add(mainMenuSB, 0, 0);
		layoutS.add(skipBB, 0, 3);
		layoutS.add(playPauseB, 1, 3);
		layoutS.add(skipFB, 2, 3);
		//spacing between elements in the grid
		layoutS.setHgap(spacing);
		layoutS.setVgap(spacing);
		layoutS.setAlignment(Pos.CENTER);
		//adds the column and row constraints
		layoutS.getColumnConstraints().addAll(c1, c2, c3);
		layoutS.getRowConstraints().addAll(r1, r2, r3);
		
		//Layout for the profile page
		GridPane layoutP = new GridPane();
		//adds elements to specific spots in the grid
		layoutP.add(pNameT, 1, 0, 2, 1);
		layoutP.add(subT, 1, 1, 2, 1);
		layoutP.add(mainMenuPB, 0, 0);
		layoutP.add(subB, 1, 2);
		layoutP.add(unsubB, 2, 2);
		//spacing between elements in the grid
		layoutP.setHgap(spacing);
		layoutP.setVgap(spacing);
		layoutP.setAlignment(Pos.CENTER);
		//adds the column and row constraints
		layoutP.getColumnConstraints().addAll(c1, c2, c3);
		layoutP.getRowConstraints().addAll(r1, r2, r3);
		
		//Debug settings for the scenes
		/*
		layoutM.setGridLinesVisible(true);
		layoutP.setGridLinesVisible(true);
		layoutS.setGridLinesVisible(true);
		*/
		//Creates the main scene
		mainPage = new Scene(layoutM, SCENESIZE, SCENESIZE);
		//creates the music player scene
		playSongs = new Scene(layoutS, SCENESIZE, SCENESIZE);
		//Creates the profile scene
		profile = new Scene(layoutP, SCENESIZE, SCENESIZE);
		
		//Initial scene called on program run
		window.setScene(mainPage);
		//Show the window
		window.show();
	}
	//Creates the buttons for the scenes and keeps the start method from becoming hard to read
	public void buttons(Stage window) {
		//Buttons for the main page
		//Button for going to your profile
		profileB = new Button("Profile");
		profileB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		profileB.setOnAction(e -> window.setScene(profile));
		//Button for playing songs
		musicB = new Button("Play Music");
		musicB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		musicB.setOnAction(e -> {
			window.setScene(playSongs);
			Songs.main(null);
			songT.setText("");
		});
		
		//Button for returning to the main menu
		mainMenuSB = new Button("Main Menu");
		mainMenuSB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		mainMenuSB.setOnAction(e -> window.setScene(mainPage));
		mainMenuPB = new Button("Main Menu");
		mainMenuPB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		mainMenuPB.setOnAction(e -> window.setScene(mainPage));
		
		//Buttons for music page
		playPauseB = new Button("Play/Pause");
		playPauseB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		
		playPauseB.setOnAction(e -> {
			if(SongPlayer.isPlaying) {
				SongPlayer.pause();
				s1 = SongPlayer.getCurrentSong();
				songT.setText("");
			}else {
				SongPlayer.play(s1);
				songT.setText("");
			}
		});
		skipFB = new Button(">|");
		skipFB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		skipFB.setOnAction(e -> {
			SongPlayer.skipf();
			songT.setText("");
		});
		skipBB = new Button("|<");
		skipBB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		skipBB.setOnAction(e -> {
			SongPlayer.skipb();
			songT.setText("");
		});
		
		//Buttons for profile page
		subB = new Button("Subscribe");
		subB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		subB.setOnAction(e -> {
			if(!account.subType) {
				FreeUser.cancelSub();
				subT.setText("You are now subscribed");
			}else {
				subT.setText("You are already subscribed");
			}
		});
		unsubB = new Button("Unsubscribe");
		unsubB.setMaxWidth(Double.MAX_VALUE);
		//Sets the functions to be called when the button is pressed
		unsubB.setOnAction(e -> {
			if(account.subType) {
				PaidUser.cancelSub();
				subT.setText("You are now unsubscribed");
			}else {
				subT.setText("You are already unsubscribed");
			}
		});
	}
	
	
}
