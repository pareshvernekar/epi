package revision.stacks;
import java.util.*;

public class PostingsListSearch<T extends Comparable<T>> {
	
	public void computeRec(JumpNode<T> head) {
		if (head == null)
			 throw new IllegalArgumentException("Invalid input param");
		helper(head,0);

	}

	private void helper(JumpNode<T> head, int order) {
		if (head != null && head.order == -1) {
			
			head.order=order+1;
			System.out.println(head.data.toString());

			if (head.jumpNode != null) {
				helper(head.jumpNode,order+1);
			}
			
			if (head.nextNode != null) {
				helper(head.nextNode,order+1);
			}
		}
	}

	public void computeIter(JumpNode<T> head) {

		Deque<JumpNode<T>> stack = new LinkedList<>();
		stack.addFirst(head);
		int order = 0;
		while (!stack.isEmpty()) {
			JumpNode<T> temp = stack.removeFirst();
			if (temp.order == -1) {
				System.out.println(temp.data.toString());
				temp.order=order++;
				stack.addFirst(temp.nextNode);
				stack.addFirst(temp.jumpNode);
			}
		}

	}


}

class JumpNode<T extends Comparable<T>> {
	
	T data;
	JumpNode<T> nextNode;
	JumpNode<T> jumpNode;
	int order=-1;
}