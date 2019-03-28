package answer.part3;

import edu.princeton.cs.algs4.StdOut;

public class Ex02 {
	public static void main(String[] args) {
		Stack s = new Stack(50);
		String string = "it was - the beat - of times - - - it was - the - -";
		String[] split = string.split(" ");
		for (int i = 0; i < split.length; i++) {
			if(!split[i].equals("-"))
				s.push(split[i]);
			else if (!s.isEmpty())
				StdOut.print(s.pop()+" ");
		}
		StdOut.println("(" + s.size()+" left on stack");
	}
}/** OutPut:
was beat times of the was the it (1 left on stack
*/


class Stack {
	private String[] s;
	private int N;

	public Stack(int cap) {
		s = new String[cap];
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
