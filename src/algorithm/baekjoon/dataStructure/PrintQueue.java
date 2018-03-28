package algorithm.baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrintQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		//출력하는 순서를 저장할 배열
		int[] printOrder = new int[size];
		//배열 인덱스
		int arrSize = 0;
		
		for(int i = 1;i <= size;i++) {
			int count = 1;
			String firstRow = br.readLine();
			StringTokenizer token = new StringTokenizer(firstRow);
			
			int N = Integer.parseInt(token.nextToken());	//문서 개수
			int pos = Integer.parseInt(token.nextToken());	//위치
			String importance = br.readLine();				//문서 중요도
			//우선순위 큐
			PriorityQueue<Book> pQueue = getPriorityQueue(importance,N);
			//내림차순으로 설정
			PriorityQueue<Book> reversedPriorityQueue = 
			         new PriorityQueue<Book>(pQueue.size(), Collections.reverseOrder());
			        reversedPriorityQueue.addAll(pQueue);
			        
			while(!reversedPriorityQueue.isEmpty()) {
				Book book = reversedPriorityQueue.poll();
				//위치가 배열 인덱스랑 같은거 같아 배열 인덱스를 Book 클래스의 pos에 넣었음.
				//입력받은 문서의 위치와 Book 클래스의 pos와 같을때까지 출력순서를 세는 count 증가
				if(book.pos != pos) {
					count++;
				}else {
					printOrder[arrSize++] = count;
				}
			}
		}
		for(int result : printOrder) {
			bw.write(result+"\n");
		}
		br.close();
		bw.close();
	}
	//우선순위 큐 생성
	public static PriorityQueue<Book> getPriorityQueue(String str, int size){
		//문서 중요도
		StringTokenizer token = new StringTokenizer(str);
		PriorityQueue<Book> pQueue = new PriorityQueue<Book>();
		
		for(int i = 0;i < size;i++) {
			Book book = new Book(i,Integer.parseInt(token.nextToken()));
			pQueue.offer(book);
		}
		
		return pQueue;
	}
	//문서 클래스
	static class Book implements Comparable<Book>{
		String name;
		int priority;	//중요도
		int pos;		//위치
		public Book(int pos,int priority) {
			super();
			this.pos = pos;
			this.priority = priority;
		}
		
		@Override
		public int compareTo(Book book) {
			if(this.priority > book.priority) {
				return 1;
			}else if(this.priority < book.priority) {
				return -1;
			}
			return 0;
		}
	}
}

