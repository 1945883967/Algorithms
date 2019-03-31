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

