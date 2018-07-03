package algorithm.baekjoon.etc;

import java.util.Scanner;

/*
 * 팩토리얼
 */
public class Q10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int result = 1;
		for(int i = 1;i <= input;i++) {
			result *= i;
		}
		System.out.println(result);
	}
}
