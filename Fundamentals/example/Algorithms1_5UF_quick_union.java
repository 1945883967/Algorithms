package example;

public class Algorithms1_5UF_quick_union {
	private int[] id;//分量id(以触点作为索引)
	private int count;//分量数量
	public Algorithms1_5UF_quick_union(int N) {
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
		return id[p];
	}
	public void union(int p,int q) {
		//将p和q归并到相同的分量中
		int pID = find(p);
		int qID = find(q);
		//如果p 和 q已经在同一分量中则不需要采取任何行动
		if(pID == qID) return;
		//将p的分量命名为q的名称
		for (int i = 0; i < id.length; i++) 
			if(id[i] == pID) id[i] = qID;
		count--;
	}
}
