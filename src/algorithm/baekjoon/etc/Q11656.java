package algorithm.baekjoon.etc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 접미사 배열
 */
public class Q11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputs = br.readLine();
        ArrayList<String> suffixArr = new ArrayList<String>();
        //문자를 자르는 방법은 substring 사용
        //index를 증가시켜가면서 자른다.
        for(int i = 0;i < inputs.length();i++){
            suffixArr.add(inputs.substring(i,inputs.length()));
        }
        //정렬
        Collections.sort(suffixArr);
        //출력
        for(String suffix : suffixArr){
            bw.write(suffix+"\n");
        }
        br.close();
        bw.close();
    }
}
