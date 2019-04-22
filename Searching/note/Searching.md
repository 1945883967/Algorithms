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

在二叉树中，每个结点都只有左右两个链接，分别指向自己的左子结点和右子结点。

二叉查找树：一颗二叉查找树（BST）是一颗二叉树，其中每个结点都含有一个Comparable的键（以及相关联的值）且每个结点的键都大于其左子树的任意结点的键而小于右子树的任意结点的键。
![Snipaste_2019-04-22_20-27-47.jpg](https://i.loli.net/2019/04/22/5cbdb35701cb6.jpg)

### 3.2.1 查找

二叉查找树中查找时按递归的方式进行查找，如果树是空的，则未命中；如果查找的键和根的键相等，查找命中；如果查找的键较小就选择左子树，较大则选择右子树。过程如图：
![Snipaste_2019-04-22_20-45-56.jpg](https://i.loli.net/2019/04/22/5cbdb8678ffac.jpg)
