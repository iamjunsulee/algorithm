package algorithm.Samsung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gabokchi {
	static int[][] sea = new int[20][20];
	static boolean[][] visited;
	static int N;		//배열 가로, 세로 사이즈
	static int[] x = {-1, 0, 0, 1};		//상하좌우
	static int[] y = {0, 1, -1, 0};		//상하좌우
	static Fish me;	//개복치
	static int fish_size, eat, result;
	static ArrayList<Fish> food = new ArrayList<Fish>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		//input
		for(int i = 0;i < N;i++) {
			for(int j = 0;j < N;j++) {
				int input = sc.nextInt();
				sea[i][j] = input;
				if(input == 9) {
					me = new Fish(i,j,0);
					fish_size = 2;
					eat = 0;
					sea[i][j] = 0;
				}	
			}
		}
		
		while(true) {
			visited = new boolean[20][20];		//방문 초기화
			food.clear();	//먹이 초기화
			solve();			//bfs
			if(food.size() == 0) break;	//먹을 물고기가 없는 경우 반복 종료
			//거리가 짧은순으로, 같으면 위쪽, 왼쪽순으로 정렬
			Collections.sort(food, new Comparator<Fish>() {
				@Override
				public int compare(Fish f1, Fish f2) {
					if(f1.time < f2.time) {
						return -1;
					}else if(f1.time > f2.time) {
						return 1;
					}else{
						if(f1.x < f2.x) {
							return -1;
						}else if(f1.x > f2.x) {
							return 1;
						}else {
							if(f1.y < f2.y) {
								return -1;
							}else if(f1.y > f2.y) {
								return 1;
							}else {return 0;}
						}
					}
				}
			});
			//정렬 했으므로 최소거리 먹이는 첫번째 원소
			Fish f = food.get(0);
			//System.out.println("x : "+f.x+", y : "+f.y+", size : "+fish_size+", distance : "+f.time);
			//먹이를 잡아먹으므로 위치 이동 및 먹이 삭제
			me.x = f.x;
			me.y = f.y;
			eat++;
			sea[f.x][f.y] = 0;
			
			if(fish_size == eat) {
				fish_size++;
				eat = 0;
			}
			
			result += f.time;
		}
		System.out.println(result);
	}
	
	public static void solve() {
		Queue<Fish> list = new LinkedList<Fish>();
		list.add(me);
		visited[me.x][me.y] = true;
		
		while(!list.isEmpty()) {
			Fish top = list.poll();
			int cur_x = top.x;
			int cur_y = top.y;
			int cur_time = top.time;
			//인접한 상하좌우 확인
			for(int i =0;i < 4;i++) {
				int next_x = cur_x + x[i];
				int next_y = cur_y + y[i];
				//범위안에 속하는 경우,

				if((next_x >= 0 && next_x < N) && (next_y >= 0 && next_y < N)) {
					if(!visited[next_x][next_y]) {
						visited[next_x][next_y] = true;		//방문 처리
						
						if(sea[next_x][next_y] == 0 || sea[next_x][next_y] == fish_size) {
							list.add(new Fish(next_x, next_y, cur_time+1));	
						}else if(sea[next_x][next_y] < fish_size) {//크기가 작은 경우, 먹이 리스트에 삽입
							food.add(new Fish(next_x, next_y,cur_time+1));
						}
					}
				}
			}
		}
	}

}

class Fish{
	int x, y, time;
	
	Fish(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
