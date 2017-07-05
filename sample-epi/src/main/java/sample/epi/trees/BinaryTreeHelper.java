package sample.epi.trees;

public class BinaryTreeHelper {

	public static TreeNode<Integer> createUnorderedBinaryTree() {

		TreeNode<Integer> root = new TreeNode<Integer>(314);
		TreeNode<Integer> node =  new TreeNode<Integer>(6);
		root.left=node;
		node =  new TreeNode<Integer>(6);
		root.right=node;
		TreeNode<Integer> temp = root.left;
		node =  new TreeNode<Integer>(271);
		temp.left=node;
		node =  new TreeNode<Integer>(561);
		temp.right=node;
		temp=temp.left;
		node =  new TreeNode<Integer>(28);
		temp.left = node;
		node =  new TreeNode<Integer>(0);
		temp.right=node;
		temp=root.left.right;
		node =  new TreeNode<Integer>(3);
		temp.right=node;
		temp=temp.right;
		node =  new TreeNode<Integer>(17);
		temp.left=node;

		temp=root.right;
		node =  new TreeNode<Integer>(2);
		temp.left=node;
		node=new TreeNode<Integer>(271);
		temp.right=node;
		temp=temp.left;
		node=new TreeNode<Integer>(1);
		temp.right = node;
		temp=temp.right;
		node=new TreeNode<Integer>(401);
		temp.left=node;
		node=new TreeNode<Integer>(257);
		temp.right=node;
		temp=temp.left;
		temp.left = new TreeNode<Integer>(641);

		temp=root.right.right;
		temp.right= new TreeNode<Integer>(28);

		return root;
	} 



	public static TreeNode<Integer> createSymmetricTree() {

		TreeNode<Integer> root = new TreeNode<Integer>(314);
		TreeNode<Integer> node =  new TreeNode<Integer>(6);
		root.left=node;
		node =  new TreeNode<Integer>(6);
		root.right=node;

		TreeNode<Integer> temp = root.left;
		node =  new TreeNode<Integer>(2);
		temp.left=node;
		node =  new TreeNode<Integer>(3);
		temp.right=node;
		temp=temp.left;
		node =  new TreeNode<Integer>(4);
		temp.left = node;

		temp = root.right;

		node =  new TreeNode<Integer>(3);
		temp.left=node;


		node =  new TreeNode<Integer>(2);
		temp.right=node;
		temp=temp.right;
		temp.right=new TreeNode<Integer>(4);

		return root;
	} 

	public static TreeNode<Integer> createASymmetricTree() {

		TreeNode<Integer> root = new TreeNode<Integer>(314);
		TreeNode<Integer> node =  new TreeNode<Integer>(6);
		root.left=node;
		node =  new TreeNode<Integer>(6);
		root.right=node;

		TreeNode<Integer> temp = root.left;
		node =  new TreeNode<Integer>(2);
		temp.left=node;
		node =  new TreeNode<Integer>(3);
		temp.right=node;
		temp=temp.left;
		node =  new TreeNode<Integer>(4);
		temp.left = node;

		temp = root.right;

		node =  new TreeNode<Integer>(3);
		temp.left=node;


		node =  new TreeNode<Integer>(5);
		temp.right=node;
		temp=temp.right;
		temp.right=new TreeNode<Integer>(4);
		return root;
	} 

	public static TreeNode<Integer> createSmallTreeWithBinaryData() {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		TreeNode<Integer> node =  new TreeNode<Integer>(0);
		root.left=node;
		node =  new TreeNode<Integer>(1);
		root.right=node;
		return root;
	}
	public static TreeNode<Integer> createTreeWithBinaryData() {

		TreeNode<Integer> root = new TreeNode<Integer>(1);
		TreeNode<Integer> node =  new TreeNode<Integer>(0);
		root.left=node;
		node =  new TreeNode<Integer>(1);
		root.right=node;

		TreeNode<Integer> temp = root.left;
		temp.left=new TreeNode<Integer>(0);
		temp.right = new TreeNode<Integer>(1);
		temp=temp.left;
		temp.left=new TreeNode<Integer>(0);
		temp.right=new TreeNode<Integer>(1);
		temp=root.left.right;
		temp.right=new TreeNode<Integer>(1);
		temp=temp.right;
		temp.left=new TreeNode<Integer>(0);

		node=root.right;
		node.left=new TreeNode<Integer>(1);
		node.right=new TreeNode<Integer>(0);
		node=node.left;
		node.right=new TreeNode<Integer>(0);
		node=node.right;
		node.left=new TreeNode<Integer>(1);
		node.right=new TreeNode<Integer>(0);
		node=node.left;
		node.right=new TreeNode<Integer>(1);

		node=root.right.right;
		node.right=new TreeNode<Integer>(0);

		return root;
	}


	public static TreeNode<Integer> createUnorderedBinaryTreeWithParent() {

		TreeNode<Integer> root = new TreeNode<Integer>(314);
		TreeNode<Integer> node =  new TreeNode<Integer>(6);
		root.left=node;
		node.parent=root;
		node =  new TreeNode<Integer>(6);
		root.right=node;
		node.parent=root;

		TreeNode<Integer> temp = root.left;
		node =  new TreeNode<Integer>(271);
		temp.left=node;
		node.parent=temp;
		node =  new TreeNode<Integer>(561);
		temp.right=node;
		node.parent=temp;

		temp=temp.left;
		node =  new TreeNode<Integer>(28);
		temp.left = node;
		node.parent=temp;
		node =  new TreeNode<Integer>(0);
		temp.right=node;
		node.parent=temp;

		temp=root.left.right;
		node =  new TreeNode<Integer>(3);
		temp.right=node;
		node.parent=temp;
		temp=temp.right;
		node =  new TreeNode<Integer>(17);
		temp.left=node;
		node.parent=temp;
		temp=root.right;
		node =  new TreeNode<Integer>(2);
		temp.left=node;
		node.parent=temp;
		node=new TreeNode<Integer>(271);
		temp.right=node;
		node.parent=temp;
		temp=temp.left;
		node=new TreeNode<Integer>(1);
		temp.right = node;
		node.parent=temp;
		temp=temp.right;
		node=new TreeNode<Integer>(401);
		temp.left=node;
		node.parent=temp;
		node=new TreeNode<Integer>(257);
		temp.right=node;
		node.parent=temp;
		temp=temp.left;
		temp.left = new TreeNode<Integer>(641);
		temp.left.parent=temp;
		temp=root.right.right;
		temp.right= new TreeNode<Integer>(28);
		temp.right.parent=temp;
		return root;
	} 
}