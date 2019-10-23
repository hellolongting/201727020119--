package cn.edu.scau.cmi.longting.composite.consistent;

import java.util.HashSet;
import java.util.Set;


public abstract class ConsistentComponent {
	
	protected String name;
	/**
	 * 父节点
	 */
	ConsistentComponent parent = null;
	/**
	 * 子节点作为其组成部分，类似于递归
	 */
	Set<ConsistentComponent> children = new HashSet<ConsistentComponent>();
	/**
	 * 业务能力
	 */
	abstract String doSomething();
	/**
	 * 对包含对象的功能
	 */
	abstract ConsistentComponent getParent();
	/**
	 * 对构成部分管理的功能，这些和安全性组合模式不同
	 */
	public abstract ConsistentComponent addChild(ConsistentComponent child);
	public abstract ConsistentComponent deleteChild(ConsistentComponent child);
	public abstract Set<ConsistentComponent> getChildren();

	public abstract String getName();
}
