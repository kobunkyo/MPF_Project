package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import manager.SceneManager;
import model.Items;

public class ViewCharm{
	private Scene scene;
	private Label title, description;
	private Image image;
	private ImageView iv;
	private Button zoomin, zoomout, rotateLeft, rotateRight;
	private HBox buttonSets;
	private VBox desc, vb;
	private FlowPane descFP;
	private boolean isPopUp;
	private int index;
	
	public ViewCharm() {
		this.isPopUp = false;
		index = SceneManager.getImageByIndex();
		title = new Label(Items.getItems().get(index).getName());
		image = new Image(Items.getItems().get(index).getImageURL());
		iv = new ImageView(image);
		description = new Label(Items.getItems().get(index).getDescription());
		zoomin = new Button("+");
		zoomout = new Button("-");
		rotateLeft = new Button("<-");
		rotateRight = new Button("->");
		
		buttonSets = new HBox();
		desc = new VBox();
		descFP = new FlowPane();
		vb = new VBox();
		
		scene = new Scene(vb, 700, 550);
		
		SetComponent();
		SetStyles();
		SetActions();
	}
	
	private void SetComponent() {
		buttonSets.getChildren().addAll(zoomin, zoomout, rotateLeft, rotateRight);
		descFP.getChildren().addAll(description);
		desc.getChildren().addAll(descFP, buttonSets);
		vb.getChildren().addAll(title, iv, desc);
		
	}

	private void SetStyles() {
		
		description.setMaxWidth(400);
		description.setWrapText(true);
		description.setTextAlignment(TextAlignment.CENTER);
		descFP.setAlignment(Pos.CENTER);
		
		zoomin.setMinSize(30, 30);
		zoomout.setMinSize(30, 30);
		rotateLeft.setMinSize(30, 30);
		rotateRight.setMinSize(30, 30);
		
		zoomin.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		zoomout.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		rotateLeft.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		rotateRight.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(5), Insets.EMPTY)));
		
		try {
			int fontSize = 40;
			Font font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			title.setFont(font);
			title.setTextFill(Color.WHITE);
			
			fontSize = 20;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/AlegreyaSansSC-Bold.ttf")), fontSize);
			description.setFont(font);
			description.setTextFill(Color.WHITE);
			
			fontSize = 15;
			font = Font.loadFont(new FileInputStream(new File("Assets/font/Espera-Regular.ttf")), fontSize);
			zoomin.setFont(font);
			zoomin.setTextFill(Color.WHITE);
			zoomout.setFont(font);
			zoomout.setTextFill(Color.WHITE);
			rotateLeft.setFont(font);
			rotateLeft.setTextFill(Color.WHITE);
			rotateRight.setFont(font);
			rotateRight.setTextFill(Color.WHITE);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		buttonSets.setSpacing(20);
		buttonSets.setAlignment(Pos.CENTER);
		desc.setSpacing(10);
		desc.setAlignment(Pos.CENTER);
		vb.setSpacing(20);
		vb.setAlignment(Pos.CENTER);
		vb.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));
		
	}
	
	private void SetActions() {
		zoomin.setOnMouseClicked(e->{
			if (this.iv.getScaleX() < 1.5 && this.iv.getScaleY() < 1.5) {
				this.iv.setScaleX(this.iv.getScaleX()*1.1);
				this.iv.setScaleY(this.iv.getScaleY()*1.1);
			}
		});
		
		zoomout.setOnMouseClicked(e->{
			if (this.iv.getScaleX() > 0.75 && this.iv.getScaleY() > 0.75) {
				this.iv.setScaleX(this.iv.getScaleX()*0.9);
				this.iv.setScaleY(this.iv.getScaleY()*0.9);
			}
		});
		
		rotateLeft.setOnMouseClicked(e->{
			this.iv.setRotate(this.iv.getRotate() - 15);
		});
		
		rotateRight.setOnMouseClicked(e->{
			this.iv.setRotate(this.iv.getRotate() + 15);
		});
	}
	
	public Scene GetScene() {
		return scene;
	}
	
	public void setPopUp(boolean isPopUp) {
		this.isPopUp = isPopUp;
	}
	
	public boolean getPopUpProperty() {
		return this.isPopUp;
	}

}
