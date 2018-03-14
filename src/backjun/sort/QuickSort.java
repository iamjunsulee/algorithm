package backjun.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1<=N<=1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 
 * 이 수는 절대값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class QuickSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		int[] data = new int[size];
		
		for(int i = 0;i < size;i++){
			data[i] = Integer.parseInt(br.readLine());
		}
		
		quickSort(data,0,size-1);
		
		for(int i = 0;i < size;i++){
			bw.write(data[i]+"\n");
		}
		bw.close();
		br.close();
	}
	
	public static void quickSort(int[] data, int start, int end){
		if(start < end){
//			System.out.println("start : "+start+", end : "+end);
			int pivot = data[start];	//기준값 설정
			int left = start+1;
			int right = end;
			int temp;

			while(left < right){
				while(pivot < data[right] && start < right){right--;}
				while(pivot > data[left] && left < end){left++;}
//				System.out.println("right : "+right+", left : "+left);
				if(right > left){
					temp = data[right];
					data[right] = data[left];
					data[left] = temp;
				}
//				for(int i=0;i<data.length;i++){
//					System.out.print(data[i]+" ");
//				}
//				System.out.println();
			}
			if(data[right] < data[start]){
				temp = data[right];
				data[right] = data[start];
				data[start] = temp;
			}
//			for(int i=0;i<data.length;i++){
//				System.out.print(data[i]+" ");
//			}
//			System.out.println();
			quickSort(data,start,right-1);
			quickSort(data,right+1,end);
		}
	}
}
