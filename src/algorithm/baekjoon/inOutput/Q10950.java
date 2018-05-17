package algorithm.baekjoon.inOutput;

import java.util.Scanner;

public class Q10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0, testCase = 0;
		testCase = sc.nextInt();
		
		for(int i = 0;i < testCase;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			System.out.println(a+b);
		}
	}
}
