package algorithm.Baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 거스름돈 문제
 * 타로는 자주 JOI잡화점에서 물건을 산다. 
 * JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 갯수가 가장 적게 잔돈을 준다. 
 * 타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 갯수를 구하는 프로그램을 작성하시오.
 * 예를 들어 입력된 예1의 경우에는 아래 그림에서 처럼 4개를 출력해야 한다.
 * 
 * 입력
 * 입력은 한줄로 이루어져있고, 타로가 지불할 돈(1 이상 1000미만의 정수) 1개가 쓰여져있다.
 * 
 * 출력
 * 제출할 출력 파일은 1행으로만 되어 있다. 잔돈에 포함된 매수를 출력하시오.
 * 
 * 예제입력
 * 380
 * 예제출력
 * 4
 */
public class q5585 {
	private int coins[] = {500, 100, 50, 10, 5, 1};//동전 종류
	private int minCount[];				//최소개수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		q5585 dynamic = new q5585();
		int value = Integer.parseInt(br.readLine());
		
		bw.write(dynamic.giveChange(1000 - value)+"\n");
		
		bw.close();
		br.close();
	}
	public int giveChange(int value) {
		minCount = new int[1001];
		minCount[0] = 0;
		for(int i = 1;i <= value;i++) {
			minCount[i] = 10000;			// 초기값 큰값으로 설정
		}
		for(int i = 1;i <= value;i++) {
			for(int j = 0;j < coins.length;j++) {	//거스름돈 개수만큼 반복
				if(i - coins[j] >= 0 && minCount[i] > minCount[i-coins[j]]+1) {//작은 값일 경우, 체인지
					minCount[i] = minCount[i-coins[j]]+1;	
					System.out.println("잔돈 : "+i+", count["+i+"] = count["+i+"-"+coins[j]+"]+1 = "+minCount[i]);
				}
			}
		}
		return minCount[value];
	}
}
