package algorithm.baekjoon.graph;

import java.util.Scanner;
/**
 * 알파벳
 * 반례
 * 3 3
 * ABB
 * BBB
 * CBB
 * 이전에는 백트레킹을 하지 않아서 A B 방문하면 끝나서 최대 방문 정점이 2였다.
 * 하지만, A B C 방문하고 최대 방문 정점은 3이 되야 정답이다.
 * 더 이상 탐색할 정점이 없으면 그 이전 정점으로 돌아가야 한다.(백트레킹)
 * 최대 방문 정점의 수를 출력한다.
 */
public class Q1987 {
    static char[][] vertex;
    static boolean[] visited;
    static int[] moveX = {-1, 0, 0, 1};
    static int[] moveY = {0, 1, -1, 0};
    static int r, c;
    static int count = 1, max = 1;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();   //세로
        c = sc.nextInt();   //가로

        vertex = new char[r][c];
        visited = new boolean[91];  //알파벳 대문자 A~Z 아스키코드값 65~90

        String input = sc.nextLine();   //공백 제거용
        for(int i = 0;i < r;i++){
            input = sc.nextLine();
            char[] ch = input.toCharArray();
            int idx = 0;
            for(char j : ch){
                vertex[i][idx++] = j;
            }
        }
        dfs(0,0);
        System.out.println(max);
    }
    public static void dfs(int x, int y){
        visited[vertex[x][y]] = true;
        count++;    //방문 정점 개수
        System.out.println(vertex[x][y]+" 방문, 이 때의 x :"+x+", y :"+y);

        for(int i = 0;i < 4;i++){
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            if((newX >= 0 && newX < r) && (newY >= 0 && newY < c)){
                System.out.println("방문할 점 : "+vertex[newX][newY]+", 이 때의 x :"+newX+", y :"+newY);
                if(!visited[vertex[newX][newY]]){
                    max = Math.max(count, max);     //최대 방문 정점 개수
                    System.out.println("max : "+max);
                    dfs(newX, newY);
                }
            }
        }
        visited[vertex[x][y]] = false;  //back tracking 하기 위해 방문 정점 초기화
        count--;    //back tracking 하므로 방문 정점 수 -1
    }
}
