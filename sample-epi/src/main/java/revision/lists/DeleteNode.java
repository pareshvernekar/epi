package  revision.lists;

import java.util.*;

public class DeleteNode {


		public ListNode<Integer> modDelete(ListNode<Integer> head, int n) {

			if (head == null)
				return null;

			ListNode<Integer> dummyHead = new ListNode<>(null,head);
			ListNode<Integer> iter = head;

			while (iter != null && iter.data.compareTo(n) != 0) {
				iter=iter.next;
			}

			if (iter != null && iter.next != null) {
				iter.data = iter.next.data;
				iter.next = iter.next.next;
			}

			return dummyHead.next;

		}

		public ListNode<Integer> delete(ListNode<Integer> head, int n) {

			if (head == null)
				return null;

			ListNode<Integer> dummyHead = new ListNode<>(null,head);
			ListNode<Integer> prev = dummyHead;
			ListNode<Integer> iter = head;

			while (iter != null) {

				if (iter.data.compareTo(n) == 0) {
					prev.next=iter.next;
				}
				iter=iter.next;
				prev=prev.next;
			}

			return dummyHead.next;

		}
	

		public static void main(String[] argv) {

		Integer[] data = {10,20,30,40,50,60,70};
		ListNode<Integer> temp = new ListNode<>(null,null);
		DeleteNode dn = new DeleteNode();

		ListNode<Integer> head = temp.buildList(data);
		System.out.println(temp.toString(head));
		head = dn.delete(head,40);
		System.out.println("Middle Node delete:"+temp.toString(head));
		head = dn.delete(head,10);
		System.out.println("First Node delete:"+temp.toString(head));
		head = dn.delete(head,70);
		System.out.println("Last Node delete:"+temp.toString(head));


		head = temp.buildList(data);
		System.out.println(temp.toString(head));
		head = dn.modDelete(head,40);
		System.out.println("Middle Node delete:"+temp.toString(head));
		head = dn.modDelete(head,10);
		System.out.println("First Node delete:"+temp.toString(head));
		head = dn.modDelete	(head,70);
		System.out.println("Last Node delete:"+temp.toString(head));


	}
}