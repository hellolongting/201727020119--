package cn.edu.scau.cmi.longting.customize.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.cmi.longting.hibernate.domain.Student;
import cn.edu.scau.cmi.longting.hibernate.domain.Teacher;

public class TeacherDAOByJdbc {

	public void insert(Teacher teacher) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "insert into Teacher (id,name) values(?,?)";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		pStatement.setLong(1, teacher.getId());
		pStatement.setString(2, teacher.getName());
		pStatement.executeUpdate();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
	/**
	 * 根据该老师的ID号，修改老师的name
	 * @param student
	 * @throws SQLException 
	 */
	public void update(Teacher teacher) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "update Teacher set name='"+teacher.getName()+"' where id='"+teacher.getId()+"'";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		pStatement.executeUpdate();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
	/**功能9：教师选择被指导的学生
	 * 根据该老师的ID号，选择老师被指导的学生
	 * @param student
	 * @throws SQLException 
	 */
	public void updateStudentTutor(Teacher teacher, Student student) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "update Student set tutor='"+teacher.getId()+"' where id='"+student.getId()+"'";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		pStatement.executeUpdate();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
	/**功能9：教师修改被指导的学生
	 * 根据该老师的ID号，修改老师被指导的学生
	 * @param student
	 * @throws SQLException 
	 */
	public void updateStudentTutor2(Teacher teacher, Student oldStudent, Student newStudent) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "update Student set tutor=null where id='"+oldStudent.getId()+"'";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		pStatement.executeUpdate();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
		//下面删除旧的学生，下面将要修改的新学生设置tutor
		this.updateStudentTutor(teacher, newStudent);
	}
	
	/**
	 * 遍历获取数据库所有老师的信息
	 * @throws SQLException 
	 */
	public void listAllTeacher() throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "select * from Teacher";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		ResultSet resultset = pStatement.executeQuery();
		int col = resultset.getMetaData().getColumnCount();
		//一行一行取数进行显示输出
		while(resultset.next()) {
			for(int i=1;i<=col;i++) {
				System.out.print(resultset.getString(i)+"\t");
				if ((i == 2) && (resultset.getString(i).length() < 8)) {
					System.out.print("\t");
				}
			}
			System.out.println("");
		}
		System.out.println("============================================");
		if(resultset != null)
			resultset.close();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
	public void delete(Teacher teacher) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "delete from Teacher where id='"+teacher.getId()+"'";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		pStatement.executeUpdate();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
}
