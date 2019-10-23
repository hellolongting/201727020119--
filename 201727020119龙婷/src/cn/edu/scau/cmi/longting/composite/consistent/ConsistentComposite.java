package cn.edu.scau.cmi.longting.composite.consistent;

import java.util.Set;

public class ConsistentComposite extends ConsistentComponent{	
	
	public ConsistentComposite() {
		super();
	}
	
	public ConsistentComposite(String name) {
		super();
		this.setName(name);
	}
	
	String doSomething() {
		System.out.println("这是一致性组件中的非叶子节点！");
		return null;
	}

	ConsistentComponent getParent() {
		return this;
	}
	
	public Set<ConsistentComponent> getChildren() {
		return this.children;
	}

	public ConsistentComponent addChild(ConsistentComponent child) {
		System.out.println("在组合节点中添加子节点");
		this.children.add(child);
		return this;
	}

	@Override
	public ConsistentComponent deleteChild(ConsistentComponent child) {
		children.remove(child);
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "团队：" + this.getName();
	}
	
}
