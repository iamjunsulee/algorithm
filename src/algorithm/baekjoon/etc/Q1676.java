package algorithm.baekjoon.etc;

import java.util.Scanner;

/*
 * 팩토리얼 0의 개수
 * 0은 10이 곱해질때마다 하나씩 생긴다.즉, 10이 몇 번 곱해지는지에 따라 0의 갯수가 정해진다.
 * 10은 2와 5로 이루어져있으니, 2와 5의 개수를 세면 된다.
 */
public class Q1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int count = 0;
		//2의 개수는 많기 때문에 5의 개수만 세어도 충분하다.
		//500이하의 5의 배수는 5, 25, 125가 있으므로 해당 수로 나눠떨어지는 수의 개수를 센다.
		for(int i = 1;i <= input;i++) {
			if(i % 5 == 0)
				count++;
			if(i % 25 == 0)
				count++;
			if(i % 125 == 0)
				count++;
		}
		System.out.println(count);
	}
}
