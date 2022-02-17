package algorithm.Codility.Lesson5_PrefixSums;

/*
A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q),
where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1
 */
public class PassingCars {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1};
        System.out.println(solution2(a));
    }
    //반복문 2개 쓰니까 너무 오래 걸림
    public static int solution(int[] A) {
        int count = 0;
        for (int i = 0;i < A.length;i++) {
            if (A[i] == 1) continue;
            for (int j = i;j < A.length;j++) {
                if (A[j] == 1) count++;
            }
        }
        return count;
    }
    //
    public static int solution2(int[] A) {
        int east = 0;
        int pass = 0;

        for (int i = 0;i < A.length;i++) {
            if (A[i] == 0) east++;
            if (A[i] == 1) pass += east;
        }

        if (pass > 1000000000)
            return -1;
        else
            return pass;
    }
}
