package algorithm.baekjoon.dynamic;

import java.util.Scanner;
/*
 * 제곱수의 합
 */
public class Q1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//자연수 N
		int[] result = new int[n+1];
		
		result[0] = 0;
		for(int i = 1;i <= n;i++) {
			result[i] = i;		//일단 1의 제곱 수의 개수로 초기화, 안그럼 min에 의해 계속 0이 들어감.
		}
		for(int i = 2;i <= n;i++) {
			for(int j = 2;j*j <= i;j++) {//해당 수 범위 내에 존재하는 제곱수가 있으면
				//1로만 이루어진 값과 제곱수로 이루어진 값을 비교하여 최소값을 저장
				result[i] = Math.min(result[i],result[i - j*j]+1);	
				System.out.println(i+" = "+result[i]+", "+(i - j*j)+" = "+result[i-j*j]);
			}
		}
		System.out.println(result[n]);
	}
}
