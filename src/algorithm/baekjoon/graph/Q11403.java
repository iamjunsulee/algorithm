package algorithm.baekjoon.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 경로 찾기
 * 가중치 없는 방향 그래프가 주어졌을 때, 모든 정점 i, j에 대해서 i에서 j로 가는 경로가 있는지 없는지
 * 하나의 정점에서 다른 정점과의 연결관계를 찾을 때에는 DFS
 * 각각의 정점에서의 DFS를 통해 방문한 정점들이 있으면 그 정점과는 연결되어있다는 뜻임.
 */
public class Q11403 {
    static int[][] adArr;
    static boolean[] visited;
    static int[][] result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();

        adArr = new int[vertex+1][vertex+1];
        visited = new boolean[vertex+1];
        result = new int[vertex+1][vertex+1];
        Arrays.fill(visited, false);	//false로 초기화

        for(int i = 1;i <= vertex;i++){
            for(int j = 1;j <= vertex;j++){
                adArr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1;i <= vertex;i++){
            dfsByRecursiveArray(adArr, visited, i);     //모든 정점에서 출발하는 DFS
            for(int j = 1;j <= vertex;j++){
                if(visited[j])                          //방문한 정점이 있다면, 연결되어있다는 뜻임
                    result[i][j] = 1;
                else
                    result[i][j] = 0;
            }
            Arrays.fill(visited, false);	//false로 초기화
        }

        for(int i = 1;i <= vertex;i++){
            for(int j = 1;j <= vertex;j++){
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void dfsByRecursiveArray(int[][] a, boolean[] visited, int start){
        //System.out.print(start + " ");
        for(int i = 1;i < a.length;i++){
            //인접 정점이면서 방문하지 않은 경우
            if(a[start][i] == 1 && !visited[i]){
                visited[i] = true;	//출발점에서 도착정점에 오면 방문
                dfsByRecursiveArray(a, visited, i);
            }
        }
    }
}
