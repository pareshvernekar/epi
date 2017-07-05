package sample.epi.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinaryTree {
	
	static TreeNode build(int[] arr) {

		TreeNode<Integer> head = null;
		
		for (int i=0;i<arr.length;i++) {
			if (head == null) {
				head = new TreeNode(arr[i]);
			} else if (head.data.compareTo(arr[i]) >= 0) {
				insertLeft(head,arr[i]);
			} else if (head.data.compareTo(arr[i]) < 0) {
				insertRight(head,arr[i]);
			}
		}
		return head;
	}
	
	static <T extends Comparable<T>> void inOrder(TreeNode<T> treeNode) {
		
		if (treeNode == null)
			return;
		inOrder(treeNode.left);
		System.out.println(treeNode.data);
		inOrder(treeNode.right);
	}
	
	static <T extends Comparable<T>> void preOrder(TreeNode<T> treeNode) {
		
		if (treeNode == null)
			return;
	
		System.out.println(treeNode.data);
		preOrder(treeNode.left);
		preOrder(treeNode.right);
	}
	
	static <T extends Comparable<T>> void postOrder(TreeNode<T> treeNode) {
		
		if (treeNode == null)
			return;
	
		
		postOrder(treeNode.left);
		postOrder(treeNode.right);
		System.out.println(treeNode.data);
	}
	
	static <T extends Comparable<T>> void insertLeft(TreeNode T, T data) {
		
		TreeNode<T> left = T.left;
		if (left == null) {
			left = new TreeNode(data);
			T.left = left;
		} else if (left.data.compareTo(data) >= 0 ) {
			insertLeft(left,data);
		} else if (left.data.compareTo(data) < 0) {
			insertRight(left,data);
		}
	}
	
	static <T extends Comparable<T>> void insertRight(TreeNode T, T data) {
		
		TreeNode<T> right = T.right;
		if (right == null) {
			right = new TreeNode(data);
			T.right=right;
		} else if (right.data.compareTo(data) >= 0 ) {
			insertLeft(right,data);
		} else if (right.data.compareTo(data) < 0) {
			insertRight(right,data);
		}
	}
	
	static int countNodesRecursive(TreeNode root) {
		if (root == null)
			return 0;
		return 1+(countNodesRecursive(root.left))+(countNodesRecursive(root.right));
		
	}
	
	static int countNodesNonRecursive(TreeNode root) {
		
		int count = 0;
		if (root == null)
			return count;
		Stack<TreeNode> nodeStack = new Stack<>();
		nodeStack.add(root);
		count+=1;
		TreeNode node = null;
		while(!nodeStack.isEmpty()) {
			node = nodeStack.pop();
			if (node.left!=null) {
				count+=1;
				nodeStack.push(node.left);
			}
			
			if (node.right!=null) {
				count+=1;
				nodeStack.push(node.right);
			}
		}
		return count;
	}
	
	static int sumRecursive(TreeNode root) {
		if (root == null)
			return 0;
		int data = (int)root.data;
		return data+(sumRecursive(root.left))+(sumRecursive(root.right));
		
	}
	
	static int sumNonRecursive(TreeNode root) {
	
		int sum = 0;
		if (root == null)
			return sum;
		Stack<TreeNode> nodeStack = new Stack<>();
		nodeStack.add(root);
		sum+=(int)root.data;
		TreeNode node = null;
		while(!nodeStack.isEmpty()) {
			node = nodeStack.pop();
			if (node.left!=null) {
				sum+=(int)node.left.data;
				nodeStack.push(node.left);
			}
			
			if (node.right!=null) {
				sum+=(int)node.right.data;
				nodeStack.push(node.right);
			}
		}
		return sum;
	}
	
	static int recursiveDepth(TreeNode root) {
		if (root.left==null && root.right==null)
			return 0;
		
		int sum = 1;
		int leftDepth = root.left!=null?recursiveDepth(root.left):0;
		int rightDepth=root.right!=null?recursiveDepth(root.right):0;
		sum+=(leftDepth>rightDepth?leftDepth:rightDepth);
		return sum;
	}
	
	static int nonRecursiveDepth(TreeNode root) {
		
		int depth = 0;
		if (root == null || (root.left==null && root.right==null))
			return 0;
		Queue<TreeNode> parentQ = new ConcurrentLinkedQueue<>();
		Queue<TreeNode> childQ = new ConcurrentLinkedQueue<>();
		parentQ.add(root);
		TreeNode temp = null;
		while (!parentQ.isEmpty() || !childQ.isEmpty()) {
			while(!parentQ.isEmpty()) {
				temp = parentQ.poll();
				if (temp.left != null)
					childQ.add(temp.left);
				if (temp.right != null)
					childQ.add(temp.right);
			}
			if (!childQ.isEmpty()) {
				depth+=1;
				parentQ.addAll(childQ);
				childQ.clear();
			}
		}
		
		return depth;
	}
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for (int i =0;i<N;i++) {
			arr[i] = scanner.nextInt();
		}
		TreeNode<Integer> head = build(arr);
		System.out.println("*****************INORDER********************");
		inOrder(head);
		System.out.println("*****************PREORDER********************");
		preOrder(head);
		System.out.println("*****************POSTORDER********************");
		postOrder(head);
		System.out.println("******************RECURSIVE COUNT************");
		System.out.println(countNodesRecursive(head));
		System.out.println("******************NON RECURSIVE COUNT************");
		System.out.println(countNodesNonRecursive(head));
		System.out.println("******************RECURSIVE SUM************");
		System.out.println(sumRecursive(head));
		System.out.println("******************NON RECURSIVE COUNT************");
		System.out.println(sumNonRecursive(head));
		System.out.println("******************RECURSIVE DEPTHT************");
		System.out.println(recursiveDepth(head));
		System.out.println("******************NON RECURSIVE DEPTHT************");
		System.out.println(nonRecursiveDepth(head));
		
		scanner.close();
	}
}


