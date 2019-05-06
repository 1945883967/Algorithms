# 第四章 图

## 4.1 无向图

**图**：图是由一组顶点(vertex)和一组能够将两个顶点相连的边(edge)组成的。

**Graph数据类型**：

```java
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
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
}
```

### 4.1.1 深度优先搜索

**深度优先遍历(DFS）**：递归的遍历所有顶点，在访问其中一个顶点时：

* 将它标记为已访问
* 递归地访问它的所有没有被标记过的邻居顶点

```java
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		count++;
		for(int w : G.adj(v)) {
			if(!marked[w]) dfs(G, w);
		}
	}
	
	public boolean marked(int w) {
		return marked[w];
	}
	public int count() {
		return count;
	}
}
```

**使用深度优先搜索查找图中的路径**

```java
import java.util.Stack;

public class DepthFirstPaths {
	private boolean[] marked;// 这个顶点上调用过dfs()了吗？
	private int[] edgeTo;	 // 从起点到一个顶点的已知路径上的最后一个顶点
	private final int s;     // 起点
	
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
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
```

### 4.1.2 广度优先搜索

**广度优先搜索(BFS)**:先将起点加入队列，然后重复以下步骤直到队列为空

* 取队列中的下一个顶点v并标记它
* 将与v相邻的所有未被标记过的顶点加入队列。

```java
import java.util.Stack;

import edu.princeton.cs.algs4.Queue;

public class BreadthFirstPaths {
	private boolean[] marked; // 到达该顶点的最短路径已知吗？
	private int[] edgeTo;     // 到达该顶点的已知路径上的最后一个顶点
	private final int s;      // 起点
	
	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s2) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;    // 标记起点
		queue.enqueue(s);    // 将它加入队列
		while (!queue.isEmpty()) {
			int v = queue.dequeue(); // 从队列中删去下一顶点
			for (int w : G.adj(v)) {
				if (!marked[w]) {	// 对于每个未标记的相邻顶点
					edgeTo[w] = v; //保存最短路径的最后一条边
					marked[w] = true;// 标记他，因为最短路径已知
					queue.enqueue(w); // 并将它添加到队列中
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
```

深度优先搜索探索一幅图的方式是寻找离起点更远的顶点，只有碰到死胡同时才访问近处的顶点；

广度优先搜索则会首先覆盖起点附近的顶点，只有临近的所有顶点都被访问后才向前进。