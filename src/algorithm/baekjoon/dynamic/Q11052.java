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
		/*
		 * 붕어빵이 4개일 때 최대수익은
		 * 붕어빵 3개일 떄 최대 수익 + 붕어빵 1개 가격
		 * 붕어빵 2개일 때 최대 수익 + 붕어빵 2개 가격
		 * 붕어빵 1개일 때 최대 수익 + 붕어빵 3개 가격
		 * 붕어빵 0개일 때 최대 수익 + 붕어빵 4개 가격
		 * 위 4가지 경우 중 최대 값이 된다.
		 */
		result[1] = price[1];	//한 개일 때는 하나 가격이 최대
		for(int i = 2;i <= n;i++) {
			for(int j = 1;j <= i;j++) {
				//System.out.println("result["+(i-j)+"] + price["+j+"], result["+i+"]");
				result[i] = Math.max(result[i-j] + price[j], result[i]);
			}
			//System.out.println(result[i]);
		}
		
		System.out.println(result[n]);
	}
}
