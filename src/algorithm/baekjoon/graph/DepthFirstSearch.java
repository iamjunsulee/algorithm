package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DepthFirstSearch {
	static int[][] adArr;
	static ArrayList<Integer>[] adList;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();					//정점 개수
		int e = sc.nextInt();					//간선 개수
		int start = sc.nextInt();				//탐색 시작
		adArr = new int[v+1][v+1];
		adList = (ArrayList<Integer>[]) new ArrayList[v+1];
		
		//인접 리스트
		for(int i = 1; i <= v;i++) {
			adList[i] = new ArrayList<Integer>();
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
		
		for(int i = 1; i <= v;i++) {
			for(int j = 1;j <= v;j++){
				System.out.print(adArr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= v;i++) {
			System.out.println("adList["+i+"] : "+adList[i]);
		}
	}

}
