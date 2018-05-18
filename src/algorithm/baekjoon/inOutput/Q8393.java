package algorithm.baekjoon.inOutput;

import java.util.Scanner;

public class Q8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0, sum = 0;
		n = sc.nextInt();
		
		for(int i = 1;i <=n;i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
