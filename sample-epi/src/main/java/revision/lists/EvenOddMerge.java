package revision.lists;

import java.util.*;

public class EvenOddMerge {
	
	public ListNode<Integer> merge(ListNode<Integer> head) {
		int n = 0;
		ListNode<Integer> evenHead = new ListNode<Integer>(null,null);
		ListNode<Integer> oddHead = new ListNode<Integer>(null,null);
		List<ListNode<Integer>> headList = Arrays.asList(evenHead,oddHead);
		while (head!= null) {
			headList.get(n).next=head;
			headList.set(n,headList.get(n).next);
			head = head.next;
			n^=1;
		}
		headList.get(1).next=evenHead.next;
		headList.get(0).next=null;
		return oddHead.next;
	}

	public static void main(String[] argv) {
		Integer[] data = {10,20,30,40,50,60,70};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> head = temp.buildList(data);
		System.out.println("Input:"+temp.toString(head));
		EvenOddMerge eom = new EvenOddMerge();
		System.out.println("Output:"+temp.toString(eom.merge(head)));
	}

}