package algorithm.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 * 익은 토마토의 경우, 차례대로 큐에 삽입
 * 차례대로 BFS 탐색
 * 방문하지 않은 토마토가 있다면, 토마토가 익지 못하는 상황이라고 하기 위해
 * 없는 토마토의 경우, 방문 처리함
 */
public class Q7576 {
    static int m, n;
    static int[][] tomato;
    static boolean[][] visited;
    static int[] moveX = {-1, 0, 0, 1};
    static int[] moveY = {0, 1, -1, 0};
    static int minDay = 0;
    static Queue<Tomato> q = new LinkedList<Tomato>();

    public static class Tomato{
        int x;
        int y;
        int day;
        Tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day; //익기위한 일수
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();   //가로
        n = sc.nextInt();   //세로

        tomato = new int[n][m];
        visited = new boolean[n][m];

        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                tomato[i][j] = sc.nextInt();
                if(tomato[i][j] == 1){  //익은 토마토인 경우, queue에 삽입, 방문 처리
                    count++;
                    visited[i][j] = true;
                    q.offer(new Tomato(i,j,0));
                }else if(tomato[i][j] == -1){   //토마토가 없는 경우, 방문 처리 -> bfs 탐색 결과, 방문하지 않은게 있다면 토마토가 다 익지 못하는 상황으로 간주하기 위함
                    visited[i][j] = true;
                }
            }
        }
        if(count == n*m){   //처음부터 다 익은 경우
            System.out.println(0);
            return;
        }

        bfs();
    }
    public static void bfs(){
        while(!q.isEmpty()){
            Tomato t = q.poll();
            System.out.println(t.x+", "+t.y+" 토마토 방문, 최소 일수 :"+t.day);
            minDay  = t.day;
            for(int i = 0;i < 4;i++){
                int newX = t.x + moveX[i];
                int newY = t.y + moveY[i];
                System.out.println("new x : "+newX+", new y :"+newY);
                if((newX >= 0 && newX < n) && (newY >= 0 && newY < m)){
                    if(!visited[newX][newY] && tomato[newX][newY] != -1){
                        q.offer(new Tomato(newX,newY, minDay+1));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(!visited[i][j]){  //방문못하는 정점이 있으면, 토마토가 모두 익지 못하는 경우이므로
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(minDay);
    }
}
