package answer.part1;

import java.util.Arrays;

public class Ex15 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,1,2,3,4};
		int M = 8;
		int[] histogram = histogram(a, M);
		System.out.println(Arrays.toString(histogram));
	}
	
	public static int[] histogram(int[] a,int M) {
		int[] m = new int[M];
		for (int i = 0; i < a.length; i++) {
			if(a[i] < M-1) {
				m[a[i]]++;
				
				/*if(m[a[i]] != 0) 
					m[a[i]]+=1;
				else 
					m[a[i]]=1;*/
			}
		}
		return m;
	}
}/* OutPut:
[0, 2, 2, 2, 2, 1, 1, 0]
*/
