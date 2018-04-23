package algorithm.baekjoon.backtracking;

import java.util.Scanner;
/*
 * 스도쿠 문제
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0
 */
public class Q2580 {
	static int[][] sdoku = new int[9][9];
	static int cur_x = 0, cur_y = 0;	//빈 곳 좌표
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력받은 값으로 스도쿠 초기화
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				sdoku[i][j] = sc.nextInt(); 
			}
		}
		sdoku();
		
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				System.out.print(sdoku[i][j]+" "); 
			}
			System.out.println();
		}
	}
	//스도쿠판이 완성됐는지 확인하는 함수
	public static boolean isComplete() {
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(sdoku[i][j] == 0) {//빈 곳인 경우
					cur_x = i;
					cur_y = j;
					return false;
				}
			}
		}
		return true;
	}
	
	public static void sdoku() {
		int x= 0, y = 0;//좌표
		
		if(isComplete()) {//스도쿠판이 완성된 경우, 종료
			return;
		}
		//빈 곳 좌표
		x = cur_x;
		y = cur_y;
		System.out.println("x좌표 : "+x+", y좌표 : "+y);
		
		for(int i = 1;i <= 9;i++) {
			if(isPossible(x, y, i)) {
				sdoku[x][y] = i;		//해당 숫자를 적는다.
				sdoku();
				if(isComplete()) {	//스도쿠판이 완성된 경우, 종료
					return;
				}
				System.out.println("backtracking 시작, x좌표 : "+x+", y좌표 : "+y);
				sdoku[x][y] = 0;	//backtracking
			}
		}
	}
	
	//숫자를 적을 수 있는지 확인
	public static boolean isPossible(int x, int y, int value) {
		int new_x = x / 3 * 3;
		int new_y = y / 3 * 3;
		
		//세로, 가로 확인
		for(int i = 0;i < 9;i++) {
			if(sdoku[i][y] == value || sdoku[x][i] == value) {
				return false;
			}
		}
		//3 * 3 해당 구간 확인
		for(int i = new_x;i <new_x +3;i++) {
			for(int j = new_y;j <new_y +3;j++) {
				if(sdoku[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
