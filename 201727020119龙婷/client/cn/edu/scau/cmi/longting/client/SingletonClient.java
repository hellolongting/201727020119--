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
		
		Chairman chairman1 = Chairman.getInstance("ë��");
		
		Chairman chairman2 = Chairman.getInstance("ϰ��ƽ");
		
		if(chairman1 == chairman2) {
			System.out.println("һ����!");
		}else {
			System.out.println("��һ���ģ�");
		}
		
		System.out.println("����Ԫ˧1"+Marshal.getInstance("����Ԫ˧1"));
		System.out.println("����Ԫ˧2"+Marshal.getInstance("����Ԫ˧2"));
		System.out.println("����Ԫ˧3"+Marshal.getInstance("����Ԫ˧3"));
		System.out.println("����Ԫ˧4"+Marshal.getInstance("����Ԫ˧4"));
		System.out.println("����Ԫ˧5"+Marshal.getInstance("����Ԫ˧5"));
		System.out.println("����Ԫ˧6"+Marshal.getInstance("����Ԫ˧6"));
		System.out.println("����Ԫ˧7"+Marshal.getInstance("����Ԫ˧7"));
		System.out.println("����Ԫ˧8"+Marshal.getInstance("����Ԫ˧8"));
		System.out.println("����Ԫ˧9"+Marshal.getInstance("����Ԫ˧9"));
		System.out.println("����Ԫ˧10"+Marshal.getInstance("����Ԫ˧10"));
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/cn/edu/scau/cmi/longting/singleton/Singleton.fxml"));
		System.out.println("root: "+root);
		Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Singleton and Multiton");
	    primaryStage.show();
	}

}
