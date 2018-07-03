package algorithm.baekjoon.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
/*
 * 소수 찾기
 */
public class Q1978 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());		//입력받은 숫자 개수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] num = new int[size];	//주어진 수 저장할 배열
		for(int i = 0;i < size;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		/*
		 * 소수란 ? 약수가 1과 자기 자신 뿐인 수
		 * 어떤 수의 배수이면 안됨. 
		 */
		int count = 0;
		boolean isPrime = true;
		for(int i = 0;i < size;i++) {
			isPrime = true;
			if(num[i] > 1) {
				for(int j = 2;j < num[i];j++) {
					if(num[i] % j == 0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) {
					count++;
				}
			}
		}
		bw.write(count+"\n");
		br.close();
		bw.close();
	}
}
