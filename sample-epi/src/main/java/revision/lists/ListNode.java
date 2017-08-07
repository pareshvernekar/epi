package revision.lists;

import java.util.*;

public class ListNode<T extends Comparable<T>> {


	T data;
	ListNode<T> next;

	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
	}


	public ListNode<T> buildList(T[] data) {

		int len = data.length;
		ListNode<T> head=null;
		for (int i=0;i<len;i++) {
			ListNode<T> temp = new ListNode<>(data[i],head);
			head=temp;
		}
		return head;
	}

	public String toString(ListNode<T> head) {
		ListNode<T>  temp = head;

		StringBuilder strBuilder = new StringBuilder();


		while (temp != null) {
			if (temp.data != null) {
				if (strBuilder.length() == 0) {
					strBuilder.append(temp.data.toString());
				} else {
					strBuilder.append(",").append(temp.data.toString());
				}
			}
			temp = temp.next;
		}

		return strBuilder.toString();
	}

}