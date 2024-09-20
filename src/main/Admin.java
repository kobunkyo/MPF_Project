package main;

import java.io.File;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import model.Items;

public class Admin {
	private Scene adminPage;
	private MenuBar mb;
	private Menu menu;
	private MenuItem logout;
	private BorderPane bp;
	private Label title, imgTitle1, imgTitle2, imgTitle3, imgTitle4, imgTitle5, priceLabel1, priceLabel2, priceLabel3, priceLabel4, priceLabel5, stockLabel1, stockLabel2, stockLabel3, stockLabel4, stockLabel5, descLabel1, descLabel2, descLabel3, descLabel4, descLabel5;
	private TextArea desc1, desc2, desc3, desc4, desc5;
	private VBox vb, allItems, allModifier1, allModifier2, allModifier3, allModifier4, allModifier5, imgTitleGroup1, imgTitleGroup2, imgTitleGroup3, imgTitleGroup4, imgTitleGroup5, descGroup1, descGroup2, descGroup3, descGroup4, descGroup5;
	private HBox priceStockHB1, priceStockHB2, priceStockHB3, priceStockHB4, priceStockHB5, itemHB1, itemHB2, itemHB3, itemHB4, itemHB5;
	private Image img1, img2, img3, img4, img5;
	private ImageView iv1, iv2, iv3, iv4, iv5;
	private Button update1, update2, update3, update4, update5;
	private TextField price1, price2, price3, price4, price5;
	private Spinner<Integer> stock1, stock2, stock3, stock4, stock5;
	private ScrollPane scrollAllItems;
	private FlowPane priceFP1, priceFP2, priceFP3, priceFP4, priceFP5, stockFP1, stockFP2, stockFP3, stockFP4, stockFP5;
	
