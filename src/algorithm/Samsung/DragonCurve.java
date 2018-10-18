package algorithm.Samsung;

import java.util.ArrayList;
import java.util.Scanner;

public class DragonCurve {
	static int[][] point = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//드래곤 커브 개수
		
		while(N > 0) {
			int x = sc.nextInt();	//시작점 x 좌표
			int y = sc.nextInt();	//시작점 y 좌표
			int d = sc.nextInt();	//시작방향
			int g = sc.nextInt();	//세대
			
			solution(x, y, d, g);
			N--;
		}
		//정사각형 찾기 -> 4곳의 좌표에 대해 point 배열 값이 1이면 정사각형
		int result = 0;
		for(int i = 0;i < 100;i++) {
			for(int j = 0;j < 100;j++) {
				if(point[i][j] == 1 && point[i+1][j] == 1 && point[i][j+1] == 1 & point[i+1][j+1] == 1) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	/**
	 * 문제 해결 함수
	 * @param x 시작점 x 좌표
	 * @param y 시작점 y 좌표
	 * @param d 시작방향
	 * @param g 세대
	 */
	public static void solution(int x, int y, int d, int g) {
		ArrayList<Integer> directions = new ArrayList<Integer>();	//방향
		directions.add(d);
		//0부터 g세대까지 
		for(int i = 0;i < g;i++) {
			int size = directions.size();
			//다음 방향 설정
			//끝에서 부터 다음 방향으로 전환이 되기때문에 size-1 값부터 시작
			for(int j = size-1;j >= 0;j--) {
				int from = directions.get(j);
				int to = (from + 1) % 4;	//3 -> 0으로 보내기위해서
				directions.add(to);
			}
		}
		//좌표 설정
		point[x][y] = 1;
		int size = directions.size();
		
		for(int i = 0;i < size;i++) {
			int dir = directions.get(i);
			
			switch(dir) {
			case 0:
				x++;
				break;
			case 1:
				y--;
				break;
			case 2:
				x--;
				break;
			case 3: 
				y++;
				break;
			}
			point[x][y] = 1;
		}
	}
}
