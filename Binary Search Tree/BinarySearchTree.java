import java.util.ArrayList;

public class BinarySearchTree {
	
	Node root;
	static final int COUNT = 10;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public void insert(int value) {
		Node newNode = new Node(value);
		
		if (this.root == null) {
			this.root = newNode;
		} else {
			Node current = this.root;
			
			while (true) {
				if (value == current.val) break;
				
				if (value < current.val) {
					if (current.left == null) {
						current.left = newNode;
					} else {
						current = current.left;
					}
				} else if (value > current.val) {
					if (current.right == null) {
						current.right = newNode;
					} else {
						current = current.right;
					}
				}
			}
			
		}
	}
	
	public Node find(int value) {
		boolean found = false;
		
		if (this.root == null) return null;
		
		Node current = this.root;
		
		while (current != null && !found) {
			if (value < current.val) {
				current = current.left;
			} else if (value > current.val) {
				current = current.right;
			} else {
				found = true;
			}
		}
		
		if (!found) found = false;
		
		return current;
	}
	
	/**
	 * The method below performs a breadth first search traversal of
	 * our BST
	 * */
	public void BFS() {
		ArrayList<Integer> data = new ArrayList<>();
		ArrayList<Node> queue = new ArrayList<>();
		Node node = this.root;
		
		queue.add(node);
		
		while (queue.size() > 0) {
			node = queue.remove(0);
			data.add(node.val);
			
			if (node.left != null) queue.add(node.left);
			if (node.right != null) queue.add(node.right);
		}
		
		System.out.println(data.toString());
	}
	
	/**
	 * postOrder Traversal
	 * */	
	public void postOrder(Node node) {
		
		if (node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " ");
	}
	
	/**
	 * preOrder Traversal
	 * */
	public void preOrder(Node node) {
		
		if (node == null) return;
		
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * inOrder Traversal
	 * */
	public void inOrder(Node node) {
		
		if (node == null) return;
		
		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
		
	}
	
	public Node lowestCommonAncestor (Node r, Node p, Node q) {
		
		if (r == null) return null;
		
		// If both p and q are smaller than the root, then LCA lies in left
		if (r.val > p.val && r.val > q.val)
			return lowestCommonAncestor(r.left, p, q);
		
		// If both p and q are greater than the root, then LCA lies in right
		if (r.val < p.val && r.val < q.val)
			return lowestCommonAncestor(r.right, p, q);
		
		return r;
	}
	
	/**
	 * The method below prints a BST in two dimensions.
	 * This solution was found on geeksforgeeks.org at:
	 * https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
	 * */
	static void print2DUtil(Node root, int space) {
		
		if (root == null) return;
		
		// Increase distance between levels
		space += COUNT;
		
		// Process right child first
		print2DUtil(root.right, space);
		
		// Print current node after space count
		System.out.print("\n");
		
		for (int i = COUNT; i < space; i++) {
			System.out.print(" ");
		}
		System.out.print(root.val + "\n");
		
		// Process left child
		print2DUtil(root.left, space);
	}
	
	// Wrapper over print2DUtil
	void print2D(Node root) {
		
		// Pass initial space count as 0
		print2DUtil(root, 0);
	}
	
	/**
	 * The method below checks if the tree is full. This
	 * solution was found on geeksforgeeks.org at:
	 * https://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
	 * */
	boolean isFullTree(Node node) {
		
		// If empty
		if (node == null) return true;
		
		// If leaf node
		if (node.left == null && node.right == null) return true;
		
		// If both left and right subtrees are not null they are full
		if ((node.left != null) && (node.right != null)) 
			return (isFullTree(node.left) && isFullTree(node.right));
		
		// If none work
		return false;
	}
	
	boolean isComplete(Node root, int index, int numNodes) {
		
		// An empty tree is complete
		if (root == null) return true;
		
		// If index assigned to current node is more than number of nodes in tree, then true is not complete
		if (index >= numNodes) return false;
		
		// Recur left and right subtrees
		return (isComplete(root.left, 2*index + 1, numNodes) 
				&& isComplete(root.right, 2*index + 2, numNodes));
	}
	
}

class Node {
	
	Node left;
	Node right;
	int val;
	
	public Node(int value) {
		this.val = value;
		this.left = null;
		this.right = null;
	}
}