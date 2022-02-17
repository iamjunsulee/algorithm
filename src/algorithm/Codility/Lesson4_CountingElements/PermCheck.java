package algorithm.Codility.Lesson4_CountingElements;

import java.util.Arrays;

public class PermCheck {
    public static void main(String[] args) {
        int[] a = {4, 1, 3};
        System.out.println(solution(a));
    }
    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0;i < A.length;i++) {
            if (A[i] != i + 1) return 0;
        }
        return 1;
    }
}
