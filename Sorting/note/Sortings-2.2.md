# 第2章 排序-2.2归并排序

**归并排序**：将数组递归的分成两部分，分别进行排序，然后归并起来。

归并操作：将两个有序数组归并为一个大的有序数组。

## 原地归并的抽象方法

原地归并：先将前半部分排序，在将后半部分排序，然后在数组中移动元素，而不需要使用额外的空间。

**原地归并的抽象方法**

```java
public static void merge(Comparable[] a, int lo, int mid, int hi) {
		// 将a[lo..mid] 和 a[mid+1..hi]归并
		int i = lo, j = mid + 1;
		for (int k = 0; k <= hi; k++) { // 将a[lo..hi]复制到aux[lo..hi]
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {//归并回到a[lo..hi]
			if	   (i > mid)				a[k] = aux[j++];
			else if(j > hi)					a[k] = aux[i++];
			else if(less(aux[j], aux[i]))	a[k] = aux[j++];
			else							a[k] = aux[i++];
		}
	}
```

## 自顶向下的归并排序

将一个大数组分成两个小数组去求解。(化整为零)

因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。

**自顶向下的归并排序**

```java
	private static Comparable[] aux;//归并排序所需的辅助数组
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];//一次性分配内存空间
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		//将数组a[lo..hi]排序
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);		//将左半边
		sort(a, mid+1, hi);		//将右半边排序
		merge(a, lo, mid, hi);  //归并结果
	}
```

## 自底向上的归并排序

先归并那些微型数组，然后成对归并得到的微型数组。（循序渐进）

**自底向上的归并排序**

```java
private static Comparable[] aux;//归并排序所需的辅助数组
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[a.length];//一次性分配内存空间
		for (int sz = 0; sz < N; sz += sz+sz) { 		//sz子数组大小
			for (int lo = 0; lo < N-sz; lo += sz+sz) {	//lo子数组索引
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1,N-1));
			}
		}
	}
```



