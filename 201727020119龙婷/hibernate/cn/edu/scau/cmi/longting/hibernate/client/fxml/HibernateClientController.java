package cn.edu.scau.cmi.longting.hibernate.client.fxml;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.hibernate.Session;
import cn.edu.scau.cmi.longting.hibernate.dao.StudentDao;
import cn.edu.scau.cmi.longting.hibernate.dao.TeacherDao;
import cn.edu.scau.cmi.longting.hibernate.domain.Student;
import cn.edu.scau.cmi.longting.hibernate.domain.Teacher;
import cn.edu.scau.cmi.longting.hibernate.util.ScauCmiHibernateSessionFactoryUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HibernateClientController implements Initializable{
	
	//学生名字
	@FXML
	private TextField insert_stu_name;
	//要更新的学生ID
	@FXML
	private TextField update_stu_id;
	//要更新的学生名字
	@FXML
	private TextField update_stu_name;
	//要更新的学生指导老师
	@FXML
	private TextField update_stu_tutor;
	//要删除的学生ID
	@FXML
	private TextField del_stu_id;
	//要增加指导老师的学生id
	@FXML
	private TextField stu_id;
	//要增加、修改的指导老师id
	@FXML
	private TextField stu_tutor;
	@FXML
	private TextArea allStudents;
	@FXML
	private TextArea allTeachers;
	
	//老师名字
	@FXML
	private TextField insert_teacher_name;
	//要更新的老师ID
	@FXML
	private TextField update_teacher_id;
	//要更新的学生名字
	@FXML
	private TextField update_teacher_name;
	//要删除的学生ID
	@FXML
	private TextField del_teacher_id;
	//要增加指导老师的学生id
	@FXML
	private TextField teacher_id;
	//要增加、修改的指导老师id
	@FXML
	private TextField tutor_stu;	
	@FXML
	private TextArea allStudents2;
	@FXML
	private TextArea allTeachers2;
	
//	spring注入dao对象
	private static StudentDao studentDao = new StudentDao();
	private static TeacherDao teacherDao = new TeacherDao();
	private static Session session;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.showAllStudents();
		this.showAllTeachers();
	}

	/**
	 * 插入学生
	 * @param e
	 */
	@FXML
	public void insert_stu(ActionEvent e) {
		if(this.insert_stu_name==null || this.insert_stu_name.getText().isEmpty()) {
			this.showWarningStage("要插入的姓名不能为空。");
			return;
		}
		Student student = new Student();
		student.setName(this.insert_stu_name.getText());
		studentDao.save(student);
		this.showAllStudents();
	}
	/**
	 * 修改学生
	 * @param e
	 */
	@FXML
	public void update_stu(ActionEvent e) {
		if(this.update_stu_id==null || update_stu_id.getText().isEmpty()) {
			this.showWarningStage("要修改学生信息，学生ID 不能为空");
		}else if(this.update_stu_name==null || update_stu_name.getText().isEmpty()) {
			this.showWarningStage("要修改ID为 "+this.update_stu_id.getText()+" 学生信息，姓名不能为空，请输入要修改的姓名");
		}else {
			Student student = new Student();
			student.setId(Long.valueOf(this.update_stu_id.getText()));
			student.setName(this.update_stu_name.getText());
			if(this.update_stu_tutor==null || !update_stu_tutor.getText().isEmpty()) {
				Teacher teacher = new Teacher();
				teacher.setId(Long.valueOf(update_stu_tutor.getText()));
				student.setTeacher(teacher);
			}
			studentDao.attachDirty(student);
		}
		this.showAllStudents();
	}
	/**
	 * 删除学生
	 * @param e
	 */
	@FXML
	public void delete_stu(ActionEvent e) {
		if(this.del_stu_id==null || del_stu_id.getText().isEmpty()) {
			this.showWarningStage("请输入要删除的学生ID！");
			return;
		}
		Student student = new Student();
		student.setId(Long.valueOf(del_stu_id.getText()));
		studentDao.delete(student);
		this.showAllStudents();
	}
	/**
	 * 增加、修改学生的指导老师
	 * @param e
	 */
	@FXML
	public void stu_tutor(ActionEvent e) {
		if(this.stu_id==null || stu_id.getText().isEmpty()) {
			this.showWarningStage("要修改学生的指导老师，学生ID不能为空");
		}else if(this.stu_tutor==null || stu_tutor.getText().isEmpty()) {
			this.showWarningStage("要修改ID为 "+this.stu_id.getText()+" 学生的指导老师，老师ID不能为空！");
			
		}else {
			Student student = studentDao.findById(Long.valueOf(stu_id.getText()));
			Teacher teacher = (student.getTeacher()==null ? new Teacher() : student.getTeacher());
			teacher.setId(Long.valueOf(stu_tutor.getText()));
			student.setTeacher(teacher);
			studentDao.attachDirty(student);
			this.showAllStudents();
		}
	}
	
	/**
	 * 插入老师
	 * @param e
	 */
	@FXML
	public void insert_teacher(ActionEvent e) {
		if(this.insert_teacher_name==null || this.insert_teacher_name.getText().isEmpty()) {
			this.showWarningStage("要插入的姓名不能为空。");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setName(insert_teacher_name.getText());
		teacherDao.save(teacher);
		this.showAllTeachers();
	}
	/**
	 * 修改老师
	 * @param e
	 */
	@FXML
	public void update_teacher(ActionEvent e) {
		if(this.update_teacher_id==null || update_teacher_id.getText().isEmpty()) {
			this.showWarningStage("要修改老师信息，老师ID 不能为空");
		}else if(this.update_teacher_name==null || update_teacher_name.getText().isEmpty()) {
			this.showWarningStage("要修改ID为 "+this.update_stu_id.getText()+" 老师信息，姓名不能为空，请输入要修改的姓名");
		}else {
			Teacher teacher = new Teacher();
			teacher.setId(Long.valueOf(this.update_teacher_id.getText()));
			teacher.setName(this.update_teacher_name.getText());
			teacherDao.attachDirty(teacher);
		}
		this.showAllTeachers();
	}
	/**
	 * 删除老师
	 * @param e
	 */
	@FXML
	public void delete_teacher(ActionEvent e) {
		if(this.del_teacher_id==null || del_teacher_id.getText().isEmpty()) {
			this.showWarningStage("请输入要删除的老师ID！");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setId(Long.valueOf(del_teacher_id.getText()));
		teacherDao.delete(teacher);
		this.showAllTeachers();
	}
	/**
	 * 增加、修改老师指导的学生
	 * @param e
	 */
	@FXML
	public void teacher_stu(ActionEvent e) {
		if(this.teacher_id==null || teacher_id.getText().isEmpty()) {
			this.showWarningStage("要修改老师指导的学生，老师ID不能为空");
		}else if(this.tutor_stu==null || tutor_stu.getText().isEmpty()) {
			this.showWarningStage("要修改ID为 "+this.teacher_id.getText()+" 老师所指导的学生，学生ID不能为空！");
		}else {
			Student student = studentDao.findById(Long.valueOf(tutor_stu.getText()));
			Teacher teacher = (student.getTeacher()==null ? new Teacher() : student.getTeacher());
			teacher.setId(Long.valueOf(teacher_id.getText()));
			student.setTeacher(teacher);
			studentDao.attachDirty(student);
			this.showAllStudents();
		}
	}
	
	public Session getSession() {
		session = ScauCmiHibernateSessionFactoryUtil.getSession();
		return session;
	}
	
	private void showWarningStage(String message) {
		Alert warning = new Alert(Alert.AlertType.WARNING,message);
		Button warnButton=new Button();
		warnButton.setOnAction((ActionEvent)->{
			warning.showAndWait();
		});
		warning.show();
	}
	
	private void showAllStudents() {
		allStudents.clear();
		List students = studentDao.findAll();
		Iterator<?> studentIterator = students.iterator();
		Student student;
		while(studentIterator.hasNext()) {
			student = (Student) studentIterator.next();
			allStudents.setText(allStudents.getText()+"学生ID号："+student.getId()+",  学生名字："+student.getName()+",  指导老师ID："+(student.getTeacher() != null ? student.getTeacher().getId() : "无")+"\n");
		}
		allStudents2.setText(allStudents.getText());
	}
	private void showAllTeachers() {
		allTeachers.clear();
		List teachers = teacherDao.findAll();
		Iterator<?> teacherIterator = teachers.iterator();
		Teacher teacher;
		while(teacherIterator.hasNext()) {
			teacher = (Teacher) teacherIterator.next();
			allTeachers.setText(allTeachers.getText()+"老师ID号："+teacher.getId()+", 老师名字："+teacher.getName()+"\n");
		}
		allTeachers2.setText(allTeachers.getText());
	}
}
