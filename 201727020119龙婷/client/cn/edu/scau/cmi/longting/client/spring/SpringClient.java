package cn.edu.scau.cmi.longting.client.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.scau.cmi.longting.spring.domain.Student;
import cn.edu.scau.cmi.longting.spring.util.ApplicationContextUtil;


public class SpringClient {
	public static void main(String[] args){
		ApplicationContext applicationContext = getApplicationContext();
		Student student = (Student) applicationContext.getBean("zhangsan");
		System.out.println(student.getName()+" 的毕业指导老师是："+student.getTutor().getName());
	}

	private static ApplicationContext getApplicationContext() {
		//单例获取ac
		ApplicationContext ac = ApplicationContextUtil.getApplicationContext();
		return ac;
	}
}
