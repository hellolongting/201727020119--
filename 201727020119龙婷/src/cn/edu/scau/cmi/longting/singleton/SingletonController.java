package cn.edu.scau.cmi.longting.singleton;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SingletonController implements Initializable{

	@FXML
	private TextField singleName;
	
	@FXML
	private TextField multitonName;
	
	@FXML
	private Label singleText;
	
	@FXML
	private Label multitonText;

	private boolean flag = true;
	
	private String out;
	
	private static int MARSHAL_NUM = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void singleton(javafx.event.ActionEvent event){
		if (flag) {
			String name = singleName.getText();
			Chairman chairman = Chairman.getInstance(name);			
			singleText.setText(name+chairman);
			flag = false;
			out = name+chairman;
		}else {
			singleText.setText(out+"已经创建了一个主席，只能创建一个哦！");
		}
	}
	    
	@FXML
	public void multiton(javafx.event.ActionEvent event){
	    if (MARSHAL_NUM < 10) {
	    	String name = multitonName.getText();
	    	Marshal marshal = Marshal.getInstance(name);
	    	multitonText.setText(multitonText.getText()+"\n"+name+marshal);    	
	    	MARSHAL_NUM++;
	    }else {
	    	multitonText.setText(multitonText.getText()+"\n"+"您已经创建10个元帅，不能再创建。");    	
	    }
	}
	
	
}