	public Admin() {
		mb = new MenuBar();
		menu = new Menu("Menu");
		logout = new MenuItem("Logout");
		title = new Label("Admin Page");
		
		// Heart
		imgTitle1 = new Label(Items.getItems().get(0).getName());
		img1 = new Image(Items.getItems().get(0).getImageURL());
		iv1 = new ImageView(img1);
		price1 = new TextField(Items.getItems().get(0).getPrice().toString());
		stock1 = new Spinner<>(0, 10000, Items.getItems().get(0).getStock());
		desc1 = new TextArea(Items.getItems().get(0).getDescription());
		update1 = new Button("Update");
		priceLabel1 = new Label("Price:");
		stockLabel1 = new Label("Stock:");
		descLabel1 = new Label("Description:");
		
		// Coffee
		imgTitle2 = new Label(Items.getItems().get(1).getName());
		img2 = new Image(Items.getItems().get(1).getImageURL());
		iv2 = new ImageView(img2);
		price2 = new TextField(Items.getItems().get(1).getPrice().toString());
		stock2 = new Spinner<>(0, 10000, Items.getItems().get(1).getStock());
		desc2 = new TextArea(Items.getItems().get(1).getDescription());
		update2 = new Button("Update");
		priceLabel2 = new Label("Price:");
		stockLabel2 = new Label("Stock:");
		descLabel2 = new Label("Description:");
		
		// Whetstone
		imgTitle3 = new Label(Items.getItems().get(2).getName());
		img3 = new Image(Items.getItems().get(2).getImageURL());
		iv3 = new ImageView(img3);
		price3 = new TextField(Items.getItems().get(2).getPrice().toString());
		stock3 = new Spinner<>(0, 10000, Items.getItems().get(2).getStock());
		desc3 = new TextArea(Items.getItems().get(2).getDescription());
		update3 = new Button("Update");
		priceLabel3 = new Label("Price:");
		stockLabel3 = new Label("Stock:");
		descLabel3 = new Label("Description:");
		
		// Twin Heart
		imgTitle4 = new Label(Items.getItems().get(3).getName());
		img4 = new Image(Items.getItems().get(3).getImageURL());
		iv4 = new ImageView(img4);
		price4 = new TextField(Items.getItems().get(3).getPrice().toString());
		stock4 = new Spinner<>(0, 10000, Items.getItems().get(3).getStock());
		desc4 = new TextArea(Items.getItems().get(3).getDescription());
		update4 = new Button("Update");
		priceLabel4 = new Label("Price:");
		stockLabel4 = new Label("Stock:");
		descLabel4 = new Label("Description:");
		
		// Smoke Bomb
		imgTitle5 = new Label(Items.getItems().get(4).getName());
		img5 = new Image(Items.getItems().get(4).getImageURL());
		iv5 = new ImageView(img5);
		price5 = new TextField(Items.getItems().get(4).getPrice().toString());
		stock5 = new Spinner<>(0, 10000, Items.getItems().get(4).getStock());
		desc5 = new TextArea(Items.getItems().get(4).getDescription());
		update5 = new Button("Update");
		priceLabel5 = new Label("Price:");
		stockLabel5 = new Label("Stock:");
		descLabel5 = new Label("Description:");
		
		// Add img and title on left side
		imgTitleGroup1 = new VBox();
		imgTitleGroup2 = new VBox();
		imgTitleGroup3 = new VBox();
		imgTitleGroup4 = new VBox();
		imgTitleGroup5 = new VBox();
		
		// Add price label and textfield
		priceFP1 = new FlowPane();
		priceFP2 = new FlowPane();
		priceFP3 = new FlowPane();
		priceFP4 = new FlowPane();
		priceFP5 = new FlowPane();
		
		// Add stock label and textfield
		stockFP1 = new FlowPane();
		stockFP2 = new FlowPane();
		stockFP3 = new FlowPane();
		stockFP4 = new FlowPane();
		stockFP5 = new FlowPane();
		
		// Add priceFP and stockFP
		priceStockHB1 = new HBox();
		priceStockHB2 = new HBox();
		priceStockHB3 = new HBox();
		priceStockHB4 = new HBox();
		priceStockHB5 = new HBox();
		
		// Add desc label and textarea
		descGroup1 = new VBox();
		descGroup2 = new VBox();
		descGroup3 = new VBox();
		descGroup4 = new VBox();
		descGroup5 = new VBox();
		
		// All group + button
		allModifier1 = new VBox();
		allModifier2 = new VBox();
		allModifier3 = new VBox();
		allModifier4 = new VBox();
		allModifier5 = new VBox();
		
		// Add modifier + img group
		itemHB1 = new HBox();
		itemHB2 = new HBox();
		itemHB3 = new HBox();
		itemHB4 = new HBox();
		itemHB5 = new HBox();
		
		allItems = new VBox();
		scrollAllItems = new ScrollPane();
		
		vb = new VBox();
		bp = new BorderPane();
		
		adminPage = new Scene(bp, 1280, 720, Color.BROWN);
		
		SetComponent();
		SetStyles();
		SetActions();
	}
	
