package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 케빈 베이컨의 6단계 법칙
 * 플로이드 워셜 알고리즘으로 쉽게 풀수있다고 함.
 * bfs를 사용해서 각 정점에서 다른 정점으로의 거리를 구한 후, 
 * 해당 거리의 합이 제일 작은 정점을 구했다.
 */
public class Q1389 {
	static ArrayList<Integer>[] a;
	static int N , M, length;	//친구수, 관계수
	static boolean[] visited;
	static int[] depth, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//친구수 -> 정점수
		M = sc.nextInt();	//관계수
		
		//객체생성
		a = (ArrayList<Integer>[])new ArrayList[N+1];
		visited = new boolean[N+1];
		depth = new int[N+1];
		
		//ArrayList 배열 객체 생성
		for(int i = 1;i <= N;i++) {
			a[i] = new ArrayList<Integer>();
		}
		//초기화
		Arrays.fill(visited, false);	
		Arrays.fill(depth, 0);
		
		//인접리스트 
		for(int i = 1;i <= M;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			a[v1].add(v2);
			a[v2].add(v1);
		}
		
		int min = 10000, person = 0;
		for(int i = 1;i <= N;i++) {
			int answer = bfs(i);
			//다른 정점에서 출발하기전에 초기화
			Arrays.fill(visited, false);
			Arrays.fill(depth, 0);
			//최소값
			if(answer < min) {
				min = answer;
				person = i;
			}
		}
		System.out.println(person);
	}
	
	public static int bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();	//큐
		int sum = 0;
		//System.out.println("시작 정점 : "+start);
		q.add(start);					//큐 삽입
		visited[start] = true;		//정점 방문
		
		while(!q.isEmpty()){
			int top = q.poll();
			
			//System.out.println("현재 top = "+top);
			//System.out.println("현재까지 depth = "+depth[top]);
			sum += depth[top];
			for(int next : a[top]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
					depth[next] = depth[top] + 1;
				}
			}
		}
		return sum;
	}
}
