package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 조세퍼스 문제, 조세퍼스 문제2
 */
public class Q1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inputs = br.readLine();		
		StringTokenizer st = new StringTokenizer(inputs," ");
		StringBuilder  sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());		//n번까지
		int m = Integer.parseInt(st.nextToken());	//m번째 사람 제거
		
		ArrayList<Integer> number = new ArrayList<Integer>();
		//1 ~ N까지 초기화
		for(int i = 1;i <= n;i++) {
			number.add(i);
		}
		
		int idx = 0;
		sb.append("<");
		while(!number.isEmpty()) {
			idx += m-1;		//index는 0부터 시작하므로 1을 빼준다.
			
			if(idx >= number.size()) {	//사이즈를 벗어나면 나눠줌으로써 인덱스 위치를 찾는다.
				idx %= number.size();
			}
			sb.append(number.remove(idx)+", ");
			//System.out.println("idx : "+idx+" , remove : "+number.remove(idx));
		}
		bw.write(sb.toString().substring(0,sb.length()-2)+">");	//마지막에 들어간 ", " 부분을 잘라준다.
		br.close();
		bw.close();
	}
}
