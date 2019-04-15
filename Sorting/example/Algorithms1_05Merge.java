package example;
//�Զ����µĹ鲢����
public class Algorithms1_05Merge {
	private static Comparable[] aux;//�鲢��������ĸ�������
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];//һ���Է����ڴ�ռ�
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		//������a[lo..hi]����
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);		//������
		sort(a, mid+1, hi);		//���Ұ������
		merge(a, lo, mid, hi);  //�鲢���
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
