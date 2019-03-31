package example;

public class Algorithms1_5UF_WeightedQuickUnion {
	private int[] id;//父链接数组（由触点索引）
	private int[] sz;//（由触点索引的）各个根节点所对应的分量的大小
	private int count;//连通分量数量
	public Algorithms1_5UF_WeightedQuickUnion(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	public boolean connection(int p,int q) {
		return find(p) == find(q);
	}
	public int find(int p) {
		//跟随节点到根节点
		while(p != id[p]) p = id[p];
		return p;
	}
	public void union(int p,int q) {
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		//将小树链接到大树的根节点
		if(sz[i] < sz[j]) {id[i] = j;sz[j]+=sz[i];}
		else 			  {id[j] = i;sz[i]+=sz[j];}
		count--;
	}
}
