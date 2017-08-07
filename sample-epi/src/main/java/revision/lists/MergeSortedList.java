package revision.lists;

import java.util.*;

public class MergeSortedList {
	

	public ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
		ListNode<Integer> dummyHead = new ListNode<>(null,head1);
		ListNode<Integer> current = new ListNode<>(null,head1);
		ListNode<Integer> p1=head1, p2=head2;

		while (p1 != null && p2 != null) {

			if (p1.data<=p2.data) {
				current.next=p1;
				p1=p1.next;
			} else {
				current.next=p2;
				p2=p2.next;
			}
			current=current.next;
		}
		current.next=(p1!=null)?p1:p2;
		return dummyHead.next;

	}


	public static void main(String[] argv) {

		
		ListNode<Integer> head1 = createList(new int[]{80,70,25,15,10});
		ListNode<Integer> head2 = createList(new int[]{100,50,40,30,20,10});


		System.out.println(head1.toString(head1));
		
		System.out.println(head2.toString(head2));
		MergeSortedList msl = new MergeSortedList();
		ListNode<Integer> nh = msl.merge(head1,head2);
		System.out.println("After Merge:"+nh.toString(nh));
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