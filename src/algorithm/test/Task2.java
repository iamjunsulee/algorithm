package algorithm.test;

import java.util.Arrays;

/*
한 번에 1씩 늘리거나 줄이거나 할 수 있다.
크기 N인 배열이 주어질 때, 해당 배열은 1~N 까지의 숫자를 멤버로 가진다고 할 때,
몇 번의 연산을 해야되는지 구하는 문제.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] a = {6, 2, 3, 5, 6, 3};
        int[] b = {1,2,1};
        int[] c = {2,1,4,4};
        int[] d = {2,2,2,2,2};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
        System.out.println(solution(d));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;

        for(int i = 0;i < A.length;i++) {
            if (A[i] != (i+1)) {
                count += Math.abs(A[i] - (i+1));
            }
            if (count > 1000000000) return -1;
        }
        return count;
    }
}
