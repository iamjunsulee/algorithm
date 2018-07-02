package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 2진수 8진수 
 */
public class Q1373 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder inputs = new StringBuilder(br.readLine()); 
		
		//2진수를 8진수로 변환하려면, 3자리씩 묶어서 바꾸면 된다.
		//따라서, 3자리로 안묶이는 경우, 길이가 3으로 나눠떨어지지 않는 경우, 나머지에 따라 0, 00 을 앞에 붙여준다.
		if(inputs.length() % 3 == 1) {
			inputs.insert(0, "00");
		}else if(inputs.length() % 3 == 2) {
			inputs.insert(0, "0");
		}
		
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0;i < inputs.length();i+=3) {
			int result  = 0;
			
			result += (inputs.charAt(i) - '0') * 4;
			result += (inputs.charAt(i+1) - '0') * 2;
			result += (inputs.charAt(i+2) - '0') * 1;
			
			answer.append(result);
		}
		bw.write(answer.toString());
		br.close();
		bw.close();
	}
}
