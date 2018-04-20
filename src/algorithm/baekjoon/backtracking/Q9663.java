package algorithm.baekjoon.backtracking;

import java.util.Scanner;

/*
 * N Queen 문제
 * 퀸의 능력상 한 줄에 하나만 놓을 수 있다는 점을 활용해야한다.
 * 한 줄에 하나씩만 놓기 때문에 1차원 배열을 선언해도 된다.
 */
public class Q9663 {
	static int[] queen;
	static int size = 0, count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();	//사이즈
		queen = new int[size+1];
		
		for(int i = 1;i <= size;i++) {
			queen[1] = i;		//첫번째 퀸을 i 위치에 놓는다.
			dfs(1);
		}
		System.out.println(count);
	}
	
	public static void dfs(int x) {
		System.out.println(x+"번째 row");
		if(x == size) {
			System.out.print("퀸의 위치 = ");
			for(int i = 1;i <= size;i++) {
				System.out.print(queen[i]+" ");
			}
			System.out.println();
			count++;
		}else {
			for(int i = 1;i <= size;i++) {
				queen[x+1] = i;				//2~4번째 퀸을 i에 놓는다. 
				System.out.println(isPossible(x+1));
				if(isPossible(x+1)) {		//해당 위치에 퀸을 놓아도 되는지 확인
					dfs(x+1);					//다음 퀸을 놓을 곳을 찾는다.
				}else {							//놓을 수 없다면
					queen[x+1] = 0;		//백트래킹, 해당 row의 퀸 위치 초기화 시켜줌
				}
			}
		}
	}
	//퀸을 놓을 수 있는지 확인하는 함수
	public static boolean isPossible(int x) {
		for(int i = 1;i < x;i++) {
			if(queen[x] == queen[i]) {											//같은 열에 있는 경우
				return false;
			}
			//queen[1] = 3, queen[2] = 2 이면, 서로 대각선에 위치
			//index 차이와 값의 차이는 절대값 1로 같다.
			if(Math.abs(queen[x] - queen[i]) == Math.abs(x-i)) {	//대각선에 있는 경우
				return false;
			}
		}
		return true;
	}
}
