package algorithm.baekjoon.etc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 최대공약수
 */
public class Q1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputs = br.readLine();
        StringTokenizer st = new StringTokenizer(inputs);
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        for(int i = 0;i < gcd(a,b);i++){
            bw.write("1");
        }
        br.close();
        bw.close();
    }
    //Greatest Common Divisor : 최대공약수
    //입력받은 수를 1의 갯수로 다시 수를 바꾸면 숫자가 너무 커진다.
    //굳이 바꿀것이 아니라 입력받은 수들의 최대 공약수만큼 1을 출력하면 된다.
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
