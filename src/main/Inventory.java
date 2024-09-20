package main;

import java.io.File;
import java.io.FileInputStream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import manager.SceneManager;
import manager.UserID;
import model.Items;
import model.Users;

public class Inventory {
	private Scene scene;
	private MenuBar mb;
	private Menu menu;
	private MenuItem shop, logout;
	private Label title, imgTitle1, imgTitle2, imgTitle3, imgTitle4, imgTitle5, quantityLabel1, quantityLabel2, quantityLabel3, quantityLabel4 ,quantityLabel5;
	private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
	private Button useCharm1, useCharm2, useCharm3, useCharm4, useCharm5;
	private VBox item1, item2, item3, item4, item5, buttonQuant1, buttonQuant2, buttonQuant3, buttonQuant4, buttonQuant5, bpCenter;
	private HBox section1, section2;
	private BorderPane bp;
	private int index; 
	private Integer[] quantity;
	
	public Inventory() {
		mb = new MenuBar();
		menu = new Menu("Menu");
		shop = new MenuItem("Shop");
		logout = new MenuItem("Logout");
		title = new Label("JE's Inventory");
		
		index = UserID.getIndex();
		quantity = Users.getUsers().get(index).getQuantity();
		
		// Data1
		imgTitle1 = new Label(Items.getItems().get(0).getName());
		imageView1 = new ImageView(new Image(Items.getItems().get(0).getImageURL()));
		quantityLabel1 = new Label(String.format("Quantity: %dx", quantity[0]));
		useCharm1 = new Button("Use Charm");
		
		// Data 2
		imgTitle2 = new Label(Items.getItems().get(1).getName());
		imageView2 = new ImageView(new Image(Items.getItems().get(1).getImageURL()));
		quantityLabel2 = new Label(String.format("Quantity: %dx", quantity[1]));
		useCharm2 = new Button("Use Charm");
		
		// Data 3
		imgTitle3 = new Label(Items.getItems().get(2).getName());
		imageView3 = new ImageView(new Image(Items.getItems().get(2).getImageURL()));
		quantityLabel3 = new Label(String.format("Quantity: %dx", quantity[2]));
		useCharm3 = new Button("Use Charm");
		
		// Data 4
		imgTitle4 = new Label(Items.getItems().get(3).getName());
		imageView4 = new ImageView(new Image(Items.getItems().get(3).getImageURL()));
		quantityLabel4 = new Label(String.format("Quantity: %dx", quantity[3]));
		useCharm4 = new Button("Use Charm");
		
		// Data 5
		imgTitle5 = new Label(Items.getItems().get(4).getName());
		imageView5 = new ImageView(new Image(Items.getItems().get(4).getImageURL()));
		quantityLabel5 = new Label(String.format("Quantity: %dx", quantity[4]));
		useCharm5 = new Button("Use Charm");
		
		item1 = new VBox();
		item2 = new VBox();
		item3 = new VBox();
		item4 = new VBox();
		item5 = new VBox();
		
		buttonQuant1 = new VBox();
		buttonQuant2 = new VBox();
		buttonQuant3 = new VBox();
		buttonQuant4 = new VBox();
		buttonQuant5 = new VBox();
		
		section1 = new HBox();
		section2 = new HBox();
		bpCenter = new VBox();
		bp = new BorderPane();
		SetSection();
		SetComponent();
		SetStyles();
		SetActions();
		SetScene();
	}
	
