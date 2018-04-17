package algorithm.baekjoon.graph;

import java.util.*;

/**
 * 숫자고르기
 * 1 | 2 | 3 | 4 | 5 | 6 | 7 |
 * ---------------------------
 * 3 | 1 | 1 | 5 | 5 | 4 | 6 |
 *
 * 첫째줄에서 뽑은 수의 집합과 두번째 줄에 있는 값의 집합이 같아야한다.
 * 같기 위해서는 1-3-1 처럼 1에서 출발해서 1로 돌아와야한다. 즉 순환구조를 가져야한다.
 */
public class Q2668 {
    static boolean[] visited;
    static ArrayList<Integer>[] adList;
    static Queue<Integer> q;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    static int size = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        size =  sc.nextInt();
        adList = (ArrayList<Integer>[])new ArrayList[size+1];
        visited = new boolean[size+1];

        //인접 리스트
        for(int i = 1; i <= size;i++) {
            adList[i] = new ArrayList<Integer>();
        }

        for(int i = 1;i <= size;i++){
            int vertex = sc.nextInt();
            adList[i].add(vertex);
        }
        for(int i = 1;i <= size;i++) {
            q = new LinkedList<Integer>();  //큐 사용
            Arrays.fill(visited, false);    //false로 초기화
            dfs(i);
        }
        System.out.println(result.size());
        for(int vertex : result){
            System.out.println(vertex);
        }
    }
    public static void dfs(int start){
        visited[start] = true;
        q.offer(start);     //큐에 삽입, FIFO 성질을 이용하기 위해서 큐 사용
        System.out.println(start + " 방문");

        for(int next : adList[start]){
            if(!visited[next]){
                dfs(next);
            }else{  //이미 방문한 경우
                int head = q.poll();    //출발 정점
                if(head == next){       //출발 정점과 다음 정점이 같으면 순환구조
                    result.add(head);   //순환구조를 가진 정점 결과 리스트에 삽입
                }
                System.out.println("top : "+head);
                System.out.println("next : "+next);
            }
        }
    }
}
