package algorithm.baekjoon.etc;

import java.util.Scanner;

/*
 * 소인수분해
 * 소인수란 ? 인수(약수) 중에서 소수인 것
 * 소인수분해란? 자연수 N을 소인수들의 곱으로 나타내는 것
 */
public class Q11653 {
	static int[] num = new int[10000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		//setPrime(input);
		
		int num = 2;
		while(true) {
			if(input == 1)break;
			
			if(input % num == 0) {
				input = input / num;	//몫
				System.out.println(num);
			}else {
				num++;
			}
		}
	}
}
