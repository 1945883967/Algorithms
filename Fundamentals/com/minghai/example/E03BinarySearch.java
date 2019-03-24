package com.minghai.example;

public class E03BinarySearch {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length-1;
		while(lo<=hi) {
			int mid = lo + (lo+hi)/2;
			if(key < a[mid]) hi = mid;
			else if(key > a[mid]) lo = mid;
			else return mid;
		}
		return -1;
	}

}
