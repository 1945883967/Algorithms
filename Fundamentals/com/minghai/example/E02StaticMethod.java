package com.minghai.example;

public class E02StaticMethod {
	//����һ�������ľ���ֵ
	public static int abs(int a) {
		if(a<0)
			return -a;
		else 
			return a;
	}
	
	//����һ���������ľ���ֵ
	public static double abs(double a) {
		if(a<0)
			return -a;
		else 
			return a;
	}
	
	//�ж�һ�����Ƿ�Ϊ������������(����Ϊ�ڴ���1����Ȼ���У�����1�����������ⲻ��������������)
	public static boolean isPrime(int n) {
		if(n<2) return false;
		for (int i = 0; i*i < n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	//����ƽ������ţ�ٵ�������
	public static double sqrt(double a) {
		if(a<0) return Double.NaN;//Nan һ������������double���͵ķ����֣�NaN��ֵ�� ���൱�ڷ��ص�ֵDouble.longBitsToDouble(0x7ff8000000000000L) ��
		double err = 1e-15;
		double t = a;
		while(Math.abs(t-a/t)>err*t)
			t = (a/t+t)/2.0;
		return t;
	}
	
	//����ֱ�������ε�б��
	public static double hypotenuse(double a,double b) {
		return Math.sqrt(a*a+b*b);
	}
	
	//������ͼ���
	public static double H(int n) {
		double sum = 0.0;
		for (int i = 0; i <= n; i++) {
			sum += 1.0/i;
		}
		return sum;
	}
}
