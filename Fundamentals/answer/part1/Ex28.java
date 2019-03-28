package answer.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex28 {
	public static int rank(int key, int[] a) {
		//��������������
		int lo = 0;
		int hi = a.length-1;
		while(lo<hi) {
			int mid = lo + (hi-lo)/2;
			if(key < a[mid]) hi = mid - 1;
			else if(key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		//ȥ���������е��ظ�Ԫ��
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < whitelist.length-1; i++) {
			if(whitelist[i] == whitelist[i+1]) {
				list.add(i+1);
			}
		}
		whitelist = trimArray(whitelist, list);
		
		while(!StdIn.isEmpty()) {
			//��ȡ��ֵ���������������������ӡ
			int key = StdIn.readInt();
			if(rank(key, whitelist) < 1) {
				StdOut.println(key);
			}
		}
	}
	
	public static int[] trimArray(int[] a,List list) {
		int[] temp = new int[a.length-list.size()];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if(!list.contains(i)) {
				temp[count++] = a[i];
			}
		}
		return temp;
	}
}
