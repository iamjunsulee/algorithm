package algorithm.baekjoon.inOutput;

import java.util.Scanner;
/*
 * 별찍기 문제들
 */
public class Q2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printStar12(n);
	}
	public static void printStar1(int n){
		for(int i = 1;i <= n;i++) {
			for(int j = 0;j < i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void printStar2(int n){
		for(int i=n;i>0;i--){
			for(int j=0;j<=n-1;j++){
				if(j < i-1)
					System.out.print(" ");
				if(j >= i-1)
					System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void printStar3(int n){
		for(int i = n;i > 0;i--) {
			for(int j = 0;j < i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void printStar4(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<=n-1;j++){
				if(i>j)
					System.out.print(" ");
				if(i<=j)
					System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void printStar5(int n) {
		for(int i = 1;i <= n;i++) {
			for(int k = n-i;k >0;k--) {
				System.out.print(" ");
			}
			for(int j = 1;j <= 2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void printStar8(int n) {
		for(int i = 1;i <= n;i++) {
			for(int j = 1;j <= n;j++) {
				if(j <= i) {
					System.out.print("*");
				}else {
					System.out.print("8");
				}
			}
			for(int k = 1;k <= n;k++) {
				if(k <= n-i) {
					System.out.print("8");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for(int i = n-1;i > 0;i--) {
			for(int j = 1;j <= n;j++) {
				if(j <= i) {
					System.out.print("*");
				}else {
					System.out.print("8");
				}
			}
			for(int k = 1;k <= n;k++) {
				if(k <= n-i) {
					System.out.print("8");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public static void printStar9(int n) {
		for(int i = n;i >0;i--) {
			for(int k = n-i;k > 0;k--) {
				System.out.print("8");
			}
			for(int j = 1;j <= 2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 2;i <= n;i++) {
			for(int k = n-i;k > 0;k--) {
				System.out.print("8");
			}
			for(int j = 1;j <= 2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void printStar12(int n) {
		for(int i = 1;i <= n;i++) {
			for(int j = 1;j <= n-i;j++) {
				System.out.print("8");
			}
			for(int k = i;k  > 0;k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = n-1;i > 0;i--) {
			for(int j = 1;j <= n-i;j++) {
				System.out.print("8");
			}
			for(int k = i;k  > 0;k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
