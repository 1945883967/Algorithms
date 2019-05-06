# 第1章 基础-1.5案例研究：union-find算法

**动态连通性问题**

1. 网络
2. 变量名等价性
3. 数学集合

数据结构的性质将直接影响到算法的效率，因此数据结构和算法的设计是紧密相连的。

#### **算法实现**
这里讨论三种不同的实现，它们均根据触点为索引的id[]数组来确定两个触点是否在于相同分量中。

##### **quick-find算法**
一种方法是保证当且仅当id[p]等于id[q]时p和q是连通的。换句话说，在同一个连通分量中的所有触点在id[]中的值必须全部相同。这意味着connected(p,q)只需要判断id[p] == id[q],当且仅当p和q在同一连通分量中该语句才会返回true。为了调用union(p,q)确保这一点，我们首先检查它们是否已经存在同一分量之中。如果是则不采取任何行动，否则我们将p所在连通分量中所有触点的id[]值的值全部改为q所在连通分量中的值，此时q和p在同一连通分量中，并且此连通分量中所有触点的id[]值全部都相等。

```java
public class UF {
	private int[] id;//分量id(以触点作为索引)
	private int count;//分量数量
	public UF(int N) {
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

```

**quick-find算法分析**
find()操作的速度显然是很快的，因为它每次只需要访问id[]数组一次。但quick-find算法一般无法处理大型问题，因为对于每一对输入union()都需要扫描整个id[]数组。
##### quick-union算法
这个算法相比与上一个重点是提高union（）方法的速度，它和quick-find算法是互补的。同样也是基于**相同的数据结构**--以触点为索引的id数组。但赋予这些值的意义不同，每个触点所对应的id[]元素都是同一分量中的另一个触点名称（也可能是它自己）---这种联系称为**连接**。实现find（）方法时我们从给定的触点开始，由它链接到另一个触点，再由这个触点的链接到达第三个触点，如此继续跟随着链接直到到达一个**根触点**，即**链接指向直接的触点**（你将会看到这样的触点势必存在）。当且仅当分别由两个触点开始的这个过程到达了同一个根触点时它们存在与同一个连通分量（**如果在同一连通分量中，势必有同一个根触点**）。为了保证这个过程的有效性，需要用union(p,q)来保证这一点，由p和q的链接分别找到它们的根触点，然后将一个根触点链接到另一个根触点即可将一个分量重命名为另一个分量。

```java
public class UF_quick_find {
	private int[] id;//分量id(以触点作为索引)
	private int count;//分量数量
	public UF_quick_find(int N) {
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
```
![Snipaste_2019-03-31_14-06-31.jpg](https://i.loli.net/2019/03/31/5ca059037ff8a.jpg)
**森林表示**
quick-union算法用**节点**（带标签的圆圈）表示触点，用一个结点到另一个节点的箭头表示**链接**，从技术上说，得到的结构是**树**，id[]数组用父链接的形式形成了一片森林。

代码中数组被初始化后，每个结点的链接都指向它自己。

**quick-union算法的分析**
quick-union算法看起来比quick-find算法更快，应为它不需要为每对输入遍历整个数组，但quick-union算法任然存在问题，不能保证它在所有的情况下都能比quick-find算法快的多（对于某些输入，quick-union算法并不比quick-find算法快）。

**定义**：**一棵树的大小是它的结点数量。树中的一个节点的深度是它到根节点的路径上的链接树。树的高度是它所有节点中的最大深度。**

##### 加权quick-union算法
记录每一棵树的大小并总是将较小的树连接到较大的树。通过添加一个数组和改动代码来记录树中的节点数，从而改进算法效率，这样形成的树称之为**加权树**。

```java
public class WeightedQuickUnion {
	private int[] id;//父链接数组（由触点索引）
	private int[] sz;//（由触点索引的）各个根节点所对应的分量的大小
	private int count;//连通分量数量
	public WeightedQuickUnion(int N) {
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
```

加权quick-union算法是三种算法中唯一可以用于解决大型实际问题的算法。加权quick-union算法能够在合理的时间范围内解决实际中的大规模**动态连通性**问题。

![Snipaste_2019-03-31_16-18-35.jpg](https://i.loli.net/2019/03/31/5ca078019379b.jpg)
**最优算法**
理想情况下，每个节点直接链接到它的根节点上，通过检查节点时将它们直接链接到根节点。（**路径压缩**）
要实现路径压缩，只需在find()添加一个循环，将在路径上遇到的所有节点都直接链接到根节点。之后我们等到的树将是完全扁平化的树。

**路径压缩的加权quick-union算法是最优算法，但并非所有操作都能在常数时间内完成**。

* * *

