package answer.part1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex21 {
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		System.out.println("������ѧ����������ѧ����Ϣ:");
		int n = scan.nextInt();
		scan.nextLine();
		System.out.println("������ѧ����������ѧ����Ϣ:");
		String[] s = new String[n];
		int index = 0;
		while(index < n) {
			s[index++] = scan.nextLine();
		}
		System.out.printf("%40s","----------------------���------------------------\n");
		for (int i = 0; i < s.length; i++) {
			String[] split = s[i].split("\\s+");
			double temp = Integer.parseInt(split[1]) / Integer.parseInt(split[2]);
			System.out.printf("���� : %-5s %5s %10s %10.3f\n", split[0],split[1],split[2],temp);
		}
	}
}
