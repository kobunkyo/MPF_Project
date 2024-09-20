package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import manager.SceneManager;
import manager.UserID;
import model.Items;
import model.Users;

public class Shop {
	private Scene scene;
	private BorderPane bp;
	private MenuBar mb;
	private Menu menu;
	private MenuItem inventory, logout;
	private VBox leftSection, itemQty1, itemQty2, itemQty3, itemQty4, itemQty5;
	private VBox rightSection, item1, item2, item3, item4, item5;
	private FlowPane itemsQtyFP, itemsFP, totalsFP, coinsFP, emptyFP;
	private HBox buttonCollections, bpCenter;
	private ScrollPane itemsSP;
	private Button checkoutButton, clearButton;
	private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
	private Label leftSectionTitle, totalPriceLabel, emptyQtyLabel, itemQtyLabel1, itemQtyLabel2, itemQtyLabel3, itemQtyLabel4, itemQtyLabel5, qtyLabel1, qtyLabel2, qtyLabel3, qtyLabel4, qtyLabel5;
	private Label rightSectionTitle, totalCoinsLabel, imgLabel1, imgLabel2, imgLabel3, imgLabel4, imgLabel5, itemPriceLabel1, itemPriceLabel2, itemPriceLabel3, itemPriceLabel4, itemPriceLabel5, stockItemLabel1, stockItemLabel2, stockItemLabel3, stockItemLabel4, stockItemLabel5;
	private int index, qty1, qty2, qty3, qty4, qty5, price, coin;

	public Shop() {
		index = UserID.getIndex();
		price = Users.getUsersByIndex(index).getTotalPrice();
		coin = Users.getUsers().get(index).getCoin();
		
		mb = new MenuBar();
		menu = new Menu("Menu");
		inventory = new MenuItem("Inventory");
		logout = new MenuItem("Logout");
		
		leftSectionTitle = new Label("Your Cart");
		emptyQtyLabel = new Label("Your cart is currently empty!");
		totalPriceLabel = new Label(String.format("Total: %d", price));
		checkoutButton = new Button("Checkout");
		clearButton = new Button("Clear Cart");
		
		// item cart 1
		qty1 = Users.getUsersByIndex(index).getItemQuantity1();
		itemQtyLabel1 = new Label(Items.getItems().get(0).getName());
		qtyLabel1 = new Label(String.format("Quantity: %d", qty1));
		
		// item cart 2
		qty2 = Users.getUsersByIndex(index).getItemQuantity2();
		itemQtyLabel2 = new Label(Items.getItems().get(1).getName());
		qtyLabel2 = new Label(String.format("Quantity: %d", qty2));
		
		// item cart 3
		qty3 = Users.getUsersByIndex(index).getItemQuantity3();
		itemQtyLabel3 = new Label(Items.getItems().get(2).getName());
		qtyLabel3 = new Label(String.format("Quantity: %d", qty3));
		
		// item cart 4
		qty4 = Users.getUsersByIndex(index).getItemQuantity4();
		itemQtyLabel4 = new Label(Items.getItems().get(3).getName());
		qtyLabel4 = new Label(String.format("Quantity: %d", qty4));
		
		// item cart 5
		qty5 = Users.getUsersByIndex(index).getItemQuantity5();
		itemQtyLabel5 = new Label(Items.getItems().get(4).getName());
		qtyLabel5 = new Label(String.format("Quantity: %d", qty5));
		
		
		rightSectionTitle = new Label("Charm Shop");
		totalCoinsLabel = new Label(String.format("Coin: %d", coin));
		
		// item1
		imgLabel1 = new Label(Items.getItems().get(0).getName());
		imageView1 = new ImageView(new Image(Items.getItems().get(0).getImageURL()));
		itemPriceLabel1 = new Label(String.format("Price: %d", Items.getItems().get(0).getPrice()));
		stockItemLabel1 = new Label(String.format("Stock: %d", Items.getItems().get(0).getStock()));
		
		// item2
		imgLabel2 = new Label(Items.getItems().get(1).getName());
		imageView2 = new ImageView(new Image(Items.getItems().get(1).getImageURL()));
		itemPriceLabel2 = new Label(String.format("Price: %d", Items.getItems().get(1).getPrice()));
		stockItemLabel2 = new Label(String.format("Stock: %d", Items.getItems().get(1).getStock()));
		
		// item3
		imgLabel3 = new Label(Items.getItems().get(2).getName());
		imageView3 = new ImageView(new Image(Items.getItems().get(2).getImageURL()));
		itemPriceLabel3 = new Label(String.format("Price: %d", Items.getItems().get(2).getPrice()));
		stockItemLabel3 = new Label(String.format("Stock: %d", Items.getItems().get(2).getStock()));
		
		// item4
		imgLabel4 = new Label(Items.getItems().get(3).getName());
		imageView4 = new ImageView(new Image(Items.getItems().get(3).getImageURL()));
		itemPriceLabel4 = new Label(String.format("Price: %d", Items.getItems().get(3).getPrice()));
		stockItemLabel4 = new Label(String.format("Stock: %d", Items.getItems().get(3).getStock()));
		
		// item5
		imgLabel5 = new Label(Items.getItems().get(4).getName());
		imageView5 = new ImageView(new Image(Items.getItems().get(4).getImageURL()));
		itemPriceLabel5 = new Label(String.format("Price: %d", Items.getItems().get(4).getPrice()));
		stockItemLabel5 = new Label(String.format("Stock: %d", Items.getItems().get(4).getStock()));
		
		itemsFP = new FlowPane();
		itemsQtyFP = new FlowPane();
		totalsFP = new FlowPane();
		coinsFP = new FlowPane();
		emptyFP = new FlowPane();
		
		buttonCollections = new HBox();
		
		itemsSP = new ScrollPane();
		
		item1 = new VBox();
		item2 = new VBox();
		item3 = new VBox();
		item4 = new VBox();
		item5 = new VBox();
		
		itemQty1 = new VBox();
		itemQty2 = new VBox();
		itemQty3 = new VBox();
		itemQty4 = new VBox();
		itemQty5 = new VBox();
		
		leftSection = new VBox();
		rightSection = new VBox();
		bpCenter = new HBox();
		bp = new BorderPane();
		
		SetComponent();
		SetStyles();
		SetActions();
		
		scene = new Scene(bp, 1280, 720);
	}
	
