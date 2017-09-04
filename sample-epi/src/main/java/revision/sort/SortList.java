package revision.sort;

import revision.lists.ListNode;
import java.util.*;
public class SortList<T extends Comparable<T>>{
	 
	public ListNode<T> insertionSort(ListNode<T> head) {

		if (head == null || head.next == null)
			return head;

		ListNode<T> dummyHead = new ListNode<>(null,head);
		ListNode<T> iter = dummyHead.next;

		while (iter != null && iter.next != null) {
			if (iter.data.compareTo(iter.next.data) > 0) {

				ListNode<T> target = iter.next, pre = dummyHead;

				while (pre.next.data.compareTo(target.data)<0) {
					pre = pre.next;
				}
				ListNode<T> temp = pre.next;
				pre.next=target;
				iter.next=target.next;
				target.next=temp;	
			} else {
 
				iter = iter.next;
			}
			System.out.println("I1:"+dummyHead.toString(dummyHead.next));
		}
		return dummyHead.next;
	}

	public static void main(String[] argv) {
		ListNode<Integer> temp = new ListNode<>(null,null);
		Integer[] data = {10,1,2,8,8,2,4,11};
		ListNode<Integer> head=temp.buildList(data);
		System.out.println("Before sorting:"+temp.toString(head));
		SortList<Integer> sl = new SortList<Integer>();
		head=sl.insertionSort(head);
		System.out.println("After sorting:"+temp.toString(head));
	}
}


