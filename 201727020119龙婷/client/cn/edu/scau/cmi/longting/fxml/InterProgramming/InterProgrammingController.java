package cn.edu.scau.cmi.longting.fxml.InterProgramming;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cn.edu.scau.cmi.longting.interProgramming.GraduateStudent;
import cn.edu.scau.cmi.longting.interProgramming.Student;
import cn.edu.scau.cmi.longting.interProgramming.UndergraduateStudent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InterProgrammingController implements Initializable{
	
	@FXML
	public TextField result;
	private Student graduateStudent;
	private Student undergraduateStudent;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		graduateStudent = new GraduateStudent();		
		undergraduateStudent = new UndergraduateStudent();
	}
	
	@FXML
	public void GraduateStudent(javafx.event.ActionEvent event) throws IOException{
		result.setText("应届毕业生："+graduateStudent.learning());
	}
	@FXML
	public void UndergraduateStudent(javafx.event.ActionEvent event) throws IOException{
		result.setText("在读研究生："+undergraduateStudent.learning());
	}
	
}
