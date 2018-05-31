package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 가장 긴 감소하는 부분 수열
 * 가장 긴 증가하는 부분 수열문제(11053번)와 반대의 경우
 */
public class Q11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();					//수열 크기
		int[] increasing = new int[n];	//0부터 n-1위치까지의 증가하는 부분 수열 최대 개수를 저장할 배열
		int[] number = new int[n];		//숫자 저장할 배열
		
		for(int i = 0;i < n;i++) {
			number[i] = sc.nextInt();
		}
		
		increasing[0] =  1;//첫번째 경우는 자기 자신 하나
		for(int i = 1;i < n;i++) {
			int max = 0;
			for(int j = 0;j < i;j++) {
				if(number[i] < number[j]) {//현재보다 큰 값을 찾으면
					System.out.println("max : "+max+", count : "+increasing[j]);
					max = Math.max(max,increasing[j]);//이전까지 최대 증가 개수와 비교하여 최대값 저장
				}
			}
			increasing[i] = max + 1;//큰 값이 없다면 max가 0일테고, 자기 자신만 저장
			System.out.println(i+"번쨰 : "+increasing[i]);
		}
		for(int i = 0;i < n;i++) {
			System.out.println(i+"번쨰 : "+increasing[i]);
		}
		Arrays.sort(increasing);
		System.out.println(increasing[n-1]);
	}
}
