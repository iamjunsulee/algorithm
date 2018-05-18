package algorithm.baekjoon.inOutput;

import java.util.Scanner;

public class Q11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0, testCase = 0;
		testCase = sc.nextInt();
		char ch[] = new char[testCase];
		
		sc.nextLine();
		String input = sc.nextLine();
		ch = input.toCharArray();
		for(int i = 0;i < ch.length;i++) {
			sum += (int)ch[i] - '0';
		}
		System.out.println(sum);
	}
}
