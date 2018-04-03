package algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		//최대 90 자리이기 때문에 int ->long type으로 변경
		long[] dp = new long[n+1];	
		
		dp[1] = 1;
		/*
		 * 1자리 : 1
		 * 2자리 : 10
		 * 3자리 : 100, 101
		 * 4자리 : 1000,1001,1010
		 * 5자리 : 10000, 10001, 10010, 10100, 10101
		 * 1 뒤에는 1이 붙을 수 없고, 0만 붙을 수 있다. 
		 * 0 뒤에는 1과 0 둘 다 붙을 수 있다.
		 * dp(n) = dp(n-1) + n-1 자리 경우 중 끝자리가 0인 것의 개수가 된다.
		 * n-1자리의 경우 중 끝자리가 0인 것은 n-2번째의 경우와 같으므로 최종 점화식은 dp(n) = dp(n-1)+dp(n-2)가 된다.
		 */
		for(int i = 1;i <=n;i++) {
			if(i > 1)
				dp[i] = dp[i-1] + dp[i-2];
		}
		bw.write(dp[n]+"\n");
		br.close();
		bw.close();
	}
}
