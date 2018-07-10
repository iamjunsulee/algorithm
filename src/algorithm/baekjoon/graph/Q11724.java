package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 연결요소의 개수
 * DFS로 탐색한 수를 세면 된다.
 * 인접리스트 사용할 시 : 2116 MS
 * 인접배열 사용할 시 : 1388MS 걸렸음.
 */
public class Q11724 {
	static ArrayList<Integer>[] adList;
	static boolean[] visited;
	static int[][] adArr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();		//정점의 수
		int e = sc.nextInt();		//간선의 수
		visited = new boolean[v+1];
		adList = (ArrayList<Integer>[]) new ArrayList[v+1];
		adArr = new int[v+1][v+1];
		//방문여부
		Arrays.fill(visited, false);	//false로 초기화
		//인접 리스트
		for(int i = 1; i <= v;i++) {
			adList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1;i <= e;i++) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
			//인접리스트 입력
			adList[vertex1].add(vertex2);
			adList[vertex2].add(vertex1);
			
			//인접행렬 입력
			adArr[vertex1][vertex2] = adArr[vertex2][vertex1] = 1;
		}
		for (int i=1; i<=v; i++) {
            Collections.sort(adList[i]);	//정점 번호가 작은 것을 먼저 방문하기 위해 sorting
        }
		int count = 0;
		for(int i = 1;i <= v;i++){
			if(!visited[i]) {
				//dfsByRecursiveList(adList, visited, i);	//모든 정점에서 출발하는 DFS
				dfsByRecursiveArray(adArr, visited, i);
				count++;
				//System.out.println();
			}
		}
		System.out.println(count);
	}
	/*
	 * 인접 리스트로 구현한 DFS
	 */
	public static void dfsByRecursiveList(ArrayList<Integer>[] a, boolean[] visited, int start){
		visited[start] = true;	//정점 방문
		//System.out.print(start + " ");

		for(int i : a[start]){
			if(!visited[i]){//인접 정점이면서 방문하지 않은 경우
				dfsByRecursiveList(a, visited, i);
			}
		}
	}
	/*
		재귀적인 방법으로 구현한 DFS
	 */
	public static void dfsByRecursiveArray(int[][] a, boolean[] visited, int start){
		visited[start] = true;	//정점 방문
		//System.out.print(start + " ");
		
		for(int i = 1;i < a.length;i++){
			if(a[start][i] == 1 && !visited[i]){//인접 정점이면서 방문하지 않은 경우
				dfsByRecursiveArray(a, visited, i);
			}
		}
	}
}
