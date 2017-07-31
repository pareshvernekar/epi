package sample.epi.heaps.episolution;

import java.util.*;

public class HeapAsStack {
	
	int timestamp = 0;

	PriorityQueue<StackElement> stack = new PriorityQueue<>(32, new Comparator<StackElement>() {

		public int compare(StackElement se1, StackElement se2) {
			return se2.timestamp.compareTo(se1.timestamp);
		}
	});

	public void push(Integer i) {
		stack.offer(new StackElement(i,timestamp++));

	}

	public Integer pop() {
		return stack.poll().data;
	}


	public Integer peek() {
		return stack.peek().data;

	}


	public static void main(String[] argv) {

		int[] data = new int[] {1,2,3,4,5,6,7,8,9,10};
		HeapAsStack  has = new HeapAsStack();
		for (int i=0;i<data.length;i++) {
			has.push(data[i]);
		}

		System.out.println(has.peek());

	}

}


class StackElement {

	Integer data;
	Integer timestamp;

	public StackElement(Integer data, Integer timestamp) {
		this.data= data;
		this.timestamp=timestamp;
	}
}