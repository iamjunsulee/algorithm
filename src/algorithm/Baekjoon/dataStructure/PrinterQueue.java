package algorithm.Baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrinterQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());

		while(size != 0) {
			String firstRow = br.readLine();
			StringTokenizer token = new StringTokenizer(firstRow);
			
			int N = Integer.parseInt(token.nextToken());	//문서 개수
			int pos = Integer.parseInt(token.nextToken());	//위치
			String secondRow = br.readLine();				//문서 중요도
			int[] doc = new int[N];							//중요도 저장할 배열
			boolean[] check = new boolean[N];				//출력여부 저장할 배열 (true/false)
			
			token = new StringTokenizer(secondRow);
			for(int i=0;i < N;i++) {
				doc[i] = Integer.parseInt(token.nextToken());
			}
			
			int start = 0;//시작지점
			int order = 0;//출력순서 
			//현재 위치에 있는 문서가 출력이 될때까지 반복
			while(!check[pos]) {
				int move = start;	//비교대상
				int now = -1;
				//최초 한번 실행을 위해 while -> do while로
				do{
					if(!check[move]) {//출력안된경우
						if(now == -1 || doc[move] > doc[now]) {//우선순위 큰 거 찾으면 현재 위치를 해당 위치로 
							now = move;
							System.out.println("now : "+now);
							System.out.println("doc[move] : "+doc[move]+", doc[now] : "+doc[now]);
						}
					}
					move = (move + 1) % N;	//다시 처음으로 돌아가기 위함
					System.out.println("move : "+move);
				}while(start != move);
				
				check[now] = true;	//우선순위 큰거 출력
				start = now;
				order++;
			}
			bw.write(order+"\n");
			size--;
		}
		br.close();
		bw.close();
	}
}

