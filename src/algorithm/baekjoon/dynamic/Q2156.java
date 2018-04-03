package algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Dynamic Programming(포도주 시식)
public class Q2156 {
	static int[] eat  = new int[10001];	//최대 포도주 양
	static int[] wine = new int[10001];	//포도주양
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for(int i = 1;i <= n;i++) {
			wine[i] = Integer.parseInt(br.readLine());	
		}
		bw.write(dp(n)+"\n");
		br.close();
		bw.close();
	}
	/*
	 * 처음과 두번째는 다 먹는게 최대값이고
	 * 나머지는 전체적인 틀로는 두가지 경우가 있다.
	 * 해당 포도주를 먹는 경우와 안 먹는 경우
	 * 해당 포도주를 먹는 경우에는 다음 두가지 경우가 있다.
	 * 바로 전꺼를 먹는 경우 => eat[i-3]+wine[i]+wine[i-1]
	 * 안 먹는 경우 => eat[i-2]+wine[i]
	 * 해당 포도주를 안먹는 경우 => eat[i-1]
	 * 위 경우 중 최대값이 포도주를 먹는 최대값이 된다.
	 */
	public static int dp(int n) {
		for(int i=1;i <= n;i++) {
			eat[i] = eat[i-1] + wine[i];	//첫번째, 두번째는 다 먹는게 최대값
			if(i > 2) {
				eat[i] = Math.max(Math.max(eat[i-1], eat[i-2]+wine[i]),eat[i-3]+wine[i]+wine[i-1]);
			}
		}
		return eat[n];
	}
}