	private void SetComponent() {
		menu.getItems().addAll(logout);
		mb.getMenus().addAll(menu);
		
		// Item 1
		imgTitleGroup1.getChildren().addAll(imgTitle1, iv1);
		priceFP1.getChildren().addAll(priceLabel1, price1);
		stockFP1.getChildren().addAll(stockLabel1, stock1);
		priceStockHB1.getChildren().addAll(priceFP1, stockFP1);
		descGroup1.getChildren().addAll(descLabel1, desc1);
		allModifier1.getChildren().addAll(priceStockHB1, descGroup1, update1);
		itemHB1.getChildren().addAll(imgTitleGroup1, allModifier1);
		
		// Item 2
		imgTitleGroup2.getChildren().addAll(imgTitle2, iv2);
		priceFP2.getChildren().addAll(priceLabel2, price2);
		stockFP2.getChildren().addAll(stockLabel2, stock2);
		priceStockHB2.getChildren().addAll(priceFP2, stockFP2);
		descGroup2.getChildren().addAll(descLabel2, desc2);
		allModifier2.getChildren().addAll(priceStockHB2, descGroup2, update2);
		itemHB2.getChildren().addAll(imgTitleGroup2, allModifier2);		
		
		// Item 3
		imgTitleGroup3.getChildren().addAll(imgTitle3, iv3);
		priceFP3.getChildren().addAll(priceLabel3, price3);
		stockFP3.getChildren().addAll(stockLabel3, stock3);
		priceStockHB3.getChildren().addAll(priceFP3, stockFP3);
		descGroup3.getChildren().addAll(descLabel3, desc3);
		allModifier3.getChildren().addAll(priceStockHB3, descGroup3, update3);
		itemHB3.getChildren().addAll(imgTitleGroup3, allModifier3);		
		
		// Item 4
		imgTitleGroup4.getChildren().addAll(imgTitle4, iv4);
		priceFP4.getChildren().addAll(priceLabel4, price4);
		stockFP4.getChildren().addAll(stockLabel4, stock4);
		priceStockHB4.getChildren().addAll(priceFP4, stockFP4);
		descGroup4.getChildren().addAll(descLabel4, desc4);
		allModifier4.getChildren().addAll(priceStockHB4, descGroup4, update4);
		itemHB4.getChildren().addAll(imgTitleGroup4, allModifier4);		
		
		// Item 5
		imgTitleGroup5.getChildren().addAll(imgTitle5, iv5);
		priceFP5.getChildren().addAll(priceLabel5, price5);
		stockFP5.getChildren().addAll(stockLabel5, stock5);
		priceStockHB5.getChildren().addAll(priceFP5, stockFP5);
		descGroup5.getChildren().addAll(descLabel5, desc5);
		allModifier5.getChildren().addAll(priceStockHB5, descGroup5, update5);
		itemHB5.getChildren().addAll(imgTitleGroup5, allModifier5);
		
		
		allItems.getChildren().addAll(itemHB1, itemHB2, itemHB3, itemHB4, itemHB5);
		scrollAllItems.setContent(allItems);
		vb.getChildren().addAll(title, scrollAllItems);
		bp.setTop(mb);
		bp.setCenter(vb);
	}
	
