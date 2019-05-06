package code;

public class Graph {
	private final int V;		// ������Ŀ
	private int E;				// �ߵ���Ŀ
	private Bag<Integer>[] adj; // �ڽӱ�
	public Graph(int V) {
		this.V = V; this.E = 0;
		adj = (Bag<Integer>[])new Bag[V]; //�����ڽӱ�
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();  // �����������ʼ��Ϊ��
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w); // ��w��ӵ�v��������
		adj[w].add(v); // ��v��ӵ�w��������
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for (int i = 0; i < V; i++) {
			s += V + ": ";
			for (int w : this.adj(i)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
}
