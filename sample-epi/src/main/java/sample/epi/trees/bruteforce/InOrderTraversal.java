package sample.epi.trees.bruteforce;

import java.util.*;
import sample.epi.trees.*;

public class InOrderTraversal {


	public String inOrderRec(TreeNode<Integer> root) {
		StringBuilder strBuilder = new StringBuilder();
		inOrderRec(root,strBuilder);
		return strBuilder.toString();
	}

	private void inOrderRec(TreeNode<Integer> node, StringBuilder strBuilder) {
		if (node == null) {
			return;
		}
		inOrderRec(node.left,strBuilder);
		strBuilder.append(node.data).append(" ");
		inOrderRec(node.right,strBuilder);
	}

	public String inOrderNonRec(TreeNode<Integer> root) {

		if (root == null)
			return "";

		StringBuilder strBuilder = new StringBuilder();
		Deque<TreeNode<Integer>> stack = new LinkedList();
		TreeNode<Integer> temp = root;
		while (!stack.isEmpty() || temp != null) {
			
			if (temp != null) {
				stack.addLast(temp);
				temp = temp.left;
			} else {
				temp = stack.removeLast();
				strBuilder.append(temp.data).append(" ");
				temp = temp.right;
			}
		}
		return strBuilder.toString();
	}
	

	public static void main(String[] argv) {

		InOrderTraversal t = new InOrderTraversal();
		TreeNode<Integer> root = BinaryTreeHelper.createUnorderedBinaryTree();
		System.out.println("Recursive:"+t.inOrderRec(root));
		System.out.println("Non-Recursive:"+t.inOrderNonRec(root));

	}
}