package algorithm.baekjoon.graph;

import java.util.Scanner;

/**
 * 섬의 개수
 * 유기농 배추문제와 유사한 문제
 * 인접 정점이 상하좌우에 대각선까지
 */
public class Q4963 {
	static int[][] island;
    static boolean[][] visited;
    static int[] mX = {-1, 0, 0, 1, -1, -1, 1, 1};	//상하좌우 대각선
    static int[] mY = {0, 1, -1, 0, 1, -1, 1, -1};
	static int w= 0, h = 0;	//지도 가로 세로
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();	//가로길이
			h = sc.nextInt();	//세로길이
			int count = 0;		//섬의 개수
			
			if(w == 0 && h == 0) break;		//0일 경우 종료
			
			island = new int[w][h];
			visited = new boolean[w][h];
			
			for(int i =0;i < h;i++) {
				for(int j = 0;j < w;j++) {
					island[j][i] = sc.nextInt();
				}
			}
			
			for(int i =0;i < h;i++) {
				for(int j = 0;j < w;j++) {
					if(island[j][i] == 1 && !visited[j][i]){
						dfs(j,i);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        //System.out.print(x+ " -> "+y+"\n");

        //좌표 이동 후, dfs
        for(int i = 0;i < 8;i++){
            int newX = x + mX[i];
            int newY = y + mY[i];
            //System.out.println("new x : "+newX+", new y :"+newY);
            if((newX >= 0 && newX < w) && (newY >= 0 && newY < h)){
                if(!visited[newX][newY] && island[newX][newY] == 1){
                    dfs(newX, newY);
                }
            }
        }
    }
}
