package revision.lists;

import java.util.*;
import java.lang.reflect.*;
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

	public ListNode<T>[] buildIntersectList(T[] data1, T[] data2, T common) {

		int len = data1.length;
		ListNode<T> head=null;
		ListNode<T> commonNode=null;
		ListNode[] heads = new ListNode[2];
		for (int i=0;i<len;i++) {
			ListNode<T> temp = new ListNode<>(data1[i],head);
			if (common.compareTo(data1[i])==0)
				commonNode=temp;
			head=temp;
		}

		heads[0]=head;
		len = data2.length;
		for (int i=0;i<len;i++) {
			ListNode<T> temp=new ListNode<>(data2[i],head);
			if (i==0)
				temp.next=commonNode;
			head=temp;
		}
		heads[1]=head;
		return heads;
	}

	public ListNode<T> buildCyclicList(T[] data, T cycle) {

		int len = data.length;
		ListNode<T> head=null;
		ListNode<T> cycleNode = null;
		ListNode<T> tail = null;
		for (int i=0;i<len;i++) {
			ListNode<T> temp = new ListNode<>(data[i],head);
			if (data[i].compareTo(cycle)==0) {
				cycleNode = temp;
			}
			if (i==0) {
				tail = temp;
			}
			head=temp;
		}
		if (cycleNode != null) {
			tail.next=cycleNode;
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