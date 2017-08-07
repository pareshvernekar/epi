package revision.lists;

import java.util.*;

public class ReverseSublist {
	

	public ListNode<Integer> reverseSubList(ListNode<Integer> head, int start, int end) {

		if (start <= 0 || start >= end)
			return head;

		ListNode<Integer> dummyHead = new ListNode<Integer>(null,head);
		ListNode<Integer> subListHead = new ListNode<Integer>(null,head);
		ListNode<Integer> subListIter = head;
		int count = 1;
		while (count != start && subListIter!=null) {
			subListHead=subListHead.next;
			subListIter=subListIter.next;
			count++;
		}

		if (subListIter==null)
			return head;

		ListNode<Integer> next = subListIter.next;

		while (count != end && next != null) {

			subListIter.next=next.next;
			next.next=subListHead.next;
			subListHead.next=next;
			next=subListIter.next;
			count++;
		}
		return start==1?subListHead.next:dummyHead.next;

	}

	public static void main(String[] argv) {

		ListNode<Integer> head1 = createList(new int[]{80,70,25,15,10,100,50,40,30,20,10});
		ReverseSublist rsl = new ReverseSublist();
		System.out.println(head1.toString(head1));
		head1 = rsl.reverseSubList(head1,3,6);
		System.out.println("Result:"+head1.toString(head1));

		 head1 = createList(new int[]{80,70,25,15,10,100,50,40,30,20,10});
		System.out.println(head1.toString(head1));
		head1 = rsl.reverseSubList(head1,1,11);
		System.out.println("Result:"+head1.toString(head1));

		

	}
	private static ListNode<Integer> createList(int[] arr) {

		ListNode<Integer> head = null;
		for (int i=0;i<arr.length;i++) {
			if (head == null) {
				head = new ListNode<>(arr[i],null);
			} else {
				ListNode<Integer> temp  = new ListNode<>(arr[i],head);
				head=temp;
			}
		}
		return head;
	}

}