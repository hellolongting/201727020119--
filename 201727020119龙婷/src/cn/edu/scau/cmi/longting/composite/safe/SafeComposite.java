package cn.edu.scau.cmi.longting.composite.safe;

import java.util.HashSet;
import java.util.Set;

public class SafeComposite extends SafeComponent{
		
	private Set<SafeComponent> children = new HashSet<SafeComponent>();
	
	
	public SafeComposite() {
		super();
	}

	public SafeComposite(String name) {
		super();
		this.name = name;
	}

	@Override
	public String doSomething() {
		return "我是安全性组合模式中的组合组件！！！";
	}
	
	@Override
	public SafeComponent getParent() {
		return this.getParent();
	}
	
	public SafeComponent addChild(SafeComponent child) {
		children.add(child);
		return this;
	}
	
	public SafeComponent removeChild(SafeComponent child) {
		children.remove(child);
		return this;
	}
	
	public Set<SafeComponent> getChildren(){
		return this.children;
	}
	
	public void setChildren(Set<SafeComponent> children) {
		this.children=children;
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
		return "团队："+name;
	}

}
