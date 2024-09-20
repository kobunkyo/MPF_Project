package main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import manager.SceneManager;
import model.User;
import model.Users;


public class Register {
	private Scene register;
	private FlowPane dataFP;
	private StackPane registerPane;
	private VBox dataVB, registerVB, allRegistVB;  
	private Image bg;
	private ImageView bgView;
	private Image image;
	private ImageView titleView;
	private Label name, email, password, confirmPass, loginLink;
	private TextField nameTF, emailTF; 
	private PasswordField passwordTF, confirmPassTF;
	private Button registerBtn;
	
	public Register() {
		image = new Image(new File("Assets/image/logo.png").toURI().toString());
		titleView = new ImageView(image);
		name = new Label("Name");
		nameTF = new TextField();
		email = new Label("Email");
		emailTF = new TextField();
		password = new Label("Password");
		passwordTF = new PasswordField();
		confirmPass = new Label("Confirm Password");
		confirmPassTF = new PasswordField();
		loginLink = new Label("Login here");
		dataVB = new VBox();
		dataFP = new FlowPane();
		registerBtn = new Button("Register Account");
		registerVB = new VBox();
		allRegistVB = new VBox();
		
		bg = new Image(new File("Assets/image/register bg.jpg").toURI().toString());
		bgView = new ImageView(bg);
		
		registerPane = new StackPane(bgView, allRegistVB);
		
		register = new Scene(registerPane, 1280, 720);
		
		SetComponent();
		SetStyles();
		SetActions();
	}
	
	private void SetComponent() {
		dataVB.getChildren().addAll(name, nameTF, email, emailTF, password, passwordTF, confirmPass, confirmPassTF, loginLink);
		dataFP.getChildren().addAll(dataVB);
		registerVB.getChildren().addAll(dataFP, registerBtn);
		allRegistVB.getChildren().addAll(titleView, registerVB);
	}
	
	private void SetStyles() {
		dataFP.setAlignment(Pos.CENTER);
		registerVB.setAlignment(Pos.CENTER);
		allRegistVB.setAlignment(Pos.CENTER);
		registerPane.setAlignment(Pos.CENTER);
		
		bgView.setFitWidth(1280);
		bgView.setFitHeight(720);
		
		int sizeTitle = 50;
		titleView.setFitHeight(sizeTitle);
		titleView.setFitWidth(sizeTitle*9);
		
		int spacing = 5;
		dataVB.setSpacing(spacing);
		registerVB.setSpacing(spacing+5);
		allRegistVB.setSpacing(spacing+10);
		
		try {
			int fontSize = 16;
			Font font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			name.setFont(font);
			email.setFont(font);
			password.setFont(font);
			confirmPass.setFont(font);
			loginLink.setFont(font);
			nameTF.setFont(font);
			emailTF.setFont(font);
			passwordTF.setFont(Font.font(fontSize));
			confirmPassTF.setFont(Font.font(fontSize));
			registerBtn.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		name.setTextFill(Color.WHITE);
		email.setTextFill(Color.WHITE);
		password.setTextFill(Color.WHITE);
		confirmPass.setTextFill(Color.WHITE);
		loginLink.setTextFill(Color.WHITE);
		registerBtn.setTextFill(Color.WHITE);
		
		int width = 350;
		int height = 30;
		nameTF.setMinWidth(width);;
		nameTF.setMaxHeight(height);
		emailTF.setMinWidth(width);;
		emailTF.setMaxHeight(height);
		passwordTF.setMinWidth(width);
		passwordTF.setMaxHeight(height);
		confirmPassTF.setMinWidth(width);
		confirmPassTF.setMaxHeight(height);
		registerBtn.setMinWidth(width);
		registerBtn.setMaxHeight(height);
		
		registerBtn.setStyle(
				"-fx-background-color: #a34c00;" + 
				"-fx-border-color: #a34c00;" + 
				"-fx-border-width: 0;"
				);
	}
	
	private void SetActions() {
		loginLink.setOnMouseClicked(e->{
			SceneManager.setScene(new Login().GetScene());
		});
		
		registerBtn.setOnMouseClicked(e->{
			boolean validate = ValidateRegister();
			if(validate) {
				Users.addUsers(nameTF.getText().toString(), emailTF.getText().toString(), passwordTF.getText().toString());
				Login login = new Login();
				SceneManager.setScene(login.GetScene());
			}
		});
	}
	
	private boolean isEmailUnique() {
		ArrayList<User> users = Users.getUsers();
		for (User user : users) {
			if(user.getEmail().equals(emailTF.getText())) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isGmail() {
		if(emailTF.getText().length() < 10) return false;
		if(emailTF.getText().split("@")[1].equals("gmail.com")) {
			return true;
		}
		return false;
	}
	
	private boolean isAlphanumeric() {
		if (Pattern.compile("[^[a-z][A-Z][0-9]]").matcher(passwordTF.getText()).find()) {
			return false;
		}
		if(Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE).matcher(passwordTF.getText()).find()) {
			if (Pattern.compile("[0-9]").matcher(passwordTF.getText()).find()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean ValidateRegister() {
		if(nameTF.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Name must be filled!", ButtonType.OK);
			alert.show();
			return false;
		} else if(nameTF.getText().length() < 3 || nameTF.getText().length() > 12) {
			Alert alert = new Alert(AlertType.ERROR, "Name must be 3-12 characters long!", ButtonType.OK);
			alert.show();
			return false;
		}
		
		if(emailTF.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Email must be filled!", ButtonType.OK);
			alert.show();
			return false;
		} else if(!isEmailUnique()) {
			Alert alert = new Alert(AlertType.ERROR, "Email must be unique!", ButtonType.OK);
			alert.show();
			return false;
		} else if(emailTF.getText().split("@").length > 2) {
			Alert alert = new Alert(AlertType.ERROR, "Email must contains only one '@'", ButtonType.OK);
			alert.show();
			return false;
		} else if(!isGmail()) {
			Alert alert = new Alert(AlertType.ERROR, "Email must end with '@gmail.com'", ButtonType.OK);
			alert.show();
			return false;
		} else if(emailTF.getText().split(" ").length > 1) {
			Alert alert = new Alert(AlertType.ERROR, "Email must not contain space!", ButtonType.OK);
			alert.show();
			return false;
		}
		
		if(passwordTF.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Password must be filled!", ButtonType.OK);
			alert.show();
			return false;
		} else if(passwordTF.getText().length() < 8) {
			Alert alert = new Alert(AlertType.ERROR, "Password must be at least 8 characters long!", ButtonType.OK);
			alert.show();
			return false;
		} else if(!isAlphanumeric()) {
			Alert alert = new Alert(AlertType.ERROR, "Password must be alphanumeric!", ButtonType.OK);
			alert.show();
			return false;
		}
		
		if(!passwordTF.getText().equals(confirmPassTF.getText())) {
			Alert alert = new Alert(AlertType.ERROR, "password and confirm password must be the same!", ButtonType.OK);
			alert.show();
			return false;
		}
		
		return true;
	}
	
	
	public Scene GetScene() {
		return register;
	}

}
