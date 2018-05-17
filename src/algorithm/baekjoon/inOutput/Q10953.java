package algorithm.baekjoon.inOutput;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0, testCase = 0;
		
		testCase = sc.nextInt();
		sc.nextLine();
		for(int i = 0;i < testCase;i++) {
			String input = sc.nextLine();
			StringTokenizer token = new StringTokenizer(input, ",");
			a = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			System.out.println(a+b);
		}
	}
}
