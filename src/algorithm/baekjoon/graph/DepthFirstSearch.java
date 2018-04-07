package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearch {
	static int[][] adArr;
	static ArrayList<Integer>[] adList;
	static boolean[] visited;

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();					//정점 개수
		int e = sc.nextInt();					//간선 개수
		int start = sc.nextInt();				//탐색 시작 정점

		adArr = new int[v+1][v+1];
		adList = (ArrayList<Integer>[]) new ArrayList[v+1];
		visited = new boolean[v+1];

		//인접 리스트
		for(int i = 1; i <= v;i++) {
			adList[i] = new ArrayList<Integer>();
			visited[i] = false;
		}
		
		for(int i = 1;i <= e;i++) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
			//인접행렬 입력
			adArr[vertex1][vertex2] = adArr[vertex2][vertex1] = 1;
			//인접리스트 입력
			adList[vertex1].add(vertex2);
			adList[vertex2].add(vertex1);
		}

		//dfs_recursive(adArr, visited, start);
		dfs_stack(adArr, visited, start);
		/*
		for(int i = 1; i <= v;i++) {
			for(int j = 1;j <= v;j++){
				System.out.print(adArr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= v;i++) {
			System.out.println("adList["+i+"] : "+adList[i]);
		}
		*/
	}
	/*
		재귀적인 방법으로 구현한 DFS
	 */
	public static void dfs_recursive(int[][] a, boolean[] visited, int start){
		visited[start] = true;	//정점 방문
		System.out.print(start + " ");
		for(int i = 1;i < a.length;i++){
			if(a[start][i] == 1 && !visited[i]){//인접 정점이면서 방문하지 않은 경우
				dfs_recursive(a, visited, i);
			}
		}
	}
	/*
		stack을 사용해서 구현한 DFS
	 */
	public static void dfs_stack(int[][] a, boolean[] visited, int start){
		Stack<Integer> stack = new Stack<Integer>();	//스택 선언

		stack.push(start);		//정점 push
		visited[start] = true;	//정점 방문
		System.out.print(start + " ");

		while(!stack.isEmpty()){			//stack이 빌 때까지
			boolean isAdjacent = false;		//인접한지 아닌지 체크하기 위한 flag

			for(int i = 1;i < a.length; i++){
				int top = stack.peek();				//현재 stack top 정점

				if(a[top][i] == 1 && !visited[i]){	//인접 정점이면서 방문하지 않은 경우
					stack.push(i);
					visited[i] = true;
					System.out.print(i + " ");
					isAdjacent = true;
				}
			}

			if(!isAdjacent){
				stack.pop();	//인접한 정점이 없으면 stack에서 pop해줌으로 그 전 정점으로 돌아간다.
			}
		}
	}
}
