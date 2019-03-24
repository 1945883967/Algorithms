package com.minghai.example;

public class E02StaticMethod {
	//计算一个整数的绝对值
	public static int abs(int a) {
		if(a<0)
			return -a;
		else 
			return a;
	}
	
	//计算一个浮点数的绝对值
	public static double abs(double a) {
		if(a<0)
			return -a;
		else 
			return a;
	}
	
	//判断一个数是否为素数（质数）(定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。)
	public static boolean isPrime(int n) {
		if(n<2) return false;
		for (int i = 0; i*i < n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	//计算平方根（牛顿迭代法）
	public static double sqrt(double a) {
		if(a<0) return Double.NaN;//Nan 一个常数，持有double类型的非数字（NaN）值。 它相当于返回的值Double.longBitsToDouble(0x7ff8000000000000L) 。
		double err = 1e-15;
		double t = a;
		while(Math.abs(t-a/t)>err*t)
			t = (a/t+t)/2.0;
		return t;
	}
	
	//计算直角三角形的斜边
	public static double hypotenuse(double a,double b) {
		return Math.sqrt(a*a+b*b);
	}
	
	//计算调和级数
	public static double H(int n) {
		double sum = 0.0;
		for (int i = 0; i <= n; i++) {
			sum += 1.0/i;
		}
		return sum;
	}
}
