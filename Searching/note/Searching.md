#  第三章 查找

## 3.1 符号表

**符号表**：是一种存储键值对的数据结构（就是将一个**键**和**值**联系起来），支持两种操作：

* 插入（put）：将一组新的键值对存入表中
* 查找（get）：根据数据给定的键得到相应的值。

符号表中遵循一些原则：

* **重复的键**

  * 每个键只对应着一个值（表中不允许存在重复的键）；
  * 当向表中存入的键值对和表中已有的键冲突时，新的值会代替旧的值。

* **空（null）键）**

  键不能为空

* **空（null）值**

  符号表不允许有空值。原因如下：

  1. 可以用get（）方法是否返回值来测试给定的键是否存在于符号表中；
  2. 可以将空值作为put（）方法的第二个参数存入表中来实现删除；

* **删除操作**

  1. 延时删除：将键对应的值直为空，然后在某个时候删去所有值为空的键
  2. 即时删除：立刻从表中删除指定的键。

无序符号表的顺序查找

**有序符号表的二分查找**

* 关键代码

  ```java
  public class BinarySearchST<Key extends Comparable<Key>,Value> {
  	private Key[] keys;
  	private Value[] vals;
  	private int N;
  	public BinarySearchST(int capacity) {
  		keys = (Key[]) new Comparable[capacity];
  		vals = (Value[]) new Object[capacity];
  	}
  	public int size() {
  		return N;
  	}
  	public Value get(Key key) {
  		if(isEmpty()) return null;
  		int i = rank(key);
  		if(i < N && keys[i].compareTo(key) == 0)  return vals[i];
  		else 									  return null;
  	}
  	private boolean isEmpty() {
  		return N == 0;
  	}
  	//基于有序数组的二分查找
  	public int rank(Key key) {
  		int lo = 0, hi = N-1;
  		while(lo <= hi) {
  			int mid = lo + (hi - lo)/2;
  			int cmp = key.compareTo(keys[mid]);
  			if(cmp < 0) hi = mid -1;
  			else if(cmp > 0) lo = mid +1;
  			else return mid;
  		}
  		return lo;
  	}
  	public void put(Key key, Value val) {
  		//查找键，找到则更新值，否则创建新的元素
  		int i = rank(key);
  		if(i < N && keys[i].compareTo(key) == 0) {
  			vals[i] = val; return;
  		}
  		for(int j = N; j > i; j--) {
  			keys[j] = keys[j-1];
  			vals[j] = vals[j-1];
  		}
  		keys[i] = key;
  		vals[i] = val;
  		N++;
  	}
  }
  ```

  ![Snipaste_2019-04-17_21-12-50.jpg](https://i.loli.net/2019/04/17/5cb72669c6844.jpg)

## 3.2 二叉查找树

[**二叉查找树完整代码BST.java**](https://github.com/1945883967/Algorithms/blob/master/Searching/example/BST.java)

在二叉树中，每个结点都只有左右两个链接，分别指向自己的左子结点和右子结点。

二叉查找树：一颗二叉查找树（BST）是一颗二叉树，其中每个结点都含有一个Comparable的键（以及相关联的值）且每个结点的键都大于其左子树的任意结点的键而小于右子树的任意结点的键。
![Snipaste_2019-04-22_20-27-47.jpg](https://i.loli.net/2019/04/22/5cbdb35701cb6.jpg)

### 3.2.1 查找

二叉查找树中查找时按递归的方式进行查找，如果树是空的，则未命中；如果查找的键和根的键相等，查找命中；如果查找的键较小就选择左子树，较大则选择右子树。过程如图：
![bst-search.png](https://i.loli.net/2019/04/22/5cbdbc0693c38.png)

```java
public Value get(Key key) {
	return get(root,key);
}
private Value get(Node x, Key key) {
	//以x为结点的子树中查找并返回key所对应的值，如果找不到返回null
	if(x == null) return null;
	int cmp = key.compareTo(x.key);
	if	   (cmp < 0) return get(x.left, key);
	else if(cmp > 0) return get(x.right, key);
	else             return x.val;
}
```



### 3.2.2 插入

如果树是空的，则返回一个含有该键值对的新结点；查找被插入的键，如果存在，则更新键的值，否则如果插入的键小于根结点的键，将以key和val为键值对的新结点插入到该左子树中，否则将以key和val为键值对的新结点插入到该右子树中。过程如图：
![Snipaste_2019-04-22_21-06-30.jpg](https://i.loli.net/2019/04/22/5cbdbc6190acf.jpg)

**代码**

```java
public void put(Key key, Value val) {
	//查找key,找到则更新它的值，否则为它创建一个新的结点
	root = put(root, key, val);
}
private Node put(Node x, Key key, Value val) {
	//如果key存在于以x为根结点的子树中则更新它的值
	//否则将以key和val为键值对的新结点插入到该子树中
	if(x == null) return new Node(key, val, 1);
	int cmp = key.compareTo(x.key);
	if     (cmp < 0) x.left = put(x.left, key, val);
	else if(cmp > 0) x.right = put(x.right, key, val);
	else x.val = val;
	x.N = size(x.left) + size(x.right) + 1;
	return x;
	}
}
```

### 3.2.3 最大键和最小键

**最小键：**如果根结点的左链为空，那么一颗二叉查找树中最小的键就是根结点；如果左链非空，那么最小键就是左子树中的最小键。

* **代码**
 ```java
  public Key min(){
   return min(root).key;
  }
  private Node min(Node x){
   if(x.left == null) return x;
   return min(x.left);
  }
 ```
**最大键：**如果根结点的右链为空，那么一颗二叉查找树中的最大键就是根结点；如果右链非空，那么最答键就是右子树中的最大键

* **代码**
  

```java
  public Key max(){
  return max(root).key;
}
  private Node max(Node x){
    if(x.right == null) return x;
	   return min(x.right);
}
```

### 3.2.4 向下取整和向上取整

向下取整 floor(key)：小于等于键的最大键

- 如果键小于根节点的键，那么 floor(key) 一定在左子树中；

- 如果键大于根节点的键，需要先判断右子树中是否存在 floor(key)，如果存在就返回，否则根节点就是 floor(key)。

  ```java
  public Key floor(Key key) {
  		Node x = floor(root, key);
  		if(x == null) return null;
  		return x.key;
  	}
  	private Node floor(Node x, Key key) {
  		if(x == null) return null;
  		int cmp = key.compareTo(x.key);
  		if(cmp == 0) return x;
  		if(cmp < 0) return floor(x.left, key);
  		Node t = floor(x.right, key);
  		if(t != null) return t;
  		else return x;
  	}
  ```

向上取整 ceiling()：大于等于键的最小值

### 3.2.5 选择操作

select():查找排名为k的键（即树中正好有k个小于它的键），如果左子树中的结点数t大于k，那么继续在左子树中查找排名为k的键；如果t等于k,返回根节点中的键；如果t小于k,在右子树中查找排名为(k-t-1)的键。

**代码**

```java
public Key select(int k) {
	return select(root, k).key;
}
private Node select(Node x, int k) {
	// 返回排名为k的结点
	if(x == null) return null;
	int t = size(x.left);
	if(t > k) return select(x.left, k);
	else if(t < k) return select(x.right, k);
}
```



### 2.3.6 排名

rank(key) 返回 key 的排名。

- 如果键和根节点的键相等，返回左子树的节点数；
- 如果小于，递归计算在左子树中的排名；
- 如果大于，递归计算在右子树中的排名，加上左子树的节点数，再加上 1（根节点）。

**代码**

```java
public int rank(Key key) {
		return rank(key, root);
	}
	private int rank(Key key, Node x) {
		// 返回以x为根结点的子树中小于x.key的键的数量
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(key, x.left);
		else if(cmp > 0) return 1 + size(x.left) + rank(key, x.right);
		else return size(x.left);
	}
```

### 2.3.7 删除最小键和最大键

**删除最小键deleteMin():**令指向最小节点的链接指向最小节点的右子树。





## 3.4 散列表

散列的找算法分为两步：

* 第一步是用**散列函数**将被查找的键转换为数组的一个索引。
* 第二步是处理**碰撞冲突**的过程。

散列表示算法在时间和空间上作出权衡的经典例子。

散列表类似于数组，可以把散列表的散列值看成数组的索引值。访问散列表和访问数组元素一样快速，它可以在常数时间内实现查找和插入操作。

散列表的实现：

* 基于拉链法的散列表
* 基于线性探测法的散列表

