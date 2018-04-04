package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;
//Dynamic Programming(연속합)
public class Q1912 {
	//2초 제한이라 BufferedReader, BufferedWriter 대신에 Scanner 사용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();			//정수 개수 
		int[] sum = new int[n];		//0부터 n-1위치까지의 최대 연속합 저장할 배열
		int number = 0;					//입력받는 수
		/*
		 * 처음에는 자기 자신이 최대 연속합
		 * 두번째부터는 현재 자신 값과 그 전까지의 최대연속합 값과 비교해서 더 큰 값이 현재 위치까지의 최대 연속합이 된다.
		 * 주어진 수  : 10 -4 3 1 5 6 -35 12 21 -1
		 * 2번째 위치까지의 최대 연속합은 10+(-4) = 6 > 3이므로 다 더한 9가 최대 연속합이 된다.
		 */
		for(int i = 0;i < n;i++) {
			number = sc.nextInt();
			if(i == 0) {sum[i] = number;}	
			else {sum[i] = Math.max(number, sum[i-1]+number);}
		}
		/*
		for(int i = 0;i < n;i++) {
			System.out.println(i+"번째까지 최대 연속합 : "+sum[i]);
		}
		*/
		//정렬을 하면 최대 연속합은 배열 제일 끝에 위치
		Arrays.sort(sum);
		System.out.println(sum[n-1]);
	}
}
