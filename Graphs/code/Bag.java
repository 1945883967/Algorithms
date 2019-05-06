package code;
import java.util.Iterator;
public class Bag<Item> implements Iterable<Item> {
	private Node first;//链表首节点
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return first == null;}
	
	public int size() {return N;}
	
	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next=oldfirst;
		N++;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public void move() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
