package revision.queues;

import java.util.*;

public class MaxQueue<T extends Comparable<T>> {
	
	private Queue<T> q = new LinkedList<>();
	private Deque<T> dq = new LinkedList<>();

	public void enqueue(T data) {
		q.add(data);
		while (!dq.isEmpty()) {
			if (dq.peekLast().compareTo(data) >= 0) {
				break;
			}
			dq.removeLast();
		}
		dq.addLast(data);
	}

	public T dequeue() {
		if (!q.isEmpty()) {
			T data = q.remove();
			if (!dq.isEmpty() && dq.peek().compareTo(data)==0) {
				dq.removeFirst();
			}
			return data;
		}
		return null;
	}

	public T max() {
		if (!dq.isEmpty()) {
			return dq.peek();
		}
		return null;
	}

	public static void main(String[] argv) {
		MaxQueue<Integer> mq = new MaxQueue<>();
		mq.enqueue(10);
		mq.enqueue(15);
		mq.enqueue(30);
		mq.enqueue(60);
		mq.enqueue(30);
		mq.enqueue(60);
		System.out.println("Max:"+mq.max());
		System.out.println("DQ:"+mq.dequeue());
		System.out.println("DQ:"+mq.dequeue());
		System.out.println("DQ:"+mq.dequeue());
		System.out.println("DQ:"+mq.dequeue());
		System.out.println("DQ:"+mq.dequeue());
		System.out.println("Max:"+mq.max());
	}
}