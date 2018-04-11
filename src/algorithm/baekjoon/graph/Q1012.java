package algorithm.baekjoon.graph;

import java.util.Scanner;

/**
 * 유기농 배추
 * 인접 정점이 상, 하, 좌, 우 좌표에 존재
 */
public class Q1012 {
    static boolean[][] visited;
    static int[][] vertex;
    static int count = 0;
    static int[] moveX = {-1, 0, 0, 1};
    static int[] moveY = {0, 1, -1, 0};
    static int m, n, k;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0;i < testCase;i++){
            m = sc.nextInt();       //가로길이
            n = sc.nextInt();       //세로길이
            k = sc.nextInt();       //배추 위치 개수

            //testcase마다 초기화
            visited = new boolean[m][n];
            vertex = new int[m][n];

            for(int j = 0;j < k;j++){
                int x = sc.nextInt();   //가로 좌표
                int y = sc.nextInt();   //세로 좌표
                vertex[x][y] = 1;
            }

            for(int a = 0;a < m;a++){
                for(int b = 0;b < n;b++){
                    if(!visited[a][b] && vertex[a][b] == 1){
                        //System.out.println("a : "+a+", b : "+b);
                        dfs(a, b);
                        count++;    //인접한 블록을 찾고나면 count 1 증가
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0;i < 4;i++){   //상 하 좌 우 검사
            int newX = x + moveX[i];
            int newY = y + moveY[i];

            //상 하 좌 우 좌표의 x, y축 범위에 따라
            if((newX >= 0 && newX < m) && (newY >= 0 && newY < n)){
                if(!visited[newX][newY] && vertex[newX][newY] == 1) {//방문하지않았고, 값이 1인 경우 다음 방문
                    dfs(newX, newY);
                }
            }
        }
    }
}
