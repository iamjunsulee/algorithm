package algorithm.baekjoon.inOutput;

import java.util.Scanner;

public class Q10992 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1;i <= n;i++){
            for(int j = i;j <= n-1;j++){
                System.out.print("8");
            }
            if(i == 1){
                System.out.println("*");
            }
            else if(i == n){
               for(int k = 1;k <= 2*n-1;k++){
                   System.out.print("*");
               }
               System.out.println();
            }else{
                for(int k = 1;k <= 2*i-1;k++){
                    if(k == 1 || k == 2*i-1){
                        System.out.print("*");
                    }else {
                        System.out.print("8");
                    }
                }
                System.out.println();
            }
        }
    }
}
