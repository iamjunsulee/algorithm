package algorithm.Codility.Lesson6_Sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] a = {-3, 1, 2, -2, 5, 6};
        System.out.println(solution(a));
    }
    //key : 양수 3개 곱, 음수2개 양수1개 곱 중 최대값
    public static int solution(int[] A) {
        Arrays.sort(A);
        int max_positive = A[A.length - 3] * A[A.length - 2] * A[A.length - 1];
        int max_negative = A[0] * A[1] * A[A.length - 1];
        return Math.max(max_negative, max_positive);
    }
}
