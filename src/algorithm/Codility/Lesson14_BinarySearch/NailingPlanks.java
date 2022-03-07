package algorithm.codility.Lesson14_BinarySearch;

import java.util.Arrays;

/*
You are given two non-empty arrays A and B consisting of N integers.
These arrays represent N planks. More precisely, A[K] is the start and B[K] the end of the K−th plank.
Next, you are given a non-empty array C consisting of M integers.
This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.
We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].
The goal is to find the minimum number of nails that must be used until all the planks are nailed.
In other words, you should find a value J such that all planks will be nailed after using only the first J nails.
More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..30,000];
each element of arrays A, B and C is an integer within the range [1..2*M];
A[K] ≤ B[K].
 */
public class NailingPlanks {
    public static void main(String[] args) {
        int[] a = {1, 4, 5, 8};
        int[] b = {4, 5, 9, 10};
        int[] c = {4, 6, 7, 10, 2};
        System.out.println(solution(a, b, c));
    }
    public static int solution(int[] A, int[] B, int[] C) {
        int start = 1;
        int end = C.length;
        int answer = -1;
        //binary search
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isMissing(A, B, C, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    private static boolean isMissing(int[] a, int[] b, int[] c, int mid) {
        boolean missing = false;
        int[] nails = new int[c.length * 2 + 1];
        for (int i = 0; i < mid; i++) { //중간값까지만 카운트
            nails[c[i]] = 1;
        }
        for (int i = 1; i < nails.length; i++) {
            nails[i] += nails[i - 1];   //해당 위치까지 nail의 수 표시
        }
        for (int i = 0; i < a.length; i++) {
            if (nails[a[i] - 1] == nails[b[i]]) {   //값이 같다는 뜻은 해당 위치에 못이 없다는 뜻
                missing = true;
            }
        }
        return missing;
    }
}
