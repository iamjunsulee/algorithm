package algorithm.baekjoon.inOutput;

import java.util.Scanner;

public class Q10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		
		while(sc.hasNextInt()) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			if(a == 0 && b == 0) {
				break;
			}
			System.out.println(a+b);
		}
	}
}
