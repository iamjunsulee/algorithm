package algorithm.Codility.Lesson6_Sorting;

import java.util.Arrays;

public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 1, 4, 0};
        System.out.println(solution(a));
    }
    public static int solution(int[] A) {
        long[] start = new long[A.length];  //중점을 기준으로 왼쪽 시작점
        long[] end = new long[A.length];    //중점을 기준으로 오른쪽 끝점

        for (int i = 0;i < A.length;i++) {
            start[i] = i - A[i];
            end[i] = i + A[i];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));

        int start_point = 0;
        int intersections = 0;

        for (int end_point = 0;end_point < A.length;end_point++) {
            while (start_point < A.length && start[start_point] <= end[end_point]) {
                start_point++;
            }
            intersections += start_point - end_point - 1;
            System.out.println("intersections :: " + intersections);

            if (intersections > 10000000) {
                return -1;
            }
        }
        return intersections;
    }
}
