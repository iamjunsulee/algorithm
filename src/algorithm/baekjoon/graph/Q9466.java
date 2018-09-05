package algorithm.baekjoon.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Q9466 {
	static boolean[] visited;	//방문 여부
	static int[] visitCount;		//몇번쨰 방문인지
	static int[] startV;				//시작 정점
	static int[] adArr;	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();	//테스트케이스 개수
		
		while(testCase > 0) {
			int num = sc.nextInt();		//학생 수
			
			visited = new boolean[num+1];
			adArr = new int[num+1];
			visitCount = new int[num+1];
			startV = new int[num+1];
			
			//배열 초기화
			Arrays.fill(visited, false);
			Arrays.fill(visitCount, 0);
			Arrays.fill(startV, 0);
			Arrays.fill(adArr, 0);
			
			for(int i = 1;i <= num;i++) {
				adArr[i] = sc.nextInt();	//학생들 번호 저장
			}
			int total = 0;
			for(int i = 1;i <= num;i++) {
				if(!visited[i]) {
					//dfs(i);
					total += dfs(i,i,1);
				}
			}
			System.out.println(num - total);
			testCase--;
		}
	}
	public static int dfs(int start, int current, int cnt) {
		if(visited[current]) {//방문한 경우
			System.out.println("startV : "+startV[current]+", start : "+start);
			if(startV[current] != start) {//정점 시작점이 다를 경우, 사이클 아님
				return 0;
			}
			return cnt-visitCount[current];	//사이클 정점 수
		}
		visitCount[current] = cnt;	//몇번째 방문인지
		startV[current] = start;		//시작 정점
		visited[current] = true;		//방문 기록

		return dfs(start, adArr[current],cnt+1);
	}
}
