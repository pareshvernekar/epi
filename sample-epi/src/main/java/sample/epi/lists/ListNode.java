package sample.epi.lists;

public class ListNode<T extends Comparable<T>> {
	
	public T data;
	public ListNode<T> next;
}