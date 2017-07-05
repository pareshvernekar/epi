package sample.epi.stacks.episolution;

import java.util.*;

public class MaxStack {
	
	Deque<ElementWithMax> deque = new LinkedList<>();

	public MaxStack(Integer[] data) {
		if (data == null)
			throw new IllegalArgumentException("Invalid parameter values");
		int len = data.length;
		for (int i = 0;i < len;i++) {


			deque.addFirst(new ElementWithMax(data[i], 
				(deque.isEmpty()?data[i]:Math.max(data[i],max()))));
		}
	}

	public Integer max() {
		if (deque.isEmpty())
			return null;
		return deque.peekFirst().max;
	}
	public static void main(String[] argv) {
		Integer[] data = new Integer[]{5,3,4,6,2,8,9,1};
		MaxStack maxStack = new MaxStack(data);
		while (!maxStack.deque.isEmpty()) {
			System.out.println("MAX:"+maxStack.max());
			maxStack.deque.pollFirst();
		}
	}


}

class ElementWithMax {
	
	Integer element;
	Integer max;

	ElementWithMax(Integer data, Integer newMax) {
		this.element = data;
		this.max = newMax;
	}
}