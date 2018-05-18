package algorithm.baekjoon.inOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10818 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		//int size = 0;
		//size = sc.nextInt();
		//int[] arr = new int[size];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		long[] arr = new long[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < size;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		bw.write(arr[0]+" "+arr[size-1]);
		bw.close();
		br.close(); 
	}
}
