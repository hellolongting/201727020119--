package cn.edu.scau.cmi.longting.fxml.component;

import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

import cn.edu.scau.cmi.longting.composite.consistent.ConsistentComponent;
import cn.edu.scau.cmi.longting.composite.consistent.ConsistentComposite;
import cn.edu.scau.cmi.longting.composite.consistent.ConsistentLeaf;
import cn.edu.scau.cmi.longting.composite.safe.SafeComponent;
import cn.edu.scau.cmi.longting.composite.safe.SafeComposite;
import cn.edu.scau.cmi.longting.composite.safe.SafeLeaf;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;

public class ComponentController implements Initializable{
	
	@FXML
	private TreeView<SafeComponent> tv1;
	
	@FXML
	private TreeView<ConsistentComponent> tv2;
	
	@FXML
	private TextField inputName1;
	
	@FXML
	private TextField inputName2;
	
	/**
	 * 获取选中的节点的下标
	 */
	private TreeItem<SafeComponent> temp1 = null;
	private TreeItem<ConsistentComponent> temp2 = null;
	
	private SafeComponent root1 = null;
	private ConsistentComponent root2 = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initTreeView();
		addListener();
	}

	private void addListener() {
		tv1.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<TreeItem<SafeComponent>>() {

				@Override
				public void changed(ObservableValue<? extends TreeItem<SafeComponent>> observableValue, TreeItem<SafeComponent> oldItem,
						TreeItem<SafeComponent> newItem) {
					temp1=tv1.getSelectionModel().getSelectedItem();
//					System.out.println("temp1 : "+temp1+"    ;      newItem : "+newItem.getValue());
					
				}
			}
				
		);
		
		tv2.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<TreeItem<ConsistentComponent>>() {
				@Override
				public void changed(ObservableValue<? extends TreeItem<ConsistentComponent>> observableValue, TreeItem<ConsistentComponent> oldItem,
						TreeItem<ConsistentComponent> newItem) {
					temp2=tv2.getSelectionModel().getSelectedItem();
//					System.out.println("temp2 : "+temp2+"    ;      newItem : "+newItem.getValue());
						
				}
			}
					
		);
	}

	private void initTreeView() {
		/**
		 * 第一个界面的初始化
		 */
		root1 = new SafeComposite("总团队");
		TreeItem<SafeComponent> item=new TreeItem<>(root1);
		tv1.setRoot(item);
		item.setExpanded(true);
		/**
		 * 第二个界面的初始化
		 */
		root2 = new ConsistentComposite("总团队");
		TreeItem<ConsistentComponent> item2 = new TreeItem<ConsistentComponent>(root2);
		tv2.setRoot(item2);
		item2.setExpanded(true);
	}

	/**
	 * 两个页面，6个功能键
	 * @param e
	 */
	@FXML
	public void addTeam1(ActionEvent e) {
		if(temp1 == null) {
			this.showWarningStage("您没有选择要操作的节点！");
		}else if(temp1.getValue().getClass() == SafeLeaf.class){
			this.showWarningStage("个人节点是不能添加团队的!");
		}else if(inputName1.getText().length() == 0) {
			inputName1.setStyle("-fx-border-color:red;");
		}else if(isNameExisted1(temp1.getValue(),inputName1.getText())) {
			this.showWarningStage("您要添加的节点名在该层中已存在！");
		}else {
			/**符合条件的进行过插入团队操作
			 * 1. 先通过输入的名称，建立相应的SafeComposite对象
			 */
			SafeComponent node = new SafeComposite(inputName1.getText());
			/**
			 * 2. 把新建的对象加入到该团队的子节点
			 */
			SafeComponent tempNode = temp1.getValue();
			((SafeComposite)tempNode).addChild(node);
			/**
			 * 3. 把新增的节点，加入到界面显示出来
			 */
			TreeItem<SafeComponent> item = new TreeItem<SafeComponent>(node);
			temp1.getChildren().add(item);
			item.setExpanded(true);
		}
	}
	
	@FXML
	public void addPerson1(ActionEvent e) {
		if(temp1 == null) {
			this.showWarningStage("您没有选择要操作的节点！");
		}else if(temp1.getValue().getClass() == SafeLeaf.class){
			this.showWarningStage("个人节点是不能添加节点!");
		}else if(inputName1.getText().length() == 0) {
			inputName1.setStyle("-fx-border-color:red;");
		}else if(isNameExisted1(temp1.getValue(),inputName1.getText())) {
			this.showWarningStage("您要添加的节点名在该层中已存在！");
		}else {
			/**符合条件的进行过插入个人操作
			 * 1. 先通过输入的名称，建立相应的SafeLeaf对象
			 */
			SafeComponent node = new SafeLeaf(inputName1.getText());
			/**
			 * 2. 把新建的对象加入到该团队的子节点
			 */
			SafeComponent tempNode = temp1.getValue();
			((SafeComposite)tempNode).addChild(node);
			/**
			 * 3. 把新增的节点，加入到界面显示出来
			 */
			TreeItem<SafeComponent> item = new TreeItem<SafeComponent>(node);
			temp1.getChildren().add(item);
			item.setExpanded(true);
		}
	}
	
	@FXML
	public void delete1(ActionEvent e) {
		if(temp1 == null) {
			this.showWarningStage("您没有选择要操作的节点！");
		}else if(temp1.getValue().equals(root1)) {
			this.showWarningStage("您不能删除总节点，请选择其他节点进行操作！");
		}else {
			/**
			 * 符合条件的进行节点删除操作
			 */
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"确定删除该节点？");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.get() == ButtonType.OK) {
				/**
				 * 1.获取选中节点的父节点tempParent, 父团队sc
				 */
				TreeItem<SafeComponent> tempParent = temp1.getParent();
				SafeComposite sc = (SafeComposite)tempParent.getValue();
				/**
				 * 2. 在实际结构中删掉该节点，同时在显示的结构中删掉显示节点
				 */
				tempParent.getChildren().remove(temp1);
				sc.removeChild(temp1.getValue());

				System.out.println("test----------------");
				System.out.println(tempParent.getChildren());
				System.out.println(sc.getChildren());
			}
		}
	}
	
	@FXML
	public void addTeam2(ActionEvent e) {
		if(temp2 == null) {
			this.showWarningStage("您没有选择要操作的节点！");
		}else if(temp2.getValue().getClass() == ConsistentLeaf.class){
			this.showWarningStage("个人节点是不能添加团队的!");
		}else if(inputName2.getText().length() == 0) {
			inputName2.setStyle("-fx-border-color:red;");
		}else if(isNameExisted2(temp2.getValue(),inputName2.getText())) {
			this.showWarningStage("您要添加的节点名在该层中已存在！");
		}else {
			/**符合条件的进行过插入团队操作
			 * 1. 先通过输入的名称，建立相应的SafeComposite对象
			 */
			ConsistentComponent node = new ConsistentComposite(inputName2.getText());
			/**
			 * 2. 把新建的对象加入到该团队的子节点
			 */
			ConsistentComponent tempNode = temp2.getValue();
			((ConsistentComposite)tempNode).addChild(node);
			/**
			 * 3. 把新增的节点，加入到界面显示出来
			 */
			TreeItem<ConsistentComponent> item = new TreeItem<ConsistentComponent>(node);
			temp2.getChildren().add(item);
			item.setExpanded(true);
		}
	}
	
	@FXML
	public void addPerson2(ActionEvent e) {
		if(temp2 == null) {
			this.showWarningStage("您没有选择要操作的节点！");
		}else if(temp2.getValue().getClass() == ConsistentLeaf.class){
			this.showWarningStage("个人节点是不能添加节点!");
		}else if(inputName2.getText().length() == 0) {
			inputName2.setStyle("-fx-border-color:red;");
		}else if(isNameExisted2(temp2.getValue(),inputName2.getText())) {
			this.showWarningStage("您要添加的节点名在该层中已存在！");
		}else {
			/**符合条件的进行过插入个人操作
			 * 1. 先通过输入的名称，建立相应的SafeLeaf对象
			 */
			ConsistentComponent node = new ConsistentLeaf(inputName2.getText());
			/**
			 * 2. 把新建的对象加入到该团队的子节点
			 */
			ConsistentComponent tempNode = temp2.getValue();
			((ConsistentComposite)tempNode).addChild(node);
			/**
			 * 3. 把新增的节点，加入到界面显示出来
			 */
			TreeItem<ConsistentComponent> item = new TreeItem<ConsistentComponent>(node);
			temp2.getChildren().add(item);
			item.setExpanded(true);
		}
	}
	
	@FXML
	public void delete2(ActionEvent e) {
		if(temp2 == null) {
			this.showWarningStage("您没有选择要操作的节点！");
		}else if(temp2.getValue().equals(root2)) {
			this.showWarningStage("您不能删除总节点，请选择其他节点进行操作！");
		}else {
			/**
			 * 符合条件的进行节点删除操作
			 */
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"确定删除该节点？");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.get() == ButtonType.OK) {
				/**
				 * 1.获取选中节点的父节点tempParent, 父团队sc
				 */
				TreeItem<ConsistentComponent> tempParent = temp2.getParent();
				ConsistentComposite sc = (ConsistentComposite)tempParent.getValue();
				/**
				 * 2. 在实际结构中删掉该节点，同时在显示的结构中删掉显示节点
				 */
				tempParent.getChildren().remove(temp2);
				sc.deleteChild(temp2.getValue());

				System.out.println("test----------------");
				System.out.println(tempParent.getChildren());
				System.out.println(sc.getChildren());
			}
		}
	}
	
	private void showWarningStage(String message) {
		Alert warning = new Alert(Alert.AlertType.WARNING,message);
		Button warnButton=new Button();
		warnButton.setOnAction((ActionEvent)->{
			warning.showAndWait();
		});
		warning.show();
	}
	
	private boolean isNameExisted1(SafeComponent value, String text) {
		Set<SafeComponent> children = ((SafeComposite)value).getChildren();
		Iterator<SafeComponent> childrenIterator = children.iterator();
		System.out.println("childrenIterator : "+childrenIterator);
		while(childrenIterator.hasNext()) {
			SafeComponent itemComponent = childrenIterator.next();
			if(itemComponent.getClass() == SafeComposite.class) {
				if(((SafeComposite)itemComponent).getName().equals(text)) {
					return true;
				}
			}else if(itemComponent.getClass() == SafeLeaf.class){
				if(((SafeLeaf)itemComponent).getName().equals(text)) {
					return true;
				}
			}
			
		}
		return false;
	}

	private boolean isNameExisted2(ConsistentComponent value, String text) {
		Set<ConsistentComponent> children = ((ConsistentComposite)value).getChildren();
		Iterator<ConsistentComponent> childrenIterator = children.iterator();
		System.out.println("childrenIterator : "+childrenIterator);
		while(childrenIterator.hasNext()) {
			ConsistentComponent itemComponent = childrenIterator.next();
			if(itemComponent.getClass() == ConsistentComposite.class) {
				if(((ConsistentComposite)itemComponent).getName().equals(text)) {
					return true;
				}
			}else if(itemComponent.getClass() == ConsistentLeaf.class){
				if(((ConsistentLeaf)itemComponent).getName().equals(text)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
}
