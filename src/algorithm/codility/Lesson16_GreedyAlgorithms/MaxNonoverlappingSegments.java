package algorithm.codility.Lesson16_GreedyAlgorithms;

public class MaxNonoverlappingSegments {
    public static void main(String[] args) {
        int[] a = {1, 3, 7, 9, 9};
        int[] b = {5, 6, 8, 9, 10};

        System.out.println(solution(a, b));
    }
    public static int solution(int[] A, int[] B) {
        if (A.length < 1) return 0; //크기가 0인 경우, 0 리턴
        int count = 1;
        int checkPoint = B[0]; //첫 번째 영역의 끝 점이 체크 시작 지점
        for (int i = 1;i < A.length;i++) {
            if (checkPoint < A[i]) {    //체크 지점보다 시작점이 클 경우 겹치지 않는 영역
                count += 1;
                checkPoint = B[i];
            }
        }
        return count;
    }
}
