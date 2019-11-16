package cn.edu.scau.cmi.longting.customize.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.cmi.longting.hibernate.domain.Student;


public class StudentDAOByJdbc {

	public void insert(Student student) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "insert into Student (id,name) values(?,?)";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		pStatement.setLong(1, student.getId());
		pStatement.setString(2, student.getName());
		pStatement.executeUpdate();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
	/**
	 * 根据该学生的ID号，修改name和tutor
	 * @param student
	 * @throws SQLException 
	 */
	public void update(Student student) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql;
//		if(student.getTutor() != null)
//			sql = "update Student set name='"+student.getName()+"', tutor='"+student.getTutor()+"' where id='"+student.getId()+"'";
//		else 
//			sql = "update Student set name='"+student.getName()+"' where id='"+student.getId()+"'";
//		System.out.println("sql : "+sql);
		PreparedStatement pStatement;
//		pStatement = connection.prepareStatement(sql);
//		pStatement.executeUpdate();
//		if(pStatement != null)
//			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
	/**
	 * 根据该学生的ID号，修改指导老师
	 * @param student
	 * @throws SQLException 
	 */
	public void updateTutor(Student student) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
//		String sql = "update Student set tutor='"+student.getTutor()+"' where id='"+student.getId()+"'";
		PreparedStatement pStatement;
//		pStatement = connection.prepareStatement(sql);
//		pStatement.executeUpdate();
//		if(pStatement != null)
//			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
	/**
	 * 遍历获取数据库所有学生的信息
	 * @throws SQLException 
	 */
	public void listAllStudent() throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "select * from Student";
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
	
	public void delete(Student student) throws SQLException {
		Connection connection = JdbcConnectionUtil.getConnection();
		String sql = "delete from Student where id='"+student.getId()+"'";
		PreparedStatement pStatement;
		pStatement = connection.prepareStatement(sql);
		pStatement.executeUpdate();
		if(pStatement != null)
			pStatement.close();
		if(connection != null)
			connection.close();
	}
	
}
