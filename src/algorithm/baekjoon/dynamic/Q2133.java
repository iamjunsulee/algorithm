package algorithm.baekjoon.dynamic;

import java.util.Scanner;
/*
 * 타일 채우기
 */
public class Q2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();				//자연수 N
		int[] result = new int[31];	//범위가 30까지이므로
		
		//홀수의 경우 1*1 공간때문에 채울수가 없음
		result[0] = 1;
		result[1] = 0;
		result[2] = 3;
		if(n % 2 == 0) {
			for (int i = 4; i <= n; i += 2){
				result[i] = result[i-2] * 3;			//2칸이 늘어나기 때문에 2칸일 경우 만들수 있는 경우의 수 3만큼 배가 됨
				System.out.println("result["+i+"] = result["+(i-2)+"] * 3 = "+(result[i-2]*3));
	            for(int j = 4;i-j >= 0;j += 2) {
	            	result[i] += result[i-j] * 2;		
	            	//가운데 1*2짜리가 여러개오는 특이한 모양이 2개씩 있고, 그걸로 만들 수 있는 경우의 수를 더해줘야함
	            	System.out.println("result["+i+"] += result["+(i-j)+"] * 2 = "+(result[i-j]*2));
	            }
	        }
		}
		System.out.println(result[n]);
	}
}
