package algorithm.baekjoon.etc;

import java.util.Scanner;

/**
 * 최소공배수
 */
public class Q1934 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        for(int i = 0;i < size;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(lcm(a, b));
        }
    }
    //Greatest Common Divisor : 최대공약수
    public static int gcd(int a, int b){
        int remain;
        while(b != 0){
            remain = a % b;
            a = b;
            b = remain;
        }
        return a;
    }
    //Least Common Multiple : 최소공배수
    //최대공약수를 사용하면 쉽다.
    public static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
}
