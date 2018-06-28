package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/*
 * 에디터문제
 * ArrayList vs LinkedList
 */
public class Q1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inputs = br.readLine();		
		StringBuilder  sb = new StringBuilder();
		LinkedList<Character> list = new LinkedList<Character>();
		
		char[] ch = inputs.toCharArray();
		
		//첫 줄, 초기문자열 세팅
		for(char c : ch) {
			list.add(c);
		}
		
		int size = Integer.parseInt(br.readLine());
		
		//iterator는 단방향 이동, listIterator는 양방향 이동 가능
		ListIterator iterator = list.listIterator(list.size());
		
		for(int i = 0;i < size;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String operator = st.nextToken();
			
			if(operator.equals("L")) {//커서 왼쪽으로 이동
				if(iterator.hasPrevious()) {
					iterator.previous();
					//System.out.print(iterator.previous());
				}
			}else if (operator.equals("D")) {//커서 오른쪽으로 이동
				if (iterator.hasNext()) {
					iterator.next();
					//System.out.print(iterator.next());
				}
			}else if (operator.equals("B")) {
				if (iterator.hasPrevious()) {
					iterator.previous();	//커서 왼쪽이동
					iterator.remove();		//해당 문자 삭제
				}
			}else {//P인 경우
				iterator.add(st.nextToken().charAt(0));
			}
		}
		
		for(char c : list) {
			sb.append(c);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
