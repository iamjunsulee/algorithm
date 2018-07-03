package algorithm.baekjoon.etc;

import java.util.Scanner;
/*
 * 조합 0의 개수
 * nCr = n! / (n-r)!r! 이므로 분자의 0의 개수에서 분모의 0의 개수를 빼주면 해당 조합의 0의 개수가 된다.
 */
public class Q2004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long r = sc.nextInt();
		long five = countFive(n) - countFive(r) - countFive(n-r);
		long two = countTwo(n) - countTwo(r) - countTwo(n-r);
		//둘 중에 더 작은 개수만큼 0이 만들어지므로 더 작은 개수를 출력한다.
		System.out.println(five > two? two:five);
	}
	//2의 개수 구하는 함수
	public static long countTwo(long num) {
		long count = 0;
	    
	    for (long i = 2; i <= num; i *= 2)
	        count += num / i;
	    
	    return count;
	}
	//5의 개수 구하는 함수
	//1~ 100 까지 5의 개수는 100/5 + 100/25와 같다.
	public static long countFive(long num) {
		long count = 0;
	    
	    for (long i = 5; i <= num; i *= 5)
	        count += num / i;
	    
	    return count;
	}
}
