package cn.edu.scau.cmi.longting.fxml.component;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComponentMain extends Application {

	public static void main(String[] args) { 
		launch(args);	
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/cn/edu/scau/cmi/longting/fxml/component/Component.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("component");
		stage.show();
	}

}
