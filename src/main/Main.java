package main;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import manager.SceneManager;
import manager.UserID;
import model.Item;
import model.Items;
import model.User;
import model.Users;

public class Main extends Application{	
	private Stage popUp = new Stage();
	private int uid = 0;
	
	// Data
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<>();
	
	// BGM
	private Media bgm;
	private MediaPlayer bgmPlayer;
	
	public void PlayAudio() {
		// BGM
		bgm = new Media(new File("Assets/audio/bgm.mp3").toURI().toString());
		bgmPlayer = new MediaPlayer(bgm);
		
		// BGM Play
		bgmPlayer.setAutoPlay(true);
		bgmPlayer.setVolume(0.5);
		bgmPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				bgmPlayer.seek(Duration.ZERO);
			}
		});
	}
	
	private void ArrayListInit(ArrayList<User> users) {
		Users.setUsers(users);
	}
	
	private void ItemsInit(ArrayList<Item> items) {
		Items.setArrayList(items);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Init user id
		UserID.setIndex(uid);
		
		// Init Data
		ArrayListInit(users);
		Users.addUsers("admin", "admin@gmail.com", "admin");
		
		ItemsInit(items);
		Items.InitializeItem();
		
		// Init Scene Manager
		SceneManager.setStage(primaryStage);
		
		// Init Stage
		primaryStage.setTitle("Jubilee Emporium");
		primaryStage.getIcons().add(new Image(new File("Assets/image/applogo.png").toURI().toString()));
		PlayAudio();
		Login login = new Login();
		
		// Pop Up View Charm
		SceneManager.setPopUp(popUp);
		popUp.setTitle("View Charm Windows");
		popUp.getIcons().add(new Image(new File("Assets/image/applogo.png").toURI().toString()));
		
		
		primaryStage.setScene(login.GetScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
