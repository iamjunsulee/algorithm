package algorithm.baekjoon.dynamic;

import java.util.Scanner;

public class Q1463 {
	private static int[] count = new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//dp(n);
		System.out.println(dpRecursive(n));
	}
	//BOTTOM-UP 방식 : 시간 148 MS 걸림
	public static void dp(int n) {
		count[1] = 0;
		
		for(int i = 2;i <= n;i++) {
			count[i] = count[i-1]+1;
			if(i % 2 == 0) {
				count[i] = Math.min(count[i], count[i/2]+1);
			}
			if(i % 3 == 0) {
				count[i] = Math.min(count[i], count[i/3]+1);
			}
		}
		System.out.println(count[n]);
	}
	//TOP_DOWN(재귀적 방법)방식 : 시간 3188 MS 걸림
	public static int dpRecursive(int n) {
		count[1] = 0;
		
		if(n>1) {
			if(count[n] != 0)
				return count[n];
			
			count[n] = dpRecursive(n-1)+1;
			if(n % 2 == 0) {
				count[n] = Math.min(dpRecursive(n), dpRecursive(n/2)+1);
			}
			if(n % 3 == 0) {
				count[n] = Math.min(dpRecursive(n), dpRecursive(n/3)+1);
			}
		}
		return count[n];
	}
}
