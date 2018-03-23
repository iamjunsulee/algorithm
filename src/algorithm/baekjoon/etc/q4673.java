package algorithm.baekjoon.etc;

import java.util.Arrays;

public class q4673 {
	/*
	 * 셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다. 
	 * 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87이다.
	 * 양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다.
	 * 예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 
	 * 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 이런식으로 다음과 같은 수열을 만들 수 있다. 
	 * 33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
	 * 
	 * n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 
	 * 생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다. 
	 * 
	 * 생성자가 없는 숫자를 셀프 넘버라고 한다. 100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
	 * 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력은 없다.
	 * 10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.
	 * 
	 * 예제출력
		1
		3
		5
		7
		9
		20
		31
		42
		53
		64
		 |
		 |       <-- a lot more numbers
		 |
		9903
		9914
		9925
		9927
		9938
		9949
		9960
		9971
		9982
		9993
	 */
	
	/*
	 * 문제 해결 과정
	 * 1. 우선 각 자리수의 합을 구하는 방법부터 생각해보자
	 * 각 자리 수의 합을 구하기위해서는 양의 정수 n을 몫이 0이 될 때까지, 10으로 나눠준다.
	 * 각 나눗셈을 반복하면서 발생하는 나머지를 다 더하면 각 자리 수의 합이 된다.
	 * 
	 * 2. 생성자가 없는 것을 어떻게 체크할 것인가
	 * 임의의 양의 정수 n에 대해 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열이 만들어진다고 했다.
	 * 고로 d(n) 변환이 된 값에 대해서 selfNumber 배열에 false값을 입력한다.
	 * 1 ~ 10,000 사이의 수에 대해 selfNumber 배열의 값이 true인 값을 출력한다.
	 */
	private static boolean[] selfNumber = new boolean[10040];
	
	public static void main(String[] args) {
		Arrays.fill(selfNumber, true);

		for(int i=1;i<=10000;i++){
			d(i);
			if(selfNumber[i]){
				System.out.println(i);
			}
		}
	}
	// d(n) 함수 
	private static int d(int num){
		int next = 0;
		next = num + positionalSum(num);
	
		if(next <= 5){
			System.out.print("d("+num+") = "+next+" ");
			selfNumber[next] = false;
			return d(next);
		}else{
			System.out.println("d("+num+") = "+next);
			selfNumber[next] = false;
		}
		return next;
	}
	//각 자리수 의 합
	private static int positionalSum(int num){
		int sum = 0;
		int rem = num % 10;	//몫
		int qut = num / 10; //나머지
		
		sum = rem;
		if(qut != 0){
			return sum + positionalSum(qut);
		}
			
		return sum;
	}
}
