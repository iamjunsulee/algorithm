package algorithm.baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class postfixNotation {
	private Stack<Character> stack;
	private char[] postfix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		char[] chArr = input.toCharArray();
		
		postfixNotation ps = new postfixNotation();
		ps.postFix(chArr);
		
		//char 배열은 \0 값으로 초기화됨.
		for(char ch : ps.postfix) {
			//배열의 크기가 크기 때문에 
			//초기화된 값이 아닐 경우에만 출력하도록
			if(ch != '\0') { 	
				bw.write(ch);
			}
		}
		br.close();
		bw.close();
	}
	public void postFix(char[] infix) {
		stack = new Stack<Character>();
		postfix = new char[infix.length+1];
		int count = 0;
		
		for(int i = 0;i < infix.length;i++) {
			int priority = getPriority(infix[i]);
			char operator = infix[i];
			//연산자별 처리
			switch(operator){
				case '/':
				case '*':
				case '+':
				case '-':
					if(stack.isEmpty()) {	//기존의 다른 연산자가 없을 때
						stack.push(operator);
					}else {
						//현재 top과 우선순위 비교
						while(!stack.isEmpty() && priority <= getPriority(stack.peek())) {
							postfix[count++] = stack.pop();	//우선순위가 큰 연산자 배열에 삽입
						}
						stack.push(operator);
					}
					break;
				case '(':
					stack.push(operator);
					break;
				case ')':
					//좌괄호가 아닐때까지 연산자 추출
					while(stack.peek() != '(' && !stack.isEmpty()) {
						postfix[count++] = stack.pop();
					}
					stack.pop();	//좌괄호 제거
					break;
				default://A~Z 문자일때
					postfix[count++] = operator;
					break;
			}
		}
		//남아있는 연산자 추출
		while(!stack.isEmpty()){
			postfix[count++] = stack.pop();
		}
	}
	public int getPriority(char operator) {
		switch(operator){
			case '/' :
			case '*' :
				return 2;
			case '+' :
			case '-' :
				return 1;
			default :
				return 0;
		}
	}
}
