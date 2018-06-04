package algorithm.baekjoon.dynamic;

import java.util.Scanner;
/*
 * 붕어빵 판매
 */
public class Q11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//붕어빵 개수
		int[] price = new int[1001];
		int[] result = new int[1001];
		
		for(int i = 1;i <= n;i++) {
			price[i] = sc.nextInt();
		}
		
		result[1] = price[1];
		for(int i = 2;i <= n;i++) {
			for(int j = 1;j <= i;j++) {
				System.out.println("result["+(i-j)+"] + price["+j+"], result["+i+"]");
				result[i] = Math.max(result[i-j] + price[j], result[i]);
			}
			System.out.println(result[i]);
		}
		
		System.out.println(result[n]);
	}
}
