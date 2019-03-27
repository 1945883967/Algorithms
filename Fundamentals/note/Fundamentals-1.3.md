# 第1章 基础-1.3背包、队列和栈
许多**基础数据类型**都和**对象的集合**有关。数据类型的值就是一组对象的集合，所有操作都是关于添加、删除或者访问集合中的对象。

对包、队列和栈它们的不同之处在于**删除或者访问对象的顺序不同**。

**集合类的抽象数据类型**的一个关键特性是我们应该用它们存储**任意类型**的数据。Java中的**泛型**能做到这一点，也叫做**参数化类型**。

**泛型中的参数**必须为引用类型。

**自动装箱（自动拆箱）**：在处理复制语句、方法的参数和算数或逻辑表达式时，Java会自动在**引用类型**和**对应的原始数据类型**之间进行**转换**。***注意***：**在循环中尽量避免自动装箱与拆箱，当循环次数多时，会产生额外的消耗**。

**背包**是一种不支持从中删除元素的集合数据类型。（迭代时迭代的顺序不确定，且与用例无关）

**先进先出队列**：是一种基于先进先出（FIFO）策略的集合类型，简称**队列**。

**下压栈**：是一种后进先出队列（LIFO）策略的集合类型，简称**栈**。当用foreach遍历栈中的元素时，元素的处理顺序和它们被压入栈的顺序恰好相反（对于algs4.jar包中的Stack而言，Java原始库中的以压入的顺序处理）。

**算数表达式**可能是一个数，或者是由一个左括号、一个算数表达式、一个运算符、另一个算数表达式和一个右括号组成的表达式。

Java在集合的实现中，如果底层为数组，与泛型相结合使用时，不能定义**泛型参数类型的数组，即new Item[cap]** 如下的代码:(Item是一个类型参数)
a = new Item[cap];
Java中会报错，正确的定义方式
a = (Item[])new Object[cap];

**在Java中数组一旦创建，大小是无法改变的**。因此在定义集合时应当动态的处理数组大小，以栈为例：
* push()方法可定义为

    ```java
    public void push(Item item){
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    ```

* pop()方法可定义为
```java
public Item pop(){
    Item item = a[--N];
    a[N] = null;//避免对象游离
    if(N > 0 && N == a.length/4) resize(a.length/2);
    return item;
}
```

动态处理数组大小时，始终使的数组**处于半满的状态**，此时任可进行多次pop和push。

**Java的垃圾回收策略**是回收所有**无法访问的对象的内存**。

**对象游离**：保存一个不需要的对象的引用。
* 为了避免对象游离，只需将不在需要的对象的引用设置为null即可，这样将覆盖无用的引用，对应的对象变为无法访问的对象，被垃圾回收机制回收。

集合的迭代方式：
第一种（使用增强for循环）：
```
Stack<String> collection = new Stack<String>();
...
for(String s : collection){
    System.out.println(s);
}
```
这里，foreach语句只是while语句的一种简写方式，它**本质上与while语句是一样的**
第二种：
```
Iterator<String> i = collection.iterator();
while(i.hasNext()){
    String s = i.next();
    System.out.println(s);
}   
```

任意可迭代（不管用foreach还是while迭代）的集合数据类型中我们都需要实现：
* 一个iterator()方法并返回一个Iterator对象。
* Iterator类必须有两个方法：hasNext()（返回一个布尔值）和next()（返回集合中的一个泛型元素）

**算法1.1 下压（FIFO）栈(能够动态调整数组大小的实现)**

```java
import java.util.Iterator;

public class E08Algorithms1_1ResizingStack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	public boolean isEmpty() { return N == 0;}
	public int size() { return N;}
	private void resize(int max) {
		//将栈元素移动到一个大小为max的新数组
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) 
			temp[i] = a[i];
		a  = temp;
	}
	public void push(Item item) {
		//将占元素添加到栈顶
		if(N == a.length) resize(a.length*2);
		a[N++] = item;
	}
	public Item pop() {
		//从栈顶元素删除
		Item item = a[--N];
		a[N] = null;//避免对象游离
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator(); 
	}
	private class ReverseArrayIterator implements Iterator<Item>{
		//支持后进先出
		private int i = N;
		public boolean hasNext() {return i > 0;}
		public Item next() {return a[--i];}
		public void remove() {}
	}
}

```



**链表**：是一种递归的数据结构，它或者为空（null），或者是指向一个结点（node）的引用，该结点含有一个**泛型的元素**和**一个指向另一个链表的引用**。
定义中**结点**是一个可能含有任意类型数据的抽象实体。

**链表是数组的一种重要替代方式**



**算法1.2 下压堆栈（链表实现）**

``` java
import java.util.Iterator;

public class Algorithms1_2StackList<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {return first == null;}
	public int size() {return N;}
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
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
```



**算法1.3 先进先出队列**

```java
import java.util.Iterator;

public class Algorithms1_3Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {return first == null;}
	public int size() {return N;}
	public void enqueue(Item item) {
		//向表尾添加元素
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;;
		N++;
	}
	public Item dequeue() {
		//从表头删除元素
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
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

```



**算法1.4 背包**

``` 
import java.util.Iterator;

public class Algorithms1_4Bag<Item> implements Iterable<Item> {
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
```

**数据结构**中有两种表示对象集合的方式，即**数组**和**链表**，常被称为**顺序存储**和**链式存储**。

| 数据结构 |              优点              | 缺点                           |
| -------- | :----------------------------: | ------------------------------ |
| 数组     |  通过索引可以直接访问任意元素  | 在初始化时就需要知道元素的数量 |
| 链表     | 使用的空间大小和元素数量成正比 | 需要通过引用访问任意元素       |

描述一种数据结构，用白活说就是一组值的表示。
描述算法：用白话说就是实现一组操作的方式。

Java不允许泛型数组
[**共变数组**](https://blog.csdn.net/CLoudLord3/article/details/61415378)
[**类型擦除**](https://blog.csdn.net/briblue/article/details/76736356)

**宽接口 窄接口**