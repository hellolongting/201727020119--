package cn.edu.scau.cmi.longting.composite.safe;

public abstract class SafeComponent {
	protected String name;
	/**
	 * 业务能力
	 */
	String doSomething() {
		return "I am safe component!!!";
	}
	/**
	 * 获取包含对象的功能
	 */
	SafeComponent getParent() {
		return null;
	}
	
	abstract String getName();

}
