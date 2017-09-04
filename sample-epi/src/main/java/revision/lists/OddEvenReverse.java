package revision.lists;

import java.util.*;
import java.io.*;

public class OddEvenReverse {
	
	public ListNode<Integer> process(ListNode<Integer> oddLenList) {
		ListNode<Integer> dummyOddHead = new ListNode<Integer>(null, null);
		ListNode<Integer> dummyEvenHead = new ListNode<Integer>(null, null);
		List<ListNode<Integer>> headList = new ArrayList<>();
		headList.add(dummyOddHead);
		headList.add(dummyEvenHead);
		int i=0;
		ListNode<Integer> iter = oddLenList;
		while (iter != null) {
			headList.get(i).next=iter;
			headList.set(i,headList.get(i).next);
			iter=iter.next;
			i^=1;
		}
		headList.get(0).next=null;
		headList.get(1).next=null;
		System.out.println(dummyOddHead.toString(dummyOddHead.next));
		System.out.println(dummyOddHead.toString(dummyEvenHead.next));
		ListNode<Integer> subListHead=dummyEvenHead;
		ListNode<Integer> subListIter = subListHead.next;
		while (subListIter != null && subListIter.next != null) {
			ListNode<Integer> temp = subListIter.next;
			subListIter.next=temp.next;
			temp.next=subListHead.next;
			subListHead.next=temp;
		}
		System.out.println(dummyOddHead.toString(subListHead.next));
		headList.get(0).next=subListHead.next;
		return dummyOddHead.next;
	}

	
	public static void main(String[] argv) {
		
		Integer[] oddLenArr = {1,2,3,4,5,6,7,8,9};
		Integer[] evenLenArr = {1,2,3,4,5,6,7,8};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> oddLenList = temp.buildList(oddLenArr);
		ListNode<Integer> evenLenList = temp.buildList(oddLenArr);
		OddEvenReverse oer = new OddEvenReverse();
		ListNode<Integer> processNode = oer.process(oddLenList);
		System.out.println(temp.toString(processNode));
	}

}