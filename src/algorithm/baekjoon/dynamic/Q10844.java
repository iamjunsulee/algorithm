package algorithm.baekjoon.dynamic;

import java.util.Scanner;

public class Q10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();						//자리수
		int[][] dp = new int[101][10];		//dp[i][j]는 i자리수에서 끝이 j로 끝나는 경우의 수
		
		dp[1][0] = 0;
		for(int i =1;i <= 9;i++) {
			dp[1][i] = 1;		//자리수가 1인 경우, 각 경우는 1개뿐
		}
		/*
		 * dp[2][1] = dp[1][2] + dp[1][0] 즉, 21 1가지 경우
		 * dp[2][2] = dp[1][3] + dp[1][1] 즉, 32 12 2가지 경우
		 */
		for(int i = 2;i <= n;i++) {
			dp[i][0] = dp[i-1][1];		//끝자리가 0인 경우는 1개뿐
			for(int j = 1;j <=9;j++) {
				if(j+1 < 10) {	//10이 넘어가면 자릿수가 바뀌므로 안됨
					dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1])%1000000000;
				}else {
					dp[i][j] = dp[i-1][j-1]%1000000000;
				}
			}
		}
		int result = 0;
		for(int i = 0;i <= 9;i++) {
			result = (result + dp[n][i])%1000000000;	//각 자리수의 경우에 대해 저장해놓았기때문에 다 더해야 총 경우의 수
		}
		System.out.println(result);
	}
}