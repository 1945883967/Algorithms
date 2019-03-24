package com.minghai.example;
//二分查找递归版本
public class E04BinarySearchRecursion {
	
	public static int rank(int key, int[] a) {
		return rank(key,a,0,a.length-1);
	}
	public static int rank(int key, int[] a,int lo,int hi) {
		//如果key存在与a[]中，他的索引不会小于lo,且不会大于hi
		if( lo > hi) return -1;
		int mid = lo +(lo+hi)/2;
		if(key < a[mid]) return rank(key, a,lo,mid-1);
		else if(key > a[mid]) return rank(key, a, mid+1, hi);
		return mid;
	}
}
