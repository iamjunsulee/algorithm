package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 진법 변환
 */
public class Q2745 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		char[] n =st.nextToken().toCharArray();		//B진법 N 
		int b = Integer.parseInt(st.nextToken());		//B진법
		int result = 0;
		
		//10진법 수로 바꾸려면, 각자리수마다 B진법의 지수승을 곱하면된다.
		for(int i =0;i < n.length;i++) {
			if('0' <= n[i] && n[i] <= '9' ) {
				result += (n[i]-'0')*Math.pow(b, n.length-(i+1));
			}else {
				result += (n[i]-'A'+10)*Math.pow(b, n.length-(i+1));
			}
		}
		bw.write(result+"\n");
		br.close();
		bw.close();
	}
}
