package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 순열그래프
 * 유방향 그래프에서 사이클을 찾는 것이므로 
 * dfs 탐색 횟수 세는 문제라고 생각하면 된다.
 */
public class Q10451 {
    static ArrayList<Integer>[] adList;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while(testCase > 0){
            int size = sc.nextInt();    //순열 사이즈

            adList = (ArrayList<Integer>[]) new ArrayList[size+1];
            visited = new boolean[size+1];
            //인접 리스트
            for(int i = 1; i <= size;i++) {
                adList[i] = new ArrayList<Integer>();
            }
            Arrays.fill(visited, false);
            //인접 리스트
            for(int j = 1; j <= size;j++) {
                int v = sc.nextInt();
                adList[j].add(v);
            }
            int count = 0;
            for(int k = 1;k <= size;k++){
                if(!visited[k]){
                    dfs(k);
                    count++;
                }
            }
            System.out.println(count);
            testCase--;
        }
    }
    public static void dfs(int start){
        visited[start] = true;	//정점 방문
        //System.out.print(start + " ");

        for(int next : adList[start]){
            if(!visited[next]){//인접 정점이면서 방문하지 않은 경우
                dfs(next);
            }
        }
    }
}
