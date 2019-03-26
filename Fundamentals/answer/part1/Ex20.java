package answer.part1;

public class Ex20 {
	public static void main(String[] args) {
		System.out.println(ln(10));//15.104412573075518
	}
	
	
	public static double ln(long N) {
		if(N ==0 || N ==1)
			return 0.0;
		else 
			return Math.log(N) + ln(N-1);
	}
}/**OutPut:
15.104412573075518
*/
