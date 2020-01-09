package cn.edu.scau.cmi.longting.fxml.adapter;

import java.io.DataInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import cn.edu.scau.cmi.longting.adapter.Sort;
import cn.edu.scau.cmi.longting.adapter.SortClassAdapter;
import cn.edu.scau.cmi.longting.adapter.SortUtil;
import cn.edu.scau.cmi.longting.adapter.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClassAdapterController implements Initializable{

	public TableView table;
    public TableColumn tableNum;
    public TableColumn tableName;
    public TextField name;
    public TextField number;
    public List<Student> students = new ArrayList<Student>();
    private Sort sort = new SortClassAdapter();
    
    private final ObservableList<Student> data = FXCollections.observableList(students);
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
        this.table.setItems(data);
        this.tableNum.setCellValueFactory(new PropertyValueFactory("number"));
        this.tableName.setCellValueFactory(new PropertyValueFactory("name"));
	}
	
	public void confirm(ActionEvent e) {
		if(number.getText() == null || !this.isNumber(number.getText())) {
			this.informationDialog("输入的学号不正确", "学号应该只由数字组成！");
		}else if(name.getText() == null) {
			this.informationDialog("输入的姓名不正确", "姓名不能为空！");
		}else {
			Student student = new Student();
//			System.out.println("number.getText() : "+number.getText()+" , Integer.parseInt(number.getText()) : "+Integer.parseInt(number.getText()));
			student.setNumber(Integer.parseInt(number.getText()));
			student.setName(name.getText());
			students.add(student);
			// 下面进行排序
			students = sort.sortStudents(students);
			data.clear();
			data.addAll(students);
			System.out.println("students : "+students.size());
//			table.refresh();
		}
	}
	
	public void clear(ActionEvent e) {
		number.setText("");
		name.setText("");
	}
	
	/**
     * 弹出一个信息对话框
     * @param p_header
     * @param p_message
     */
    public static void informationDialog(String p_header, String p_message){

        Alert _alert = new Alert(Alert.AlertType.INFORMATION);
        _alert.setTitle("提示信息");
        _alert.setHeaderText(p_header);
        _alert.setContentText(p_message);
        _alert.showAndWait();

    }
    // 判断字符串是否是数字组成
    public boolean isNumber(String num) {
    	char[] data = num.toCharArray();
    	for(int i=0;i<data.length;i++) {
    		if(data[i] < '0' || data[i] > '9') {
    			System.out.println("-------"+data[i]);
    			return false;
    		}
    	}
    	return true;
    }
}
