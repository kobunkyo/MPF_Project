package manager;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

	public static Stage stage;
	public static Stage popUp;
	public static int index;
	
	public static void setStage(Stage primaryStage) {
		stage = primaryStage;
	}
	
	public static void setScene(Scene scene) {
		stage.setScene(scene);
	}
	
	public static void setImageByIndex(int i) {
		index = i;
	}
	
	public static int getImageByIndex() {
		return index;
	}
	
	public static void setPopUp (Stage secondaryStage) {
		popUp =  secondaryStage;
	}
	
	public static void setPopUpScene (Scene scene) {
		popUp.setScene(scene);
	}
	
	public static void showPopUp() {
		popUp.show();
	}
}
