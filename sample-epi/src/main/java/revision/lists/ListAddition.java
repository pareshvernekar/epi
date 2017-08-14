package revision.lists;

import java.util.*;

public class ListAddition {
	
	public ListNode<Integer> add(ListNode<Integer> head1, ListNode<Integer> head2) {
		if (head1==null && head2!=null)
			return head2;
		else if(head1!=null && head2==null)
			return head1;
		else if(head1==null && head2==null) 
			return null;
		int carry = 0;
		ListNode<Integer> dummyHead = new ListNode<Integer>(null,null);
		ListNode<Integer> iter = dummyHead;
		while (head1 != null && head2 != null) {

			int sum = head1.data + head2.data + carry;
			System.out.println("sum:"+sum);
			ListNode<Integer> temp = new ListNode<Integer>(sum%10,null);
			carry = sum/10;
			System.out.println("carry1:"+carry);
			if (dummyHead.next==null) {
				dummyHead.next=temp;
			} else {
				iter.next=temp;
			}
			iter = iter.next;
			head1=head1.next;
			head2=head2.next;
		}

		ListNode<Integer> remain=head1!=null?head1:head2;

		while (remain != null) {

			int sum = remain.data+carry;
			System.out.println("sum:"+sum);
			ListNode<Integer> temp = new ListNode<Integer>(sum%10,null);
			carry = sum/10;
			iter.next=temp;
			iter=iter.next;
			remain=remain.next;
		}

		while (carry != 0) {
			ListNode<Integer> temp = new ListNode<Integer>(carry%10,null);
			carry=carry/10;
			iter.next=temp;
			iter=iter.next;
		}
		return dummyHead.next;
	}

	public static void main(String[] argv) {
		Integer[] data1 = {1,2,3,4,5,6,7};
		Integer[] data2 = {9,8,3};
		ListNode<Integer> temp = new ListNode<>(null,null);
		ListNode<Integer> head1 = temp.buildList(data1);
		ListNode<Integer> head2 = temp.buildList(data2);
		ListAddition la = new ListAddition();
		ListNode<Integer> result=la.add(head1,head2);
		System.out.println("Output:"+temp.toString(result));
	}
}