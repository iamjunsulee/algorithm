package algorithm.baekjoon.dynamic;

import java.util.Scanner;
/*
 * 스티커
 */
public class Q9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int i = 0;i < testCase;i++) {
			int size = sc.nextInt();
			int[][] sticker = new int[2][size];	//스티커 점수
			for(int j = 0;j < 2;j++) {
				for(int k = 0;k < size;k++) {
					sticker[j][k] = sc.nextInt();
				}
			}
			dp(sticker, size);
		}
	}
	public static void dp(int[][] sticker, int size) {
		int[][] result = new int[2][size];	//해당 위치에서 얻을 수 있는 최대값
		//첫번째 스티커 최대값은 자기 자신
		result[0][0] = sticker[0][0];
		result[1][0] = sticker[1][0];
		//두번째 스티커 최대값
		result[0][1] = sticker[0][1] + sticker[1][0];
		result[1][1] = sticker[0][0] + sticker[1][1];
		
		/*
		 * 3번째 위치의 스티커부터는 
		 * 대각선 위치의 스티커를 선택한 경우와 선택하지 않은 경우 중 더 큰 값과 본인 스티커의 값의 합이 해당 위치에서 
		 * 얻을 수 있는 최대값이 된다.
		 * 
		 * 50 10+30 100+max(50+50,30) ..
		 * 30 50+50 70+max(10+30,50) ..
		 */
		for(int i = 2;i < size;i++) {
			result[0][i] = sticker[0][i] + Math.max(result[1][i-1], result[1][i-2]);
			result[1][i] = sticker[1][i] + Math.max(result[0][i-1], result[0][i-2]);
		}
		/*
		for(int i = 0; i < 2;i++) {
			for(int j = 0;j < size;j++) {
				System.out.println("result["+i+"]["+j+"] = "+result[i][j]);
			}
		}
		*/
		System.out.println(Math.max(result[0][size-1], result[1][size-1]));
	}
}
