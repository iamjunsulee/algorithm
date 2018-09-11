package algorithm.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로탐색
 * 최소라는 말이 나오면 BFS
 */
public class Q2178 {
	static char[][] arr;
	static boolean[][] visited;
    static int[] mX = {-1, 0, 0, 1};
    static int[] mY = {0, 1, -1, 0};
    static int N, M, length;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0;i < N;i++) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			
			for(int j = 0;j < ch.length;j++) {
				arr[i][j] = ch[j];
			}
		}
		bfs(0, 0);
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(x, y));//시작점
		visited[x][y] = true;
		length = 0;
		
		while(!q.isEmpty()) {
			length++;
			int size = q.size();

			for(int i = 0;i < size;i++) {
				Point p = q.poll();
				
				if(p.x == N-1 && p.y == M-1) {
					System.out.println(length);
					return;
				}
				
				for(int j = 0;j < 4;j++){
		            int newX = p.x + mX[j];
		            int newY = p.y + mY[j];

		            if((newX >= 0 && newX < N) && (newY >= 0 && newY < M)){
		                if(!visited[newX][newY] && arr[newX][newY] == '1'){
		                	q.add(new Point(newX, newY));        	
		                	visited[newX][newY] = true;
				            //System.out.println("new x : "+newX+", new y :"+newY);
		                }
		            }
		        }
			}
		}
		System.out.println(length);
	}
}
class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
