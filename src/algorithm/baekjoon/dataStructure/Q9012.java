package algorithm.baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/*
 * 괄호 - 스택
 */
public class Q9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		
		for(int i =0;i < size;i++) {
			String input = br.readLine();
			char[] inputs = input.toCharArray();
			Stack<Character> s = new Stack<Character>();
			for(int j = 0;j < inputs.length;j++) {
				if(s.isEmpty() || inputs[j] == '(') {	//스택이 비어있는 경우나 좌괄호인 경우에만 push
					s.push(inputs[j]);
				}
				if(inputs[j] == ')' && s.peek() == '(') {	//top이 좌괄호이고, 넣으려는 문자가 우괄호이면 pop
					s.pop();
				}
			}
			if(!s.isEmpty()) {//스택에 남아있는 게 있으면 vps가 아님
				bw.write("NO"+"\n");
			}else {
				bw.write("YES"+"\n");
			}
		}
		br.close();
		bw.close();
	}
}
