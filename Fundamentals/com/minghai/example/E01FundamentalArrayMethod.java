package com.minghai.example;

public class E01FundamentalArrayMethod {
	// 找出数组中最大的元素
	public int max(int[] a) {
		int max=a[0];
		for (int i = 1; i < a.length; i++)
			if(a[0]<a[i]) max=a[i];
		return max;
	}
	
	//计算数组元素的平均值
	public double average(double[] a) {
		int n = a.length;
		double sum = 0.0;
		for (int i = 0; i < n; i++) 
			sum+=a[i];
		return sum/n;
	}
	
	//复制数组
	public int[] copy(int[] a) {
		int n = a.length;
		int[] b = new int[n];
		for(int i = 0; i < n; i++) 
			b[i] = a[i];
		return b;
	}
	
	//颠倒数组的顺序
	public static void reversal(int[] a) {
		int n = a.length;
		for (int i = 0; i < n/2; i++) {
			int temp = a[i];
			a[i] = a[n-1-i];
			a[n-1-i] = temp;
		}
	}
	
	//矩阵相乘（方阵） a[][]*b[][]=c[][]
	public int[][] multiply(int[][] a,int[][]b){
		int n = a.length;
		int[][] c = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <n; j++) {
				//计算行i和列j的点乘
				c[i][j] = a[i][j] * b[i][j];
			}
		}
		return c;
	}
}
