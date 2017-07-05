package sample.epi.trees.episolution;
import java.util.*;
import sample.epi.trees.*;

public class PreOrderTraversal {

	public String preOrderRec(TreeNode<Integer> root) {
		StringBuilder strBuilder = new StringBuilder();
		preOrderRec(root,strBuilder);
		return strBuilder.toString();
	}

	private void preOrderRec(TreeNode<Integer> node, StringBuilder strBuilder) {
		if (node == null) {
			return;
		}
		strBuilder.append(node.data).append(" ");
		preOrderRec(node.left,strBuilder);
		preOrderRec(node.right,strBuilder);
	}

	public String preOrderNonRec(TreeNode<Integer> root) {

		if (root == null)
			return "";

		StringBuilder strBuilder = new StringBuilder();
		Deque<TreeNode<Integer>> stack = new LinkedList();
		TreeNode<Integer> temp = root;
		while (!stack.isEmpty() || temp != null) {
			
			if (temp != null) {
				strBuilder.append(temp.data).append(" ");
				stack.addLast(temp);
				temp = temp.left;
			} else {
				temp = stack.removeLast();
				temp = temp.right;
			}
		}
		return strBuilder.toString();
	}
	

	public String preOrderMod(TreeNode<Integer> root) {

		if (root == null)
			return "";

		StringBuilder strBuilder = new StringBuilder();
		Deque<TreeNode<Integer>> stack = new LinkedList();
		TreeNode<Integer> temp = root;
		stack.addLast(temp);
		while (!stack.isEmpty() || temp!=null) {
			temp=stack.removeLast();
			if (temp!=null) {
				strBuilder.append(temp.data).append(" ");
				stack.addLast(temp.right);
				stack.addLast(temp.left);
			}
		}
		return strBuilder.toString();
	}

	public static void main(String[] argv) {

		PreOrderTraversal t = new PreOrderTraversal();
		TreeNode<Integer> root = BinaryTreeHelper.createUnorderedBinaryTree();
		System.out.println("Recursive:"+t.preOrderRec(root));
		System.out.println("Non-Recursive:"+t.preOrderNonRec(root));
		System.out.println("Non-Recursive Mod:"+t.preOrderMod(root));

	}
}