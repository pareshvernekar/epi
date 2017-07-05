package sample.epi.queues.bruteforce;

import sample.epi.trees.*;
import java.util.*;


public class BinaryTreeBFS  {
	
	public List<List<Integer>> nodesInIncreasingDepth(TreeNode<Integer> root) {

		Deque<TreeNode<Integer>> queue = new LinkedList<>();
		Deque<TreeNode<Integer>> childQueue = new LinkedList<>();
		queue.addLast(root);
		TreeNode<Integer> temp = null;
		List<List<Integer>> results = new ArrayList<>();	
		List<Integer> tempList = new ArrayList<>();
		while (!queue.isEmpty()) {
			
			temp = queue.pollFirst();
			if (temp.left != null)
				childQueue.addLast(temp.left);
			if (temp.right != null)
				childQueue.addLast(temp.right);
			tempList.add(temp.data);

			if (queue.isEmpty()) {
				results.add(tempList);
				tempList = new ArrayList<>();
				queue.addAll(childQueue);
				childQueue = new LinkedList<>();
			}
		}
		return results;
	}

	public static void main(String[] argv) {
		TreeNode<Integer> root = BinaryTreeHelper.createUnorderedBinaryTree();
		BinaryTreeBFS binTreeBFS = new BinaryTreeBFS();
		List<List<Integer>> results = binTreeBFS.nodesInIncreasingDepth(root);
		for(List<Integer> list:results) {
			for(Integer i:list) {
				System.out.print(i);System.out.print("\t");
			}
			System.out.println();
		}

	}

}