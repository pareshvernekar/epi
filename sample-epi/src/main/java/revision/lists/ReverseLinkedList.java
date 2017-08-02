package revision.lists;

import java.util.*;

public class ReverseLinkedList<T extends Comparable<T>> {


	public ListNode<T> fullReverse(ListNode<T> head) {

		if (head == null || head.next == null)
			return head;

		ListNode<T> dummyHead = new ListNode<>(null,head);
		ListNode<T> dummyIter = dummyHead.next;
		ListNode<T> currIter = dummyIter.next;

		while (currIter != null) {

			dummyIter.next = currIter.next;
			currIter.next=dummyHead.next;
			dummyHead.next=currIter;
			currIter = dummyIter.next;
		}
		return dummyHead.next;
	}

	public ListNode<T> partialReverse(ListNode<T> head,int j) {

		if (head == null || head.next == null || j == 0)
			return head;

		ListNode<T> dummyHead = new ListNode<>(null,head);
		ListNode<T> dummyIter = dummyHead.next;
		while (j>0 && dummyIter != null) {
			dummyHead = dummyIter;
			dummyIter = dummyIter.next;	
			j--;
		}
		if (j > 0 && dummyIter == null)
			return head;



		ListNode<T> currIter = dummyIter.next;

		while (currIter != null) {

			dummyIter.next = currIter.next;
			currIter.next=dummyHead.next;
			dummyHead.next=currIter;
			currIter = dummyIter.next;
		}
		return head;
	}


	public static void main(String[] argv) {

		Integer[] data = {10,20,30,40,50,60,70};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ReverseLinkedList<Integer> rll = new ReverseLinkedList<>();

		ListNode<Integer> head = temp.buildList(data);
		System.out.println(temp.toString(head));
		head = rll.fullReverse(head);
		System.out.println("FULL REVERSE:"+temp.toString(head));
		System.out.println("BEFORE REVERSE:"+temp.toString(head));
		System.out.println("PARTIAL REVERSE:"+temp.toString(rll.partialReverse(head,3)));
	}


}