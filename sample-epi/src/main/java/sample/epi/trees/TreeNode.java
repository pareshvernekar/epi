package sample.epi.trees;
public class TreeNode<T extends Comparable<T>> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	TreeNode(T data) {
		this.data = data;
	}
}