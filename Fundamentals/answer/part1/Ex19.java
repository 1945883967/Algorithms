package answer.part1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

public class Ex19 {
	public static long F(int N) {
		if(N == 0) return 0;
		if(N == 1) return 1;
		return F(N - 1) + F(N -2);
	}
	//通过数组 优化
	static long[] array = new long[100];//斐波那契数列还可以以其他的方式优化，可以自行脑洞,当n=92时会超出long的取值范围，可以用BigInteger替换
	public static long F1(int N) {
		if(N == 0 || N == 1) {
			return array[N] = 1;
		}
		if(array[N] == 0) {
			array[N] = array[N-1] + array[N-2];
		}
		return array[N];
	}
	
	public static void main(String[] args) {
		for (int N = 0; N < 100; N++) {
			StdOut.println(N + " " + F1(N));
		}
	}
}/**
程序当N为41、42时速度明显变慢，一个小时内能够得到F(N)结果的最大N值未测试
*/
