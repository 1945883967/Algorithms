package code;

import java.util.Stack;

import edu.princeton.cs.algs4.Queue;

public class BreadthFirstPaths {
	private boolean[] marked; // ����ö�������·����֪��
	private int[] edgeTo;     // ����ö������֪·���ϵ����һ������
	private final int s;      // ���
	
	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s2) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;    // ������
		queue.enqueue(s);    // �����������
		while (!queue.isEmpty()) {
			int v = queue.dequeue(); // �Ӷ�����ɾȥ��һ����
			for (int w : G.adj(v)) {
				if (!marked[w]) {	// ����ÿ��δ��ǵ����ڶ���
					edgeTo[w] = v; //�������·�������һ����
					marked[w] = true;// ���������Ϊ���·����֪
					queue.enqueue(w); // ���������ӵ�������
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}