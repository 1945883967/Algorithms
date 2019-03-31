package example;

public class Algorithms1_5UF_quick_find {
	private int[] id;//分量id(以触点作为索引)
	private int count;//分量数量
	public Algorithms1_5UF_quick_find(int N) {
		//初始化分量id数组
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
		//找出分量的名称
		while(p!=id[p]) p = id[p];
		return p; 
	}
	public void union(int p,int q) {
		//将p和q的根结点统一
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot ) return;
		
		id[pRoot] = qRoot;
		
		count--;
	}
}
