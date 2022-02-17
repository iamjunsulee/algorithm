package algorithm.Codility.Lesson5_PrefixSums;

import java.util.Arrays;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        int[] p = {2, 5, 0};
        int[] q = {4, 5, 6};
        String s = "CAGCCTA";
        System.out.println(Arrays.toString(solution(s, p, q)));
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int[] answer = new int[P.length];
        //해당 index까지 문자 개수 저장
        //P, Q 값으로 계산하기 위해 S.length() + 1 크기만큼 생성
        int[] A = new int[S.length() + 1];
        int[] C = new int[S.length() + 1];
        int[] G = new int[S.length() + 1];
        int[] T = new int[S.length() + 1];

        for (int i = 0;i < S.length();i++) {
            if (S.charAt(i) == 'A') {
                A[i+1] = A[i] + 1;
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            if (S.charAt(i) == 'C') {
                A[i+1] = A[i];
                C[i+1] = C[i] + 1;
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            if (S.charAt(i) == 'G') {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i] + 1;
                T[i+1] = T[i];
            }
            if (S.charAt(i) == 'T') {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i] + 1;
            }
        }
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(C));
        System.out.println(Arrays.toString(G));
        System.out.println(Arrays.toString(T));

        for (int i = 0;i < P.length;i++) {
            if (A[Q[i] + 1] - A[P[i]] > 0)
                answer[i] = 1;
            else if (C[Q[i] + 1] - C[P[i]] > 0)
                answer[i] = 2;
            else if (G[Q[i] + 1] - G[P[i]] > 0)
                answer[i] = 3;
            else
                answer[i] = 4;
        }
        return answer;
    }
}
