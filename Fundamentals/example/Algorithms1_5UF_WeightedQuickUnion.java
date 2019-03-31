package example;

public class Algorithms1_5UF_WeightedQuickUnion {
	private int[] id;//���������飨�ɴ���������
	private int[] sz;//���ɴ��������ģ��������ڵ�����Ӧ�ķ����Ĵ�С
	private int count;//��ͨ��������
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
		//����ڵ㵽���ڵ�
		while(p != id[p]) p = id[p];
		return p;
	}
	public void union(int p,int q) {
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		//��С�����ӵ������ĸ��ڵ�
		if(sz[i] < sz[j]) {id[i] = j;sz[j]+=sz[i];}
		else 			  {id[j] = i;sz[i]+=sz[j];}
		count--;
	}
}
