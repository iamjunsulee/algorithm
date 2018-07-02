package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 진법 변환 2
 */
public class Q11005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());		//10진수 N
		int b = Integer.parseInt(st.nextToken());		//B진법

		int remain = 0;
		String result = "";
		while(n > 0) {//몫이 0이 아닌 동안 계속 나눠준다.
			remain = n % b;	//나머지
			n = n / b;				//몫
			
			if(remain >= 10) {
				result = (char)(remain+55) + result;	//A~Z의 아스키코드값은 65~90
			}else {
				result = remain + result;
			}
		}
		bw.write(result);
		br.close();
		bw.close();
	}
}
