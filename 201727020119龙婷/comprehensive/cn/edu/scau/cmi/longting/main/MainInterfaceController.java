package cn.edu.scau.cmi.longting.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cn.edu.scau.cmi.longting.fxml.InterProgramming.InterProgramming;
import cn.edu.scau.cmi.longting.fxml.abstractFactory.AbstractFactoryController;
import cn.edu.scau.cmi.longting.fxml.adapter.ClassAdapterController;
import cn.edu.scau.cmi.longting.hibernate.client.fxml.HibernateClientController;
import cn.edu.scau.cmi.longting.singleton.Marshal;
import cn.edu.scau.cmi.longting.singleton.SingletonController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainInterfaceController implements Initializable{

	// client根目录下的类
	private InterProgramming interProgramming;
	// src根目录下的类
	private SingletonController singletonController;
	// hibernate 根目录下的类
	private HibernateClientController hibernateClientController;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		interProgramming = new InterProgramming();
		singletonController = new SingletonController();
		hibernateClientController = new HibernateClientController();
	}
	@FXML
	public void experiment1(javafx.event.ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(interProgramming.getClass().getResource("/cn/edu/scau/cmi/longting/fxml/InterProgramming/InterProgramming.fxml"));
		System.out.println("experiment1-root: "+root);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("实验一：接口模式");
	    primaryStage.show();
	}
	@FXML
	public void experiment2(javafx.event.ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(singletonController.getClass().getResource("/cn/edu/scau/cmi/longting/singleton/Singleton.fxml"));
		System.out.println("experiment2-root: "+root);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("实验二：单例模式、多例模式");
	    primaryStage.show();
	}
	@FXML
	public void experiment3(javafx.event.ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(interProgramming.getClass().getResource("/cn/edu/scau/cmi/longting/fxml/abstractFactory/AbstractFactory.fxml"));
		System.out.println("experiment3-root: "+root);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("实验三：简单工厂模式、工厂模式、抽象工厂模式");
	    primaryStage.show();
	}
	@FXML
	public void experiment4_class(javafx.event.ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(interProgramming.getClass().getResource("/cn/edu/scau/cmi/longting/fxml/adapter/ClassAdapter.fxml"));
		System.out.println("experiment4_class-root: "+root);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("实验四：类适配器模式" );
	    primaryStage.show();
	}
	@FXML
	public void experiment4_object(javafx.event.ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(interProgramming.getClass().getResource("/cn/edu/scau/cmi/longting/fxml/adapter/ObjectAdapter.fxml"));
		System.out.println("experiment4_object-root: "+root);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("实验四：对象适配器模式");
	    primaryStage.show();
	}
	@FXML
	public void experiment5(javafx.event.ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(interProgramming.getClass().getResource("/cn/edu/scau/cmi/longting/fxml/component/Component.fxml"));
		System.out.println("experiment5-root: "+root);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("实验五：安全组合模式、一致性组合模式");
	    primaryStage.show();
	}
	@FXML
	public void experiment67(javafx.event.ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(hibernateClientController.getClass().getResource("/cn/edu/scau/cmi/longting/hibernate/client/fxml/HibernateClientFxml.fxml"));
		System.out.println("experiment67-root: "+root);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("实验六七：基于DI、ORM模式，使用Spring集成Hibernate框架");
	    primaryStage.show();
	}
}
