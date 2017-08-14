package revision.stacks;
import java.util.*;

public class MaxStack<T extends Comparable<T>> {
	
	private Deque<StackNode<T>> stack;
	public MaxStack() {
		stack = new ArrayDeque<>();
	}

	public void push(T data) {
		if (!stack.isEmpty()) {
			if (data.compareTo(stack.peek().max) > 0) {
				stack.addFirst(new StackNode(data,data));
			} else {
				stack.addFirst(new StackNode(data,stack.peek().max));
			}

		} else {
			stack.addFirst(new StackNode(data, data));
		}
	}

	public T pop() {
		if (!stack.isEmpty()) {
			return stack.poll().data;
		} 
		return null;
	}

	public T max() {
		return stack.peek().max;
	}


	public static void main(String[] argv) {
		MaxStack<Integer> stack = new MaxStack<>();
		stack.push(15);
		stack.push(5);
		stack.push(10);
		System.out.println("Max:1:"+stack.max());
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println("Max:2:"+stack.max());
		stack.pop();
		System.out.println("Max:3:"+stack.max());
		stack.pop();
		stack.pop();
		System.out.println("Max:4:"+stack.max());

	}

}

class StackNode<T> {

	T data;
	T max;

	public StackNode(T data, T curMax) {
		this.data = data;
		this.max=curMax;
	}
}