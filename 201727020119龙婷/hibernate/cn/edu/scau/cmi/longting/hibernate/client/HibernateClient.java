package cn.edu.scau.cmi.longting.hibernate.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.scau.cmi.longting.hibernate.dao.StudentDao;
import cn.edu.scau.cmi.longting.hibernate.dao.TeacherDao;
import cn.edu.scau.cmi.longting.hibernate.domain.Student;
import cn.edu.scau.cmi.longting.hibernate.util.ScauCmiHibernateSessionFactoryUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HibernateClient extends Application{
	
//	spring注入dao对象
	private static StudentDao studentDao = new StudentDao();
	private static TeacherDao teacherDao = new TeacherDao();
	private static Session session;
	
	public static void main(String[] args) {
		Integer a=123456;
		Integer bInteger=123221;
		System.out.println(a.equals(bInteger));
		launch(args);
		/*
		newStudent();
		listStudents();
		*/	}

	@Override
	public void start(Stage arg0) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/cn/edu/scau/cmi/longting/hibernate/client/fxml/HibernateClientFxml.fxml"));
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("HibernateClient");
		arg0.show();
	}
	
	private static void newStudent() {
		session = ScauCmiHibernateSessionFactoryUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setName("综合性实验的学生姓名");
		
		studentDao.save(student);
		transaction.commit();
		if(session != null)
			session.close();
	}

	private static void listStudents() {
		List students = studentDao.findAll();
		Iterator<?> studentIterator = students.iterator();
		Student student;
		while(studentIterator.hasNext()) {
			student = (Student) studentIterator.next();
			System.out.println("学生的ID号是："+student.getId()+", 学生的名字是："+student.getName());
		}
	}
	
}
 