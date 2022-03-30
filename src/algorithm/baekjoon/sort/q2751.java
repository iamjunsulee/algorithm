package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q2751 {
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
			int pivot = data[start];	//���ذ� ����
			int left = start+1;			//2 ��° �ε����� left�� �ʱ� ����
			int right = end;
			int temp;

			while(left < right){//right�� left���� ũ�� ������ �� ����
				while(pivot < data[right] && start < right){right--;}	//pivot���� ū ��� �����ʿ� �ִ°� �����Ƿ� -1
				while(pivot > data[left] && left < end){left++;}		//pivot���� ���� ��� ���ʿ� �ִ°� �����Ƿ� +1

				if(right > left){
					temp = data[right];
					data[right] = data[left];
					data[left] = temp;
				}

			}
			//right�� ����Ű�� ���� �� ũ�ٸ� �ٲ� �ʿ䰡����
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
