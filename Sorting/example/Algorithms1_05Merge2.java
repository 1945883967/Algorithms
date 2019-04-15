package example;
//�Ե����ϵĹ鲢����
public class Algorithms1_05Merge2 {
	private static Comparable[] aux;//�鲢��������ĸ�������
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[a.length];//һ���Է����ڴ�ռ�
		for (int sz = 0; sz < N; sz += sz+sz) { 		//sz�������С
			for (int lo = 0; lo < N-sz; lo += sz+sz) {	//lo����������
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1,N-1));
			}
		}
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		// ��a[lo..mid] �� a[mid+1..hi]�鲢
		int i = lo, j = mid + 1;
		for (int k = 0; k <= hi; k++) { // ��a[lo..hi]���Ƶ�aux[lo..hi]
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {//�鲢�ص�a[lo..hi]
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
