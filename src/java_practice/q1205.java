package java_practice;

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
		
		if(scoreList[n-1] >= score && n == p){
			System.out.println(-1);
		}else{
			int rank = 1;
			for(int i=0;i<n;i++){
				if(scoreList[i] > score){
					rank++;
				}else{
					break;
				}
			}
			System.out.println(rank);
		}
	}
}