	private void SetStyles() {
		bp.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		
		// Data 1
		imgTitleGroup1.setAlignment(Pos.CENTER);
		iv1.autosize();
		imgTitleGroup1.setPadding(new Insets(30, 30, 30, 0));
		priceFP1.setHgap(4);
		price1.setMinWidth(150);
		priceFP1.setMaxWidth(250);
		stockFP1.setHgap(4);
		stock1.setMinWidth(150);
		stockFP1.setMaxWidth(250);
		priceStockHB1.setSpacing(5);
		descGroup1.setSpacing(2);
		descGroup1.setMaxWidth(500);
		descGroup1.setMaxHeight(100);
		update1.setMaxWidth(250);
		allModifier1.setSpacing(30);
		allModifier1.setPadding(new Insets(10, 0, 5, 30));
		itemHB1.setSpacing(100);
		itemHB1.setMaxWidth(1280*0.7);
		itemHB1.setMaxHeight(600);
		itemHB1.setPadding(new Insets(5, 0, 5, 0));
		itemHB1.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(20), Insets.EMPTY)));
		itemHB1.setAlignment(Pos.CENTER);
		update1.setStyle("-fx-background: #8B4513;" + "-fx-background-color: #8B4513");
		
		// Data 2
		imgTitleGroup2.setAlignment(Pos.CENTER);
		iv2.autosize();
		imgTitleGroup2.setPadding(new Insets(30, 30, 30, 0));
		priceFP2.setHgap(4);
		price2.setMinWidth(150);
		priceFP2.setMaxWidth(250);
		stockFP2.setHgap(4);
		stock2.setMinWidth(150);
		stockFP2.setMaxWidth(250);
		priceStockHB2.setSpacing(5);
		descGroup2.setSpacing(2);
		descGroup2.setMaxWidth(500);
		descGroup2.setMaxHeight(100);
		update2.setMaxWidth(250);
		allModifier2.setSpacing(30);
		allModifier2.setPadding(new Insets(10, 0, 5, 30));
		itemHB2.setSpacing(100);
		itemHB2.setMaxWidth(1280*0.7);
		itemHB2.setMaxHeight(600);
		itemHB2.setPadding(new Insets(5, 0, 5, 0));
		itemHB2.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(20), Insets.EMPTY)));
		itemHB2.setAlignment(Pos.CENTER);
		update2.setStyle("-fx-background: #8B4513;" + "-fx-background-color: #8B4513");
		
		// Data 3
		imgTitleGroup3.setAlignment(Pos.CENTER);
		iv3.autosize();
		imgTitleGroup3.setPadding(new Insets(30, 30, 30, 0));
		priceFP3.setHgap(4);
		price3.setMinWidth(150);
		priceFP3.setMaxWidth(250);
		stockFP3.setHgap(4);
		stock3.setMinWidth(150);
		stockFP3.setMaxWidth(250);
		priceStockHB3.setSpacing(5);
		descGroup3.setSpacing(2);
		descGroup3.setMaxWidth(500);
		descGroup3.setMaxHeight(100);
		update3.setMaxWidth(250);
		allModifier3.setSpacing(30);
		allModifier3.setPadding(new Insets(10, 0, 5, 30));
		itemHB3.setSpacing(30);
		itemHB3.setMaxWidth(1280*0.7);
		itemHB3.setMaxHeight(600);
		itemHB3.setPadding(new Insets(5, 0, 5, 0));
		itemHB3.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(20), Insets.EMPTY)));
		itemHB3.setAlignment(Pos.CENTER);
		update3.setStyle("-fx-background: #8B4513;" + "-fx-background-color: #8B4513");
		
		// Data 4
		imgTitleGroup4.setAlignment(Pos.CENTER);
		iv4.autosize();
		imgTitleGroup4.setPadding(new Insets(30, 30, 30, 0));
		priceFP4.setHgap(4);
		price4.setMinWidth(150);
		priceFP4.setMaxWidth(250);
		stockFP4.setHgap(4);
		stock4.setMinWidth(150);
		stockFP4.setMaxWidth(250);
		priceStockHB4.setSpacing(5);
		descGroup4.setSpacing(2);
		descGroup4.setMaxWidth(500);
		descGroup4.setMaxHeight(100);
		update4.setMaxWidth(250);
		allModifier4.setSpacing(30);
		allModifier4.setPadding(new Insets(10, 0, 5, 30));
		itemHB4.setSpacing(100);
		itemHB4.setMaxWidth(1280*0.7);
		itemHB4.setMaxHeight(600);
		itemHB4.setPadding(new Insets(5, 0, 5, 0));
		itemHB4.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(20), Insets.EMPTY)));
		itemHB4.setAlignment(Pos.CENTER);
		update4.setStyle("-fx-background: #8B4513;" + "-fx-background-color: #8B4513");
		
		// Data 5
		imgTitleGroup5.setAlignment(Pos.CENTER);
		iv5.autosize();
		imgTitleGroup5.setPadding(new Insets(30, 30, 30, 0));
		priceFP5.setHgap(4);
		price5.setMinWidth(150);
		priceFP5.setMaxWidth(250);
		stockFP5.setHgap(4);
		stock5.setMinWidth(150);
		stockFP5.setMaxWidth(250);
		priceStockHB5.setSpacing(5);
		descGroup5.setSpacing(2);
		descGroup5.setMaxWidth(500);
		descGroup5.setMaxHeight(100);
		update5.setMaxWidth(250);
		allModifier5.setSpacing(30);
		allModifier5.setPadding(new Insets(10, 0, 5, 30));
		itemHB5.setSpacing(100);
		itemHB5.setMaxWidth(1280*0.7);
		itemHB5.setMaxHeight(600);
		itemHB5.setPadding(new Insets(5, 0, 5, 0));
		itemHB5.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, new CornerRadii(20), Insets.EMPTY)));
		itemHB5.setAlignment(Pos.CENTER);
		update5.setStyle("-fx-background: #8B4513;" + "-fx-background-color: #8B4513");
		
		try {
			int fontSize = 40;
			Font font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			title.setFont(font);
			title.setTextFill(Color.WHITE);
			
			fontSize = 18;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			imgTitle1.setFont(font);
			imgTitle1.setTextFill(Color.WHITE);
			priceLabel1.setFont(font);
			priceLabel1.setTextFill(Color.WHITE);
			stockLabel1.setFont(font);
			stockLabel1.setTextFill(Color.WHITE);
			descLabel1.setFont(font);
			descLabel1.setTextFill(Color.WHITE);
			update1.setFont(font);
			update1.setTextFill(Color.WHITE);
			
			imgTitle2.setFont(font);
			imgTitle2.setTextFill(Color.WHITE);
			priceLabel2.setFont(font);
			priceLabel2.setTextFill(Color.WHITE);
			stockLabel2.setFont(font);
			stockLabel2.setTextFill(Color.WHITE);
			descLabel2.setFont(font);
			descLabel2.setTextFill(Color.WHITE);
			update2.setFont(font);
			update2.setTextFill(Color.WHITE);
			
			imgTitle3.setFont(font);
			imgTitle3.setTextFill(Color.WHITE);
			priceLabel3.setFont(font);
			priceLabel3.setTextFill(Color.WHITE);
			stockLabel3.setFont(font);
			stockLabel3.setTextFill(Color.WHITE);
			descLabel3.setFont(font);
			descLabel3.setTextFill(Color.WHITE);
			update3.setFont(font);
			update3.setTextFill(Color.WHITE);
			
			imgTitle4.setFont(font);
			imgTitle4.setTextFill(Color.WHITE);
			priceLabel4.setFont(font);
			priceLabel4.setTextFill(Color.WHITE);
			stockLabel4.setFont(font);
			stockLabel4.setTextFill(Color.WHITE);
			descLabel4.setFont(font);
			descLabel4.setTextFill(Color.WHITE);
			update4.setFont(font);
			update4.setTextFill(Color.WHITE);
			
			imgTitle5.setFont(font);
			imgTitle5.setTextFill(Color.WHITE);
			priceLabel5.setFont(font);
			priceLabel5.setTextFill(Color.WHITE);
			stockLabel5.setFont(font);
			stockLabel5.setTextFill(Color.WHITE);
			descLabel5.setFont(font);
			descLabel5.setTextFill(Color.WHITE);
			update5.setFont(font);
			update5.setTextFill(Color.WHITE);
			
			fontSize = 14;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/Espera-Regular.ttf")), fontSize);
			price1.setFont(font);
			desc1.setFont(font);
			
			price2.setFont(font);
			desc2.setFont(font);
			
			price3.setFont(font);
			desc3.setFont(font);
			
			price4.setFont(font);
			desc4.setFont(font);
			
			price5.setFont(font);
			desc5.setFont(font);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		vb.setPadding(new Insets(5, 0, 0, 0));
		vb.setSpacing(5);
		allItems.setAlignment(Pos.CENTER);
		allItems.setSpacing(10);
		scrollAllItems.setStyle("-fx-background: #8B4513;" + "-fx-background-color: #8B4513");
		scrollAllItems.setFitToWidth(true);
		scrollAllItems.setBorder(Border.EMPTY);
		scrollAllItems.setPadding(new Insets(5, 0, 5, 0));
		vb.setAlignment(Pos.TOP_CENTER);
	}
	
	private void SetActions() {
		
		logout.setOnAction(e->{
			Login login = new Login();
			SceneManager.setScene(login.GetScene());
		});
		
		update1.setOnMouseClicked(e->{
			boolean validate = updateValidation(price1.getText(), stock1.getValue(), desc1.getText());
			if(validate) {
				Integer price = Integer.parseInt(price1.getText());
				Integer stock = stock1.getValue();
				String description = desc1.getText();
				Items.updateItemByIndex(0, price, stock, description);
				Alert alert = new Alert(AlertType.INFORMATION, "Update Successfull", ButtonType.OK);
				alert.show();
			}
		});
		
		update2.setOnMouseClicked(e->{
			boolean validate = updateValidation(price2.getText(), stock2.getValue(), desc2.getText());
			if(validate) {
				Integer price = Integer.parseInt(price2.getText());
				Integer stock = stock2.getValue();
				String description = desc2.getText();
				Items.updateItemByIndex(1, price, stock, description);
				Alert alert = new Alert(AlertType.INFORMATION, "Update Successfull", ButtonType.OK);
				alert.show();
			}
		});
		
		update3.setOnMouseClicked(e->{
			boolean validate = updateValidation(price3.getText(), stock3.getValue(), desc3.getText());
			if(validate) {
				Integer price = Integer.parseInt(price3.getText());
				Integer stock = stock3.getValue();
				String description = desc3.getText();
				Items.updateItemByIndex(2, price, stock, description);
				Alert alert = new Alert(AlertType.INFORMATION, "Update Successfull", ButtonType.OK);
				alert.show();
			}
		});
		
		update4.setOnMouseClicked(e->{
			boolean validate = updateValidation(price4.getText(), stock4.getValue(), desc4.getText());
			if(validate) {
				Integer price = Integer.parseInt(price4.getText());
				Integer stock = stock4.getValue();
				String description = desc4.getText();
				Items.updateItemByIndex(3, price, stock, description);
				Alert alert = new Alert(AlertType.INFORMATION, "Update Successfull", ButtonType.OK);
				alert.show();
			}
		});
		
		update5.setOnMouseClicked(e->{
			boolean validate = updateValidation(price5.getText(), stock5.getValue(), desc5.getText());
			if(validate) {
				Integer price = Integer.parseInt(price5.getText());
				Integer stock = stock5.getValue();
				String description = desc5.getText();
				Items.updateItemByIndex(4, price, stock, description);
				Alert alert = new Alert(AlertType.INFORMATION, "Update Successfull", ButtonType.OK);
				alert.show();
			}
		});

		
	}
	
	private boolean isPriceNumeric(String priceTF) {
		try {
			Integer.valueOf(priceTF);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private boolean updateValidation(String priceTF, Integer stockTF, String descTA) {
		if(priceTF.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Price must be filled in", ButtonType.OK);
			alert.show();
			return false;
		} else if(!isPriceNumeric(priceTF)) {
			Alert alert = new Alert(AlertType.ERROR, "Price must be numeric", ButtonType.OK);
			alert.show();
			return false;
		} else if(Integer.parseInt(priceTF) < 1) {
			Alert alert = new Alert(AlertType.ERROR, "Price must be more than 0", ButtonType.OK);
			alert.show();
			return false;
		}
		
		if (stockTF.toString().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Stock must be filled in", ButtonType.OK);
			alert.show();
			return false;
		} else if(stockTF < 1) {
			Alert alert = new Alert(AlertType.ERROR, "Stock must be more than 0", ButtonType.OK);
			alert.show();
			return false;
		}
		
		if (descTA.toString().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR, "Description must be filled in", ButtonType.OK);
			alert.show();
			return false;
		}
		return true;
	}
	
	public Scene GetScene() {
		return adminPage;
	}

}
