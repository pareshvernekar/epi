package sample.epi.queues.bruteforce;
import java.util.*;

public class QWithStacks {
	
	Deque<Integer> dqStack = new LinkedList<>();
	Deque<Integer> enqStack = new LinkedList<>();

	public boolean enqueue(Integer i) {
		enqStack.addLast(i);
		return Boolean.TRUE;
	}


	public Integer dequeue() {
		if (dqStack.isEmpty()) {
			while (!enqStack.isEmpty()) {
				dqStack.addLast(enqStack.pollLast());
			}
		}
		if (!dqStack.isEmpty())
			return dqStack.pollLast();
		return null;
	}

	public static void main(String[] argv) {
		QWithStacks qStack = new QWithStacks();
		qStack.enqueue(5);
		qStack.enqueue(6);
		qStack.enqueue(7);
		System.out.println(qStack.dequeue());
		System.out.println(qStack.enqueue(8));
		System.out.println(qStack.enqueue(9));
		System.out.println(qStack.dequeue());
		System.out.println(qStack.dequeue());
		System.out.println(qStack.dequeue());
		System.out.println(qStack.dequeue());
		
	}
}