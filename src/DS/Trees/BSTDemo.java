package DS.Trees;

import java.util.Scanner;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}

}

public class BSTDemo {

	private static TreeNode root = null;

	public static void insert(int data) {
		TreeNode newNode = new TreeNode(data, null, null);
		if (root == null) {
			root = newNode;
			return;
		}
		TreeNode curr = root;
		TreeNode prev = curr;

		while (curr != null) {
			if (data < curr.val) {
				curr = curr.left;
			} else if (data > curr.val) {
				curr = curr.right;
			}

			if (curr != null)
				prev = curr;
		}

		if (data < prev.val)
			prev.left = newNode;
		else
			prev.right = newNode;
	}
	
	public static void dfs(TreeNode root) {
		if(root == null) return;
		
		dfs(root.left);
		System.out.print(root.val+" ");
		dfs(root.right);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many values you want to insert?");
		int n = sc.nextInt();
		while (n-- > 0) {
			int val = sc.nextInt();
			insert(val);
		}
		
		dfs(root);

	}

}
