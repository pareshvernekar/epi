package sample.epi.trees.episolution;

import java.util.*;
import sample.epi.trees.*;

public class TreeSymmetry {

	public boolean isSymmetric(TreeNode<Integer> subtree1, TreeNode<Integer> subtree2) {

		if (subtree1==null && subtree2==null) {
			return Boolean.TRUE;
		}

		if (subtree1!=null && subtree2!=null) {
			return (subtree1.data==subtree2.data && 
				isSymmetric(subtree1.left,subtree2.right) &&
				isSymmetric(subtree1.right,subtree2.left)
				);
		}

		return Boolean.FALSE;
	}
	
	public static void main(String[] argv) {

		TreeNode<Integer> root1 = BinaryTreeHelper.createSymmetricTree();
		TreeNode<Integer> root2 = BinaryTreeHelper.createASymmetricTree();
		TreeSymmetry ts = new TreeSymmetry();
		System.out.println("Symmetric:"+ts.isSymmetric(root1.left, root1.right));
		System.out.println("Symmetric:"+ts.isSymmetric(root2.left, root2.right));

	}
}