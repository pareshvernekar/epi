package sample.epi.lists.episolution;

import sample.epi.lists.*;
import java.util.*;

public class LinkedListCycleDetect {
	

	public ListNode<Integer> isCyclic(ListNode<Integer> head) {

		ListNode<Integer> first = head;
		ListNode<Integer> second = head;
		while (first != null && first.next != null) {
			first=first.next.next;
			second = second.next;
			if (first == second) {	//Found intersection

				int cycleLen = 0;
				do {
					cycleLen+=1;
					first = first.next;
				} while (first != second);
				System.out.println("Cycle Length:"+cycleLen);
				ListNode<Integer> cycleIter = head;
				while (cycleLen-->0) {
					cycleIter = cycleIter.next;
				}
				System.out.println("START:"+cycleIter.data);
				ListNode<Integer> temp = head;
				while (temp != cycleIter) {
					temp = temp.next;
					cycleIter=cycleIter.next;
					System.out.println("TEMP:"+temp.data+"::"+cycleIter.data);
				}
				return temp;
			}
		}
		return null;	//Null if no cycle
	}
	public static void main(String[] argv) {
		Integer[] arr1 = new Integer[]{1,2,3,4,5,6,7,8,9};
		ListHelper<Integer> listHelper = new ListHelper<Integer>();
		ListNode<Integer> head = listHelper.createList(arr1);
		head = listHelper.createCycle(head, 5);
		LinkedListCycleDetect llCD = new LinkedListCycleDetect();
		ListNode<Integer> intersect = llCD.isCyclic(head);
		System.out.println("INTERSECT:"+(intersect!=null?intersect.data:null));

	}
}