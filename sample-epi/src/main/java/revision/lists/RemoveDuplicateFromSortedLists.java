package revision.lists;

import java.util.*;

public class RemoveDuplicateFromSortedLists {


	public ListNode<Integer> deleteDuplicate(ListNode<Integer> head) {
		if (head==null || head.next==null)
			return head;
		ListNode<Integer> dummyHead = new ListNode<Integer>(null,head);
		ListNode<Integer> prev = dummyHead;
		ListNode<Integer> iter = head;

		while (iter != null) {
			prev=prev.next;
			iter=iter.next;
			while (iter != null && prev.data==iter.data) {
				iter=iter.next;
			}

			if (iter != null && prev.data != iter.data) {
				prev.next=iter;
			}
		}
		return dummyHead.next;
	}
	

	public static void main(String[] argv) {

		Integer[] data = {10,20,30,30, 40,40,50,60,70, 70};
		ListNode<Integer> temp = new ListNode<>(null,null);

		RemoveDuplicateFromSortedLists rdfsl = new RemoveDuplicateFromSortedLists();


		ListNode<Integer> head = temp.buildList(data);
		System.out.println(temp.toString(head));
		head = rdfsl.deleteDuplicate(head);
		System.out.println("After delete:"+temp.toString(head));

	}
}