package algorithm.codility.Lesson9_MaximumSliceProblem;

import java.util.Arrays;

/*
A non-empty array A consisting of N integers is given.
A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

A[0] = 3
A[1] = 2
A[2] = 6
A[3] = -1
A[4] = 4
A[5] = 5
A[6] = -1
A[7] = 2

double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.
 */
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] a = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(solution(a));
    }
    //key : Y를 기점으로 나눈다는 점
    public static int solution(int[] A) {
        int[] max_left = new int[A.length];
        int[] max_right = new int[A.length];
        int maxSliceSum = 0;

        for(int i = 1;i < A.length;i++) {
            max_left[i] = Math.max(0, max_left[i-1] + A[i]);
        }

        for(int i = A.length - 2;i >= 0;i--){
            max_right[i] = Math.max(0, max_right[i+1] + A[i] );
        }
        System.out.println(Arrays.toString(max_left));
        System.out.println(Arrays.toString(max_right));

        for(int i = 1;i < A.length - 1;i++) {
            maxSliceSum = Math.max(maxSliceSum, max_left[i - 1] + max_right[i + 1]);
        }
        return maxSliceSum;
    }
}
