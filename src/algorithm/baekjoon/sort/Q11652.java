package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q11652 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		long[] value = new long[size];
		
		for(int i =0;i < size;i++) {
			value[i] = Long.parseLong(br.readLine());
		}
		//배열 정렬
		Arrays.sort(value);
		//초기 시작값 설정
		long start = value[0];
		int count = 0;			//해당 숫자의 개수
		int maxCount = 0;		//가장 많은 수의 개수
		long maxVal = 0;		//가장 많은 수
		
		for(int i = 0;i < size;i++) {
			if(start != value[i]) {//같지 않은 경우
				if(count > maxCount) {
					maxCount = count;
					maxVal = start;
				}
				count = 1;
				start = value[i];
			}else {//같은 경우
				count++; //개수 증가
			}
		}
		//마지막에 증가된 count값과 비교가 안되므로
		if(count > maxCount) {
			maxCount = count;
			maxVal = start;
		}
		
		bw.write(maxVal+"\n");
		br.close();
		bw.close();
	}
}
