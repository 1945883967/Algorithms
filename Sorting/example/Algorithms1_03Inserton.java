package example;

import edu.princeton.cs.algs4.StdOut;

public class Algorithms1_03Inserton {
	public static void sort(Comparable[] a){
		//��a[]����������
		int N = a.length;
		for (int i = 0; i < N; i++) {
			//��a[i]���뵽a[i-1]��a[i-2]��a[i-3]...֮��
			for (int j = i; j < 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	private static void show(Comparable[] a) {
		//�ڵ����д�ӡ����
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i]+" ");
		}
		StdOut.println();
	}
	public static boolean isSorted(Comparable[] a) {
		//��������Ԫ���Ƿ�����
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
}
