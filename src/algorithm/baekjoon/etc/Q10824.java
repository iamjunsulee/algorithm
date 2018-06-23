package algorithm.baekjoon.etc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 네 수
 */
public class Q10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputs = br.readLine();
        StringTokenizer st = new StringTokenizer(inputs);
        String[] inputNumber = new String[4];

        for(int i=0; i < 4;i++){
            inputNumber[i] = st.nextToken();
        }
        //문자열 붙인 다음에 타입 바꿔서 더하면 끝
        String first = inputNumber[0] + inputNumber[1];
        String second = inputNumber[2] + inputNumber[3];
        long result = Long.parseLong(first) + Long.parseLong(second);   //범위가 1<= A, B, C, D <= 1000000 이므로 long 타입으로 변경
        //출력
        bw.write(result+"\n");
        br.close();
        bw.close();
    }
}
