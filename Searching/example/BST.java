package example;

public class BST<Key extends Comparable<Key>,Value> {
	private Node root;	//二叉查找树的根节点
	
	private class Node{
		private Key key; 		//键
		private Value val;		//值
		private Node left,right;//指向子树的链接
		private int N;			//以该结点为根的子树中结点的总数
		
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size() {
		return size(root);
	}
	private int size(Node x) {
		if(x == null) return 0;
		else 		  return x.N;
	}
	
	public Value get(Key key) {
		return get(root,key);
	}
	private Value get(Node x, Key key) {
		//以x为结点的子树中查找并返回key所对应的值，如果找不到返回null
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if	   (cmp < 0) return get(x.left, key);
		else if(cmp > 0) return get(x.right, key);
		else             return x.val;
	}
}
