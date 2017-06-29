package sample.epi.lists.episolution;

import java.util.*;
import sample.epi.lists.*;

public class ReverseSubList {

	public ListNode<Integer> reverse(ListNode<Integer> head, int l1, int l2) {

		ListNode<Integer> temp=null, subHead = null, subIter = null;
		int count = 1;
		
		subHead = new ListNode<Integer>();
		subHead.next=head;
		ListNode<Integer> tempHead = subHead;
		while (count++ < l1) {
			subHead = subHead.next;
		}
		subIter = subHead.next;	//start of sublist to reverse

		while (l1++ <l2) {
			temp = subIter.next;
			subIter.next=temp.next;
			temp.next=subHead.next;	
			subHead.next=temp;
		}
		return tempHead.next;
	}
	public static void main(String[] argv) {
		Integer[] arr1 = new Integer[]{1,2,3,4,5,6,7,8,9};
		ListHelper<Integer> listHelper = new ListHelper<Integer>();
		ListNode<Integer> head = listHelper.createList(arr1);
		ReverseSubList rsl = new ReverseSubList();
		System.out.println(listHelper.toString(head));
		System.out.println(listHelper.toString(rsl.reverse(head,1,4)));
	}
}