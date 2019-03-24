package com.minghai.example;
//���ֲ��ҵݹ�汾
public class E04BinarySearchRecursion {
	
	public static int rank(int key, int[] a) {
		return rank(key,a,0,a.length-1);
	}
	public static int rank(int key, int[] a,int lo,int hi) {
		//���key������a[]�У�������������С��lo,�Ҳ������hi
		if( lo > hi) return -1;
		int mid = lo +(lo+hi)/2;
		if(key < a[mid]) return rank(key, a,lo,mid-1);
		else if(key > a[mid]) return rank(key, a, mid+1, hi);
		return mid;
	}
}
