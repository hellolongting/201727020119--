package cn.edu.scau.cmi.longting.client;

import cn.edu.scau.cmi.longting.singleton.Chairman;
import cn.edu.scau.cmi.longting.singleton.Marshal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SingletonClient extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
		
		Chairman chairman1 = Chairman.getInstance("毛泽东");
		
		Chairman chairman2 = Chairman.getInstance("习近平");
		
		if(chairman1 == chairman2) {
			System.out.println("一样的!");
		}else {
			System.out.println("不一样的！");
		}
		
		System.out.println("天蓬元帅1"+Marshal.getInstance("天蓬元帅1"));
		System.out.println("天蓬元帅2"+Marshal.getInstance("天蓬元帅2"));
		System.out.println("天蓬元帅3"+Marshal.getInstance("天蓬元帅3"));
		System.out.println("天蓬元帅4"+Marshal.getInstance("天蓬元帅4"));
		System.out.println("天蓬元帅5"+Marshal.getInstance("天蓬元帅5"));
		System.out.println("天蓬元帅6"+Marshal.getInstance("天蓬元帅6"));
		System.out.println("天蓬元帅7"+Marshal.getInstance("天蓬元帅7"));
		System.out.println("天蓬元帅8"+Marshal.getInstance("天蓬元帅8"));
		System.out.println("天蓬元帅9"+Marshal.getInstance("天蓬元帅9"));
		System.out.println("天蓬元帅10"+Marshal.getInstance("天蓬元帅10"));
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("上面");
		Parent root = FXMLLoader.load(getClass().getResource("cn/edu/scau/cmi/longting/singleton/Singleton.fxml"));
		System.out.println("root: "+root);
		Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Singleton and Multiton");
	    primaryStage.show();
	}

}
