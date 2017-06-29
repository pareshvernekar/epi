package sample.epi.lists.episolution;

import sample.epi.lists.*;
import java.util.*;

public class ReverseSingleLinkedList {


	public ListNode<Integer> reverse(ListNode<Integer> head) {

		ListNode<Integer> dummyHead = new ListNode<Integer>();
		dummyHead.next = head;
		ListNode<Integer> subHead = dummyHead;
		ListNode<Integer> subIter = head;
		ListNode<Integer> temp = null;
		while (subIter.next != null) {
			temp = subIter.next;
			subIter.next = temp.next;
			temp.next = subHead.next;
			subHead.next=temp;
		}
		return dummyHead.next;
	}

	public static void main(String[] argv) {
		Integer[] arr1 = new Integer[]{1,2,3,4,5,6,7,8,9};
		ListHelper<Integer> listHelper = new ListHelper<Integer>();
		ListNode<Integer> head = listHelper.createList(arr1);
		ReverseSingleLinkedList rsl = new ReverseSingleLinkedList();
		System.out.println(listHelper.toString(head));
		System.out.println(listHelper.toString(rsl.reverse(head)));
	}
}