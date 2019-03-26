package answer.part1;

import edu.princeton.cs.algs4.StdOut;

public class Ex19 {
	public static long F(int N) {
		if(N == 0) return 0;
		if(N == 1) return 1;
		return F(N - 1) + F(N -2);
	}
	
	public static void main(String[] args) {
		for (int N = 0; N < 100; N++) {
			StdOut.println(N + " " + F(N));
		}
	}
}/**
程序当N为41、42时速度明显变慢，一个小时内能够得到F(N)结果的最大N值未测试
*/
