package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/*
 * 2*n 타일링 2s
 */
public class Q11727 {
	static int[] count = new int[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp(n);
	}
	/* 2*1 크기 1, 2*2 크기 2
	 * n = 1인 경우, 크기1 1개
	 * n = 2인 경우, 크기1 2개 -> 세로방향, 가로방향, 크기2 1개
	 * n = 3인 경우, 크기1 1개+ 크기2 1개(왼쪽), 크기1 1개 + 크기2 1개(오른쪽), 크기1 3개->왼쪽에 가로방향2개,오른쪽에 가로방향 2개
	 * 
	 * n = 3인 경우, 먼저 1짜리를 채웠을 때 경우의 수는 dp(2)
	 * 먼저 2짜리를 채웠을 떄 경우의 수는 dp(1)*3 이 된다.
	 * 하지만, 1짜리가 세로로 3개인 경우는 중복되므로 이 경우를 빼주면 dp(1)*2가 된다.
	 * 따라서, dp(3) = dp(2) + dp(1)*2 
	 */
	public static void dp(int n) {
		count[1] = 1;
		count[2] = 3;
		
		for(int i = 3;i<= n;i++) {
			count[i] = (count[i-1] + 2*count[i-2])%10007;
		}
		System.out.println(count[n]);
	}
}