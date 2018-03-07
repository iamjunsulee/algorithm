package backjun.sort;

import java.util.Scanner;

public class q1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int score = sc.nextInt();
		int p = sc.nextInt();
		int[] scoreList = new int[n+1];
		
		for(int i=0;i<n;i++){
			scoreList[i] = sc.nextInt();
		}
		sc.close();
		sort_descending(scoreList,n);

		if(scoreList[n-1] >= score && n == p){
			System.out.print(-1);
		}else{
			int rank = 1;
			for(int i=0;i<n;i++){
				if(scoreList[i] > score){
					rank++;
				}else{
					break;
				}
			}
			System.out.print(rank);
		}
	}
	
	public static void sort_descending(int[] num, int size){
		int max,temp;
		for(int i=0;i<size-1;i++){
			max = i;
			for(int j=i;j<size;j++){
				if(num[j] > num[max]){
					max = j;
				}
			}
			temp = num[max];
			num[max] = num[i];
			num[i] = temp;
		}
	}
}

