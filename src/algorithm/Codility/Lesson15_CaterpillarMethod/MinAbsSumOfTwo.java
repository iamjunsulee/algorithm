package algorithm.codility.Lesson15_CaterpillarMethod;

import java.util.Arrays;

public class MinAbsSumOfTwo {
    public static void main(String[] args) {
        int[] a = {1, 4, -3};
        int[] b = {-8, 4, 5, -10, 3};
        System.out.println(solution(a));
        System.out.println(solution(b));
    }
    //key : 정렬
    public static int solution(int[] A) {
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int temp = A[left] + A[right];
            min = Math.min(min, Math.abs(temp));

            //정렬을 했으므로 더한 값이 음수라면 다음 인덱스 값이 더 작은 수일 수 있으니까 현재 인덱스 다음 값을 확인해야함.
            if (temp <= 0) {
                left++;
            } else {
                right--;
            }
        }
        return min;
    }
}
