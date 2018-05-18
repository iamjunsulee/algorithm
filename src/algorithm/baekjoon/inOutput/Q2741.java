package algorithm.baekjoon.inOutput;

import java.util.Scanner;

public class Q2741 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/*
		for(int i = 1;i <= n;i++) {
			System.out.println(i);
		}
		*/
		//역순은 2742번문제
		for(int i = n;i > 0;i--) {
			System.out.println(i);
		}
	}
}
