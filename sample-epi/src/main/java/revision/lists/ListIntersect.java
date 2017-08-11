package revision.lists;

import java.util.*;

public class ListIntersect {
	
	public ListNode<Integer> findIntersection(ListNode<Integer> head1, ListNode<Integer> head2) {
		if (head1 == null || head2 == null)
			return null;

		int len1 = length(head1);
		int len2 = length(head2);
		System.out.println(head1.data+"::"+head2.data);
		System.out.println("Len1::"+len1+"::Len2:"+len2);
		ListNode<Integer> temp1 = head1, temp2 = head2;

		if (len1 > len2) {
			while (len1 != len2) {
				head1=head1.next;
				len1--;
			}
		} else {
			while (len1 != len2) {
				head2=head2.next;
				len2--;
			}
		}
		System.out.println(head1.data+"::"+head2.data);
		System.out.println("Len1::"+len1+"::Len2:"+len2);
		while (head1 != head2 && head1 != null && head2 != null) {
			System.out.println(head1.data+"::"+head2.data);
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1==head2?head1:null;

	}

	private int length(ListNode<Integer> head) {
		int count = 0;
		ListNode<Integer> temp = head;
		while (temp != null) {
			count+=1;
			temp = temp.next;
		}
		return count;
	}

	public static void main(String[] argv) {

		ListNode<Integer> temp = new ListNode<Integer>(null,null);
		Integer[] data1 = {10,20,30,40,50,60,70};
		Integer[] data2 = {80,90};
		ListNode<Integer>[] heads = temp.buildIntersectList(data1,data2,40);
		System.out.println("Head 1:"+heads[0].data) ;
		System.out.println("Head 2:"+heads[1].data) ;

		ListIntersect li = new ListIntersect();
		ListNode<Integer> inter = li.findIntersection(heads[0],heads[1]);
		System.out.println("Intersection:"+(inter!=null?inter.data:0));
	}
}
