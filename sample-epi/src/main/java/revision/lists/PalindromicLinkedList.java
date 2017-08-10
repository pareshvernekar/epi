package revision.lists;

import java.util.*;

public class PalindromicLinkedList {
	

	public boolean isPalindrome(ListNode<Integer> head) {

		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> fast = head;
		ListNode<Integer> slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("Middle:"+slow.data);
		ListNode<Integer> subHead = slow;
		ListNode<Integer> iter = slow.next;
		
		while (iter != null && iter.next != null) {
			ListNode<Integer> subIter = iter.next;
			iter.next=subIter.next;
			subIter.next=subHead.next;
			subHead.next=subIter;
		}
		System.out.println("Reverse:"+temp.toString(head));
		subHead=subHead.next;
		while (head != null && subHead != null) {
			if (head.data.compareTo(subHead.data) != 0)
				return Boolean.FALSE;
			head = head.next;
			subHead = subHead.next;

		}
		return Boolean.TRUE;
	}
	public static void main(String[] argv) {
		Integer[] data = {10,20,30,40,30,20,10};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> head = temp.buildList(data);
		System.out.println("Input:"+temp.toString(head));
		PalindromicLinkedList p = new PalindromicLinkedList();
		System.out.println("Output:"+p.isPalindrome(head));
		Integer[] data1 = {1,2,3,4,5,6};
		head = temp.buildList(data1);
		System.out.println("Output:"+p.isPalindrome(head));
		Integer[] data2 = {1,2,2,1};
		head = temp.buildList(data2);
		System.out.println("Output:"+p.isPalindrome(head));
		Integer[] data3 = {1,2,2,2};
		head = temp.buildList(data3);
		System.out.println("Output:"+p.isPalindrome(head));
	}

}