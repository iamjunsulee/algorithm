package algorithm.Codility.Lesson2_Arrays;

import java.util.Arrays;

/*
The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
A = [3, 8, 9, 7, 6], K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:
[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 */
public class CyclicRotation {
    public static void main(String[] args) {
        int[] a = {3, 8, 9, 7, 6};
        int[] a2 = {1, 2, 3, 4};
        int[] a3 = {0, 0, 0};
        System.out.println(Arrays.toString(solution(a, 3)));
    }

    //key : 나머지 연산
    public static int[] solution(int[] A, int K) {
        int[] result = new int[A.length];

        for (int i = 0;i < A.length;i++) {
//            if (i + K >= A.length) {
//                result[i+K-A.length] = A[i];
//            }else {
//                result[i+K] = A[i];
//            }
            int newIdx = (i + K) % A.length;
            result[newIdx] = A[i];
        }
        return result;
    }
}
