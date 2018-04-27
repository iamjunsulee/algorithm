package algorithm.baekjoon.dynamic;

import java.util.Scanner;
/*
 * 숫자 삼각형
 7(0,0)
 3(1,0) 8(1,1)
 8(2,0) 1(2,1) 0(2,2)
 2(3,0) 7(3,1) 4(3,2) 4(3,3)
 4(4,0) 5(4,1) 2(4,2) 6(4,3) 5(4,4)
 
 괄호 안 숫자는 배열 인덱스를 뜻한다.
 좌측 끝에 해당하는 (1,0),(2,0),(3,0),(4,0)는 해당 위치까지 더해지는 최대값은 
 바로 위의 값이랑 더한 것이 된다. 다른 곳에서 오는 선택지가 없기 때문, 우측 끝에 위치하는 경우도 마찬가지다.
 가운데 있는 경우는 우측과 좌측에서 오는 경우들이 존재하게 되고, 중복된 선택이 된다.
 이 경우, 그 전까지의 최대값을 더해줘야 해당 위치의 최대값이 된다.
 */
public class Q1932 {
	static int[][] sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//삼각형 크기
		int size = sc.nextInt();
		//초기화
		sum = new int[size][size];
		
		for(int i = 0;i < size;i++) {
			for(int j = 0;j <= i;j++) {
				sum[i][j] = sc.nextInt();
			}
		}
		//좌측 끝, 우측 끝에 위치한 경우, 선택지가 나눠지지않는다.
		//가운데 있는 경우, 선택이 중복됨. 즉, 중복되는 선택을 받는 위치의 경우, 그 중 최대값을 더해줘야한다.
		for(int i = 1;i <size;i++) {
			for(int j = 0;j <= i;j++) {
				if(j == 0) {			//좌측 끝에 위치한 경우
					sum[i][j] += sum[i-1][j];
				}else if(j == i) {	//우측 끝에 위치한 경우
					sum[i][j] += sum[i-1][j-1];
				}else {
					sum[i][j] += Math.max(sum[i-1][j], sum[i-1][j-1]);
				}
			}
		}
		//최대값 
		int max = sum[0][0];
		for(int i = 0;i < size;i++) {
			for(int j = 0;j <= i;j++) {
				if(sum[i][j] > max) {
					max = sum[i][j];
				}
			}
		}
		System.out.println(max);
	}
}
