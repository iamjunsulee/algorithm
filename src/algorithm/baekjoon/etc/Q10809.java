package algorithm.baekjoon.etc;

import java.io.*;
import java.util.Arrays;

/**
 * 알파벳 찾기
 */
public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputs = br.readLine();
        int[] alphabet = new int[26];
        char[] ch = inputs.toCharArray();
        Arrays.fill(alphabet, -1);      //초기값을 -1로 초기화

        for(int i =0;i < ch.length;i++){
            alphabet[ch[i]-'a'] = inputs.indexOf(ch[i]);    //해당 알파벳의 위치를 indexOf 함수로 가져온다.
        }
        //출력
        for(int result : alphabet) {
            bw.write(result+" ");
        }
        br.close();
        bw.close();
    }
}
