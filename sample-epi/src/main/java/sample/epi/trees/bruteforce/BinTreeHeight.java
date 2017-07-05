package sample.epi.trees.bruteforce;

import java.util.*;
import sample.epi.trees.*;


public class BinTreeHeight {
	
	public int height(TreeNode<Integer> node) {

		if (node == null) {
			return 0;
		}
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		if (leftHeight > rightHeight)
			return leftHeight+1;
		else
			return rightHeight+1;


	}

	public static void main(String[] argv) {
		TreeNode<Integer> binTree = BinaryTreeHelper.createUnorderedBinaryTree();
		BinTreeHeight bh = new BinTreeHeight();
		System.out.println("Height:"+bh.height(binTree));
	}
}