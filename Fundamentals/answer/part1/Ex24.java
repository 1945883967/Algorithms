package answer.part1;

import java.util.Scanner;

public class Ex24 {
	
	public static void main(String[] args) {
//		int p = 105,q = 24;
//		int p = 11111111,q = 1234567;
		Scanner scan = new Scanner(System.in);
		int p =scan.nextInt(),q=scan.nextInt();
		
		System.out.println(gcd(p, q));
	}
	
	public static int gcd(int p,int q) {
        if (q == 0) return p;
        int r = p % q;
        System.out.println("p = " + p + " , q = " + q);
        return gcd(q,r);
    }
}/**
p = 105 , q = 24
p = 24 , q = 9
p = 9 , q = 6
p = 6 , q = 3
3

p = 11111111 , q = 1234567
p = 1234567 , q = 8
p = 8 , q = 7
p = 7 , q = 1
1

*/
