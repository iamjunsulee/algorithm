package algorithm.codility.Lesson15_CaterpillarMethod;

public class CountDistinctSlices {
    public static void main(String[] args) {
        int[] a = {3, 4, 5, 5, 2};
        System.out.println(solution(6, a));
    }
    public static int solution(int M, int[] A) {
        int slice = 0;
        boolean[] checked = new boolean[M + 1];
        int right = 0;
        int left = 0;

        while(right < A.length && left < A.length) {
            //중복없는 경우
            if (!checked[A[right]]) {
                slice = slice + (right - left + 1); //숫자 하나가 늘어나면 right - left + 1 만큼 증가

                if (slice > 1_000_000_000) {
                    return 1_000_000_000;
                }

                checked[A[right]] = true;
                right++;
            }
            //중복되는 경우
            else {
                checked[A[left]] = false;
                left++;
            }
        }
        return slice;
    }
}
