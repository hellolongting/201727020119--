package cn.edu.scau.cmi.longting.fxml.InterProgramming;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterProgramming extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/cn/edu/scau/cmi/longting/fxml/InterProgramming/InterProgramming.fxml"));
		System.out.println("root: "+root);
		Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("接口模式");
	    primaryStage.show();
	}
	
}
