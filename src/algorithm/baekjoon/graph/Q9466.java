package algorithm.baekjoon.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Q9466 {
	static boolean[] visited;	//방문 여부
	static boolean[] finished;	//사이클 종료 여부
	static int[] adArr;
	static int cnt;				//사이클 원소 합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();	//테스트케이스 개수
		
		while(testCase > 0) {
			int num = sc.nextInt();		//학생 수
			
			visited = new boolean[num+1];
			finished = new boolean[num+1];
			adArr = new int[num+1];
			//배열 초기화
			Arrays.fill(visited, false);
			Arrays.fill(finished, false);
			Arrays.fill(adArr, 0);
			cnt = 0;
			
			for(int i = 1;i <= num;i++) {
				adArr[i] = sc.nextInt();	//학생들 번호 저장
			}
			
			for(int i = 1;i <= num;i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			System.out.println(num-cnt);
			testCase--;
		}
	}
	
	public static void dfs(int idx) {
		visited[idx] = true;	//방문 기록
		int next = adArr[idx];
		//System.out.println(idx+" 방문");
		//System.out.println("다음 방문할 노드 : "+next);
		if(!visited[next]) {
			dfs(next);
		}else {//방문한 경우
			if(!finished[next]) {
				for(int i = next;i != idx;i = adArr[i]) {	//사이클 내에 현재 idx가 아닌 다른 점 개수 카운트
					cnt++;
					//System.out.println("next : "+next+",i : "+i+",cnt = "+cnt);
				}
				cnt++;	//자기 자신 카운트
			}
		}
		finished[idx] = true;		//사이클 종료
	}
}
