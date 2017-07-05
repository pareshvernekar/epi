package sample.epi.trees.episolution;

import java.util.*;
import sample.epi.trees.*;

public class RootToLeafSumMatch {
	
	public Boolean foundLeaf(TreeNode<Integer> root, int requiredSum) {
		return foundLeaf(root,0,requiredSum);

	}

	public Boolean foundLeaf(TreeNode<Integer> node, int partialSum, int requiredSum) {
		if (node == null) {
			return (partialSum==requiredSum);
		}

		partialSum=partialSum+node.data;
		if (node.left==null && node.right==null)
			return partialSum==requiredSum;

		return foundLeaf(node.left,partialSum,requiredSum)
		||foundLeaf(node.right,partialSum,requiredSum);

	}

	public static void main(String[] argv) {
		TreeNode<Integer> root = BinaryTreeHelper.createUnorderedBinaryTree();
		RootToLeafSumMatch rlfSumMatch = new RootToLeafSumMatch();
		System.out.println("Sum:"+rlfSumMatch.foundLeaf(root,592));
	}
}