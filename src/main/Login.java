package main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import manager.SceneManager;
import manager.UserID;
import model.User;
import model.Users;

public class Login {
	private Scene login;
	private FlowPane dataFP;
	private StackPane loginPane;
	private VBox dataVB, loginVB, allLoginVB;  
	private Media media;
	private MediaPlayer video;
	private MediaView videoView;
	private Image image;
	private ImageView titleView;
	private Label email, password, registerLink;
	private TextField emailTF; 
	private PasswordField passwordTF;
	private Button loginBtn;

	public Login() {
		media = new Media(new File("Assets/video/video.mp4").toURI().toString());
		video = new MediaPlayer(media);
		videoView = new MediaView(video);
		image = new Image(new File("Assets/image/logo.png").toURI().toString());
		titleView = new ImageView(image);
		email = new Label("Email");
		emailTF = new TextField();
		password = new Label("Password");
		passwordTF = new PasswordField();
		registerLink = new Label("Click here to register");
		dataVB = new VBox();
		dataFP = new FlowPane();
		loginBtn = new Button("Login");
		loginVB = new VBox();
		allLoginVB = new VBox();
		loginPane = new StackPane(videoView, allLoginVB);
		login = new Scene(loginPane, 1280, 720);
		SetComponent();
		SetStyles();
		SetActions();
		
	}
	
	private void SetComponent() {
		dataVB.getChildren().addAll(email, emailTF, password, passwordTF, registerLink);
		dataFP.getChildren().addAll(dataVB);
		loginVB.getChildren().addAll(dataFP, loginBtn);
		allLoginVB.getChildren().addAll(titleView, loginVB);
	}
	
	private void SetStyles() {
		dataFP.setAlignment(Pos.CENTER);
		loginVB.setAlignment(Pos.CENTER);
		allLoginVB.setAlignment(Pos.CENTER);
		loginPane.setAlignment(Pos.CENTER);
		
		videoView.setFitWidth(1280);
		videoView.setFitHeight(720);
		
		int sizeTitle = 50;
		titleView.setFitHeight(sizeTitle);
		titleView.setFitWidth(sizeTitle*9);
		
		int spacing = 5;
		dataVB.setSpacing(spacing);
		loginVB.setSpacing(spacing+5);
		allLoginVB.setSpacing(spacing+10);
		
		try {
			int fontSize = 16;
			Font font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			email.setFont(font);
			password.setFont(font);
			registerLink.setFont(font);
			emailTF.setFont(font);
			passwordTF.setFont(Font.font(fontSize));
			loginBtn.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
		}

		email.setTextFill(Color.WHITE);
		password.setTextFill(Color.WHITE);
		registerLink.setTextFill(Color.WHITE);
		loginBtn.setTextFill(Color.WHITE);
		
		int width = 350;
		int height = 30;
		emailTF.setMinWidth(width);;
		emailTF.setMinHeight(height);
		passwordTF.setMinWidth(width);
		passwordTF.setMinHeight(height);
		loginBtn.setMaxWidth(width);
		loginBtn.setMinHeight(height);
		
		loginBtn.setStyle(
				"-fx-background-color: #a34c00;" + 
				"-fx-border-color: #a34c00;" + 
				"-fx-border-width: 0;"
				);
	}

	private void SetActions() {
		// Repeat Video
		video.setAutoPlay(true);
		video.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				video.seek(Duration.ZERO);
			}
		});
				
		// Validasi
		loginBtn.setOnMouseClicked(e->{
			boolean flag = LoginValidate();
			if(flag) {
			// next page
				if(emailTF.getText().equals("admin@gmail.com")) {
					Admin admin = new Admin();
					SceneManager.setScene(admin.GetScene());
				}else {
					Shop shop = new Shop();
					SceneManager.setScene(shop.GetScene()); // change to user
				}
			}
		});
		
		registerLink.setOnMouseClicked(e->{
			SceneManager.setScene(new Register().GetScene());
		});
	}
	
	private boolean LoginValidate() {
		boolean emailIsFill = false;
		boolean passIsTrue = false;
		String emailStr = emailTF.getText();
		String passwordStr = passwordTF.getText();
		
		if(emailStr.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Email must be filled!", ButtonType.OK);
			alert.show();
			return false;
		}
		if(passwordStr.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Password must be filled!", ButtonType.OK);
			alert.show();
			return false;
		}
		
		
		ArrayList<User> users = Users.getUsers();
		int i = 0;
		for (User user : users) {
			String emailCurr = user.getEmail();
			if(emailStr.equals(emailCurr)) {
				emailIsFill = true;
				String passCurr = user.getPassword();
				if(emailIsFill && passCurr.equals(passwordStr)) {
					passIsTrue = true;
					break;
				}
				break;
			}
			i++;
		}
		
		if(!emailIsFill || users.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "This email does not exist!", ButtonType.OK);
			alert.show();
			return false;
		}
		
		if(!passIsTrue) {
			Alert alert = new Alert(AlertType.ERROR, "This password does not match!", ButtonType.OK);
			alert.show();
			return false;
		}
		
		UserID.setIndex(i);
		return true;
	}

	public Scene GetScene() {
		return login;
	}
	
}
