package cn.edu.scau.cmi.longting.client;

import java.util.Iterator;
import java.util.Set;

import cn.edu.scau.cmi.longting.composite.consistent.ConsistentComponent;
import cn.edu.scau.cmi.longting.composite.consistent.ConsistentComposite;
import cn.edu.scau.cmi.longting.composite.consistent.ConsistentLeaf;

public class ConsistentCompositeClient {

	public static void main(String[] args) {
		ConsistentComponent trunk = new ConsistentComposite();
		((ConsistentComposite)trunk).setName("总团队");
		
		ConsistentComponent firstBranch = new ConsistentComposite();
		((ConsistentComposite)firstBranch).setName("第一个团队");
		
		ConsistentComponent secondBranch = new ConsistentComposite();
		((ConsistentComposite)secondBranch).setName("第二个团队");
		
		ConsistentComponent firstLeaf = new ConsistentLeaf();
		((ConsistentLeaf)firstLeaf).setName("第一个团队上的第一个人");
		
		ConsistentComponent secondLeaf = new ConsistentLeaf();
		((ConsistentLeaf)secondLeaf).setName("第一个团队上的第二个人");
		
		ConsistentComponent thirdLeaf = new ConsistentLeaf();
		((ConsistentLeaf)thirdLeaf).setName("第二个团队上的第一个人");
		
		ConsistentComponent forthLeaf = new ConsistentLeaf();
		((ConsistentLeaf)forthLeaf).setName("第二个团队上的第二个人");
		
		firstLeaf.addChild(secondLeaf);
		
		firstBranch.addChild(firstLeaf);
		
		firstBranch.addChild(secondLeaf);
		secondBranch.addChild(thirdLeaf);
		secondBranch.addChild(forthLeaf);
		
		trunk.addChild(firstBranch);
		trunk.addChild(secondBranch);
		
		Set<ConsistentComponent> trunkChirldren = trunk.getChildren();
		Iterator<ConsistentComponent> trunkChildrenIterator = trunkChirldren.iterator();
		
		while(trunkChildrenIterator.hasNext()) {
			ConsistentComposite composite = (ConsistentComposite)trunkChildrenIterator.next();
			System.out.println(composite.getName());
			Iterator<ConsistentComponent> compositrIterator = (composite.getChildren()).iterator();
			while (compositrIterator.hasNext()) {
				System.out.println(((ConsistentLeaf)compositrIterator.next()).getName());
			}
		}
		
		System.out.println("操作完毕！");
	}
}
