package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 8진수 2진수
 */
public class Q1212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] inputs = br.readLine().toCharArray();
		
		StringBuilder answer = new StringBuilder();
		//8진수를 2진수로 표현할 때는 8진수 하나를 이진수 세 자리로 나타낸다.
		for(int i = 0;i < inputs.length;i++) {
			switch(inputs[i]) {
			case '0' :
				if(i == 0) {
					answer.append("0");
				}else {
					answer.append("000");
				}
				break;
			case '1' :
				if(i == 0) {
					answer.append("1");		//처음에 0이 오면 안된다 했으므로
				}else {
					answer.append("001");
				}
				break;
			case '2' :
				if(i == 0) {
					answer.append("10");
				}else {
					answer.append("010");
				}
				break;
			case '3' :
				if(i == 0) {
					answer.append("11");
				}else {
					answer.append("011");
				}
				break;
			case '4' :
				answer.append("100");
				break;
			case '5' :
				answer.append("101");
				break;
			case '6' :
				answer.append("110");
				break;
			case '7' :
				answer.append("111");
				break;
			}
		}
		bw.write(answer.toString());
		br.close();
		bw.close();
	}
}
