package cn.edu.scau.cmi.longting.client.hibernate;

import java.sql.SQLException;

import cn.edu.scau.cmi.longting.customize.dao.StudentDAOByJdbc;
import cn.edu.scau.cmi.longting.customize.dao.TeacherDAOByJdbc;
import cn.edu.scau.cmi.longting.hibernate.domain.Student;
import cn.edu.scau.cmi.longting.hibernate.domain.Teacher;

public class JdbcEntityDAO {

	public static void main(String[] args) throws SQLException {
		//先建立实体对象表示
		Student student =new Student( 102L ,"long");
		Teacher teacher = new Teacher(58L, "masha");
		
		//对数据库的访问使用DAO的方式访问
		StudentDAOByJdbc studentDAOByJdbc = new StudentDAOByJdbc();
		//功能1：添加学生
		studentDAOByJdbc.insert(student);
		//功能2：修改学生
		student.setName("ting");
		studentDAOByJdbc.update(student);
		//功能3：删除学生
		studentDAOByJdbc.delete(student);
		
		System.out.println("\n==========完成增、删、改后Student数据库内容============");
		studentDAOByJdbc.listAllStudent();
		
		//对数据库的访问使用DAO的方式访问
		TeacherDAOByJdbc teacherDAOByJdbc = new TeacherDAOByJdbc();
		//功能4：添加教师
		teacherDAOByJdbc.insert(teacher);
		//功能5：修改教师
		teacher.setName("马莎");
		teacherDAOByJdbc.update(teacher);
		//功能6：删除教师
		teacherDAOByJdbc.delete(teacher);
		
		System.out.println("\n==========完成增、删、改后Teacher数据库内容============");
		teacherDAOByJdbc.listAllTeacher();
		
		//因为上面删掉了这两个表记录，所以下面要应用之前，记得要insert
		studentDAOByJdbc.insert(student);
		teacherDAOByJdbc.insert(teacher);
		//功能7：学生选择指导教师
	//	student.setTutor(51L);
		studentDAOByJdbc.updateTutor(student);
		//功能8：学生修改指导教师
	//	student.setTutor(teacher.getId());
		studentDAOByJdbc.updateTutor(student);
		//功能9：教师选择被指导的学生
		Student student2 =new Student( 103L ,"long");
		studentDAOByJdbc.insert(student2);
		teacherDAOByJdbc.updateStudentTutor(teacher, student2);
		//功能10：教师修改被指导的学生
		Student student3 =new Student( 104L ,"longting");
		studentDAOByJdbc.insert(student3);
		teacherDAOByJdbc.updateStudentTutor2(teacher, student2, student3);
		
		System.out.println("\n=======完成指导老师或者知道学生选择和修改后Student数据库内容=========");
		studentDAOByJdbc.listAllStudent();
		
	}

}
