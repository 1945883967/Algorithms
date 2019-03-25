package answer.part1;

public class Ex03 {
	public static void main(String[] args) {
		if(args.length==3) {
			if(args[0] == args[1] && args[0] == args[2])
				System.out.println("equal");
			else
				System.out.println("not equal");
		}else {
			throw new RuntimeException("请在命令行输入三个整数");
		}
	}
}/* OutPut:
args[] = { 1 ,2, 3}
not equal
args[] = { 1 ,1, 1}
equal
*/
