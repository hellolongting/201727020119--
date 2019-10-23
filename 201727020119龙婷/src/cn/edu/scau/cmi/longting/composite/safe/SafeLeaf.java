package cn.edu.scau.cmi.longting.composite.safe;

public class SafeLeaf extends SafeComponent{
	
	public SafeLeaf() {
		super();
	}

	public SafeLeaf(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String doSomething() {
		return "我是安全性组合模式里的叶子节点组件！";
	}
	
	@Override
	public SafeComponent getParent() {
		return this.getParent();
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "个人："+name;
	}

}
