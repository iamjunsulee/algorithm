package algorithm.baekjoon.dataStructure;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int num = sc.nextInt();
		String blank = sc.nextLine();
		for(int i=0;i<num;i++){
			StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
			int tokenCount = st.countTokens();
			String operator = st.nextToken();
			int data = 0;
			if(tokenCount == 2){
				data = Integer.parseInt(st.nextToken(),10);
				stack.push(data);
			}else{
				stackFunction(stack,operator);
			}
		}
		sc.close();
	}
	public static void stackFunction(Stack<Integer> s,String operator){
		if(operator.equals("pop")){
			if(s.empty()){
				System.out.println("-1");
			}
			else{
				int outData = s.pop();
				System.out.println(outData);
			}
		}else if(operator.equals("size")){
			System.out.println(s.size());
		}else if(operator.equals("empty")){
			if(s.empty()){
				System.out.println("1");
			}else{
				System.out.println("0");
			}
		}else if(operator.equals("top")){
			if(s.empty()){
				System.out.println("-1");
			}else{
				System.out.println(s.peek());
			}
		}
	}
}
