package code;

public class Graph {
	private final int V;		// 顶点数目
	private int E;				// 边的数目
	private Bag<Integer>[] adj; // 邻接表
	public Graph(int V) {
		this.V = V; this.E = 0;
		adj = (Bag<Integer>[])new Bag[V]; //创建邻接表
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();  // 将所有链表初始化为空
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w); // 将w添加到v的链表中
		adj[w].add(v); // 将v添加到w的链表中
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
