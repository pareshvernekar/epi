package revision.queues;

import java.util.*;

public class QUsingStack {
	
	Deque<Integer> eQ = new LinkedList<>();
	Deque<Integer> dQ = new LinkedList<>();

	public void enqueue(Integer t) {
		if (!dQ.isEmpty()) {
			while (!dQ.isEmpty()) {
				eQ.addFirst(dQ.removeFirst());
			}
		}
		eQ.addFirst(t);
	}


	public Integer dequeue() {
		if (!eQ.isEmpty()) {
			while (!eQ.isEmpty()) {
				dQ.addFirst(eQ.removeFirst());
			}
		}
		Integer t = dQ.removeFirst();
		return t;
	}

	public static void main(String[] argv) {

		QUsingStack qus = new QUsingStack();
		qus.enqueue(10);
		System.out.println(qus.dequeue());
		qus.enqueue(20);
		qus.enqueue(30);
		System.out.println(qus.dequeue());
		qus.enqueue(40);
		
		System.out.println(qus.dequeue());
	}
}