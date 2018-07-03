package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 소수 찾기
 */
public class Q1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//M이상 N이하의 소수를 출력
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] num = new int[end+1];
		
		/*
		 * 에라토스테네스의 체 (Sieve of Eratosthenes)
		 * 어떤 특정 숫자까지의 모든 소수를 구한다고 가정할 때,
		 * 특정 숫자까지 배열을 만든 후에 소수가 아닌 것들을 모두 체크한다.
		 * 체크가 안된 수들이 특정 숫자까지의 소수가 되는 셈
		 */
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
		//입력받은 범위 중 소수인 것들을 출력
		for(int i = start;i <= end;i++) {
			if(num[i] != 0) {
				bw.write(num[i]+"\n");
			}
		}
		br.close();
		bw.close();
	}
}
