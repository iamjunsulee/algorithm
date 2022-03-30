package algorithm.codility.Lesson15_CaterpillarMethod;

import java.util.Arrays;

public class CountTriangles {
    public static void main(String[] args) {
        int[] a = {10, 2, 5, 1, 8, 12};
        System.out.println(solution(a));
    }
    //key : 정렬을 해줌으로서 A[P] + A[Q] > A[R] 이 성립되는지만 확인하면 된다.
    public static int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;

        //caterpillar method
        for (int i = A.length - 1;i >= 0;i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                //이게 성립이 되면 A[left]..A[right-1] + A[right] > A[i] 다 성립이 됨을 의미
                //그 사이 triangle 수는 right - left 수 만큼이다.
                if (A[left] + A[right] > A[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
