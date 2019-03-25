package answer.part1;

import edu.princeton.cs.algs4.StdIn;

public class Ex09 {
	public static void main(String[] args) {
		int n = StdIn.readInt();
		
		String ss = Integer.toBinaryString(n); 
		System.out.println(ss);
		
		String s = "";
		for (int i = n; i > 0; i /= 2) {
			s = (i % 2) + s;
		}
		System.out.println(s);
	}
}
