package algorithm.baekjoon.etc;

import java.io.*;
import java.util.Scanner;

/**
 * 문자열 분석
 */
public class Q10820 {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String inputs = sc.nextLine();
            char ch[] = inputs.toCharArray();

            int upper = 0, lower = 0, digit = 0, space = 0;
            //isDigit, isUpperCase, isLowerCase, isSpaceChar 함수를 사용해서 쉽게 체크가 가능
            for(char input : ch){
                if(Character.isDigit(input)){//숫자인지 체크
                    digit++;
                }else if(Character.isUpperCase(input)){//대문자인지 체크
                    upper++;
                }else if(Character.isLowerCase(input)){//소문자인지 체크
                    lower++;
                }else if(Character.isSpaceChar(input)){//공백인지 체크
                    space++;
                }
            }
            System.out.print(lower+" "+upper+" "+digit+" "+space+"\n");
        }
    }
}
