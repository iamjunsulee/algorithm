package algorithm.Codility.Lesson5_PrefixSums;

public class MinAvgTwoSlice {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        int minPos = 0;
        float min = Integer.MAX_VALUE;

        for (int i = 0;i < A.length - 2;i++) {
            float min2 = (float)(A[i] + A[i + 1]) / 2;
            float min3 = (float)(A[i] + A[i + 1] + A[i + 2]) / 3;

            float minAvr = Math.min(min2, min3);
            if (minAvr < min) {
                min = minAvr;
                minPos = i;
                System.out.println("Min Avr :: " + minAvr);
                System.out.println("minPos :: " + minPos);
                System.out.println("i :: " + i);
            }
        }
        if ((A[A.length - 2] + A[A.length - 1]) / 2 < min) {
            minPos = A.length - 2;
        }
        return minPos;
    }
}
