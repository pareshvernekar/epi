package revision.lists;

import java.util.*;

public class CyclicList {

	public ListNode<Integer> isCycle(ListNode<Integer> head) {

		if (head == null || head.next==null)
			return head;
		ListNode<Integer> fast = head;
		ListNode<Integer> slow = head;
		while (fast != null && fast.next != null) {
			fast=fast.next.next;
			slow=slow.next;
			if (slow==fast) { //cycle
				int count = 0;
				do {
					fast=fast.next;
					count+=1;
				} while (fast != slow);
				System.out.println("Length of cycle:"+count);
				ListNode<Integer> cycleIter = head;
				while (count > 0) {
					cycleIter=cycleIter.next;
					count--;
				}
				ListNode<Integer> iter = head;

				while (iter != cycleIter) {
					iter = iter.next;
					cycleIter=cycleIter.next;
				}

				return cycleIter;


			}

		}
		return null;	
	} 
	public static void main(String[] argv) {

		Integer[] data = {10,20,30,40,50,60,70};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> head = temp.buildCyclicList(data,50);
		CyclicList cl = new CyclicList();
		ListNode<Integer> cycle = cl.isCycle(head);
		System.out.println(cycle != null? cycle.data:-1);
		head = temp.buildList(data);
		cycle = cl.isCycle(head);
		System.out.println(cycle != null? cycle.data:-1);
	}
		
}