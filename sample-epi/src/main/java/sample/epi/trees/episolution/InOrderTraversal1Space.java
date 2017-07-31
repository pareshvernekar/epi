package sample.epi.trees.episolution;

import java.util.*;
import sample.epi.trees.*;

public class InOrderTraversal1Space {


	public String inorder(TreeNode<Integer> root) {

		StringBuilder strBuilder = new StringBuilder();
		TreeNode<Integer> node = root;
		while (node != null) {
			if (node.left != null) {
					node = node.left;		
			}
		


		}


		return strBuilder.toString();
	}

	public static void main(String[] argv) {

		InOrderTraversal1Space it = new InOrderTraversal1Space();
		TreeNode<Integer> root = BinaryTreeHelper.createUnorderedBinaryTreeWithParent();

	}
	
}