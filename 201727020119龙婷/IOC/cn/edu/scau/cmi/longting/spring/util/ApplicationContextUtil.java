package cn.edu.scau.cmi.longting.spring.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private static ApplicationContext ac;
	
	private ApplicationContextUtil() {
	}

	public static ApplicationContext getApplicationContext() {
		if(ac == null) {
			ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return ac;
	}
	
	
}
