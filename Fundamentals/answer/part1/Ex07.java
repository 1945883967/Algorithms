package answer.part1;

import edu.princeton.cs.algs4.StdOut;

public class Ex07 {
	public static void main(String[] args) {
		//a
		double t = 9.0;
		while(Math.abs(t - 9.0/t) > .001)
			t = (9.0/t + t)/2.0;
		StdOut.println(t);
		//b
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		StdOut.println(sum);
		//c 
		int sumc = 0;
		int cunt = 1;
		for (int i = 1; i < 1000; i *= 2) {
			for (int j = 0; j < 1000; j++) {
				sumc++;
			}
		}
		StdOut.println(sumc);
	}
}/* OutPut:
3.00009155413138
499500
10000
*/