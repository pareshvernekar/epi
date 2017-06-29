package sample.epi.lists.bruteforce;

import sample.epi.lists.*;
import java.util.*;

public class LinkedListDeleteNode {


	public ListNode<Integer> delete(ListNode<Integer> head, int data) {
		ListNode<Integer> dummyHead = new ListNode<Integer>();
		dummyHead.next=head;
		ListNode<Integer> subIter=head;
		ListNode<Integer> temp = dummyHead;
		while (subIter != null && subIter.data.compareTo(data) != 0) {
			subIter = subIter.next;
			temp = temp.next;
		}
		if (subIter != null) {
			temp.next = subIter.next;
			subIter.next = null;
		}
		return dummyHead.next;


	}	
	public static void main(String[] argv) {
		Integer[] arr1 = new Integer[]{1,2,3,4,5,6,7,8,9};
		ListHelper<Integer> listHelper = new ListHelper<Integer>();
		ListNode<Integer> head = listHelper.createList(arr1);
		LinkedListDeleteNode llDN = new LinkedListDeleteNode();
		System.out.println(listHelper.toString(head));
		head=llDN.delete(head,5);
		System.out.println("AFTER DELETING 5:"+listHelper.toString(head));
		head = llDN.delete(head,1);
		System.out.println("AFTER DELETING 1:"+listHelper.toString(head));
		head = llDN.delete(head,9);
		System.out.println("AFTER DELETING 9:"+listHelper.toString(head));
	}
}