package algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Dynamic Programming(1,2,3 더하기)
public class Q9095 {
	static int[] num = new int[11];
	static int[] count = new int[11];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());		//테스트케이스 개수
		
		for(int i = 1;i <= testcase;i++) {
			num[i] = Integer.parseInt(br.readLine());
			dp(num[i]);
		}
		
		for(int i=1;i <= testcase;i++) {
			bw.write(count[num[i]]+"\n");
		}
		
		br.close();
		bw.close();
	}
	/*
	 * 4의 경우, 1, 2, 3으로 나타낼 수 있는 경우는 아래와 같다
	 * 1+1+1+1
	 * 1+1+2
	 * 1+2+1
	 * 2+1+1
	 * 2+2
	 * 1+3
	 * 3+1
	 * 
	 * 여기서 1을 빼면
	 * 1+1+1
	 * 1+2
	 * 2+1
	 * 3
	 * 2를 빼면
	 * 1+1
	 * 2
	 * 3을 빼면 
	 * 1
	 * 1을 뺀 경우는 4-1=3의 경우와 같고, 2를 뺀 경우는 4-2=2의 경우, 3을 뺀 경우는 4-3=1의 경우와 같다.
	 */
	public static void dp(int n) {
		count[1] = 1;
		
		for(int i = 2;i <= n;i++) {
			if(1< i && i <= 3){//i가 2, 3일때
				count[i] = count[i-2] + count[i-1]+1;//+1은 자기 자신을 뜻한다.
			}
			if(i > 3) {
				count[i] = count[i-3] + count[i-2] + count[i-1];
			}
		}
	}
}
