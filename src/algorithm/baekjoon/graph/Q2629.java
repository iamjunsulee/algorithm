package algorithm.baekjoon.graph;

import java.util.Scanner;

/*
 * 양팔저울
 * 추가 1g, 4g이 있을 때, 잴 수 있는 무게는 1, 4, 3, 5 이렇게 총 4가지이다.
 * 추가 구슬과 함께 사용되는 경우와 해당 추를 사용하지 않는 경우 그리고 추 모두를 사용하는 경우가 존재한다.
 * 각각 추를 사용해서 잴 수 있는 무게를 그래프에서 정점에 방문했다고 생각하면 된다.
 */
public class Q2629 {
	static int size;				//추의 개수
	static int[] arrWeight;	//추의 무게
	//추 30개로 무게 40000g을 측정할 수 있는지에 대한 배열
	static boolean[][] visited = new boolean[31][40001];	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size  = sc.nextInt();
		arrWeight = new int[size+1];
		
		for(int i = 0;i < size;i++) {
			arrWeight[i] = sc.nextInt();
		}

		dfs(0,0);
		
		int testCase = sc.nextInt();	//확인하고자 하는 구슬 개수
		
		for(int i = 0;i < testCase;i++) {
			int weight = sc.nextInt();
			if(visited[size][weight]) {
				System.out.print("Y" +" ");
			}else {
				System.out.print("N" +" ");
			}
		}
	}
	
	public static void dfs(int n, int weight) {
		if(n > size) {					//추 개수를 벗어나면 종료
			return;
		}

		if(visited[n][weight]) {	//방문했으면 종료
			return;
		}
		visited[n][weight] = true;
		System.out.println("추 개수 : "+n+", 무게 : "+weight);
		
		dfs(n+1, Math.abs(weight - arrWeight[n]));	//해당 추만 사용한 경우, 즉 한쪽에 추와 구슬이 같이 있는 경우
		dfs(n+1, weight);							//해당 추를 사용하지 않은 경우
		dfs(n+1, weight + arrWeight[n]);	//추를 다 사용한 경우
	}
}
