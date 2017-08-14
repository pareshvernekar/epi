package revision.lists;
import java.util.*;
public class LinkedListPivot {


	public ListNode<Integer> pivot(ListNode<Integer> head, Integer data) {
		if (head == null || head.next==null)
			return head;

		ListNode<Integer> lessHead = new ListNode<Integer>(null,null);
		ListNode<Integer> equalHead = new ListNode<Integer>(null,null);
		ListNode<Integer> greaterHead = new ListNode<Integer>(null,null);
		ListNode<Integer> lessIter = lessHead;
		ListNode<Integer> equalIter = equalHead;
		ListNode<Integer> greaterIter = greaterHead;
		while (head != null) {

			if (head.data.compareTo(data) < 0) {
				lessIter.next=head;
				lessIter=lessIter.next;
			} else if (head.data.compareTo(data) > 0) {
				greaterIter.next=head;
				greaterIter=greaterIter.next;
			} else {
				equalIter.next=head;
				equalIter=equalIter.next;
			}
			head=head.next;
		}
		lessIter.next=equalHead.next;
		equalIter.next=greaterHead.next;
		greaterIter.next=null;
		return lessHead.next;
	}
	public static void main(String[] argv) {
		Integer[] data = {10,20,30,40,50,60,40,70,40};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> head = temp.buildList(data);
		System.out.println("Input:"+temp.toString(head));
		LinkedListPivot llp = new LinkedListPivot();
		System.out.println("Output:"+temp.toString(llp.pivot(head,40)));
		

	}

}