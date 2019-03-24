package example.draw;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class E01StdDraw {
	public static void main(String[] args) {
//		function();
//		randomArray();
		sortedRandomArray();
	}
	//函数值
	public static void function() {
		int n = 100;
		StdDraw.setXscale(0, n);
		StdDraw.setYscale(0, n*n);
		StdDraw.setPenRadius(0.01);
		for (int i = 0; i <= n; i++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
	}
	
	//随机数组
	public static void randomArray() {
		int n = 50;
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i]  = StdRandom.random();
		}
		for (int i = 0; i < n; i++) {
			double x = 1.0*i/n;
			double y = a[i]/2.0;
			double rw = 0.5/n;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	//已经排序的随机数组
	public static void sortedRandomArray() {
		int n = 50;
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i]  = StdRandom.random();
		}
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			double x = 1.0*i/n;
			double y = a[i]/2.0;
			double rw = 0.5/n;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
	
}
