package cn.edu.scau.cmi.longting.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainInterface extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/cn/edu/scau/cmi/longting/main/MainInterface.fxml"));
		System.out.println("root: "+root);
		Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("综合性实验");
	    primaryStage.show();
	}

}
