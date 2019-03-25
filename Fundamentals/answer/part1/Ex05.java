package answer.part1;

public class Ex05 {
	public static void main(String[] args) {
		test(0.2, 0.3);
		test(2, 3);
	}
	
	public static void test(double x, double y) {
		if(x>0&&x<1 && y>0&&y<1) 
			System.out.println(true);
		else
			System.out.println(false);
	}
}/* OutPut:
true
false
*/