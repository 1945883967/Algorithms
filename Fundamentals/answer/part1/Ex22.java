package answer.part1;


public class Ex22 {
	static int depth = 0;
	public static void main(String[] args) {
		int[] a = new int[2000] ;
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		int key = 2;
		System.out.println(rank(key, a));
	}
	
	public static int rank(int key, int[] a) {
		return rank(key,a,a.length-1,0);
	}
	public static int rank(int key, int[] a,int  hi, int lo) {
		System.out.println("depth: "+depth++ + " hi: "+hi+" lo:"+lo);
		if(lo > hi) return -1;
		int mid = lo + (hi - lo)/2;
		if(key > a[mid]) return rank(key, a, hi, mid+1);
		else if(key < a[mid]) return rank(key, a,mid -1, lo);
		else return mid;
		
	}
}/* OutPut:
depth: 0 hi: 1999 lo:0
depth: 1 hi: 998 lo:0
depth: 2 hi: 498 lo:0
depth: 3 hi: 248 lo:0
depth: 4 hi: 123 lo:0
depth: 5 hi: 60 lo:0
depth: 6 hi: 29 lo:0
depth: 7 hi: 13 lo:0
depth: 8 hi: 5 lo:0
2
*/