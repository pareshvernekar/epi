package sample.epi.lists;

public class ListHelper<T extends Comparable<T>> {
	

	public ListNode<T> createList(T[] arr) {

		if (arr == null || arr.length == 0)
			return null;

		int len = arr.length;
		ListNode<T> head = null;
		ListNode<T> temp = null;
		for (int i = 0;i<len;i++) {
			if (head == null) {
				head = new ListNode<T>();
				head.data = arr[i];
			} else if (temp==null) {
				temp = new ListNode<T>();
				temp.data = arr[i];
				head.next = temp;
			} else {
				temp.next = new ListNode<T>();
				temp.next.data = arr[i];
				temp = temp.next;
			}

		}
		return head;
	}
	public  String toString(ListNode<T> head) {

		ListNode<T> temp = head;
		StringBuilder strBuilder = new StringBuilder();
		boolean first = true;
		while (temp != null) {
			if (first) {
				strBuilder.append(temp.data!=null?temp.data.toString():"NULL");
				first = false;
			}
			else
				strBuilder.append(",").append(temp.data!=null?temp.data.toString():"NULL");
			temp = temp.next;
		}
		return strBuilder.toString();
	}

	public ListNode<T> createCycle(ListNode<T> head, T data) {

		ListNode<T> dest = null;
		ListNode<T> tail = head;
		while (tail.next != null) {
			if (tail.data.compareTo(data)==0) {
				dest = tail;
			}
			tail = tail.next;
		}
		tail.next = dest;
		return head;
	}
}
