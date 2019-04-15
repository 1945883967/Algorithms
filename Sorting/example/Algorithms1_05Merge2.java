package example;
//自底向上的归并排序
public class Algorithms1_05Merge2 {
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
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
}
