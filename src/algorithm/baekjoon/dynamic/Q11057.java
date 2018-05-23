package algorithm.baekjoon.dynamic;

import java.util.Scanner;

public class Q11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();						//자리수
		int[][] dp = new int[1001][10];		//dp[i][j]는 i자리수에서 끝이 j로 끝나는 경우의 수
		
		for(int i =0;i <= 9;i++) {
			dp[1][i] = 1;	//자리수가 1인 경우, 각 경우는 1개뿐
		}
		/*
		 * dp[2][1] = dp[1][0] + dp[1][1] 즉, 01 11 2가지 경우
		 * dp[2][2] = dp[1][0] + dp[1][1] + dp[1][2] 즉, 02 12 22 3가지 경우
		 * 	             = dp[2][1] + dp[1][2]
		 */
		for(int i = 2;i <= n;i++) {
			dp[i][0] = dp[i-1][0];		//끝자리가 0인 경우는 1개뿐
			for(int j = 1;j <=9;j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1])%10007;
			}
		}
		int result = 0;
		for(int i = 0;i <= 9;i++) {
			result = (result + dp[n][i])%10007;	//각 자리수의 경우에 대해 저장해놓았기때문에 다 더해야 총 경우의 수
		}
		System.out.println(result);
	}
}
