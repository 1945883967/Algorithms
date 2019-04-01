# 第2章 排序-2.1初级排序算法
**排序**就是将一组对象按照某种逻辑顺序重新排列的过程。

**排序算法类模版**

```java
import edu.princeton.cs.algs4.StdOut;
public class Algorithms1_01Example {
	public static void sort(Comparable[] a)
	{/* */}
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	private static void show(Comparable[] a) {
		//在单行中打印数组
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i]+" ");
		}
		StdOut.println();
	}
	public static boolean isSorted(Comparable[] a) {
		//测试数组元素是否有序
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
}	
```

这个类展示了数组排序实现的框架。但是只能适用于于任何实现了**Conparable接口**的**数据类型**。

**排序成本模型**：在研究排序算法时，我们需要计算比较和交换的数量。对于不交换元素的算法，我们会计算访问数组的次数。

排序算法可分为两类：调用所需的栈和固定数目实例变量之外无需额外内存的**原地排序算法**和需要额外内存空间来存储另一份数组副本的其他排序算法。

在为自己创建的数据类型排序时，要实现**Comparable接口**就能保证用例代码可以将其排序。要做到这一点，只需要实现一个**compareTo()**方法来定义目标类型的**自然次序**。如Date数据类型所示：

```java
public class Date implements Comparable<Date>{
	private final int day;
	private final int month;
	private final int year;
	
	public Date(int d,int m,int y) {
		day = d; month = m; year = y;
	}
	
	public int day() {return day;}
	public int month() {return month;}
	public int year() {return year;}
	
	public int compareTo(Date that) {
		if(this.year > that.year) return +1;
		if(this.year < that.year) return -1;
		if(this.month > that.month) return +1;
		if(this.month < that.month) return -1;
		if(this.day > that.day) return +1;
		if(this.day < that.day) return -1;
		return 0;
	}
	
	public String toString() {
		return month + "/" + day + "/" +year;
	}
}
```

对于v<w、v=w、v>w三种情况，Java中通常在v.compareTo(w)被调用时返回一个负整数、零和一个正整数（一般是-1、0和1）。

compareTo()必须满足一个全序关系，(这里用v>w表示compareTo())即：

* 自反性，对于所有的v，v=v；
* 反对称性，对于所有的v<w都有v>w，且v=w时v=w;
* 传递性，对于所有的v、w 和x，如果v<=w且w<=x,则v<=x.

##  选择排序

**选择排序**：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。

选择排序**运行时间和输入无关**。为了找出最小的元素而扫描一遍数组并不能为下一遍扫描提供什么信息。这种性质在某些情况下是缺点，因为使用选择排序的人可能会惊讶地发现，一个已经有序的数组或是主键全部相等的数组和一个元素随机排列的数组所用的排序时间竟然一样长！

**数据移动是最少的**。每次交换都会改变两个数组元素的值，因此选择排序用了 N 次交换——交换次数和数组的大小是**线性关系**。后面研究的其他任何算法都不具备这个特征（大部分的增长数量级都是**线性对数或是平方级别**）。

```java
	public static void sort(Comparable[] a){
		//将a[]按升序排列
		int N =a.length;//数组长度
		for (int i = 0; i < N; i++) {
			//将a[i]和a[i+1..N]中最小的元素交换
			int min = i; //最小元素索引
			for (int j = i+1; j < N; j++) {
				if(less(a[j], a[min])) min = j;
			}
			exch(a, i, min);
		}
	}
```

该算法将第 i小的元素放到 a[i]之中。数组的第 i个位置的左边是 i个最小的元素且它们不会再被访问。

**[排序的动态过程](https://visualgo.net/zh/sorting)**

## 插入排序

每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。

对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。

插入排序的复杂度取决于数组的初始顺序，如果数组已经部分有序了，逆序较少，那么插入排序会很快。

- 平均情况下插入排序需要 ~N2/4 比较以及 ~N2/4 次交换；
- 最坏的情况下需要 ~N2/2 比较以及 ~N2/2 次交换，最坏的情况是数组是倒序的；
- 最好的情况下需要 N-1 次比较和 0 次交换，最好的情况就是数组已经有序了。

代码：

```java
public static void sort(Comparable[] a){
		//将a[]按升序排序
		int N = a.length;
		for (int i = 0; i < N; i++) {
			//将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
			for (int j = i; j < 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
```