	private void SetCart() {
		if(qty1 == 0 && qty2 == 0 && qty3 == 0 && qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(emptyFP);
			return;
		} else if(qty2 == 0 && qty3 == 0 && qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1);
			return;
		} else if(qty1 == 0 && qty3 == 0 && qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2);
			return;
		} else if(qty1 == 0 && qty2 == 0 && qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty3);
			return;
		} else if(qty1 == 0 && qty2 == 0 && qty3 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty4);
			return;
		} else if(qty1 == 0 && qty2 == 0 && qty3 == 0 && qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty5);
			return;
		} else if(qty3 == 0 && qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2);
			return;
		} else if(qty2 == 0 && qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty3);
			return;
		} else if(qty2 == 0 && qty3 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty4);
			return;
		} else if(qty2 == 0 && qty3 == 0 && qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty5);
			return;
		} else if(qty1 == 0 && qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2, itemQty3);
			return;
		} else if(qty1 == 0 && qty3 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2, itemQty4);
			return;
		} else if(qty1 == 0 && qty3 == 0 && qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2, itemQty5);
			return;
		} else if(qty1 == 0 && qty2 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty3, itemQty4);
			return;
		} else if(qty1 == 0 && qty2 == 0 && qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty3, itemQty5);
			return;
		} else if(qty1 == 0 && qty2 == 0 && qty3 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty4, itemQty5);
			return;
		} else if(qty4 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2, itemQty3);
			return;
		} else if(qty3 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2, itemQty4);
			return;
		} else if(qty3 == 0 && qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2, itemQty5);
			return;
		} else if(qty2 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty3, itemQty4);
			return;
		} else if(qty2 == 0 && qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty3, itemQty5);
			return;
		} else if(qty2 == 0 && qty3 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty4, itemQty5);
			return;
		} else if(qty1 == 0 && qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2, itemQty3, itemQty4);
			return;
		} else if(qty1 == 0 && qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2, itemQty3, itemQty5);
			return;
		} else if(qty1 == 0 && qty3 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2, itemQty4, itemQty5);
			return;
		} else if(qty1 == 0 && qty2 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty3, itemQty4, itemQty5);
			return;
		} else if(qty5 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2, itemQty3,  itemQty4);
			return;
		} else if(qty4 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2, itemQty3,  itemQty5);
			return;
		} else if(qty3 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2, itemQty4,  itemQty5);
			return;
		} else if(qty2 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty3, itemQty4,  itemQty5);
			return;
		} else if(qty1 == 0) {
			itemsQtyFP.getChildren().addAll(itemQty2, itemQty3, itemQty4,  itemQty5);
			return;
		} else {
			itemsQtyFP.getChildren().addAll(itemQty1, itemQty2, itemQty3, itemQty4,  itemQty5);
		}
	}

	private void SetComponent() {
		menu.getItems().addAll(inventory, logout);
		mb.getMenus().addAll(menu);
		
		emptyFP.getChildren().addAll(emptyQtyLabel);
		
		itemQty1.getChildren().addAll(itemQtyLabel1, qtyLabel1);
		itemQty2.getChildren().addAll(itemQtyLabel2, qtyLabel2);
		itemQty3.getChildren().addAll(itemQtyLabel3, qtyLabel3);
		itemQty4.getChildren().addAll(itemQtyLabel4, qtyLabel4);
		itemQty5.getChildren().addAll(itemQtyLabel5, qtyLabel5);
		
		SetCart();
		
		buttonCollections.getChildren().addAll(checkoutButton, clearButton);
		totalsFP.getChildren().addAll(totalPriceLabel);
		leftSection.getChildren().addAll(leftSectionTitle, itemsQtyFP, totalsFP, buttonCollections);
		
		item1.getChildren().addAll(imgLabel1, imageView1, itemPriceLabel1, stockItemLabel1);
		item2.getChildren().addAll(imgLabel2, imageView2, itemPriceLabel2, stockItemLabel2);
		item3.getChildren().addAll(imgLabel3, imageView3, itemPriceLabel3, stockItemLabel3);
		item4.getChildren().addAll(imgLabel4, imageView4, itemPriceLabel4, stockItemLabel4);
		item5.getChildren().addAll(imgLabel5, imageView5, itemPriceLabel5, stockItemLabel5);
		
		itemsFP.getChildren().addAll(item1, item2, item3, item4, item5);
		itemsSP.setContent(itemsFP);
		coinsFP.getChildren().addAll(totalCoinsLabel);
		rightSection.getChildren().addAll(rightSectionTitle, itemsSP, coinsFP);
		
		bpCenter.getChildren().addAll(leftSection, rightSection);
		
		bp.setTop(mb);
		bp.setCenter(bpCenter);
		
	}
	
	private void SetFonts() {
		try {
			int fontSize = 40;
			Font font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			leftSectionTitle.setFont(font);
			leftSectionTitle.setTextFill(Color.WHITE);
			rightSectionTitle.setFont(font);
			rightSectionTitle.setTextFill(Color.WHITE);
			
			fontSize = 30;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			emptyQtyLabel.setFont(font);
			emptyQtyLabel.setTextFill(Color.WHITE);
			
			fontSize = 25;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			totalPriceLabel.setFont(font);
			totalPriceLabel.setTextFill(Color.WHITE);
			totalCoinsLabel.setFont(font);
			totalCoinsLabel.setTextFill(Color.WHITE);
			
			fontSize = 20;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			itemQtyLabel1.setFont(font);
			itemQtyLabel1.setTextFill(Color.WHITE);
			itemQtyLabel2.setFont(font);
			itemQtyLabel2.setTextFill(Color.WHITE);
			itemQtyLabel3.setFont(font);
			itemQtyLabel3.setTextFill(Color.WHITE);
			itemQtyLabel4.setFont(font);
			itemQtyLabel4.setTextFill(Color.WHITE);
			itemQtyLabel5.setFont(font);
			itemQtyLabel5.setTextFill(Color.WHITE);
			
			imgLabel1.setFont(font);
			imgLabel1.setTextFill(Color.WHITE);
			imgLabel2.setFont(font);
			imgLabel2.setTextFill(Color.WHITE);
			imgLabel3.setFont(font);
			imgLabel3.setTextFill(Color.WHITE);
			imgLabel4.setFont(font);
			imgLabel4.setTextFill(Color.WHITE);
			imgLabel5.setFont(font);
			imgLabel5.setTextFill(Color.WHITE);
			
			fontSize = 15;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			qtyLabel1.setFont(font);
			qtyLabel1.setTextFill(Color.WHITE);
			qtyLabel2.setFont(font);
			qtyLabel2.setTextFill(Color.WHITE);
			qtyLabel3.setFont(font);
			qtyLabel3.setTextFill(Color.WHITE);
			qtyLabel4.setFont(font);
			qtyLabel4.setTextFill(Color.WHITE);
			qtyLabel5.setFont(font);
			qtyLabel5.setTextFill(Color.WHITE);
			
			itemPriceLabel1.setFont(font);
			itemPriceLabel1.setTextFill(Color.WHITE);
			itemPriceLabel2.setFont(font);
			itemPriceLabel2.setTextFill(Color.WHITE);
			itemPriceLabel3.setFont(font);
			itemPriceLabel3.setTextFill(Color.WHITE);
			itemPriceLabel4.setFont(font);
			itemPriceLabel4.setTextFill(Color.WHITE);
			itemPriceLabel5.setFont(font);
			itemPriceLabel5.setTextFill(Color.WHITE);
			
			stockItemLabel1.setFont(font);
			stockItemLabel1.setTextFill(Color.WHITE);
			stockItemLabel2.setFont(font);
			stockItemLabel2.setTextFill(Color.WHITE);
			stockItemLabel3.setFont(font);
			stockItemLabel3.setTextFill(Color.WHITE);
			stockItemLabel4.setFont(font);
			stockItemLabel4.setTextFill(Color.WHITE);
			stockItemLabel5.setFont(font);
			stockItemLabel5.setTextFill(Color.WHITE);
			
			checkoutButton.setFont(font);
			checkoutButton.setTextFill(Color.WHITE);
			clearButton.setFont(font);
			clearButton.setTextFill(Color.WHITE);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void SetStyles() {
		SetFonts();
		double leftSectionMinWidth = 1280*0.5 - 10;
		double rightSectionMinWidth = 1280*0.45 - 10;
		
		bp.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		bpCenter.setAlignment(Pos.CENTER);
		bpCenter.setSpacing(100);
		
		// Left Section
		leftSection.setAlignment(Pos.TOP_CENTER);
		leftSection.setMinWidth(leftSectionMinWidth);
		
		itemQty1.setAlignment(Pos.CENTER);
		itemQty2.setAlignment(Pos.CENTER);
		itemQty3.setAlignment(Pos.CENTER);
		itemQty4.setAlignment(Pos.CENTER);
		itemQty5.setAlignment(Pos.CENTER);
		
		itemQty1.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		itemQty2.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		itemQty3.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		itemQty4.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		itemQty5.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		
		double qtyMinWidth = 190;
		double qtyMinHeigth = 80;
		itemQty1.setMinSize(qtyMinWidth, qtyMinHeigth);
		itemQty2.setMinSize(qtyMinWidth, qtyMinHeigth);
		itemQty3.setMinSize(qtyMinWidth, qtyMinHeigth);
		itemQty4.setMinSize(qtyMinWidth, qtyMinHeigth);
		itemQty5.setMinSize(qtyMinWidth, qtyMinHeigth);
		
		buttonCollections.setAlignment(Pos.CENTER);
		buttonCollections.setSpacing(10);
		buttonCollections.setPadding(new Insets(20, 0, 0, 0));
		checkoutButton.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(5), Insets.EMPTY)));
		clearButton.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(5), Insets.EMPTY)));
		
		totalsFP.setMinHeight(40);
		totalsFP.setMaxHeight(40);
		totalsFP.setMinWidth(leftSectionMinWidth);
		totalsFP.setAlignment(Pos.CENTER_LEFT);
		totalsFP.setPadding(new Insets(10));
		
		emptyFP.setMinWidth(leftSectionMinWidth);
		emptyFP.setAlignment(Pos.TOP_LEFT);
		
		itemsQtyFP.setHgap(10);
		itemsQtyFP.setVgap(20);
		itemsQtyFP.setMinWidth(leftSectionMinWidth);
		itemsQtyFP.setMinHeight(525);
		itemsQtyFP.setAlignment(Pos.TOP_CENTER);
		itemsQtyFP.setPadding(new Insets(10, 0, 0, 0));
		
		// Right Section
		rightSection.setAlignment(Pos.TOP_CENTER);
		rightSection.setMinWidth(rightSectionMinWidth);
		
		coinsFP.setAlignment(Pos.CENTER_RIGHT);
		coinsFP.setPadding(new Insets(10));
		
		itemsSP.setPadding(new Insets(10));
		itemsSP.setFitToWidth(true);
		itemsSP.setBorder(Border.EMPTY);
		itemsSP.setStyle("-fx-background: #8B4513;" + "-fx-background-color: #8B4513");
		itemsSP.setMinSize(rightSectionMinWidth-100, 550);
		itemsFP.setHgap(10);
		itemsFP.setVgap(20);
		itemsFP.setPadding(new Insets(10));
		itemsFP.setMinSize(rightSectionMinWidth-100, 550);
		
		double ivHeigth1 = 130;
		double ivWidth1 = ivHeigth1 * 85 / 160;
		imageView1.setFitHeight(ivHeigth1);
		imageView1.setFitWidth(ivWidth1);
		
		double ivHeigth2 = 110;
		double ivWidth2 = ivHeigth2 * 85 / 106;
		imageView2.setFitHeight(ivHeigth2);
		imageView2.setFitWidth(ivWidth2);
		
		double ivHeigth3 = 120;
		double ivWidth3 = ivHeigth3 * 163 / 110;
		imageView3.setFitHeight(ivHeigth3);
		imageView3.setFitWidth(ivWidth3);
		
		double ivHeigth4 = 120;
		double ivWidth4 = ivHeigth4 * 89 / 148;
		imageView4.setFitHeight(ivHeigth4);
		imageView4.setFitWidth(ivWidth4);
		
		double ivHeigth5 = 110;
		double ivWidth5 = ivHeigth5 * 84 / 108;
		imageView5.setFitHeight(ivHeigth5);
		imageView5.setFitWidth(ivWidth5);
		
		double itemMinWidth = 210;
		double itemMinHeight = 200;
		item1.setMinSize(itemMinWidth, itemMinHeight);
		item2.setMinSize(itemMinWidth, itemMinHeight);
		item3.setMinSize(itemMinWidth, itemMinHeight);
		item4.setMinSize(itemMinWidth, itemMinHeight);
		item5.setMinSize(itemMinWidth, itemMinHeight);
		
		item1.setAlignment(Pos.CENTER);
		item2.setAlignment(Pos.CENTER);
		item3.setAlignment(Pos.CENTER);
		item4.setAlignment(Pos.CENTER);
		item5.setAlignment(Pos.CENTER);
		
		item1.setSpacing(5);
		item2.setSpacing(5);
		item3.setSpacing(5);
		item4.setSpacing(5);
		item5.setSpacing(5);
		
		item1.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item2.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item3.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item4.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		item5.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(10), Insets.EMPTY)));
		
		item1.setPadding(new Insets(30, 10, 30, 10));
		item2.setPadding(new Insets(30, 10, 30, 10));
		item3.setPadding(new Insets(30, 10, 30, 10));
		item4.setPadding(new Insets(30, 10, 30, 10));
		item5.setPadding(new Insets(30, 10, 30, 10));
		
		leftSection.setPadding(new Insets(10, 0, 20, 10));
		rightSection.setPadding(new Insets(10, 20, 0, 10));

	}
	
	private void SetDragAndDrop() {
		item1.setOnDragDetected(e->{
			Dragboard board = item1.startDragAndDrop(TransferMode.ANY);
			ClipboardContent cc = new ClipboardContent();
			cc.putString("1");
			board.setContent(cc);
		});
		
		item1.setOnMouseDragged(e->{
			e.setDragDetect(true);
		});
		
		item2.setOnDragDetected(e->{
			Dragboard board = item2.startDragAndDrop(TransferMode.ANY);
			ClipboardContent cc = new ClipboardContent();
			cc.putString("2");
			board.setContent(cc);
		});
		
		item2.setOnMouseDragged(e->{
			e.setDragDetect(true);
		});
		
		item3.setOnDragDetected(e->{
			Dragboard board = item3.startDragAndDrop(TransferMode.ANY);
			ClipboardContent cc = new ClipboardContent();
			cc.putString("3");
			board.setContent(cc);
		});
		
		item3.setOnMouseDragged(e->{
			e.setDragDetect(true);
		});
		
		item4.setOnDragDetected(e->{
			Dragboard board = item4.startDragAndDrop(TransferMode.ANY);
			ClipboardContent cc = new ClipboardContent();
			cc.putString("4");
			board.setContent(cc);
		});
		
		item4.setOnMouseDragged(e->{
			e.setDragDetect(true);
		});
		
		item5.setOnDragDetected(e->{
			Dragboard board = item5.startDragAndDrop(TransferMode.ANY);
			ClipboardContent cc = new ClipboardContent();
			cc.putString("5");
			board.setContent(cc);
		});
		
		item5.setOnMouseDragged(e->{
			e.setDragDetect(true);
		});
		
		itemsQtyFP.setOnDragOver(e ->{
			e.acceptTransferModes(TransferMode.ANY);
		});
		
		itemsQtyFP.setOnDragDropped(e->{
			Dragboard board = e.getDragboard();
			Integer item = Integer.parseInt(board.getString());
			switch (item) {
			case 1:
				Users.getUsersByIndex(index).setItemQuantity1(qty1++);
				Users.getUsersByIndex(index).setTotalPrice(Items.getItems().get(0).getPrice());
				break;
			case 2:
				Users.getUsersByIndex(index).setItemQuantity2(qty2++);
				Users.getUsersByIndex(index).setTotalPrice(Items.getItems().get(1).getPrice());
				break;
			case 3:
				Users.getUsersByIndex(index).setItemQuantity3(qty3++);
				Users.getUsersByIndex(index).setTotalPrice(Items.getItems().get(2).getPrice());
				break;
			case 4:
				Users.getUsersByIndex(index).setItemQuantity4(qty4++);
				Users.getUsersByIndex(index).setTotalPrice(Items.getItems().get(3).getPrice());
				break;
			case 5:
				Users.getUsersByIndex(index).setItemQuantity5(qty5++);
				Users.getUsersByIndex(index).setTotalPrice(Items.getItems().get(4).getPrice());
				break;
			default:
				break;
			}
			SceneManager.setScene(new Shop().GetScene());
			e.consume();
		});
	}
	
	private boolean StocksCheck() {
		int[] cart = Users.getUsersByIndex(index).getCart();
		for(int i = 0; i < cart.length; i++) {
			if(Items.getItems().get(i).getStock() < cart[i] )
			return false;
		}
		return true;
	}
	
	private boolean UserCartValidate() {
		if(price > coin) {
			Alert alert = new Alert(AlertType.ERROR, "Coin is not enough!", ButtonType.OK);
			alert.show();
			return false;
		} else if(!StocksCheck()) {
			Alert alert = new Alert(AlertType.ERROR, "Charm's stock not enough!", ButtonType.OK);
			alert.show();
			return false;
		}
		return true;
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
		
		inventory.setOnAction(e->{
			Inventory inventoryScene = new Inventory();
			SceneManager.setScene(inventoryScene.GetScene());
		});
		SetDragAndDrop();
		
		checkoutButton.setOnMouseClicked(e->{
			if(UserCartValidate()) {
				int[] stocks = Users.getUsersByIndex(index).getCart();
				for(int i = 0; i < stocks.length; i++) {
					Items.getItems().get(i).setStockCheckOut(stocks[i]);
				}
				Users.getUsersByIndex(index).setCoin(price);
				Users.getUsersByIndex(index).setInventory();
				Users.getUsersByIndex(index).resetCart();
				SceneManager.setScene(new Shop().GetScene());
			}
			
		});
		
		clearButton.setOnMouseClicked(e->{
			Users.getUsersByIndex(index).resetCart();
			SceneManager.setScene(new Shop().GetScene());
		});
		
		ViewCharms();
	}
	
	public Scene GetScene() {
		return scene;
	}
}
