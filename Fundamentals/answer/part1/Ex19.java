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
	//ͨ������ �Ż�
	static long[] array = new long[100];//쳲��������л������������ķ�ʽ�Ż������������Զ�,��n=92ʱ�ᳬ��long��ȡֵ��Χ��������BigInteger�滻
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
����NΪ41��42ʱ�ٶ����Ա�����һ��Сʱ���ܹ��õ�F(N)��������Nֵδ����
*/
