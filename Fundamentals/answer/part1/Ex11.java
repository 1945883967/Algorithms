package answer.part1;

public class Ex11 {
	public static void main(String[] args) {
		boolean[][] b = new boolean[][] {
			{true,false,true,false,true},
			{true,false,true,false,true},
			{true,false,true,false,true},
			{true,true,false,false,true},
			{true,false,true,false,true},
		};
		
		
		//print
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(b[i][j])
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}/* OutPut:
-----------------
* * *
* * *
* * *
**  *
* * *
-----------------
*/
