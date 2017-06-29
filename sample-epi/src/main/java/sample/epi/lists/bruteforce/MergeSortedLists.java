package sample.epi.lists.bruteforce;

import java.util.*;
import sample.epi.lists.*;
public class MergeSortedLists<T extends Comparable<T>> {
	
	public ListNode<T> merge(ListNode<T> head1, ListNode<T> head2) {
		if (head1 == null && head2 == null)
			return null;
		else if (head1 == null && head2 != null)
			return head2;
		else if (head1 != null && head2 == null)
			return head1;
		ListNode<T> dummyHead = new ListNode<T>();
		ListNode<T> temp = dummyHead;

		while (head1 != null && head2 != null) {
			if (head1.data.compareTo(head2.data) <= 0) {
				temp.next = head1;
				head1=head1.next;
			} else {
				temp.next=head2;
				head2=head2.next;
			}
			temp = temp.next;
		}

		temp.next=head1!=null?head1:head2;
		return dummyHead.next;
	}

	public static void main(String[] argv) {

		Integer[] arr1 = new Integer[]{1,3,6,7};
		Integer[] arr2 = new Integer[]{2,4,5,8,9};
		ListHelper<Integer> listHelper = new ListHelper<Integer>();
		MergeSortedLists<Integer> mergeSortedLists = new MergeSortedLists<Integer>();
		ListNode<Integer> head1 = mergeSortedLists.createList(arr1);
		ListNode<Integer> head2 =  mergeSortedLists.createList(arr2);
		System.out.println(listHelper.toString(head1));
		System.out.println(listHelper.toString(head2));
		System.out.println(listHelper.toString(mergeSortedLists.merge(head1,head2)));

	}

	public ListNode<T> createList(T[] arr) {

		if (arr == null || arr.length == 0)
			return null;

		int len = arr.length;
		ListNode<T> head = null;
		ListNode<T> temp = null;
		for (int i = 0;i<len;i++) {
			if (head == null) {
				head = new ListNode<T>();
				head.data = arr[i];
			} else if (temp==null) {
				temp = new ListNode<T>();
				temp.data = arr[i];
				head.next = temp;
			} else {
				temp.next = new ListNode<T>();
				temp.next.data = arr[i];
				temp = temp.next;
			}

		}
		return head;
	}
}