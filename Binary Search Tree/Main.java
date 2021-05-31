
public class Main {
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(6);
		tree.insert(2);
		tree.insert(8);
		tree.insert(1);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);
		tree.insert(0);
		
		
		Node root = tree.root;
		
		tree.print2D(root);
		
		if (tree.isFullTree(root))
			System.out.println("The tree is full");
		else
			System.out.println("The tree is not full");
		
		if (tree.isComplete(root, 0, 9))
			System.out.println("The tree is complete");
		else
			System.out.println("The tree is not complete");
		
//		System.out.println("inOrder: "); tree.inOrder(tree.root);
//		System.out.println("\n");
//		
//		Node two = root.left;
//		Node four = two.right;
//		
//		Node LCA = tree.lowestCommonAncestor(root, two, four);
//		
//		System.out.println(LCA.val);
		
		//tree.BFS();
	}

}
