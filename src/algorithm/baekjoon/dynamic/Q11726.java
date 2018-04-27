package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/*
 * 2*n 타일링
 */
public class Q11726 {
	static int[] count = new int[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp(n);
	}
	/* 1*2 크기 1, 2*1 크기 2
	 * n = 1인 경우, 크기1 1개
	 * n = 2인 경우, 크기1 2개, 크기2 2개
	 * n = 3인 경우, 크기1 2개+ 크기2 1개(왼쪽), 크기1 2개 + 크기2 1개(오른쪽), 크기2 3개
	 */
	public static void dp(int n) {
		count[1] = 1;
		count[2] = 2;
		
		for(int i = 3;i<= n;i++) {
			count[i] = count[i-1] + count[i-2];
		}
		System.out.println(count[n]%10007);
	}
}
