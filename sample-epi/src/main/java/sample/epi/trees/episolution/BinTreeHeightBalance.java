package sample.epi.trees.episolution;

import java.util.*;
import sample.epi.trees.*;

public class BinTreeHeightBalance {
	
	public BinTreeData checkBalance(TreeNode<Integer> node) {

		if (node == null) {
			return new BinTreeData(-1,Boolean.TRUE);
		}

		BinTreeData leftNodeData = checkBalance(node.left);
		if (!leftNodeData.balanced) {
			return leftNodeData;
		}

		BinTreeData rightNodeData = checkBalance(node.right);
		if (!rightNodeData.balanced) {
			return rightNodeData;
		}
		boolean balanced = Math.abs(leftNodeData.height-rightNodeData.height) <= 1;
		return new BinTreeData(Math.max(leftNodeData.height,rightNodeData.height)+1,balanced);
	}

	public static void main(String[] argv) {

		TreeNode<Integer> binTree = BinaryTreeHelper.createUnorderedBinaryTree();
		BinTreeHeightBalance bhb = new BinTreeHeightBalance();
		BinTreeData binTreeData = bhb.checkBalance(binTree);
		System.out.println("Height:"+binTreeData.height+":Balance:"+binTreeData.balanced);

		TreeNode<Integer> symmetricTree = BinaryTreeHelper.createSymmetricTree();
		binTreeData = bhb.checkBalance(symmetricTree);
		System.out.println("Height:"+binTreeData.height+":Balance:"+binTreeData.balanced);
		
	}
}

class BinTreeData {

	int height;
	boolean balanced;

	public BinTreeData(int height, boolean balanced) {
		this.height = height;
		this.balanced=balanced;
	}
}