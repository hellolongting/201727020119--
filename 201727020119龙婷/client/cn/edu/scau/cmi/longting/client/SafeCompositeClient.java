package cn.edu.scau.cmi.longting.client;

import java.util.Iterator;
import java.util.Set;

import cn.edu.scau.cmi.longting.composite.safe.SafeComponent;
import cn.edu.scau.cmi.longting.composite.safe.SafeComposite;
import cn.edu.scau.cmi.longting.composite.safe.SafeLeaf;

public class SafeCompositeClient {

	public static void main(String[] args) {
		
		SafeComposite team = new SafeComposite();
		team.setName("总团队");
		
		SafeLeaf person1 = new SafeLeaf();
		person1.setName("第一个成员");
		
		SafeLeaf person2 = new SafeLeaf();
		person2.setName("第二个成员");
		
		team.addChild(person1);
		team.addChild(person2);
		System.out.println(team.getName());
		
		System.out.println(team.getChildren());
		Set<SafeComponent> children = team.getChildren();
		Iterator<SafeComponent> iterator = children.iterator();
		while(iterator.hasNext()) {
			SafeComponent safeComponent = iterator.next();
			System.out.println(((SafeLeaf) safeComponent).getName());
		}
		
	}

}
