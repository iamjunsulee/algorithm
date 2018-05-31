package algorithm.baekjoon.dynamic;

import java.util.Scanner;
/*
 * 합분해
 */
public class Q2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int k = sc.nextInt();
		
		long[][] result = new long[k+1][n+1];	//k개를 가지고 n까지 만드는 경우의 수
		
		for(int i = 0;i <= n;i++) {//1개로 만드는 경우의 수는 자기 자신 뿐이므로 1로 초기화
			result[1][i] = 1;
		}
		/*
		 * 정수 2개로 20을 만드는 경우는 0+20 ~ 20+0 총 21가지
		 * 결국 1개로 0~20을 만드는 모든 경우의 합과 같다.
		 */
		for(int i = 1;i <= k;i++) {	
			for(int j = 0;j <= n;j++) {
				for(int m = 0;m <= j;m++) {
					result[i][j] += (result[i-1][j-m]%1000000000);
				}
			}
		}
		System.out.println(result[k][n]);
	}

}
