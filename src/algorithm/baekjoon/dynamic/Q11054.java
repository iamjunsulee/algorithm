package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 가장 긴 바이토닉 부분 수열
 */
public class Q11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();					//수열 크기
		int[] front = new int[n];			//0부터 n-1위치까지의 증가하는 부분 수열 최대 개수를 저장할 배열
		int[] rear = new int[n];				//n-1위치부터 0까지의 증가하는 부분 수열 최대 개수를 저장할 배열
		int[] result = new int[n];			//결과값 저장할 배열
		int[] number = new int[n];		//숫자 저장할 배열
		
		for(int i = 0;i < n;i++) {
			number[i] = sc.nextInt();
		}
		
		//1개일 경우, 최대값은 자기 자신 1개
		front[0] = 1;
		rear[n-1] = 1;
		//0부터 n-1위치까지의 증가하는 부분 수열
		for(int i = 1;i < n;i++) {
			int max = 0;
			for(int j = 0;j < i;j++) {
				if(number[i] > number[j]) {
					System.out.println("max : "+max+", count : "+front[j]);
					max = Math.max(max, front[j]);
				}
			}
			front[i] = max + 1;
		}
		//n-1위치부터 0까지의 증가하는 부분 수열
		for(int i = n-2;i >= 0;i--) {
			int max = 0;
			for(int j = n-1;j > i;j--) {
				if(number[i] > number[j]) {
					System.out.println("j : "+j+", max : "+max+", count : "+rear[j]);
					max = Math.max(max, rear[j]);
				}
			}
			rear[i] = max + 1;
		}
		/*
		for(int i = 0;i < n;i++) {
			System.out.print(front[i]+" ");
		}
		System.out.println();
		for(int i = 0;i < n;i++) {
			System.out.print(rear[i] + " ");
		}
		System.out.println();
		*/
		for(int i =0;i < n;i++) {
			result[i] = front[i] + rear[i] - 1;		//한 가지 경우가 겹치므로 1을 빼줌
			//System.out.print(result[i] + " ");
		}
		Arrays.sort(result);
		System.out.println(result[n-1]);
	}
}
