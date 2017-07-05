package sample.epi.stacks.bruteforce;

import java.util.*;

public class JumpFirstOrder {
	

	public JumpNode init() {

		JumpNode node1 = new JumpNode(10);
		JumpNode node2 = new JumpNode(20);
		JumpNode node3 = new JumpNode(30);
		JumpNode node4 = new JumpNode(40);
		node1.next 	=	node2;
		node2.next	=	node3;
		node3.next 	=	node4;
		node1.jump 	= 	node3;
		node2.jump  = 	node4;
		node3.jump 	=	node2;
		node4.jump 	=	node4;
		return node1;

	}

	private void recurJumpFirst(JumpNode node, StringBuilder strBuilder) {
		if (node == null || node.order != -1)
			return;
		if (strBuilder.length()==0) {
				strBuilder.append(node.value);
		} else {
			strBuilder.append(",").append(node.value);
		}
		if (node.jump != null && node.order==-1) {
			node.order=0;
			recurJumpFirst(node.jump,strBuilder);
		} 
		recurJumpFirst(node.next,strBuilder);

	}
	public String recurJumpFirstIter(JumpNode head) {

		JumpNode temp = head;
		StringBuilder strBuilder = new StringBuilder();
		if (strBuilder.length()==0) {
				strBuilder.append(head.value);
			}
		if (head.jump != null && head.order==-1) {
			head.order=0;
			recurJumpFirst(head.jump,strBuilder);
		}
		recurJumpFirst(head.next,strBuilder);
		return strBuilder.toString();
	}
	public String nonrecurJumpFirstIter(JumpNode head) {
		Deque<JumpNode> nextNodeStack = new LinkedList();
		JumpNode temp = head;
		StringBuilder strBuilder = new StringBilder();
		boolean first = true;
		while (temp != null)  {
			if (temp.order != -1) {
				temp = (!nextNodeStack.isEmpty())?nextNodeStack.removeFirst():null;
				continue;
			}
			temp.order=0;
			nextNodeStack.addFirst(temp.next);
+			if (first) {
				strBuilder.append(temp.value);
				first = false;
			} else {
				strBuilder.append(",").append(temp.value);
			}
			if (temp.jump != null)
				temp = temp.jump;
			else
				temp = nextNodeStack.removeFirst();
		}

		return strBuilder.toString();
	}
	public String normalIter(JumpNode head) {
		JumpNode temp = head;
		StringBuilder strBuilder = new StringBuilder();
		boolean first = true;
		while (temp != null) {
			if (first) {
				strBuilder.append(temp.value);
				first = false;
			} else {
				strBuilder.append(",").append(temp.value);
			}
			temp = temp.next;
		}
		return strBuilder.toString();
	}

	public static void main(String[] argv) {
		JumpFirstOrder j = new JumpFirstOrder();
		JumpNode head = j.init();
		System.out.println(j.normalIter(head));
		System.out.println(j.recurJumpFirstIter(head));
		System.out.println(j.nonrecurJumpFirstIter(j.init()));
	}
}
 class JumpNode {
	
	int value;
	int order=-1;
	JumpNode next;
	JumpNode jump;

	public JumpNode(int value) {
		this.value = value;
	}
}