package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * Base Conversion
 */
public class Q11576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());		//A진법
		int b = Integer.parseInt(st.nextToken());		//B진법
		int size = Integer.parseInt(br.readLine());	//A진법으로 나타낸 숫자의 자리수의 개수
		
		int dec = 0;
		st = new StringTokenizer(br.readLine());
		//A진법에서 10진법으로 변환
		for(int i = 0;i < size;i++) {
			int num = Integer.parseInt(st.nextToken());
			dec += num * Math.pow(a, size-i-1);
			//System.out.println(dec);
		}
		
		int remain = 0,  count = 0;
		String result = "";
		int[] answer = new int[26];
		
		//B진법으로 변환
		while(dec > 0) {//몫이 0이 아닌 동안 계속 나눠준다.
			remain = dec % b;			//나머지
			dec = dec / b;				//몫
			answer[++count] = remain;
		}
		for(int i = count;i >= 1;i--) {
			bw.write(answer[i]+" ");
		}
		br.close();
		bw.close();
	}

}
