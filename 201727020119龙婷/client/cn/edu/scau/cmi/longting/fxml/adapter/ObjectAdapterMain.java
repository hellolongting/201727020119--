package cn.edu.scau.cmi.longting.fxml.adapter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ObjectAdapterMain extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ObjectAdapter.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("对象适配模式");
        primaryStage.show();
	}

}
