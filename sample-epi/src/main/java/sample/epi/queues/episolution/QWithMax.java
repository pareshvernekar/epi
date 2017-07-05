package sample.epi.queues.episolution;

import java.util.*;

public class QWithMax<T extends Comparable<T>> {

	Deque<T> q = new LinkedList<>();
	Deque<T> dq = new LinkedList<>();

	public void enqueue(T data) {
		q.addLast(data);
		if (dq.isEmpty()) {
			dq.addLast(data);
		} else {
			while (!dq.isEmpty() && dq.peekLast().compareTo(data) < 1) {
				dq.pollLast();
			}
			dq.addLast(data);
		}
	}

	public T dequeue() {

		T data = q.pollFirst();
		if (data.compareTo(dq.peekFirst())==0) {
			dq.pollFirst();
		}

		return data;
	}

	public T max() {
		if (dq.isEmpty())
			return null;
		return dq.peekFirst();
	}

	public static void main(String[] argv) {
		QWithMax<Integer> q = new QWithMax<>();

		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		System.out.println("Max:"+q.max());
		q.dequeue();
		System.out.println("Max:"+q.max());
		q.dequeue();
		q.dequeue();
		q.enqueue(10);
		System.out.println("Max:"+q.max());

	}
	
}