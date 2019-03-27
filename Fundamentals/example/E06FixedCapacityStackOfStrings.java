package example;

public class E06FixedCapacityStackOfStrings {
	private String[] s;
	private int N;

	public E06FixedCapacityStackOfStrings(int cap) {
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
