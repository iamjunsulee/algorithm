package algorithm.baekjoon.graph;

import java.util.*;

/**
 * 단지 번호 붙이기
 * 유기농 배추문제와 유사한 문제
 * 인접 정점은 상하좌우
 */
public class Q2667 {
    static char[][] adArr;
    static boolean[][] visited;
    static int[] moveX = {-1, 0, 0, 1};
    static int[] moveY = {0, 1, -1, 0};
    static int size, house;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();    //지도 크기(정사각형)

        adArr = new char[size][size];
        visited = new boolean[size][size];

        String input = sc.nextLine();
        for(int i = 0;i < size;i++){
            input = sc.nextLine();
            char[] ch = input.toCharArray();
            int idx = 0;
            for(char j : ch){
                adArr[i][idx++] = j;
            }
        }
        /*
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size;j++){
               System.out.print(adArr[i][j]);
            }
            System.out.println();
        }
        */
        ArrayList<Integer> result = new ArrayList<Integer>();

        int count = 0;  //단지 수
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size;j++){
               if(!visited[i][j] && adArr[i][j] == '1'){
                  //System.out.println("i : "+i+", j : "+j);
                   dfs(i, j);
                   count++;
                   result.add(house);
                   house = 0;   //초기화
               }
            }
        }
        System.out.println(count);
        Collections.sort(result);
        for(int i = 0;i <result.size();i++){
            System.out.println(result.get(i));
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        house++;        //방문한 정점의 갯수가 단지 내 집 수
        //System.out.print(x+ " -> "+y+"\n");

        //상 하 좌 우 좌표 이동 후, dfs
        for(int i = 0;i < 4;i++){
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            //System.out.println("new x : "+newX+", new y :"+newY);
            if((newX >= 0 && newX < size) && (newY >= 0 && newY < size)){
                if(!visited[newX][newY] && adArr[newX][newY] == '1'){
                    dfs(newX, newY);
                }
            }
        }
    }
}
