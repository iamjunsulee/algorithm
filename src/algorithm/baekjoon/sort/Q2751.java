package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2751 {
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
			int pivot = data[start];	//기준값 설정
			int left = start+1;			//2번째 인덱스를 left로 초기 설정
			int right = end;
			int temp;

			while(left < right){//right가 left보다 크면 정렬이 된 상태
				while(pivot < data[right] && start < right){right--;}	//pivot보다 큰 경우 오른쪽에 있는 게 맞으므로 -1
				while(pivot > data[left] && left < end){left++;}		//pivot보다 작은 경우 왼쪽에 있는 게 맞으므로 +1

				if(right > left){
					temp = data[right];
					data[right] = data[left];
					data[left] = temp;
				}

			}
			//right가 가리키는 값이 더 크다면 바꿀 필요가 없음
			if(data[right] < data[start]){
				temp = data[right];
				data[right] = data[start];
				data[start] = temp;
			}

			quickSort(data,start,right-1);
			quickSort(data,right+1,end);
		}
	}
}
