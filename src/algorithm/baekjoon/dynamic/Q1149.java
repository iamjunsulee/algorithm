package algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Dynamic Programming(RGB거리)
public class Q1149 {
	static int[][] minCost = new int[1001][3];
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int r,g,b;
		
		for(int i = 1;i <= n;i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			r = Integer.parseInt(token.nextToken());
			g = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			
			//각 집에 대해 각 색상별 최소값
			minCost[i][0] = Math.min(minCost[i-1][1], minCost[i-1][2]) + r;	//빨강일 때 최소값
			minCost[i][1] = Math.min(minCost[i-1][0], minCost[i-1][2]) + g;	//초록일 때 최소값
			minCost[i][2] = Math.min(minCost[i-1][0], minCost[i-1][1]) + b;	//파랑일 때 최소값
		}
		//색상별 최소값 중에서 제일 작은 값이 최소 비용
		bw.write((Math.min(Math.min(minCost[n][0], minCost[n][1]), minCost[n][2]))+"\n");
		br.close();
		bw.close();
	}
}
