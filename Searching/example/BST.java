package example;

public class BST<Key extends Comparable<Key>,Value> {
	private Node root;	//����������ĸ��ڵ�
	
	private class Node{
		private Key key; 		//��
		private Value val;		//ֵ
		private Node left,right;//ָ������������
		private int N;			//�Ըý��Ϊ���������н�������
		
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
		//��xΪ���������в��Ҳ�����key����Ӧ��ֵ������Ҳ�������null
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if	   (cmp < 0) return get(x.left, key);
		else if(cmp > 0) return get(x.right, key);
		else             return x.val;
	}
}
