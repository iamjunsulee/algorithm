package algorithm.baekjoon.etc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * GCD의 합
 */
public class Q9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0;i < testCase;i++){
            String inputs = br.readLine();
            StringTokenizer st = new StringTokenizer(inputs);
            int size = Integer.parseInt(st.nextToken());    //숫자의 개수
            int[] number = new int[100];

            for(int j = 0;j < size;j++){
                number[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;   //long 타입이어야만 통과가 되네?
            for(int j = 0;j < size - 1;j++){
                for(int k = j+1;k < size;k++){
                    sum += gcd(number[j], number[k]);
                }
            }
            bw.write(sum + "\n");
        }
        br.close();
        bw.close();
    }
    //Greatest Common Divisor : 최대공약수
    public static long gcd(long a, long b){
        long remain;
        while(b != 0){
            remain = a % b;
            a = b;
            b = remain;
        }
        return a;
    }
}
