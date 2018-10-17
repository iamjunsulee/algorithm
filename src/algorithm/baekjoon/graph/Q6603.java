package algorithm.baekjoon.graph;

import java.util.Scanner;

/**
 * Created by jslee on 2018-10-17.
 * 로또문제
 * 임의의 숫자 k개가 있을 때, 6개의 수를 골라 만들수있는 모든 경우의 수
 * dfs하다가 6개 고르고나면 백트레킹 통해 고르지 않은 다음 수를 고른다.
 */
public class Q6603 {
    static int[] num;
    static int size, count;
    static StringBuffer sb;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //마지막에 0이 입력된다했으므로
        while((size = sc.nextInt()) != 0){
            num = new int[13];  // 6 < k < 13
            sb = new StringBuffer();

            for(int i = 0;i < size;i++){
                num[i] = sc.nextInt();
            }

            for(int i = 0;i < size;i++){
                count = 1;
                dfs(i, num[i] + " ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void dfs(int start, String str){
        //System.out.println("start : "+start+", str : "+str);
        //6개인 경우
        if(count == 6){
            sb.append(str);
            sb.append("\n");
        }else{
            for(int i = start+1;i < size;i++) {
                count++;
                //System.out.println("count : "+count);
                dfs(i, str + num[i] + " ");
            }
        }
        count--;    //backtracking
    }
}
