package example;

public class Algorithms1_5UF_quick_union {
	private int[] id;//����id(�Դ�����Ϊ����)
	private int count;//��������
	public Algorithms1_5UF_quick_union(int N) {
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
		return id[p];
	}
	public void union(int p,int q) {
		//��p��q�鲢����ͬ�ķ�����
		int pID = find(p);
		int qID = find(q);
		//���p �� q�Ѿ���ͬһ����������Ҫ��ȡ�κ��ж�
		if(pID == qID) return;
		//��p�ķ�������Ϊq������
		for (int i = 0; i < id.length; i++) 
			if(id[i] == pID) id[i] = qID;
		count--;
	}
}
