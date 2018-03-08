package backjun.sort;

import java.util.Scanner;

public class q10989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] data = new int[size+1];
		
		for(int i=0;i<size;i++){
			data[i] = sc.nextInt();
		}
		quickSort(data,0,size-1);
//		for(int i=0;i<size;i++){
//			System.out.println(data[i]);
//		}
	}
	
	public static void quickSort(int[] data,int left,int right){
		int l = left;
		int r = right;
		int pivot = data[left];
		
		if(l <= r){
			while(true){
				if(pivot < data[r]){
					r--;
				}
				if(pivot >= data[l]){
					l++;
				}
				if(l < r){
					swap(data,l,r);
					for(int i=0;i<data.length-1;i++){
						System.out.print(data[i]+" ");
					}
				}else{
					break;
				}
			}
			System.out.println();
			swap(data,left,r);
			for(int i=0;i<data.length-1;i++){
				System.out.print(data[i]+" ");
			}
			quickSort(data,left,r-1);
			quickSort(data,r+1,right);
		}
	}
	
	public static void swap(int[] data,int idx1, int idx2){
		int temp = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = temp;
	}
}
