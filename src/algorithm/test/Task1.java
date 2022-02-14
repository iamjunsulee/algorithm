package algorithm.test;

import java.util.Arrays;

/*
가위바위보 게임
단, 한 명은 같은 거만 내는 전략을 취한다고 할 때 최대 점수를 출력하는 문제
 */
public class Task1 {
    public static void main(String[] args) {
        String s = "RSPRS";
        String s2 = "PPPPRRSSSSS";
        System.out.println(solution(s));
        System.out.println(solution(s2));
    }
    public static int solution(String G) {
        int[] R = new int[G.length()+1];
        int[] P = new int[G.length()+1];
        int[] S = new int[G.length()+1];
        for (int i = 0;i < G.length();i++) {
            if (G.charAt(i) == 'S') {
                R[i+1] = R[i] + 2;
                P[i+1] = P[i];
                S[i+1] = S[i] + 1;
            }
            if (G.charAt(i) == 'R') {
                R[i+1] = R[i] + 1;
                P[i+1] = P[i] + 2;
                S[i+1] = S[i];
            }
            if (G.charAt(i) == 'P') {
                R[i+1] = R[i];
                P[i+1] = P[i] + 1;
                S[i+1] = S[i] + 2;
            }
        }

        int maxS = S[G.length()];
        int maxP = P[G.length()];
        int maxR = R[G.length()];

        System.out.println(Arrays.toString(S));
        System.out.println(Arrays.toString(P));
        System.out.println(Arrays.toString(R));
        return Math.max(Math.max(maxS, maxP), maxR);
    }
}
