package answer.part3;
/**
 * 为了好整理把类名FixedCapacityStackOfStrings都换成了题号
 * @author minghai
 *
 */
public class Ex01 {
	private String[] s;
	private int N;

	public Ex01(int cap) {
		s = new String[cap];
	}
	
	public boolean isFull() {
		return N == s.length;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(String string) {
		s[N++] = string;
	}
	
	public String pop() {
		return s[--N];
	}

}
