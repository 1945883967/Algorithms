package answer.part1;

public class Ex08 {
	public static void main(String[] args) {
		System.out.println('b');				//字符b
		System.out.println('b'+'c');			//字符'b'和'c'先转为整数值98和99,然后在相加
//			System.out.println('b'+0);//98
//			System.out.println('c'+0);//99
		System.out.println((char)('a' + 4));    //'a'+4=101,然后将101转为字符e
//			System.out.println((char)101);//e
	}
}/* OutPut:
b
197
e
*/