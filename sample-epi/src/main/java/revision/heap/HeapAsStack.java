package revision.heap;

import java.util.*;

public class HeapAsStack {
	
	PriorityQueue<HeapElement> stack = new PriorityQueue<>(16, new Comparator<HeapElement>() {
		public int compare(HeapElement he1, HeapElement he2) {
			return Integer.compare(he2.pos,he1.pos);
		}
	});

	public void push(Integer i) {
		if (isEmpty()) {
			stack.add(new HeapElement(i,1));
		} else {
			stack.add(new HeapElement(i,stack.peek().pos+1));
		}
	}
	public Integer pop() {
		if (!isEmpty())
			return stack.poll().data;
		else 
			return null;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int size() {
		return stack.size();
	}

	public static void main(String[] argv) {
		HeapAsStack has = new HeapAsStack();
		has.push(1);
		has.push(2);
		has.push(3);
		System.out.println(has.pop());
		System.out.println(has.pop());
		System.out.println(has.pop());
		has.push(6);
		has.push(4);
		System.out.println(has.pop());
		System.out.println(has.pop());
		System.out.println(has.pop());
		System.out.println(has.pop());
	}

}

class HeapElement {
	Integer data;
	int pos;

	public HeapElement(Integer data, int pos) {
		this.data = data;
		this.pos = pos;
	}
}
