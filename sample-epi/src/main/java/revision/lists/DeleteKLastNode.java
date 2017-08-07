package revision.lists;

import java.util.*;

public class DeleteKLastNode {


	public ListNode<Integer> deleteKNode(ListNode<Integer> head, int k) {

		if (head == null || k == 0)
			return head;

		ListNode<Integer> dummyHead = new ListNode<Integer>(null,head);
		ListNode<Integer> prev = dummyHead;
		ListNode<Integer> iter = head;

		while (k != 0) {
			iter=iter.next;
			k--;
		}

		while (iter != null) {
			prev=prev.next;
			iter=iter.next;
		}

		prev.next=prev.next.next;
	
		return dummyHead.next;

	}
	
	public static void main(String[] argv) {

		Integer[] data = {10,20,30,40,50,60,70};
		ListNode<Integer> temp = new ListNode<>(null,null);
		DeleteKLastNode dn = new DeleteKLastNode();

		ListNode<Integer> head = temp.buildList(data);
		System.out.println(temp.toString(head));
		head = dn.deleteKNode(head,1);
		System.out.println("After delete:"+temp.toString(head));

	} 

}