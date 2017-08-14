package revision.queues;

import java.util.*;

public class QueueWithMax<T extends Comparable<T>> {
	
	Deque<QNode> queue = new LinkedList<>();

	public void enqueue(T data) {

		if (queue.isEmpty()) {
			QNode temp = new QNode(data,data);
			queue.addLast(temp);
		} else {
			QNode temp = new QNode(data);
			if (queue.peek().max == null ||
					queue.peek().max.compareTo(temp.data) < 0) 
				queue.peek().max = temp.data;
			queue.addLast(temp);
		}
	}

	public T dequeue() {

		if (queue.isEmpty()) {
			return null;
		} else {
			QNode temp = queue.removeFirst();
			if (temp.max!=null) {
				if (queue.peek().max == null || queue.peek().max.compareTo(temp.data) >0)
					queue.peek().max=temp.max;
			}	
				
			return (T)temp.data;
		}
	}

	public T max() {

		if (queue.isEmpty()) {
			return null;
		} else {
			return (T)queue.peek().max;
		}
	}

	public static void main(String[] argv) {
		QueueWithMax<Integer> q = new QueueWithMax<>();
		q.enqueue(10);
		System.out.println("Max:"+q.max());
		q.enqueue(20);
		System.out.println("Max:"+q.max());
		q.enqueue(30);
		System.out.println("Max:"+q.max());
		System.out.println("After dequeue:"+q.dequeue());
		System.out.println("Max:"+q.max());
	}

}

class QNode<T extends Comparable<T>> {
	T data;
	T max;
	public QNode(T data) {
		this.data = data;
	}
	public QNode(T data, T max) {
		this.data = data;
		this.max = max;
	}
}