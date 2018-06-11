package algorithm.baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 큐
 */
public class Q10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<Integer>();
		int size = Integer.parseInt(br.readLine());
		int data = 0;
		for(int i=0;i<size;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int tokenCount = st.countTokens();
			String operator = st.nextToken();

			if(tokenCount == 2){
				data = Integer.parseInt(st.nextToken(),10);
				queue.add(data);
			}else{
				stackFunction(queue,operator,data);
			}
		}
		br.close();
		bw.close();
	}
	public static void stackFunction(Queue<Integer> q,String operator, int data){
		if(operator.equals("pop")){
			if(q.isEmpty()){
				System.out.println("-1");
			}
			else{
				int outData = q.poll();
				System.out.println(outData);
			}
		}else if(operator.equals("size")){
			System.out.println(q.size());
		}else if(operator.equals("empty")){
			if(q.isEmpty()){
				System.out.println("1");
			}else{
				System.out.println("0");
			}
		}else if(operator.equals("front")){
			if(q.isEmpty()){
				System.out.println("-1");
			}else{
				System.out.println(q.peek());
			}
		}else if(operator.equals("back")) {//큐에서 rear는 젤 마지막에 넣은 데이터이므로 그대로 출력
			if(q.isEmpty()){
				System.out.println("-1");
			}else{
				System.out.println(data);
			}
		}
	}
}
