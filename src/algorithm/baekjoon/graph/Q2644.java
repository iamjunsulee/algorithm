package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 촌수계산
9
7 4
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 * 숨바꼭질 문제와 유사
 * 촌수는 건너가는 관계마다 +1이 된다.
 * 자식 - 부모 = 1촌, 자식 - 부모 - 자식 = 2촌
 * 즉 연결된 간선 당 +1이 된다.  
 */
public class Q2644 {
	static int[][] vertex;
	static boolean[] visited;
	static ArrayList<Integer>[] adList;
	
	public static class Vertex{
		int pos;
		int height;
		
		Vertex(int height, int pos){
			this.height = height;
			this.pos = pos;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int person = sc.nextInt();	//총 사람수
		int start = sc.nextInt();			//출발점
		int end = sc.nextInt();			//도착점
		int relation = sc.nextInt();	//관계 수
		
		adList = (ArrayList<Integer>[]) new ArrayList[person+1];
		visited = new boolean[person+1];
		
		//인접 리스트
		for(int i = 1; i <= person;i++) {
			adList[i] = new ArrayList<Integer>();
		}
		//방문여부
		Arrays.fill(visited, false);	//false로 초기화
		
		//인접리스트 값 삽입
		for(int i = 1;i <= relation;i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			
			adList[parent].add(child);
			adList[child].add(parent);
		}
		System.out.println(solve(start, end));
	}
	public static int solve(int start, int end) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.offer(new Vertex(0,start));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Vertex head = q.poll();
			
			int height = head.height;		//시작 정점으로 부터 해당 정점 높이
			int pos = head.pos;				//정점 
			
			System.out.println(pos+" 방문, 이때의 높이는 "+height);
			
			if(pos == end) {
				return height;	//도착 정점에 도달하면 이때의 높이가 촌수가 된다.
			}
			for(int next : adList[pos]) {
				if(!visited[next]) {
					q.offer(new Vertex(height+1,next));
					visited[next] = true;
				}
			}
		}
		return -1;	//관계가 없는 경우
	}
}
