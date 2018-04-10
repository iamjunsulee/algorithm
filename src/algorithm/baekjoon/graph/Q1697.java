package algorithm.baekjoon.graph;

import java.util.Queue;
import java.util.*;

/*
 * 숨바꼭질 
 * 인접 정점이 -1,+1,*2 연산을 통해 만들어지고,
 * 도착 정점까지 트리의 높이가 어떻게 되는 지 구하는 문제
 */
public class Q1697 {
	static boolean[] visited = new boolean[100001];
	
	public static class Vertex{
		int height;		//트리 구조에서 높이 = 탐색 시간
		int pos;			//정점
		
		Vertex(int height, int pos){
			this.height = height;
			this.pos = pos;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//시작 정점
		int k = sc.nextInt();	//도착 정점
		Arrays.fill(visited, false);
		
		System.out.println(bfs(n, k));
	}
	public static int bfs(int n, int k) {
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.offer(new Vertex(0,n));
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			Vertex v = queue.poll();
			
			int height = v.height;		//시작 정점으로 부터 해당 정점 높이
			int pos = v.pos;				//정점 
			//System.out.println("height : "+height);
			//System.out.println("pos : "+pos);
			
			if(pos == k) {
				return height;
			}
			//인접 정점 만드는 과정
			for(int i = 0;i < 3;i++) {
				int next;
				if(i == 0) {
					next = pos - 1;
				}else if(i == 1) {
					next = pos + 1;
				}else {
					next = pos * 2;
				}
				//범위내에 포함되면서 방문하지 않은 경우
				if(0 <= next && next <= 100000) {
					if(!visited[next]) {
						queue.offer(new Vertex(height+1,next));
						visited[next] = true;
					}
				}
			}
		}
		return 0;
	}
}
