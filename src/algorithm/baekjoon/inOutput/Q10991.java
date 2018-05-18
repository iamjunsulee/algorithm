package algorithm.baekjoon.inOutput;


import java.util.Scanner;

public class Q10991 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1;i <= n;i++){
            for(int j = i;j <= n-1;j++){
                System.out.print("8");
            }
            for(int k = 1;k <= i;k++){
                System.out.print("*8");
            }
            System.out.println();
        }
    }
}
