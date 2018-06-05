package algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jslee on 2018-06-06.
 * 국영수
 */
public class Q10825 {
    static class Score implements Comparable<Score>{
        int korean, english, math;
        String name;

        Score(String name, int korean, int english,int math){
            this.korean = korean;
            this.english = english;
            this.math = math;
            this.name = name;
        }
        @Override
        public int compareTo(Score s){
            if(this.korean < s.korean){//국어 점수가 감소하는 순서로
                return 1;
            }else if(this.korean == s.korean){    //국어점수 같으면 영어 점수가 증가하는 순서로
                if(this.english < s.english){
                    return -1;
                }else if(this.english == s.english){//국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
                    if(this.math < s.math){
                        return 1;
                    }else if(this.math == s.math){//모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
                        return this.name.compareTo(s.name);
                    }else{
                        return -1;
                    }
                }else{
                    return 1;
                }
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //입력 수
        Score[] scores = new Score[n];

        for(int i = 0;i < n;i++){
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();

            scores[i] = new Score(name, korean, english, math);
        }
        Arrays.sort(scores);

        for(int i = 0;i < n;i++){
            System.out.print(scores[i].name+"\n");
        }
    }
}
