package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/*
 * 암호코드
 */
public class Q2011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] pwd = input.toCharArray();
		int length = pwd.length;
		int[] result = new int[length+1];	//result[i]는 i 위치까지의 암호 코드 해석 수
		
		/*
		 * result[i] 값을 정하는 데 있어 고려해야 할 것은 i 위치에 
		 * 한 자리수가 오는 경우와 두 자리수가 오는 경우
		 * 한 자리수가 오는 경우는 dp = dp(i-1)+ dp(i)
		 * 두 자리수가 오는 경우는 dp = dp(i-2)+ dp(i)
		 */
		if(length == 1 && pwd[0] == '0') {//길이가 1이면서 값이 0인 경우
				result[length] = 0;		// 암호가 없음
		}else {
			int temp = 0;
			result[0] = 1;	//초기값
			for(int i = 1;i <= length;i++) {
				temp = pwd[i-1]-'0';	//pwd 배열은 idx 0부터, char 0을 빼줘야 숫자 값이 됨(아스키코드참고)
				if(temp >= 1 && temp <= 9) {//한 자리수인 경우
					result[i] = (result[i-1] + result[i])%1000000;
				}
				if(i == 1)continue;
				temp = (pwd[i-1]-'0')+(pwd[i-2]-'0') * 10;	//10을 곱해서 두 자리 숫자로 만들어준다.
				System.out.println(temp);
				if(temp >= 10 && temp <= 26) {//두 자리수인 경우
					result[i] = (result[i-2] + result[i])%1000000;
				}
			}
		}
		System.out.println(result[length]);
	}
}
