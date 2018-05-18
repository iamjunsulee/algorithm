package algorithm.baekjoon.inOutput;

import java.util.Scanner;

public class Q11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		int start = 0, end = 0;
		for(int i = 0;i<=input.length()/10;i++) {
			start = 10*i;
			end = 10 + start;
			if(end > input.length()) {end = input.length();}
			System.out.println(input.substring(start,end));
		}
	}
}
