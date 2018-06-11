package algorithm.baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 덱 - Deque
 * 자바에서 Deque 클래스 선언하면 됨.
 */
public class Q10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> q = new LinkedList<Integer>();
		int size = Integer.parseInt(br.readLine());
		
		for(int i=0;i<size;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int tokenCount = st.countTokens();
			String operator = st.nextToken();
			int data = 0;
			if(tokenCount == 2){
				data = Integer.parseInt(st.nextToken(),10);
				if(operator.equals("push_front")) {
					q.addFirst(data);
				}else if(operator.equals("push_back")){
					q.addLast(data);
				}
			}else{
				if(operator.equals("pop_front")){
					if(q.isEmpty()){
						bw.write("-1"+"\n");
					}
					else{
						bw.write(q.pollFirst()+"\n");
					}
				}else if(operator.equals("pop_back")){
					if(q.isEmpty()){
						bw.write("-1"+"\n");
					}
					else{
						bw.write(q.pollLast()+"\n");
					}
				}else if(operator.equals("size")){
					bw.write(q.size()+"\n");
				}else if(operator.equals("empty")){
					if(q.isEmpty()){
						bw.write("1"+"\n");
					}else{
						bw.write("0"+"\n");
					}
				}else if(operator.equals("front")){
					if(q.isEmpty()){
						bw.write("-1"+"\n");
					}else{
						bw.write(q.peekFirst()+"\n");
					}
				}else if(operator.equals("back")) {
					if(q.isEmpty()){
						bw.write("-1"+"\n");
					}else{
						bw.write(q.peekLast()+"\n");
					}
				}
			}
		}
		br.close();
		bw.close();
	}
}
