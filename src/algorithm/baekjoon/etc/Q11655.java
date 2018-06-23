package algorithm.baekjoon.etc;

import java.io.*;

/**
 * ROT13
 */
public class Q11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputs = br.readLine();
        char[] ch = inputs.toCharArray();
        char[] change = new char[ch.length];
        //문자 변경은 아스키코드 값으로
        for(int i =0;i < ch.length;i++){
            if(!Character.isDigit(ch[i]) && !Character.isSpaceChar(ch[i])){
                change[i] = (char)((int)ch[i] + 13);
                if(Character.isUpperCase(ch[i])){
                    if(change[i] > 90){
                        change[i] -= 26;
                    }
                }else if(Character.isLowerCase(ch[i])){
                    if(change[i] > 122){
                        change[i] -= 26;
                    }
                }
            }else{//숫자인 경우는 그대로
                change[i] = ch[i];
            }
        }

        for(char result : change) {
            bw.write(result);
        }
        br.close();
        bw.close();
    }
}
