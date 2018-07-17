package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 이분그래프(Bipartite Graph)
 * 모든 꼭짓점을 빨강과 파랑으로 색칠하되,
 * 모든 변이 빨강과 파랑 꼭짓점을 포함하도록 색칠할 수 있는 그래프
 * 즉, 같은 색 정점끼리는 이어지면 안된다.
 */
public class Q1707 {
    static ArrayList<Integer>[] adList;
    static int[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while(testCase > 0){
            int v = sc.nextInt();//정점
            int e = sc.nextInt();//간선

            adList = (ArrayList<Integer>[]) new ArrayList[v+1];
            visited = new int[v+1];     //0: 미방문, 1 : 색상1, 2: 색상2

            //인접 리스트
            for(int i = 1; i <= v;i++) {
                adList[i] = new ArrayList<Integer>();
            }

            Arrays.fill(visited, 0);	//0 초기화

            for(int j = 0;j < e;j++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();

                //인접리스트 입력
                adList[v1].add(v2);
                adList[v2].add(v1);
            }
            //각 정점은 1부터 v까지 차례대로 번호
            for(int k = 1;k <= v;k++){
                if(visited[k] == 0) {//미방문인경우
                    dfs(k, 1);
                }
            }
            boolean isBipartite = true;
            for(int a = 1;a <= v;a++){
               for(int b = 0;b < adList[a].size();b++){
                   int idx = adList[a].get(b);
                   if(visited[a] == visited[idx]){//색상이 같은 경우, 이분그래프가 아님
                       isBipartite = false;
                   }
               }
            }
            System.out.println(isBipartite? "YES" : "NO");
            testCase--;
        }
    }
    public static void dfs(int start, int color){
        visited[start] = color;	//정점 색칠
        //System.out.print(start + " ");

        for(int i = 0;i < adList[start].size();i++){
            int next = adList[start].get(i);    //다음 방문할 정점
            if(visited[next] == 0){//미방문인경우
                dfs(next, 3 - color);//처음과 다른 색으로 색칠
            }
        }
    }
}
