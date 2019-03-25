package answer.part1;

public class Ex14 {
	   public static void main(String[] args) {
	        int k = lg(18);
	        System.out.println(k);
	    }

	    public static int lg(int N) {
	        int k = 0;
	        int M = 1;
	        while (M <= N) {
	            M = 2 * M;
	            k++;
	        }
	        return k - 1;
	    }
}
