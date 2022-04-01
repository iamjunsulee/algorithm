package algorithm.programmers.bruteForceSearch;

import java.util.Arrays;

/*
완전탐색 - 카펫 문제
 */
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8, 1)));
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;

        for (int width = 1;width <= area;width++) {
            int height = (int) area / width;

            if (height > width) continue;

            if (((width - 2) * (height - 2) == yellow)) {
                answer[0] = width;
                answer[1] = height;
            }
        }
        return answer;
    }
}
