package cn.edu.scau.cmi.longting.composite.consistent;

import java.util.Set;

public class ConsistentLeaf extends ConsistentComponent{
	
	
	public ConsistentLeaf() {
		super();
	}
	
	public ConsistentLeaf(String name) {
		super();
		this.setName(name);
	}

	@Override
	String doSomething() {
		System.out.println("这是一致性模式中的叶节点，不能再包含子节点了！");
		return "这是一致性模式中的原子节点，不能再包含子节点了！";
	}

	@Override
	ConsistentComponent getParent() {
		return this;
	}

	@Override
	public ConsistentComponent addChild(ConsistentComponent child) {
		System.out.println("对不起，该节点是叶节点，不能添加子节点！");
		return this;
	}

	@Override
	public ConsistentComponent deleteChild(ConsistentComponent child) {
		System.out.println("对不起，该节点是叶节点，没有子节点可以删除！");
		return this;
	}

	@Override
	public Set<ConsistentComponent> getChildren() {
		System.out.println("对不起，该节点是叶节点，没有子节点！");
		return null;
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
		return "个人：" + this.getName();
	}
}
