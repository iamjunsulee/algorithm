package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 골드바흐의 추측
 * 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
 */
public class Q6588 {
	static int[] num = new int[1000000+1];
	static int end = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		setPrime();
		
		while(true){
			int input =  Integer.parseInt(br.readLine());
			boolean isTrue = false;	//홀수 소수 합으로 나타낼 수 없는 경우 체크
			
			if(input == 0) {
				break;
			}
			//1을 제외한 홀수부터니까 3부터 시작, 홀수만 체크하므로 +2 증가
			for(int i = 3;i <= input;i+=2) {	
				if(num[i] != 0 && num[input-i] != 0) {
					bw.write(input+" = "+i+" + "+(input-i)+"\n");
					isTrue = true;
					break;	//b-a가 가장 큰 것만 출력하기 위해 하나를 찾으면 반복문을 빠져나온다.
				}
			}
			if(!isTrue) {
				bw.write("Goldbach's conjecture is wrong."+"\n");
			}
		}
		br.close();
		bw.close();
	}
	
	public static void setPrime() {
		//입력받은  수까지 배열에 초기화
		for(int i = 2;i <= end;i++) {
			num[i] = i;
		}
		
		for(int i = 2;i <= end;i++) {	//나누는 값
			if(num[i] == 0) {				//이미 체크된 경우 건너뜀
				continue;
			}
			for(int j = i+i;j <= end;j+=i) {	//i의 배수들은 소수가 아님			
				//System.out.println("j = "+j);
				num[j] = 0;
			}
		}
	}
}
