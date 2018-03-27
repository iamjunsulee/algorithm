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
		
		for(int i=0;i < ps.postfix.length;i++) {
			bw.write(ps.postfix[i]);
		}
		bw.close();
		br.close();
	}
	public void postFix(char[] infix) {
		stack = new Stack<Character>();
		postfix = new char[infix.length+1];
		int count = 0;
		int priority = 0;
		
		for(int i = 0;i < infix.length;i++) {
			priority = getPriority(infix[i]);
			System.out.println("현재 우선순위 : "+priority);
			System.out.println(infix[i]);
			switch(infix[i]){
				case '/':
				case '*':
				case '+':
				case '-':
					if(stack.isEmpty()) {//기존의 다른 연산자가 없을 때
						stack.push(infix[i]);
						System.out.println("push함. 현재 top : "+stack.peek());
					}else {
						System.out.println("현재 top : "+stack.peek());
						while(!stack.isEmpty() && priority <= getPriority(stack.peek())) {
							System.out.println("push함. 현재 top : "+stack.peek());
							postfix[count++] = stack.peek();	//우선순위가 큰 연산자 배열에 삽입
							stack.pop();
						}
						stack.push(infix[i]);
					}
					break;
				case '(':
					stack.push(infix[i]);
					System.out.println("push함. 현재 top : "+stack.peek());
					break;
				case ')':
					System.out.println("push함. 현재 top : "+stack.peek());
					while(stack.peek() != '(' && !stack.isEmpty()) {
						postfix[count++] = stack.peek();
						stack.pop();
					}
					stack.pop();
					break;
				default://A~Z 문자일때
					postfix[count++] = infix[i];
					break;
			
			}
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
