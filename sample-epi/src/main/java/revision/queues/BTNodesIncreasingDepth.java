package revision.queues;

import java.util.*;
import sample.epi.trees.BinaryTreeHelper;
import sample.epi.trees.TreeNode;
public class BTNodesIncreasingDepth {

	public List<List<Integer>> traverse(TreeNode<Integer> root) {
		Deque<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return null;
		List<List<Integer>> results = new ArrayList<>();
		queue.addFirst(root);
		List<Integer> inter = new ArrayList<>();
		List<TreeNode> childList = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode<Integer> temp = queue.removeFirst();
			inter.add(temp.data);
			if (temp.left != null)
				childList.add(temp.left);
			if (temp.right != null)
				childList.add(temp.right);

			if (queue.isEmpty()) {
				results.add(inter);
				inter=new ArrayList<>();
				if (!childList.isEmpty()) {
					queue.addAll(childList);
					childList = new ArrayList();
				}
			}

		}
		return results;
	}


	public List<List<Integer>> traverseAlt(TreeNode<Integer> root) {
		Deque<TreeNode> queue = new LinkedList<>();
		boolean flag = Boolean.TRUE;
		if (root == null)
			return null;
		List<List<Integer>> results = new ArrayList<>();
		queue.addFirst(root);
		List<Integer> inter = new ArrayList<>();
		Deque<TreeNode> childList = new LinkedList<>();
		while (!queue.isEmpty()) {
			TreeNode<Integer> temp = queue.removeFirst();
			inter.add(temp.data);
				if (temp.left != null) {
					System.out.println("Adding "+temp.left.data);
					childList.addFirst(temp.left);
				}
				if (temp.right != null) {
					System.out.println("Adding "+temp.right.data);
					childList.addFirst(temp.right);
				}
			if (queue.isEmpty()) {
				results.add(inter);
				inter=new ArrayList<>();
				if (!childList.isEmpty()) {
					queue.addAll(childList);
					childList = new LinkedList();
				}
			}

		}
		return results;
	}

	public List<List<Integer>> traverseBottomUp(TreeNode<Integer> root) {

		if (root == null)
			return null;
		List<List<Integer>> results = new ArrayList<>();
	}

	public static void main(String[] argv) {

		TreeNode<Integer> root = BinaryTreeHelper.createUnorderedBinaryTree();
		BTNodesIncreasingDepth btnid = new BTNodesIncreasingDepth();
		List<List<Integer>> results = btnid.traverse(root);
		int i = 0;
		while (i < results.size()) {
			List<Integer> inter = results.get(i++);
			for (Integer t:inter) {
				System.out.print(t);System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("************************");

		results=btnid.traverseAlt(root);
		i = 0;
		while (i < results.size()) {
			List<Integer> inter = results.get(i++);
			for (Integer t:inter) {
				System.out.print(t);System.out.print("\t");
			}
			System.out.println();
		}
	}

}

