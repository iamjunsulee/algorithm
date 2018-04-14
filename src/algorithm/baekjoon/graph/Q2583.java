package algorithm.baekjoon.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 영역 구하기
 * 이것도 어떻게 보면 유기농 배추나 단지 번호 붙이기 문제와 유사
 * 주어진 직사각형을 1이라고 표시했기때문에
 * 값이 0인 것들이 인접 행렬
 * 방문하지 않았고, 인접 행렬 값이 0인 정점들을 방문하고, 방문수를 구하면 된다.
 * 인접 방문은 배추문제와 같이 상하좌우를 방문함.
 */
public class Q2583 {
    static int m, n, k;
    static int[][] a;
    static boolean[][] visited;
    static int count, rectangle;
    static int[] moveX = {-1, 0, 0, 1};
    static int[] moveY = {0, 1, -1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();   //가로길이
        n = sc.nextInt();   //세로길이
        k = sc.nextInt();   //직사각형 개수

        //n*m 행렬 = 세로가 n 가로가 m인 행렬
        a = new int[n][m];
        visited = new boolean[n][m];

        while(k > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int i = y1;i < y2;i++){
                for(int j = x1;j < x2;j++){
                    a[j][i] = 1;    //주어진 직사각형에 해당하는 곳에 1을 삽입
                }
            }
            k--;
        }
        //결과를 저장할 ArrayList
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(!visited[i][j] && a[i][j] == 0){
                    //System.out.println("i : "+i+", j : "+j);
                    dfs(i, j);
                    count++;    //인접한 블록을 찾고나면 count 1 증가
                    result.add(rectangle);
                    rectangle = 0;   //초기화
                }
            }
        }
        System.out.println(count);
        Collections.sort(result);
        for(int i = 0;i <result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        /*
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        */
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        rectangle++;        //방문한 정점의 갯수가 직사각형이 아닌 영역의 넓이
        //System.out.print(x+ " -> "+y+"\n");

        //상 하 좌 우 좌표 이동 후, dfs
        for(int i = 0;i < 4;i++){
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            //System.out.println("new x : "+newX+", new y :"+newY);
            if((newX >= 0 && newX < n) && (newY >= 0 && newY < m)){
                if(!visited[newX][newY] && a[newX][newY] == 0){
                    dfs(newX, newY);
                }
            }
        }
    }
}
