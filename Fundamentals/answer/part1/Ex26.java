package answer.part1;

public class Ex26 {
	public static void main(String[] args) {
		function(2, 88, 9);
	}
	
	//这里假设为int型的
	public static void function(int a, int b, int c) {
		int t = 0;
		if(a > b) { t = a; a = b; b = t;}
		if(a > c) { t = c; a = c; c =t;}
		if(b > c) { t = b; b = c; c = t;}
		System.out.println(a+" "+ b+ " "+c);
	}
}
