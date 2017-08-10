package revision.lists;

import java.util.*;

public class LinkedListCyclicRightShift {
	
	public ListNode<Integer> rightShift(ListNode<Integer> head, int k) {

		if (head == null || head.next==null)
			return head;

		ListNode<Integer> temp = head;
		int n = 1;
		while (temp.next != null) {
			temp = temp.next;
			n++;
		}
		System.out.println("Length:"+n);

		k=k%n;
		System.out.println("Actual shift:"+k);
		temp.next=head;
		k = n-k;
		while (k!=0) {
			temp=temp.next;
			k--;
		}
		ListNode<Integer> newHead = temp.next;
		temp.next=null;
		return newHead;


	}

	public static void main(String[] argv) {
		Integer[] data = {10,20,30,40,50,60,70};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> head = temp.buildList(data);
		System.out.println("Input:"+temp.toString(head));
		LinkedListCyclicRightShift llcrs = new LinkedListCyclicRightShift();
		System.out.println("Output:"+temp.toString(llcrs.rightShift(head,2)));
		

	}

}