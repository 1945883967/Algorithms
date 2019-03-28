package answer.part3;

public class Ex19 {
	public static void main(String[] args) {
		Node<Integer> first = new Node<Integer>();
		Node<Integer> second = new Node<Integer>();
		Node<Integer> third = new Node<Integer>();
		first.item=0;
		second.item=1;
		third.item=2;
		first.next = second;
		second.next = third;
		// 0->1->2	删除链表尾结点，即删除third
		Node temp = new Node();
		temp = first;
		while(temp.next!=null) {
			if(temp.next.next == null) {
				temp.next = null;
				break;
			}
			temp = temp.next;
		}
		System.out.println(first.item);
		System.out.println(first.next.item);
		System.out.println(first.next.next.item);//java.lang.NullPointerException 第三个结点已经删除
		
	}
}
/** OutPut
0
1
Exception in thread "main" java.lang.NullPointerException
	at answer.part3.Ex19.main(Ex19.java:25)
*/