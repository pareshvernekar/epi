package sample.epi.trees.episolution;

import java.util.*;
import sample.epi.trees.*;

public class BinTreeSum {

	public int sum(TreeNode<Integer> root) {

		return sum(root,0);
	}

	private int sum(TreeNode<Integer> node, int partialSum) {
		if (node == null) {
			return 0;
		}
		partialSum = partialSum*2 + node.data;

		System.out.println("PartialSum:"+partialSum);
		if (node.left == null && node.right==null) {
			return partialSum;
		}
		return (sum(node.left,partialSum)+sum(node.right,partialSum));

	}
	public static void main(String[] argv) {
		BinTreeSum btSum = new BinTreeSum();
		TreeNode<Integer> root = BinaryTreeHelper.createTreeWithBinaryData();
		System.out.println("Sum:"+btSum.sum(root));

		root = BinaryTreeHelper.createSmallTreeWithBinaryData();
		System.out.println("Sum:"+btSum.sum(root));
	}
}


