package com.minghai.example;

public class E01FundamentalArrayMethod {
	// �ҳ�����������Ԫ��
	public int max(int[] a) {
		int max=a[0];
		for (int i = 1; i < a.length; i++)
			if(a[0]<a[i]) max=a[i];
		return max;
	}
	
	//��������Ԫ�ص�ƽ��ֵ
	public double average(double[] a) {
		int n = a.length;
		double sum = 0.0;
		for (int i = 0; i < n; i++) 
			sum+=a[i];
		return sum/n;
	}
	
	//��������
	public int[] copy(int[] a) {
		int n = a.length;
		int[] b = new int[n];
		for(int i = 0; i < n; i++) 
			b[i] = a[i];
		return b;
	}
	
	//�ߵ������˳��
	public static void reversal(int[] a) {
		int n = a.length;
		for (int i = 0; i < n/2; i++) {
			int temp = a[i];
			a[i] = a[n-1-i];
			a[n-1-i] = temp;
		}
	}
	
	//������ˣ����� a[][]*b[][]=c[][]
	public int[][] multiply(int[][] a,int[][]b){
		int n = a.length;
		int[][] c = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <n; j++) {
				//������i����j�ĵ��
				c[i][j] = a[i][j] * b[i][j];
			}
		}
		return c;
	}
}
