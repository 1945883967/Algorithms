package example;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
public class Algorithms1_02Selection {
	
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
	
	public static void main(String[] args) {
		String[] a = {"e","f","g","h","c","d","i","k","l","m","n","a","b",};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}	

