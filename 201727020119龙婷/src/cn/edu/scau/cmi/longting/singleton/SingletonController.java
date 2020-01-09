package cn.edu.scau.cmi.longting.singleton;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SingletonController implements Initializable{

	@FXML
	private TextField singleName;
	
	@FXML
	private TextField multitonName;
	
	@FXML
	private Label singleText;
	
	@FXML
	private TextArea multitonText;

	private boolean flag;
	
	private String out;
	
	private static int MARSHAL_NUM = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		flag = true;
	}
	
	@FXML
	public void singleton(javafx.event.ActionEvent event){
		if (flag) {
			String name = singleName.getText();
			Chairman chairman = Chairman.getInstance(name);			
			singleText.setText(name+chairman);
			flag = false;
			out = name;
		}else {
			singleText.setText("已经创建了主席：‘"+out+"’ , 主席只能创建一个！");
		}
	}
	    
	@FXML
	public void multiton(javafx.event.ActionEvent event){
	    if (MARSHAL_NUM < 10) {
	    	String name = multitonName.getText();
	    	Marshal marshal = Marshal.getInstance(name);
	    	if(MARSHAL_NUM > 0) {
	    		multitonText.setText(multitonText.getText()+"\n"+name+marshal);
	    	}else {
//	    		System.out.println("name+marshal : "+name+marshal);
	    		multitonText.setText(name+marshal);
	    	}
	    	MARSHAL_NUM++;
	    }else if(MARSHAL_NUM == 10){
	    	MARSHAL_NUM++;
	    	multitonText.setText(multitonText.getText()+"\n"+"元帅只能创建十个！");    	
	    }
	}
	
	
}
