package algorithm.codility.Lesson4_CountingElements;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        int[] a = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;
        System.out.println(Arrays.toString(solution(N, a)));
    }

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int min = 0;
        int max = 0;

        for (int num : A) {
            if (num >= 1 && num <= N) {
                //increase 할 카운터가 최소값보다 작은 상태면 먼저 업데이트 후에 increase
                if (counters[num - 1] < min) counters[num - 1] = min;

                counters[num - 1]++; //increase X

                if (counters[num - 1] > max) max = counters[num - 1];   //max 값 저장
            } else if (num == N + 1) {
                min = max;  //현재 max 값으로 전체 다 바꾸므로 결국 현재 최대값이 현재 최소값이 된다.
            }
        }

        for (int i = 0;i < counters.length;i++) {
            if (counters[i] < min) counters[i] = min;   //마지막에 일괄 업데이트
        }

        return counters;
    }
}