	private void SetSection() {
		if(quantity[0] != 0 && quantity[1] != 0 && quantity[2] != 0 && quantity[3] != 0 && quantity[4] != 0) {
			section1.getChildren().addAll(item1, item2, item3);
			section2.getChildren().addAll(item4, item5);
			return;
		} else if(quantity[0] == 0 && quantity[1] == 0 && quantity[2] == 0 && quantity[3] == 0 && quantity[4] == 0) {
			return;
		} else if(quantity[0] <= 0 && quantity[1] <= 0 && quantity[2] <= 0 && quantity[3] <= 0) {
			section1.getChildren().addAll(item5);
			return;
		} else if(quantity[0] <= 0 && quantity[1] <= 0 && quantity[2] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item4);
			return;
		} else if(quantity[0] <= 0 && quantity[1] <= 0 && quantity[3] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item3);
			return;
		} else if(quantity[0] <= 0 && quantity[2] <= 0 && quantity[3] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item2);
			return;
		} else if(quantity[1] <= 0 && quantity[2] <= 0 && quantity[3] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item1);
			return;
		} else if(quantity[0] <= 0 && quantity[1] <= 0 && quantity[2] <= 0) {
			section1.getChildren().addAll(item4, item5);
			return;
		} else if(quantity[0] <= 0 && quantity[1] <= 0 && quantity[3] <= 0) {
			section1.getChildren().addAll(item3, item5);
			return;
		} else if(quantity[0] <= 0 && quantity[1] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item3, item4);
			return;
		} else if(quantity[0] <= 0 && quantity[2] <= 0 && quantity[3] <= 0) {
			section1.getChildren().addAll(item2, item5);
			return;
		} else if(quantity[0] <= 0 && quantity[2] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item2, item4);
			return;
		} else if(quantity[0] <= 0 && quantity[3] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item2, item3);
			return;
		} else if(quantity[1] <= 0 && quantity[2] <= 0 && quantity[3] <= 0) {
			section1.getChildren().addAll(item1, item5);
			return;
		} else if(quantity[1] <= 0 && quantity[2] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item1, item4);
			return;
		} else if(quantity[1] <= 0 && quantity[3] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item1, item3);
			return;
		} else if(quantity[2] <= 0 && quantity[3] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item1, item2);
			return;
		} else if(quantity[0] <= 0 && quantity[1] <= 0) {
			section1.getChildren().addAll(item3, item4, item5);
			return;
		} else if(quantity[0] <= 0 && quantity[2] <= 0) {
			section1.getChildren().addAll(item2, item4, item5);
			return;
		} else if(quantity[0] <= 0 && quantity[3] <= 0) {
			section1.getChildren().addAll(item2, item3, item5);
			return;
		} else if(quantity[0] <= 0 && quantity[4] <= 0) {
			section1.getChildren().addAll(item2, item3, item4);
			return;
		} else if(quantity[1] <= 0 && quantity[2] <= 0){
			section1.getChildren().addAll(item1, item4, item5);
			return;
		} else if(quantity[1] <= 0 && quantity[3] <= 0){
			section1.getChildren().addAll(item1, item3, item5);
			return;
		} else if(quantity[1] <= 0 && quantity[4] <= 0){
			section1.getChildren().addAll(item1, item3, item4);
			return;
		} else if(quantity[2] <= 0 && quantity[3] <= 0){
			section1.getChildren().addAll(item1, item2, item5);
			return;
		} else if(quantity[2] <= 0 && quantity[4] <= 0){
			section1.getChildren().addAll(item1, item2, item4);
			return;
		} else if(quantity[3] <= 0 && quantity[4] <= 0){
			section1.getChildren().addAll(item1, item2, item3);
			return;
		} else if(quantity[0] <= 0) {
			section1.getChildren().addAll(item2, item3, item4);
			section2.getChildren().addAll(item5);
			return;
		} else if(quantity[1] <= 0){
			section1.getChildren().addAll(item1, item3, item4);
			section2.getChildren().addAll(item5);
			return;
		} else if(quantity[2] <= 0){
			section1.getChildren().addAll(item1, item2, item4);
			section2.getChildren().addAll(item5);
			return;
		} else if(quantity[3] <= 0){
			section1.getChildren().addAll(item1, item2, item3);
			section2.getChildren().addAll(item5);
			return;
		} else if(quantity[4] <= 0){
			section1.getChildren().addAll(item1, item2, item3);
			section2.getChildren().addAll(item4);
			return;
		}
		
		
	}
	
	private void SetComponent() {
		menu.getItems().addAll(shop, logout);
		mb.getMenus().addAll(menu);
		buttonQuant1.getChildren().addAll(quantityLabel1, useCharm1);
		buttonQuant2.getChildren().addAll(quantityLabel2, useCharm2);
		buttonQuant3.getChildren().addAll(quantityLabel3, useCharm3);
		buttonQuant4.getChildren().addAll(quantityLabel4, useCharm4);
		buttonQuant5.getChildren().addAll(quantityLabel5, useCharm5);
		item1.getChildren().addAll(imgTitle1, imageView1, buttonQuant1);
		item2.getChildren().addAll(imgTitle2, imageView2, buttonQuant2);
		item3.getChildren().addAll(imgTitle3, imageView3, buttonQuant3);
		item4.getChildren().addAll(imgTitle4, imageView4, buttonQuant4);
		item5.getChildren().addAll(imgTitle5, imageView5, buttonQuant5);
		
		
		bpCenter.getChildren().addAll(title, section1, section2);
		
		bp.setTop(mb);
		bp.setCenter(bpCenter);
		
	}

	private void SetStyles() {
		bp.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		bpCenter.setSpacing(15);
		section1.setSpacing(15);
		section2.setSpacing(15);
		
		// Data 1
		buttonQuant1.setSpacing(10);
		item1.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item1.setMinWidth(225);
		item1.setMinHeight(300);
		item1.setSpacing(5);
		useCharm1.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		imageView1.setFitHeight(150);
		imageView1.setFitWidth(80);
		
		// Data 2
		buttonQuant2.setSpacing(10);
		item2.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item2.setMinWidth(225);
		item2.setMinHeight(300);
		item2.setSpacing(5);
		useCharm2.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		imageView2.setFitHeight(150);
		imageView2.setFitWidth(120);
		
		// Data 3
		buttonQuant3.setSpacing(10);
		item3.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item3.setMinWidth(225);
		item3.setMinHeight(300);
		item3.setSpacing(5);
		useCharm3.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		imageView3.setFitHeight(150);
		imageView3.setFitWidth(222);
		
		// Data 4
		buttonQuant4.setSpacing(10);
		item4.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item4.setMinWidth(225);
		item4.setMinHeight(300);
		item4.setSpacing(5);
		useCharm4.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		imageView4.setFitHeight(150);
		imageView4.setFitWidth(90);
		
		// Data 5
		buttonQuant5.setSpacing(10);
		item5.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item5.setMinWidth(225);
		item5.setMinHeight(300);
		item5.setSpacing(5);
		useCharm5.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		imageView5.setFitHeight(150);
		imageView5.setFitWidth(117);
		
		try {
			int fontSize = 40;
			Font font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			title.setFont(font);
			title.setTextFill(Color.WHITE);
			title.setMaxHeight(45);
			
			fontSize = 25;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			imgTitle1.setFont(font);
			imgTitle1.setTextFill(Color.WHITE);
			imgTitle2.setFont(font);
			imgTitle2.setTextFill(Color.WHITE);
			imgTitle3.setFont(font);
			imgTitle3.setTextFill(Color.WHITE);
			imgTitle4.setFont(font);
			imgTitle4.setTextFill(Color.WHITE);
			imgTitle5.setFont(font);
			imgTitle5.setTextFill(Color.WHITE);
			
			fontSize = 18;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			quantityLabel1.setFont(font);
			quantityLabel1.setTextFill(Color.WHITE);
			quantityLabel2.setFont(font);
			quantityLabel2.setTextFill(Color.WHITE);
			quantityLabel3.setFont(font);
			quantityLabel3.setTextFill(Color.WHITE);
			quantityLabel4.setFont(font);
			quantityLabel4.setTextFill(Color.WHITE);
			quantityLabel5.setFont(font);
			quantityLabel5.setTextFill(Color.WHITE);
			
			fontSize = 16;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			useCharm1.setFont(font);
			useCharm1.setTextFill(Color.WHITE);
			useCharm2.setFont(font);
			useCharm2.setTextFill(Color.WHITE);
			useCharm3.setFont(font);
			useCharm3.setTextFill(Color.WHITE);
			useCharm4.setFont(font);
			useCharm4.setTextFill(Color.WHITE);
			useCharm5.setFont(font);
			useCharm5.setTextFill(Color.WHITE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		buttonQuant1.setAlignment(Pos.CENTER);
		buttonQuant2.setAlignment(Pos.CENTER);
		buttonQuant3.setAlignment(Pos.CENTER);
		buttonQuant4.setAlignment(Pos.CENTER);
		buttonQuant5.setAlignment(Pos.CENTER);
		item1.setAlignment(Pos.CENTER);
		item2.setAlignment(Pos.CENTER);
		item3.setAlignment(Pos.CENTER);
		item4.setAlignment(Pos.CENTER);
		item5.setAlignment(Pos.CENTER);
		section1.setAlignment(Pos.CENTER);
		section2.setAlignment(Pos.CENTER);
		bpCenter.setAlignment(Pos.TOP_CENTER);
	}
	
	private void ViewCharms() {
		imageView1.setOnMouseClicked(e->{
			SceneManager.setImageByIndex(0);
			ViewCharm viewCharm = new ViewCharm();
			viewCharm.setPopUp(true);
			if(viewCharm.getPopUpProperty()) {
				SceneManager.setPopUpScene(viewCharm.GetScene());
				SceneManager.showPopUp();
			}
			
		});
		
		imageView2.setOnMouseClicked(e->{
			SceneManager.setImageByIndex(1);
			ViewCharm viewCharm = new ViewCharm();
			viewCharm.setPopUp(true);
			if(viewCharm.getPopUpProperty()) {
				SceneManager.setPopUpScene(viewCharm.GetScene());
				SceneManager.showPopUp();
			}
			
		});
		
		imageView3.setOnMouseClicked(e->{
			SceneManager.setImageByIndex(2);
			ViewCharm viewCharm = new ViewCharm();
			viewCharm.setPopUp(true);
			if(viewCharm.getPopUpProperty()) {
				SceneManager.setPopUpScene(viewCharm.GetScene());
				SceneManager.showPopUp();
			}
			
		});
		
		imageView4.setOnMouseClicked(e->{
			SceneManager.setImageByIndex(3);
			ViewCharm viewCharm = new ViewCharm();
			viewCharm.setPopUp(true);
			if(viewCharm.getPopUpProperty()) {
				SceneManager.setPopUpScene(viewCharm.GetScene());
				SceneManager.showPopUp();
			}
			
		});
		
		imageView5.setOnMouseClicked(e->{
			SceneManager.setImageByIndex(4);
			ViewCharm viewCharm = new ViewCharm();
			viewCharm.setPopUp(true);
			if(viewCharm.getPopUpProperty()) {
				SceneManager.setPopUpScene(viewCharm.GetScene());
				SceneManager.showPopUp();
			}
			
		});
	}
	
	private void SetActions() {
		logout.setOnAction(e->{
			Login login = new Login(); 
			SceneManager.setScene(login.GetScene());
		});
		
		shop.setOnAction(e->{
			Shop shopScene = new Shop();
			SceneManager.setScene(shopScene.GetScene());
		});
		
		useCharm1.setOnMouseClicked(e->{
			Users.getUsers().get(index).setQty1();
			SceneManager.setScene(new Inventory().GetScene());
		});
		useCharm2.setOnMouseClicked(e->{
			Users.getUsers().get(index).setQty2();
			SceneManager.setScene(new Inventory().GetScene());
		});
		useCharm3.setOnMouseClicked(e->{
			Users.getUsers().get(index).setQty3();
			SceneManager.setScene(new Inventory().GetScene());
		});
		useCharm4.setOnMouseClicked(e->{
			Users.getUsers().get(index).setQty4();
			SceneManager.setScene(new Inventory().GetScene());
		});
		useCharm5.setOnMouseClicked(e->{
			Users.getUsers().get(index).setQty5();
			SceneManager.setScene(new Inventory().GetScene());
		});
		
		ViewCharms();
	}
	
	public void SetIndex(int index) {
		this.index = index;
	}
	
	private void SetScene() {
		scene = new Scene(bp, 1280, 720);
	}
	
	public Scene GetScene() {
		return scene;
	}
}
