package algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Dynamic Programming(계단 오르기)
public class Q2579 {
	static int[] stairScore = new int[301];
	static int[] result = new int[301];			//해당 계단까지 밟은 최고 점수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());					//계단 개수
		
		for(int i = 1;i <= N;i++) {
			stairScore[i] = Integer.parseInt(br.readLine());	//계단 점수
		}
		bw.write(dp(N)+"\n");
		br.close();
		bw.close();
	}
	/*
	 * 현재 계단까지 오는 경우는 두가지
	 * 바로 전의 계단을 밟은 경우, 안 밟은 경우
	 * 즉, 한 칸 전에서 오는 경우와 두 칸 전에서 오는 경우
	 */
	public static int dp(int n) {
		for(int i=1;i <= n;i++) {
			result[i] = result[i-1] + stairScore[i];	//첫번째 계단과 두번째 계단은 다 밟는 경우가 max

			if(i >= 3) {
				result[i] = Math.max(result[i-2]+stairScore[i], stairScore[i]+stairScore[i-1]+result[i-3]);
			}
			System.out.println("result["+i+"] : "+result[i]);
		}
		return result[n];
	}
}
