package answer.part1;

public class Ex18 {
	
	public static void main(String[] args) {
		System.out.println(mystery(2, 5));		//10
		System.out.println(mystery(3, 11));		//33
		System.out.println(mystery1(2, 5));		//16
		System.out.println(mystery1(3, 11));	//135
		
	}
	
	public static int mystery(int a, int b) {
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}
	public static int mystery1(int a, int b) {
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a * a, b / 2);
		return mystery(a * a, b / 2) * a;
	}
}/**
代码中a和b的特点是，通过b的值作为判断条件，对数a进行相应的操作
*/
