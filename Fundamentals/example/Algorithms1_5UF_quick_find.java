package example;

public class Algorithms1_5UF_quick_find {
	private int[] id;//����id(�Դ�����Ϊ����)
	private int count;//��������
	public Algorithms1_5UF_quick_find(int N) {
		//��ʼ������id����
		count = N;
		id = new int[N];
		for (int i = 0; i < id.length; i++) 
			id[i] = i;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p,int q) {
		return find(p) == find(q);
	}
	public int find(int p) {
		//�ҳ�����������
		while(p!=id[p]) p = id[p];
		return p; 
	}
	public void union(int p,int q) {
		//��p��q�ĸ����ͳһ
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot ) return;
		
		id[pRoot] = qRoot;
		
		count--;
	}
}
