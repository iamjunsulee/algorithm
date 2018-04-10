package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1260 {
	static ArrayList<Integer>[] adList;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();					//정점 개수
		int e = sc.nextInt();					//간선 개수
		int start = sc.nextInt();				//탐색 시작 정점

		adList = (ArrayList<Integer>[]) new ArrayList[v+1];
		visited = new boolean[v+1];
		
		//인접 리스트
		for(int i = 1; i <= v;i++) {
			adList[i] = new ArrayList<Integer>();
		}
		//방문여부
		Arrays.fill(visited, false);	//false로 초기화
		
		//인접 리스트 초기화
		for(int i = 1;i <= e;i++) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
			//인접리스트 입력
			adList[vertex1].add(vertex2);
			adList[vertex2].add(vertex1);
		}
		
		for (int i=1; i<=v; i++) {
            Collections.sort(adList[i]);	//정점 번호가 작은 것을 먼저 방문하기 위해 sorting
        }
		
		dfsByRecursiveList(adList, visited, start);
		System.out.println();
		//방문여부
		Arrays.fill(visited, false);	//false로 초기화
		bfs(adList, visited, start);
	}
	/*
	 * 인접 리스트로 구현한 DFS
	 */
	public static void dfsByRecursiveList(ArrayList<Integer>[] a, boolean[] visited, int start){
		visited[start] = true;	//정점 방문
		System.out.print(start + " ");

		for(int i : a[start]){
			if(!visited[i]){//인접 정점이면서 방문하지 않은 경우
				dfsByRecursiveList(a, visited, i);
			}
		}
	}
	
	/*
	 * 인접 리스트로 구현한 BFS
	 */
	public static void bfs(ArrayList<Integer>[] a, boolean[] visited, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			start = queue.poll();
			System.out.print(start + " ");
			
			for(int i : a[start]) {
				if(!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
}
