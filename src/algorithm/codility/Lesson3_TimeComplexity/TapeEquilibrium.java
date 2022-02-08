package algorithm.codility.Lesson3_TimeComplexity;

/*
For example, consider array A such that:
A[0] = 3
A[1] = 1
A[2] = 2
A[3] = 4
A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 3};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        int totalSum = 0;
        int minDiff = Integer.MAX_VALUE;
        int diff = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int num : A) {
            totalSum += num;
        }

        for(int i = 1;i < A.length;i++) {
            sum1 += A[i-1];
            sum2 = totalSum - sum1;
            diff = Math.abs(sum1 - sum2);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
